package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "UGMeet1Auto")
public class UGMeet1Auto extends LinearOpMode {

    HardwareMap hwmap = null;

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;
    private DcMotor motor4 = null;
    //private DcMotor motor5 = null;
    private Servo servo1 = null;
    private Servo servo2 = null;

    DriveTrain robot;

    {
        robot = new DriveTrain();
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        robot.init(hardwareMap, this);

        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        motor4 = hardwareMap.get(DcMotor.class, "motor4");
        //motor5 = hardwareMap.get(DcMotor.class, "motor5");

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //motor5.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //moves forward off of wall
        robot.Straight(56);

        //Strafes towards ring pile
        robot.Left_Strafe(24);

        servo1.setPosition(1);

        //read position of rod

        //split
        //A

        int x = 1; //motor5.getCurrentPosition();
        if (x == 1) {

            //strafes towards wall
            robot.Right_Strafe(36);

            //moves into drop zone
            robot.Straight(24);

            //drop wobble goal in zone A
            servo2.setPosition(1);

            //backs up from drop zone
            robot.Straight(-12);

            //strafes in front of tower
            robot.Left_Strafe(24);

            //goes forward to tower
            robot.Straight(60);

            //turns in front of tower
            robot.Turn(90);
        }
        //B
        else if (x == 2) {

            //goes forward to drop zone
            robot.Straight(48);

            //servo release wobble goal
            servo2.setPosition(1);

            //moves away from wobble goal
            robot.Straight(12);

            //strafes towards wall
            robot.Right_Strafe(24);

            //moves towards tower
            robot.Straight(36);

            //turns in front of tower
            robot.Turn(90);
        }
        //C
        else if (x == 3) {
            robot.Right_Strafe(24);

            robot.Straight(72);

            //servo release wobble goal
            //code here

            robot.Straight(-12);

            robot.Left_Strafe(24);

            robot.Turn(90);

            robot.Left_Strafe(12);
        }
        //Converge point

        //eject ring

        robot.Turn(90);

        //
        robot.Straight(60);

    }
}
