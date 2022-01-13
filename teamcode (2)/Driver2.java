package Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;


@TeleOp

public class Driver2  extends LinearOpMode{
Servo servoRight;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor topLeft;
    private DcMotor topRight;
    private DcMotor botLeft;
    private DcMotor botRight;
    private DcMotor height; 
    private DcMotor relic;

    

    double positionLeft=0, positionRight=0;
    // todo: write your code here
    public void runOpMode () throws InterruptedException {
    telemetry.addData("Status", "Initialized");
    telemetry.update();
    
    
       
    //servoRight = hardwareMap.servo.get("servoRight");
    
        topLeft  = hardwareMap.get(DcMotor.class, "topLeft");
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        botLeft  = hardwareMap.get(DcMotor.class, "botLeft");
        botRight = hardwareMap.get(DcMotor.class, "botRight");
        //height = hardwareMap.get(DcMotor.class, "height");
        //relic = hardwareMap.get(DcMotor.class, "relic");
        servoRight = hardwareMap.get(Servo.class, "servoRight");
        
        topLeft.setDirection(DcMotor.Direction.FORWARD);
        topRight.setDirection(DcMotor.Direction.FORWARD);
        botLeft.setDirection(DcMotor.Direction.FORWARD);
        botRight.setDirection(DcMotor.Direction.FORWARD);
        //height.setDirection(DcMotor.Direction.REVERSE);
        //relic.setDirection(DcMotor.Direction.FORWARD);


    double leftPower;
    double rightPower;
    
    //2 is right according to keying if its wrong then its her falt < fault
       waitForStart();
       runtime.reset();
       
       // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
          while(  opModeIsActive()){
           
            
            double driveLeft = gamepad1.left_stick_y;
            double driveRight= gamepad1.right_stick_y;
            double turn  =  gamepad1.right_stick_y;
            leftPower =  Range.clip(driveLeft, -1.0, 1.0) ;
            rightPower   = Range.clip(driveRight, -1.0, 1.0) ;
            topLeft.setPower(-leftPower);
            topRight.setPower(rightPower);
            botLeft.setPower(-leftPower);
            botRight.setPower(rightPower);
            //height.setPower(rightPower);
            //relic.setPower(leftPower);
            
            
    if(gamepad1.a){
            servoRight.setPosition(.90);
        }
        
        if(gamepad1.b){
            servoRight.setPosition(.2);
            
        }
        boolean Keying= true;
        
   
    if(gamepad1.right_bumper){
        botRight.setPower(-75);
        
    }
    if(gamepad1.left_bumper){
        botRight.setPower(75);
        
    }
    
     else{
        botRight.setPower(gamepad1.right_trigger);
        
    }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
            
             telemetry.addData("Status", "Initialized");
    telemetry.update();
    
          }
      
}

}