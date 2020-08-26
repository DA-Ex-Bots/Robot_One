package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Odometry  {

    private LinearOpMode OP;
    private HardwareMap HM;


    public DcMotor motor1 = null;
    public DcMotor motor2 = null;
    public DcMotor motor3 = null;
    public DcMotor motor4 = null;


    Odometry(LinearOpMode OP, HardwareMap HM){
        this.OP = OP;
        this.HM = HM;
        motor1 = (DcMotor)HM.get("motor1");
        motor2 = (DcMotor)HM.get("motor2");
        motor3 = (DcMotor)HM.get("motor3");
        motor4 = (DcMotor)HM.get("motor4");
        motor3.setDirection(DcMotor.Direction.REVERSE);
        motor4.setDirection(DcMotor.Direction.REVERSE);
    }



    private final double ROBOT_WIDTH = 13;

    private double[] locationTrans = {0, 0};
    private double[] location = {0, 0};
    private double x = 0;
    private double y = 0;
    private double orientation = 0;
    private double arcLength = 0;

    private double TPR = 1000;
    //^ a variable used in both functions Ticks per revolution
    private double WheelWidth = 1.5;
    //^ a variable used in both functions this is the diameter of the wheel
    private double Circumfrence = Math.PI * WheelWidth;
    //^ a variable used in both functions this is the circumfrence of the wheel
    private double RobotCircum = Math.PI * ROBOT_WIDTH;



    public void track(){

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        OP.waitForStart();

        while(OP.opModeIsActive()){
            orientation = (((((motor1.getCurrentPosition() - motor2.getCurrentPosition())/2) * Circumfrence) / TPR) / RobotCircum) * (2*Math.PI);
            arcLength = ((((orientation/(2*Math.PI)) * RobotCircum) / Circumfrence) * TPR);
            x = ((Math.sin(orientation) * motor1.getCurrentPosition()) + (Math.cos(orientation) * motor3.getCurrentPosition())) - location[0] - arcLength;
            y = ((Math.sin(orientation) * motor3.getCurrentPosition()) + (Math.cos(orientation) * motor1.getCurrentPosition())) - location[1] - arcLength;
            location[0] += x;
            location[1] += y;
            locationTrans[0] = ((location[0] * Circumfrence) / TPR);
            locationTrans[1] = ((location[1] * Circumfrence) / TPR);
            OP.telemetry.addData("location X", locationTrans[0]);
            OP.telemetry.addData("location Y", locationTrans[1]);
            OP.telemetry.addData("orientation", (orientation * (180/Math.PI)));
            OP.telemetry.update();
        }
    }
}
