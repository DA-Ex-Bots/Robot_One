package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "UGMeetAutoDom")
public class UGMeetAutoDom extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DriveTrain robot;

    {
        robot = new DriveTrain(this);
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap);
        waitForStart();

        //moves forward off of wall
        robot.Straight(56);

        //Strafes towards ring pile
        robot.Left_Strafe(24);

        //split
        //A

        //int x = motor5.getCurrentPosition();
        int x = 1;
        if (x == 1) {

            //strafes towards wall
            robot.Right_Strafe(36);

            //moves into drop zone
            robot.Straight(24);

            //drop wobble goal in zone A


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
            //code goes here

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