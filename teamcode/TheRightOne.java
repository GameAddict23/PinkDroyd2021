/*
Copyright 2018 FIRST Tech Challenge Team 10393

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp
public class TheRightOne extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor motor5;
    //private DcMotor pickupBalls, sweeper;
    Servo servo1;
    //private Servo servo2;
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
        servo1 = hardwareMap.get(Servo.class, "servo1");
       //servo2 = hardwareMap.get(Servo.class, "servo2");
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

    double leftPower; 
    double rightPower;
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
        telemetry.addData("Status","Running" );
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Status","ballpickup");
        //telemetry.addData("latchRobot", latchRobot.getCurrentPosition());
        telemetry.addData("motor0, motor1, motor2, motor3, motor4, motor5", "" + motor1.getCurrentPosition() + " " + motor2.getCurrentPosition() + " " + motor3.getCurrentPosition() + " " + motor0.getCurrentPosition()+ " " +motor4.getCurrentPosition());
        telemetry.update(); 
    
        //For basic stick movement.  
         
             double driveLeft = gamepad1.left_stick_y;
            double driveRight= gamepad1.right_stick_y;
            double turn  =  gamepad1.right_stick_y;
           
            leftPower =  Range.clip(driveLeft, -1.0, 1.0) ;
            rightPower   = Range.clip(driveRight, -1.0, 1.0) ;
            
            motor0.setPower(-leftPower);
            motor1.setPower(rightPower);
            motor2.setPower(leftPower);
            motor3.setPower(-rightPower);
        
        
        if(gamepad1.left_bumper){
            strafe(-0.5);
        } 
    
        
        if(gamepad1.right_bumper){
            strafe(0.5);
        }
        
        if(gamepad2.x){
            armforwards(-0.5);
            sleep(150);
        }else{
           armforwards(0);
           
        
        }
        if(gamepad2.a){
            armbackwards(-0.5);
        }else{
            armbackwards(0);
        }
        
        if(gamepad2.right_trigger>0){
            extend(0.5);
            sleep(150);
        }else{
            extend(0);
        }
        
        if(gamepad2.left_trigger>0){
            retract(1);
            sleep(150);
        }else{
            retract(0);
        }
      

        
        
        
        
        
        
        
    
       if(gamepad2.b){
            servo1.setPosition(0);
         }
        
        if(gamepad2.y){
        servo1.setPosition(.7);
        
}
        
        
        }      
}
        

    
    public void strafe(double power) {
        motor0.setPower(-power);
        motor1.setPower(-power);
        motor2.setPower(power);
        motor3.setPower(power);
    }
    
     public void armforward(double power) {
        motor4.setPower(-power);
        
    }
    
     public void armbackwards(double power) {
        motor4.setPower(power);
    
     }
    
         public void armforwards(double power) {
        motor4.setPower(-power);
        
         }
  public void retract (double power){
      motor5.setPower(power);
  }
  
  public void extend(double power){
      motor5.setPower(-power);
     sleep(175);
  }
     

      
    


}

