package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "CombinedAuto")
public class CombinedAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DriveTrain robot = new DriveTrain();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap, this);
        waitForStart();

        // Moves forward from wall
        robot.Straight(36);
        sleep(500);

        // Strafes left
        robot.Left_Strafe(2);
        sleep(500);

        robot.ringDetection();
        int x = robot.ringDetection();
        sleep(500);
        robot.ServoSensor.setPower(0.5);
        double pos = robot.motor5.getCurrentPosition();
        telemetry.addData("Motor 5", robot.motor5 .getCurrentPosition());
        telemetry.update();

        // ZONE B

        if(pos >350 && pos <=400){
            // Moves forward to zone B
            robot.Straight(30);
            sleep(500);

            // Strafes left
            robot.Left_Strafe(20);
            sleep(500);

            // Moves forward into zone B
            robot.Straight(15);
            sleep(500);

            // Drops wobble goal into zone B
            robot.servo4.setPosition(0.5);
            sleep(1000);

            // Moves backward from zone B
            robot.Straight(-12);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(22);
            sleep(500);

            // Moves forward to low goal
            robot.Straight(48);
            sleep(500);

            //Strafes right
            robot.Right_Strafe(28);
            sleep(500);

            // Moves forward to low goal
            robot.Straight(16);
            sleep(500);

            // Drops ring into low goal
            robot.motor5.setPower(-1);
            sleep(3000);
            robot.motor5.setPower(0);

            // Moves backward from low goal
            robot.Straight(-10);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(10);
            sleep(500);

            // Moves backward onto line
            robot.Straight(-50);
        }

        // ZONE C

        else if(pos <=350){
            // Moves forward into zone C
            robot.Straight(76);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(12);
            sleep(500);

            // Drops wobble goal into zone C
            robot.servo4.setPosition(0.5);
            sleep(1000);

            // Moves backward from zone C
            robot.Straight(-12);
            sleep(500);

            // Strafes left
            robot.Left_Strafe(24);
            sleep(500);

            // Moves forward to low goal
            robot.Straight(40);
            sleep(500);

            // Drops ring into low goal
            robot.motor5.setPower(-1);
            sleep(3000);
            robot.motor5.setPower(0);

            // Moves backward onto line
            robot.Straight(-50);
        }

        // ZONE A

        else {
            // Moves forward into zone A
            robot.Straight(20);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(12);
            sleep(500);

            // Drops wobble goal into zone A
            robot.servo4.setPosition(0.5);
            sleep(1000);

            // Moves backward from zone A
            robot.Straight(-12);
            sleep(500);

            // Strafes left
            robot.Left_Strafe(24);
            sleep(500);

            // Moves forward to low goal
            robot.Straight(92);
            sleep(500);

            // Drops ring into low goal
            robot.motor5.setPower(-1);
            sleep(4000);
            robot.motor5.setPower(0);

            // Moves backward onto line
            robot.Straight(-50);
        }
    }
}