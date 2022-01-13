package org.firstinspires.ftc.teamcode2;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous

public class BlueDepot extends LinearOpMode {
    // todo: write your code here
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor motor5;
    private DcMotor motor6;
    private Servo servo3;
    private Servo servo4;
    //private Servo sensorServo;
    //private DcMotor latchRobot; 
    //private DcMotor pulley;

    @Override
    public void runOpMode(){
       motor0  = hardwareMap.get(DcMotor.class, "motor0");
       motor1 = hardwareMap.get(DcMotor.class, "motor1");
       motor2  = hardwareMap.get(DcMotor.class, "motor2");
       motor3 = hardwareMap.get(DcMotor.class, "motor3");
       motor4 = hardwareMap.get(DcMotor.class, "motor4");
       motor5 = hardwareMap.get(DcMotor.class, "motor5");
       motor6 = hardwareMap.get(DcMotor.class, "motor6");
       servo3 = hardwareMap.get(Servo.class, "servo3");
       servo4 = hardwareMap.get(Servo.class, "servo4");
       //sensorServo = hardwareMap.get(Servo.class, "claw2");
       //pickupBalls = hardwareMap.get(DcMotor.class, "pickupBalls");
       //sweeper = hardwareMap.get(DcMotor.class, "sweeper");
       //latchRobot = hardwareMap.get(DcMotor.class, "latchRobot");
       //pulley = hardwareMap.get(DcMotor.class, "pulley"); 
        
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        motor0.setDirection(DcMotor.Direction.REVERSE);
        motor3.setDirection(DcMotor.Direction.REVERSE);
          
        motor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor5.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor6.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        motor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor6.setMode(DcMotor.RunMode.RUN_USING_ENCODER);  
        //pickupBalls.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor4.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor5.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor6.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        waitForStart();
        
        twinMotors(.5);
        sleep(6000);
        
        moveMotors(.5);
        sleep(500);
        stopMotors();
        sleep(500);
        
        turnLeft(.5);
        sleep(600);
        stopMotors();
        sleep(500);
        
        moveMotors(.5);
        sleep(2500);
        stopMotors();
        sleep(500);
        
        turnRight(.5);
        sleep(600);
        stopMotors();
        sleep(500);
        
        moveMotors(.5);
        sleep(3000);
        stopMotors();
        sleep(500) ;
        
        turnRight(.5);
        sleep(600);
        stopMotors();
        sleep(500);
        
        moveMotors(.5);
        sleep(3000);
        stopMotors();
        sleep(500);
        
        turnRight(.5);
        sleep(600);
        stopMotors();
        sleep(500);
        
        moveMotors(.5);
        sleep(2500);
        stopMotors();
        sleep(500);
        
        turnRight(.5);
        sleep(600);
        stopMotors();
        sleep(500);
        
        moveMotors(.5);
        sleep(2000);
        stopMotors();
        sleep(500);
        
        twinMotors(-.5);
        sleep(500);
        
        moveMotors(-.5);
        sleep(1000);
        stopMotors();
        sleep(500);
        


    }
    //create methods here
 public void moveMotors(double power){ //THIS IS FOR MOVING FORWARD/BACKWARD
  motor0.setPower(power/1.5);
  motor1.setPower(-power/1.5);
  motor2.setPower(power/1.5);
  motor3.setPower(-power/1.5);
 } 
 
 public void turnLeft(double power){
  motor0.setPower(-power);
  motor1.setPower(power);
  motor2.setPower(power);
  motor3.setPower(-power);
 }
 
 public void twinMotors(double power){
  motor5.setPower(power);
  motor6.setPower(power);
 }
 
 public void turnRight(double power){
  motor0.setPower(power);
  motor1.setPower(-power);
  motor2.setPower(-power);
  motor3.setPower(power);
 }
 
 public void stopMotors(){ //THIS IS TO STOP ROBOT
  moveMotors(0);
 }
       
       
       
       }
       
         
  
  

 
 