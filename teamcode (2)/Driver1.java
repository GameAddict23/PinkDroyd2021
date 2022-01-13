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

public class Driver1  extends LinearOpMode{

Servo servoArm;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor height; 
    private DcMotor relic;

    

    double positionLeft=0, positionRight=0;
    // todo: write your code here
    public void runOpMode () throws InterruptedException {
    telemetry.addData("Status", "Initialized");
    telemetry.update();
    
    
       
    //servoRight = hardwareMap.servo.get("servoRight");
    
        motor0  = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2  = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        //height = hardwareMap.get(DcMotor.class, "height");
        //relic = hardwareMap.get(DcMotor.class, "relic");
        servoArm = hardwareMap.get(Servo.class, "servoArm");
        
        motor0.setDirection(DcMotor.Direction.FORWARD);
        motor1.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.FORWARD);
        motor3.setDirection(DcMotor.Direction.FORWARD);
        //height.setDirection(DcMotor.Direction.REVERSE);
        //relic.setDirection(DcMotor.Direction.FORWARD);


    double leftPower;
    double rightPower;
    
    //2 is right according to keying if its wrong then its her falt < fault
       waitForStart();
       runtime.reset();
       
       // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
          while(opModeIsActive()){
           
            
            double driveLeft = gamepad1.left_stick_y;
            double driveRight= gamepad1.right_stick_y;
            double turn  =  gamepad1.right_stick_y;
            leftPower =  Range.clip(driveLeft, -1.0, 1.0) ;
            rightPower   = Range.clip(driveRight, -1.0, 1.0) ;
            motor0.setPower(-leftPower);
            motor1.setPower(rightPower);
            motor2.setPower(-rightPower);
            motor3.setPower(leftPower);
            //height.setPower(rightPower);
            //relic.setPower(leftPower);
            
            
    if(gamepad1.a){
            servoArm.setPosition(.90);
        }
        
        if(gamepad1.b){
            servoArm.setPosition(.2);
            
        }
        boolean Keying= true;
        
   
    if(gamepad1.right_bumper){
        motor0.setPower(-75);
        
    }
    if(gamepad1.left_bumper){
        motor0.setPower(75);
        
    }
    
     else{
        motor0.setPower(gamepad1.right_trigger);
        
    }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
            
             telemetry.addData("Status", "Initialized");
    telemetry.update();
    
          }
      
}

}
