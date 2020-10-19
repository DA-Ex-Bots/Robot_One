package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
private ElapsedTime runtime = new ElapsedTime();
private DcMotor motor1 = null;
private DcMotor motor2 = null;
private DcMotor motor3 = null;
private DcMotor motor4 = null;

        DriveTrain robot;

        {
        robot = new DriveTrain();
        }

@Override
public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        motor2.setDirection(DcMotor.Direction.REVERSE);
        motor4.setDirection(DcMotor.Direction.REVERSE);

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.Straight(12);

        robot.Turn(90);
        }
@Autonomous(name="EseehCDetleM", group="Linear Opmode")

public class EseehCDetleM extends LinearOpMode {


    }
