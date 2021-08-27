package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot
{
    /* Public OpMode members. */
    public DcMotor rf_motor = null;
    public DcMotor lf_motor = null;
    public DcMotor rb_motor   = null;
    public DcMotor lb_motor  = null;

    public DcMotor  intake     = null;
    public Servo flicker    = null;
    public Servo grabber   = null;

    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;

    /* Constructor */
    public Robot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        rb_motor  = hwMap.get(DcMotor.class, "motor1");
        lb_motor = hwMap.get(DcMotor.class, "motor2");
        rf_motor = hwMap.get(DcMotor.class, "motor3");
        lf_motor = hwMap.get(DcMotor.class, "motor4");

        intake = hwMap.get(DcMotor.class, "motor5");

        flicker = (Servo)hwMap.get("servo1");
        grabber = (Servo)hwMap.get("servo2");

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        rb_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lf_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rb_motor.setDirection(DcMotorSimple.Direction.FORWARD);
        rf_motor.setDirection(DcMotorSimple.Direction.FORWARD);
        lb_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        lf_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}

