// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.hardware.HardwareMap;

// @Autonomous

// public class PerformanceTask2 extends LinearOpMode {
    
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

