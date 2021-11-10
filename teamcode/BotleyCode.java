package Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "TheAutoCode(TAC)", group = "Testv2")
public class BotleyCode extends LinearOpMode {
    private DcMotor motor0;
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private Servo   servo1;
    
@Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo1 = hardwareMap.get(Servo.class, "servo1");

        //autonomous
        waitForStart();
        
        moveMotors(.5);
        sleep(1000);
        stopMotors();
        turnPoint(.2);
        sleep(1000);
        stopMotors(); 
        servo1.setPosition(90);
        sleep(1000);
        servo1.setPosition(0);
    }
       
        public void stopMotors() {
            moveMotors(0);
        }
       
        public void moveMotors(double power) {
            motor0.setPower(-power);
            motor1.setPower(power);
            motor2.setPower(power);
            motor3.setPower(-power);
        }
         public void turnPoint(double power) {
            motor0.setPower(-power);
            motor1.setPower(-power);
            motor2.setPower(-power);
            motor3.setPower(-power);
          
        }
        
    
}