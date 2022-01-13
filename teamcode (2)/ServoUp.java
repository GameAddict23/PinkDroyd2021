package Testing;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
@Autonomous

public class ServoUp extends LinearOpMode{

    // todo: write your code here
    //private ElapsedTime runtime = new ElapsedTime();
     private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor motor5;
    private DcMotor motor6;
    //private DcMotor pickupBalls, sweeper;
    private Servo servo0;
    private Servo servo1;
    private Servo servo2;
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
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servo3 = hardwareMap.get(Servo.class, "servo3");
        servo4 = hardwareMap.get(Servo.class, "servo4");
        //sensorServo = hardwareMap.get(Servo.class, "claw2");
        //pickupBalls = hardwareMap.get(DcMotor.class, "pickupBalls");
        //sweeper = hardwareMap.get(DcMotor.class, "sweeper");
        //latchRobot = hardwareMap.get(DcMotor.class, "latchRobot");
        //pulley = hardwareMap.get(DcMotor.class, "pulley"); 
        boolean srv1 = false;
        boolean srv3 = false;
        
        //motor0.setDirection(DcMotor.Direction.REVERSE);
       // motor1.setDirection(DcMotor.Direction.REVERSE);
        
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
        motor6.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //latchRobot.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        motor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor6.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //latchRobot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);  
        //pickupBalls.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor4.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor5.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor6.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //latchRobot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //pulley.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    //   resetEncoders();
    //   runUsingEncoders();
        
        waitForStart();
        
        //start robot backwards
        

        // while(color.argb()<610000000){//617174657(Skystone) 184878082(yellow block)
        //     strafe(0.055);
        //     sleep(400);
        // }
        // stopMotors();
        
        servo1.setPosition(0.33);
        
        

        // servo3.setPosition(0.6); //0.6 is up
        // servo4.setPosition(0); //0 is up
        // sleep(1000);

        
        while(opModeIsActive()){
            telemetry.addData("Status", "Initialized");
            telemetry.addData("motor0","");
            //telemetry.addData("DistanceCM", d1.getDistance(DistanceUnit.CM));
            //telemetry.addData("argb",color.argb());
            // telemetry.addData("red", color.red());
            // telemetry.addData("blue", color.blue());
            // telemetry.addData("green", color.green());
            // telemetry.addData("alpha", color.alpha());
            // telemetry.addData("Skystone?", getContext());
            telemetry.update();
        }
    }
    
    // public void scanForSkystone(){
    //     if(color.alpha() > 600){
    //         skystone = "NOPE";
            
    //     }else{
    //         skystone = "YES";
    //     }
    // }
    
    // public String getContext(){
    //     return skystone;
    // }
    
    public void pointTurn(double power){ //check on the motors if it is reverse or not reverse
        motor0.setPower(power);
        motor1.setPower(power);
        motor2.setPower(power);
        motor3.setPower(power); //-
    }
        
    public void strafe(double power){ //check on the motors if it is reverse or not reverse
        motor0.setPower(power);
        motor1.setPower(-power); //-
        motor2.setPower(-power); //-
        motor3.setPower(power);
    }
        
    public void runMotorToTarget(int ticks, double power){
       motor0.setTargetPosition(ticks);
        motor1.setTargetPosition(ticks);
        motor2.setTargetPosition(-ticks);
        motor3.setTargetPosition(-ticks);
        motorsRunToPos();            
        moveMotors(power);
    }
    
     public void turnByEncoders(int ticks){
        motor0.setTargetPosition(ticks);
        motor1.setTargetPosition(ticks);
        motor2.setTargetPosition(ticks);
        motor3.setTargetPosition(ticks);
        //runPosEncoders();
        moveMotors(.35);
    }
    
    public void moveMotors(double power){ //depending if it is reverse or not reverse
        motor0.setPower(-power);
        motor1.setPower(-power);
        motor2.setPower(power);
        motor3.setPower(power);
    }
    public void resetEncoders(){
        motor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
        
     public void runUsingEncoders(){
        motor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
    }
        
    public void runWithoutEncoders(){
        motor0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); 
    }
        
    public void motorsRunToPos(){
        motor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
        
    public void stopMotors(){
        moveMotors(0);        
    }    
    // public void turnDegrees(double angle){ //3755 -3942 3937 -3847 tl tr bl br
    //     do{
    //         int target = (int)(7760 / (360 / angle));
    //         topLeft.setTargetPosition(target);
    //         topRight.setTargetPosition(-target);
    //         botLeft.setTargetPosition(target);
    //         botRight.setTargetPosition(-target);
        
    //         topLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //         topRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //         botLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //         botRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
    //         moveMotors(45);
    //     }while(topLeft.isBusy()&&topRight.isBusy()&&botLeft.isBusy()&&botRight.isBusy());
    // }
        public void turnDegrees(double angle, double power) { // 3755 -3942 3937 -3847 tl tr bl br
        do {
            int target = (int) (1900 / (360 / (angle*2)));  //(int)(7760 / (360 / angle));
            turnByEncoders(target);
            motorsRunToPos();
            moveMotors(power);
        
        }while(motor0.isBusy() && motor1.isBusy() && motor2.isBusy() && motor3.isBusy());
    }
}