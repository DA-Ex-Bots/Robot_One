package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoZone1")
public class AutoZone1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DriveTrain robot = new DriveTrain();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap, this);
        waitForStart();

        //moves forward off of wall
        robot.Straight(36);
        sleep(500);
        //strafes towards wall
        robot.Right_Strafe(12);
        sleep(500);
        //split
        //A

        //int x = motor5.getCurrentPosition();
        int x = 1;
        if (x == 1) {

            //moves into drop zone
            robot.Straight(20);
            sleep(500);
            //drop wobble goal in zone A
            robot.servo4.setPosition(0.5);
            sleep(1000);
            //backs up from drop zone
            robot.Straight(-12);
            sleep(500);
            //strafes in front of tower
            robot.Left_Strafe(24);
            sleep(500);
            robot.Turn(-10);
            sleep(500);
            //goes forward to tower
            robot.Straight(92);
            sleep(500);
        }
        //Converge point - eject ring
        robot.motor5.setPower(-1);
        sleep(4000);
        robot.motor5.setPower(0);
        robot.Straight(-50);
        sleep(500);
    }
}