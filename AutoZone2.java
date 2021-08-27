package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoZone2")
public class AutoZone2 extends LinearOpMode {

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

        //Strafes towards ring pile
        robot.Left_Strafe(10);
        sleep(500);

        //B
        if (2 == 2) {

            //goes forward to drop zone
            robot.Straight(30);
            sleep(500);

            //Robot moves left
            robot.Right_Strafe(30);
            sleep(500);

            robot.Straight(15);
            sleep(500);

            robot.servo4.setPosition(0.5);
            sleep(1000);

            //Robot Moves Backwards
            robot.Straight(-12);
            sleep(500);

            //strafes towards wall
            robot.Left_Strafe(22);
            sleep(500);

            //moves towards tower
            robot.Straight(48);
            sleep(500);

        }

        robot.Right_Strafe(30);
        sleep(500);

        robot.Straight(12);
        sleep(500);

        robot.motor5.setPower(-1);
        sleep(3000);
        robot.motor5.setPower(0);

        robot.Straight(-10);
        sleep(500);

        robot.Left_Strafe(25);
        sleep(500);

        robot.Straight(-45);
        sleep(500);


    }
}