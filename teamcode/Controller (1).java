package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive0  = hardwareMap.get(DcMotor.class, "leftDrive0");
        leftDrive3 = hardwareMap.get(DcMotor.class, "leftDrive3");
        rightDrive1  = hardwareMap.get(DcMotor.class, "rightDrive1");
        rightDrive2 = hardwareMap.get(DcMotor.class, "rightDrive2");

        leftDrive0.setDirection(DcMotor.Direction.FORWARD);
        leftDrive3.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();
        
        double leftPower;
        double rightPower;

        while(opModeIsActive()) {
            telemetry.addData("Status", "Run Time");
            telemetry.update();

            double driveLeft = -gamepad1.left_stick_y;
            double driveRight= -gamepad1.right_stick_y;
            //double turn  =  gamepad1.right_stick_y;
            leftPower =  Range.clip(driveLeft, -1.0, 1.0) ;
            rightPower  = Range.clip(driveRight, -1.0, 1.0) ;
            
            leftDrive0.setPower(leftPower);
            rightDrive1.setPower(rightPower);
            rightDrive2.setPower(rightPower);
            leftDrive3.setPower(leftPower);
        }
    }
}
