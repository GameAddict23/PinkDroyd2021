package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class Szauto extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor motor5;
    private DcMotor motor6;
    //private DcMotor pickupBalls, sweeper;
    //private Servo servo1;
    //private Servo sensorServo;
    //private DcMotor latchRobot; 
    //private DcMotor pulley;
    float leftStick, rightStick;
    float  scale = 1.5f; 
    @Override
    public void runOpMode() {
        
        motor0  = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2  = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        motor4 = hardwareMap.get(DcMotor.class, "motor4");
        motor5 = hardwareMap.get(DcMotor.class, "motor5");
        //servo1 = hardwareMap.get(Servo.class, "claw1");
        //sensorServo = hardwareMap.get(Servo.class, "claw2");
        //pickupBalls = hardwareMap.get(DcMotor.class, "pickupBalls");
        //sweeper = hardwareMap.get(DcMotor.class, "sweeper");
        //latchRobot = hardwareMap.get(DcMotor.class, "latchRobot");
        //pulley = hardwareMap.get(DcMotor.class, "pulley"); 
        
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        //topLeft.setDirection(DcMotor.Direction.REVERSE);
        //botLeft.setDirection(DcMotor.Direction.REVERSE);
          
        motor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor5.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //latchRobot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        motor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //latchRobot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);  
        //pickupBalls.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor4.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor5.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //latchRobot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //pulley.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
        telemetry.addData("Status","Running" );
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Status","ballpickup");
        //telemetry.addData("latchRobot", latchRobot.getCurrentPosition());
        telemetry.addData("motor0, motor1, motor2, motor3, motor4, motor5", "" + motor1.getCurrentPosition() + " " + motor2.getCurrentPosition() + " " + motor3.getCurrentPosition() + " " + motor0.getCurrentPosition()+ " " +motor4.getCurrentPosition()+ " " + motor5.getCurrentPosition());
        telemetry.update();
        
        
        }
    }
}
