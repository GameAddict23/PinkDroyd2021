package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.lang.Math;


@Autonomous(name="AutonomousRedLeft", group="Linear Opmode")
//@Disabled
public class AutonomousRedLeft extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftDrive0 = null;
    //private DcMotor rightDrive = null;
    
    DcMotor leftDrive0; //motor 0
    DcMotor leftDrive3; // motor 1
    DcMotor rightDrive1; //motor 2
    DcMotor rightDrive2; //motor 3
    DcMotor carousel; //motor 0: Hub 4
    
    //Servos
    Servo rightServo;
    Servo leftServo;
   
    public void main(String[] args){
        runOpMode();
    }
    
    //sets motor power simultaneously
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
    //Turning
    /*
    public void turnRight(boolean right){
        
    }
    */
    //strafing
    public void strafe(double power, String direction){
        power = Math.abs(power);
        if (direction.equals("left")){
            leftDrive3.setPower(power*-1);
            rightDrive2.setPower(power*-1);
            
            rightDrive1.setPower(power*0.9);
            leftDrive0.setPower(power*0.9);
        }
        else if (direction.equals("right")){
            leftDrive3.setPower(power*0.9);
            rightDrive2.setPower(power*0.9);
            
            rightDrive1.setPower(power*-1);
            leftDrive0.setPower(power*-1);
        }
        
    }
    
    public void close(){
        for(int i = 0; i <=180; i++){
            leftServo.setPosition(i);
            rightServo.setPosition(180-i);
        }
    }
    
    public void open(){
        for(int i = 0; i <=180; i++){
            leftServo.setPosition(180-i);
            rightServo.setPosition(i);
        }
    }
    
    //stops motor power by setting it to 0
    public void stopMotors(){
        leftDrive0.setPower(0);
        leftDrive3.setPower(0);
        
        rightDrive1.setPower(0);
        rightDrive2.setPower(0);
    } 
    

    
    //set arm servo position
    public void grab(double pos){
        rightServo.setPosition(0);
        leftServo.setPosition(0);
        
        rightServo.setPosition(0.7);
        leftServo.setPosition(0.7);
    }
    public void release(double pos){
        rightServo.setPosition(0);
        leftServo.setPosition(0);
    }
    public void rest(){
        rightServo.setPosition(0);
        leftServo.setPosition(0);
        sleep(1000);
        rightServo.setPosition(0);
        leftServo.setPosition(0);
        sleep(1000);
    }
    
    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        leftDrive0 = hardwareMap.get(DcMotor.class, "leftDrive0");
        rightDrive1 = hardwareMap.get(DcMotor.class, "rightDrive1");
        
        leftDrive3  = hardwareMap.get(DcMotor.class, "leftDrive3");
        rightDrive2 = hardwareMap.get(DcMotor.class, "rightDrive2");

        carousel = hardwareMap.get(DcMotor.class, "carousel");
        
        rightServo = hardwareMap.get(Servo.class, "rightServo");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
    

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        leftDrive0.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        
        leftDrive3.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);
        
        carousel.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)

        waitForStart();
        runtime.reset();
        
        rest();
        sleep(1000);
        //sleep(1000);
        //grab(1);
        //sleep(1000);
        //release(0.3);
        //sleep(1000);
        //rest();
    }
}
