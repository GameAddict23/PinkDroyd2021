package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
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
    DcMotor leftDrive0; //motor 0 : Hub 3
    DcMotor leftDrive3; // motor 1 : Hub 3
    DcMotor rightDrive1; //motor 2 : Hub 4
    DcMotor rightDrive2; //motor 3 : Hub 4
    DcMotor carousel; //motor 0: Hub 4
    
    //Servos
    Servo rightServo;
    Servo leftServo;
    double servoPosition = 0;
    
    //Arms
    DcMotor gearArm;
    DcMotor yoyoArm;
    
    //Gamepad
    Gamepad control = new Gamepad();

    //methods
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
    
    public void strafe(double power, String direction){
        power = Math.abs(power);
        if (direction.equals("left")){
            leftDrive3.setPower(-power);
            rightDrive2.setPower(power);
            
            rightDrive1.setPower(-power);
            leftDrive0.setPower(power);
        }
        else if (direction.equals("right")){
            leftDrive3.setPower(power);
            rightDrive2.setPower(-power);
            
            rightDrive1.setPower(power);
            leftDrive0.setPower(-power);
        }
        
    }
    
     //double getAngle();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive0 = hardwareMap.get(DcMotor.class, "leftDrive0");
        rightDrive1 = hardwareMap.get(DcMotor.class, "rightDrive1");

        leftDrive3  = hardwareMap.get(DcMotor.class, "leftDrive3");
        rightDrive2 = hardwareMap.get(DcMotor.class, "rightDrive2");
        
        carousel = hardwareMap.get(DcMotor.class, "carousel");
        
        rightServo = hardwareMap.get(Servo.class, "rightServo");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        
        gearArm = hardwareMap.get(DcMotor.class, "gearArm");
        yoyoArm = hardwareMap.get(DcMotor.class,"yoyoArm");
    
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        leftDrive0.setDirection(DcMotor.Direction.FORWARD);
        rightDrive1.setDirection(DcMotor.Direction.REVERSE);

        leftDrive3.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);
        
        carousel.setDirection(DcMotor.Direction.FORWARD);
        gearArm.setDirection(DcMotor.Direction.FORWARD);
        yoyoArm.setDirection(DcMotor.Direction.FORWARD);
        
        //rightServo.setPosition(0);
        //leftServo.setPosition(0);

        waitForStart();
        runtime.reset();
            
            /*
            double powerLeft = gamepad1.left_stick_y;
            double powerRight= gamepad1.right_stick_y;
            double turn  =  gamepad1.right_stick_y;
            */
        
        double leftPower = 0;
        double rightPower = 0;
        while (opModeIsActive()) {
            
            telemetry.addData("Status", "Run Time");
            telemetry.update();
            
            //gamepad1
            //strafing    
            if (gamepad1.left_bumper)
                strafe(0.7, "left");
            else if (gamepad1.right_bumper)
                strafe(0.7, "right");

            else{
                leftDrive0.setPower(-gamepad1.left_stick_y*1.2);
                rightDrive1.setPower(-gamepad1.right_stick_y*1.2);
                leftDrive3.setPower(-gamepad1.left_stick_y*1.2);
                rightDrive2.setPower(-gamepad1.right_stick_y*1.2);
            }
                
            
            //turn right
            if (gamepad1.right_trigger == 1){
                setMotorPower(1, -1);
            }
            //turn left
            else if (gamepad1.left_trigger == 1){
                setMotorPower(-1, 1);
            }
            else{
                setMotorPower(0);
            }
            
            //gamepad2
            //spinning carousel
            if (gamepad2.x)
                carousel.setPower(0.5);
            else if (gamepad2.y)
                carousel.setPower(-0.5);
            else
                carousel.setPower(0);
                
            //hand
            if (gamepad2.right_trigger == 1){
                leftServo.setPosition(0);
                rightServo.setPosition(0.9);
            }
            //close
            else if (gamepad2.a){
                leftServo.setPosition(0.65);
                rightServo.setPosition(0.45);
            }
            //open
            else if (gamepad2.b){
                leftServo.setPosition(0.4);
               rightServo.setPosition(0.6);
            }
            
            //Never Gonna give you up never gonna let you down
            //raising and lowering arm
            if(gamepad2.left_stick_y == 1){
                gearArm.setPower(1);
            }
            else if(gamepad2.left_stick_y == -1){
                gearArm.setPower(-1);
            }  
            else{
                gearArm.setPower(0);
            }
            //Never Gonna Give You Up Never Gonna Let You Down
            
            //extending arm
            if (gamepad2.right_stick_x == 1){
                yoyoArm.setPower(0.8);
            }
            else if(gamepad2.right_stick_x == -1){
                yoyoArm.setPower(-0.8);
            }
            else{
                yoyoArm.setPower(0);
            }
        }
    }
}
