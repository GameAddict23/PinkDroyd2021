package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
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
    DcMotor leftDrive0; //motor 0 : Hub 3
    DcMotor leftDrive3; // motor 1 : Hub 3
    DcMotor rightDrive1; //motor 2 : Hub 4
    DcMotor rightDrive2; //motor 3 : Hub 4
    DcMotor carousel; //motor 0: Hub 4
    
    //Servos

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
            leftDrive3.setPower(power*-0.5);
            rightDrive2.setPower(power*-0.7);
            
            rightDrive1.setPower(power*0.7);
            leftDrive0.setPower(power*0.5);
        }
        else if (direction.equals("right")){
            leftDrive3.setPower(power*0.7);
            rightDrive2.setPower(power*0.5);
            
            rightDrive1.setPower(power*-0.5);
            leftDrive0.setPower(power*-0.7);
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
        
        carousel = hardwareMap.get(DcMotor.class, "carousel");
    

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        leftDrive0.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);

        leftDrive3.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);
        
        carousel.setDirection(DcMotor.Direction.FORWARD);
        

        waitForStart();
        runtime.reset();
            
            /*
            double powerLeft = gamepad1.left_stick_y;
            double powerRight= gamepad1.right_stick_y;
            double turn  =  gamepad1.right_stick_y;
            boolean ifStick = false;
            */
        
        double leftPower = 0;
        double rightPower = 0;
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time");
            telemetry.update();
                
            if (gamepad1.left_bumper)
                strafe(0.85, "left");
            else if (gamepad1.right_bumper)
                strafe(0.85, "right");
            else if (gamepad1.left_trigger == 1){
                setMotorPower(-1);
            }
            else if (gamepad1.right_trigger == 1){
                setMotorPower(1);
            }
            else if (gamepad1.left_stick_x == 1){
                setMotorPower(1, -1);
            }
            else if (gamepad1.left_stick_x == -1){
                setMotorPower(-1, 1);
            }
            else{
                setMotorPower(0);
            }
            
            
            
            if (gamepad1.x)
                carousel.setPower(0.8);
            else if (gamepad1.y)
                carousel.setPower(-0.2);
            else
                carousel.setPower(0);
            
            /*if(gamepad1.a){
            servo0.setPosition(.90);
            }
            if(gamepad1.b){
            servo0.setPosition(0);
            }*/
        }
    }
}
