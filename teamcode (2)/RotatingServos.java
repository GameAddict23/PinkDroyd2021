package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;



@Autonomous(name="RotatingServos", group="Linear Opmode")
//@Disabled
public class RotatingServos extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftDrive = null;
    //private DcMotor rightDrive = null;

    //resting position 0 degree
    Servo servo;
    double servoPosition = 0.0;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        servo = hardwareMap.servo.get("servo");
        servo.setPosition(servoPosition);

        waitForStart();
        runtime.reset();

        //90 degree turn
        servoPosition = 0.5;
        servo.setPosition(servoPosition);
        sleep(2000);

        //180 degree turn
        servoPosition = 1.0;
        servo.setPosition(servoPosition);
    }

}
