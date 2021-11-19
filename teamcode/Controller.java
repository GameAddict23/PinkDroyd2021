package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


//Control for Moving Forward and Backward

@TeleOp(name="Controller", group="Linear Opmode")
//@Disabled
public class Controller extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftDrive = null;
    //private DcMotor rightDrive = null;

    //NeveRest 20 Gearmotors
    DcMotor leftDrive0; //motor 0
    DcMotor leftDrive3; // motor 1
    DcMotor rightDrive1; //motor 2
    DcMotor rightDrive2; //motor 3

    Gamepad control = new Gamepad();

    public void setMotorPower(double power){
        leftDrive0.setPower(power);
        leftDrive3.setPower(power);

        rightDrive1.setPower(power);
        rightDrive2.setPower(power);
    }
    //sets left and right motors power seperately
    public void setMotorPower(double powerLeft, double powerRight){
        leftDrive0.setPower(powerLeft);
        leftDrive3.setPower(powerLeft);

        rightDrive1.setPower(powerRight);
        rightDrive2.setPower(powerRight);
    }
    
    public void strafe(double power, String direction){
        power = Math.abs(power);
        if (direction.equals("left")){
            leftDrive3.setPower(power*-1);
            rightDrive2.setPower(power*-1);
            
            rightDrive1.setPower(power);
            leftDrive0.setPower(power);
        }
        else if (direction.equals("right")){
            leftDrive3.setPower(power);
            rightDrive2.setPower(power);
            
            rightDrive1.setPower(power*-1);
            leftDrive0.setPower(power*-1);
        }
        
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive0 = hardwareMap.get(DcMotor.class, "leftDrive0");
        rightDrive1 = hardwareMap.get(DcMotor.class, "rightDrive1");

        leftDrive3  = hardwareMap.get(DcMotor.class, "leftDrive3");
        rightDrive2 = hardwareMap.get(DcMotor.class, "rightDrive2");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        leftDrive0.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);

        leftDrive3.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

            double powerLeft = gamepad1.left_stick_y;
            double powerRight= gamepad1.right_stick_y;
            double turn  =  gamepad1.right_stick_y;
            boolean ifStick = false;

        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time");
            telemetry.update();
                
            if (gamepad1.left_bumper)
                strafe(1, "left");
            else if (gamepad1.right_bumper)
                strafe(1, "right");
            else{
                powerLeft =  Range.clip(powerLeft, -1.0, 1.0) ;
                powerRight = Range.clip(powerRight, -1.0, 1.0) ;
    
                leftDrive0.setPower(-powerLeft);
                rightDrive1.setPower(powerRight);
                leftDrive3.setPower(powerLeft);
                rightDrive2.setPower(-powerRight);
    
                telemetry.addData("Status", "Run Time");
                telemetry.update();
    
                leftDrive0.setPower(-gamepad1.left_stick_y);
                rightDrive1.setPower(-gamepad1.right_stick_y);
                leftDrive3.setPower(-gamepad1.left_stick_y);
                rightDrive2.setPower(-gamepad1.right_stick_y);
            }
        }
    }
}
