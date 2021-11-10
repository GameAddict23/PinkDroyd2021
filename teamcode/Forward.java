package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Forward", group="Linear Opmode")
//@Disabled
public class Forward extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftDrive0 = null;
    //private DcMotor rightDrive = null;
    
    //NeveRest 20 Gearmotors
    DcMotor leftDrive0; //motor 0
    DcMotor leftDrive3; // motor 1
    DcMotor rightDrive1; //motor 2
    DcMotor rightDrive2; //motor 3
   
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
    //strafing
    public void strafe(double power){
        leftDrive0.setPower(-1*power);
        leftDrive3.setPower(power);
        
        rightDrive1.setPower(power);
        rightDrive2.setPower(-1*power);
    }
    
    //stops motor power by setting it to 0
    public void stopMotors(){
        leftDrive0.setPower(0);
        leftDrive3.setPower(0);
        
        rightDrive1.setPower(0);
        rightDrive2.setPower(0);
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


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        leftDrive0.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        
        leftDrive3.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)

        waitForStart();
        runtime.reset();
/*
        setMotorPower(0.5);
        sleep(2000);
        
        setMotorPower(-0.5);
        sleep(2000);
*/
        //pivot turn left
        setMotorPower(0.5, -0.5);
        sleep(1000);
        
        stopMotors();
        sleep(1000);
        
        //pivot turn right 
        setMotorPower(-0.5, 0.5);
        sleep(1000);
        
        strafe(0.5);
        sleep(1000);
        
        strafe(-0.5);
        sleep(1000);
/*
        setMotorPower(1);
        sleep(1500);
*/
        //stops the robot 
        stopMotors();
    }
}

