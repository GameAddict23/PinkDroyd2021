// /*
// Copyright 2019 FIRST Tech Challenge Team 10393

// Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
// associated documentation files (the "Software"), to deal in the Software without restriction,
// including without limitation the rights to use, copy, modify, merge, publish, distribute,
// sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in all copies or substantial
// portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
// NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// */
// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.OpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.DcMotorSimple;
// import com.qualcomm.robotcore.util.ElapsedTime;

// import java.text.SimpleDateFormat;
// import java.util.Date;

// /**
//  * This file contains an example of an iterative (Non-Linear) "OpMode".
//  * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
//  * The names of OpModes appear on the menu of the FTC Driver Station.
//  * When an selection is made from the menu, the corresponding OpMode
//  * class is instantiated on the Robot Controller and executed.
//  *
//  * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
//  * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
//  */
// @Autonomous

// public class PerformanceTask1 extends LinearOpMode {
    
//     //ISTANTIATE MOTORS AND SERVOS
//     public DcMotor  motor0;
//     public DcMotor  motor1;
//     public DcMotor  motor2;   
//     public DcMotor  motor3;    
//     public Servo    servoArm;   

//     //creating the hardware map
//     HardwareMap hardwareMap;


//     /* Initialize standard Hardware interfaces */
//     public void init(HardwareMap hardwareMap) {
        
//         // DEFINE MOTORS AND SERVOS 
//         motor0 = hardwareMap.get(DcMotor.class, "motor0");
//         motor1 = hardwareMap.get(DcMotor.class, "motor1");
//         motor2 = hardwareMap.get(DcMotor.class, "motor2");
//         motor3 = hardwareMap.get(DcMotor.class, "motor3");
//         servoArm = hardwareMap.get(Servo.class, "servoArm");

//         // Set all motors to zero power
//         motor0.setPower(0);
//         motor1.setPower(0);
//         motor2.setPower(0);
//         motor3.setPower(0);
//         //servoArm.(0);
        
//         //SET MOTOR MODE
//         motor0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //...Runmode.RUN_TO_POSITION
//         motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //...Runmode.RUN_TO_POSITION
//         motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //...Runmode.RUN_TO_POSITION
//         motor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //...Runmode.RUN_TO_POSITION
        
        
//         //SET MOTOR 0POWER BEHAVIOR
//         motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //...ZeroPowerBehavior.FLOAT
//         motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//         motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//         motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
//         //SET SERVO POSITION
//         servoArm.setPosition(0.1);
        
        
//     }
//  }

