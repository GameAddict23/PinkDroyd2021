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

public class FirstTask extends LinearOpMode {
    private DcMotor topLeft;
    private DcMotor botLeft;
    private DcMotor topRight;
    private DcMotor botRight;
    private DcMotor pickupBalls, sweeper;
    private Servo servo1;
    //private Servo sensorServo;
    private DcMotor latchRobot; 
    private DcMotor pulley;
    float leftStick, rightStick;
    float  scale = 1.5f; 
    @Override
    public void runOpMode() {
        
        topLeft  = hardwareMap.get(DcMotor.class, "topLeft");
        botLeft = hardwareMap.get(DcMotor.class, "botLeft");
        topRight  = hardwareMap.get(DcMotor.class, "topRight");
        botRight = hardwareMap.get(DcMotor.class, "botRight");
        servo1 = hardwareMap.get(Servo.class, "claw1");
        //sensorServo = hardwareMap.get(Servo.class, "claw2");
        pickupBalls = hardwareMap.get(DcMotor.class, "pickupBalls");
        sweeper = hardwareMap.get(DcMotor.class, "sweeper");
        latchRobot = hardwareMap.get(DcMotor.class, "latchRobot");
        pulley = hardwareMap.get(DcMotor.class, "pulley"); 
        
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        topLeft.setDirection(DcMotor.Direction.REVERSE);
        botLeft.setDirection(DcMotor.Direction.REVERSE);
          
        botRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        botLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        latchRobot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        botRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        botLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        latchRobot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);  
        pickupBalls.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        topLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        botRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        botLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        latchRobot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pulley.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
        telemetry.addData("Status","Running" );
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Status","ballpickup");
        telemetry.addData("latchRobot", latchRobot.getCurrentPosition());
        telemetry.addData("tL, tR, bR, bL", "" + topLeft.getCurrentPosition() + " " + topRight.getCurrentPosition() + " " + botLeft.getCurrentPosition() + " " + botRight.getCurrentPosition());
        telemetry.update(); 
        
        //For basic stick movement.  
        leftStick = gamepad1.left_stick_y;
        rightStick  = gamepad1.right_stick_y;  
        moveMotors(leftStick/scale, rightStick/scale);
        
        if(gamepad1.left_bumper){
            strafe(0.5);
        }
        
        if(gamepad1.right_bumper){
            strafe(-0.5);
        }
        
        /*if(gamepad2.dpad_up) {
            if(latchRobot.getTargetPosition() == 0) {
                latchRobot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                latchRobot.setTargetPosition(1000);
                latchRobot.setPower(.75);
            }
            else if(latchRobot.getTargetPosition() == 1000) { 
                latchRobot.setMode(DcMotor.RunMode.RUN_TO_POSITION); 
                latchRobot.setTargetPosition(0);
                latchRobot.setPower(-.75);
            }
        } */
        
        /*if(latchRobot.isBusy()){
             
         }
         else
         latchRobot.setPower(0); */
         
           if(gamepad2.dpad_up) //dpadup
              latchRobot.setPower(-1);
           else if(gamepad2.dpad_down)//dpaddown
              latchRobot.setPower(1); 
           else   
              latchRobot.setPower(0); 
        
        /*
        if(gamepad2.y) {
            latchRobot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            if(latchRobot.getCurrentPosition() > -8000){
                latchRobot.setTargetPosition(-12500);
            }
            while(latchRobot.isBusy())
                latchRobot.setPower(-1);
            latchRobot.setPower(0);
        }
        
        if(gamepad2.a){
           latchRobot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            if(latchRobot.getCurrentPosition() < 0){
                latchRobot.setTargetPosition(0);
            } 
            while(latchRobot.isBusy())
                latchRobot.setPower(1);
            latchRobot.setPower(0);
        }   */
        
        if(gamepad2.right_bumper)//leftbump
            pickupBalls.setPower(0.60);
        else if (gamepad2.left_bumper)//rightbump
            pickupBalls.setPower(-0.60);
        else 
            pickupBalls.setPower(0);
          
        
        if(gamepad1.right_trigger > 0)
            sweeper.setPower(1);
        else if (gamepad1.left_trigger > 0)
            sweeper.setPower(-1);
        else 
            sweeper.setPower(0);
    
        if(gamepad2.b)
            servo1.setPosition(0);
          //  sensorServo.setPosition(1);
        if(gamepad2.x)
            servo1.setPosition(0.5);
           // sensorServo.setPosition(0);
        /*else
            servo1.setPosition(.5);*/
    // if(gamepad2.a)
    //      sensorServo.setPosition(0.1);
    // if(gamepad2.y)
    //  sensorServo.setPosition(0.6);
          
     
        if(gamepad1.dpad_right) //padleft
            pulley.setPower(0.45);
        else if(gamepad1.dpad_left) //padright
            pulley.setPower(-0.50);
        else
            pulley.setPower(0);
            
    }
  }

    public void moveMotors(float power1, float power2) {
        topLeft.setPower(power1);
        botLeft.setPower(power1);
        topRight.setPower(power2);
        botRight.setPower(power2);
    }
    
    public void strafe(double power) {
        topLeft.setPower(-power);
        botLeft.setPower(power);
        topRight.setPower(power);
        botRight.setPower(-power);
    }

 
}

