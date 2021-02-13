package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "ExtraCompleteAuto")
public class ExtraCompleteAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    ConceptTensorFlowObjectDetection vu = new ConceptTensorFlowObjectDetection();
    DriveTrain robot = new DriveTrain();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap, this);
        telemetry.addData("Debug", 1);
        telemetry.update();
        vu.VuInit(hardwareMap, this);
        int pos = vu.VuStuff();

        telemetry.addData("Pos", pos);
        telemetry.update();

        waitForStart();

        robot.servo2.setPosition(0.3);

        // Moves forward from wall
        robot.Straight(32);
        sleep(500);

        // ZONE B

        if(pos == 1){
            robot.Straight(30);
            sleep(500);

            // Strafes left
            robot.Left_Strafe(24);
            sleep(500);

            // Turns toward high goal
            robot.Turn(10);

            // Moves forward into zone B
            robot.Straight(16);
            sleep(500);

            // Drops wobble goal into zone B
            robot.servo2.setPosition(0);
            sleep(1000);

            robot.motor6.setPower(0.8);
            robot.motor7.setPower(-0.8);

            // Moves backward onto line
            robot.Straight(-30);

            // Strafes to line up with high goal
            robot.Right_Strafe(10);
        }

        // ZONE C

        else if(pos == 2){
            // Moves forward into zone C
            robot.Straight(84);
            sleep(500);

            // Drops wobble goal into zone C
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(-63);
        }

        // ZONE A

        else {
            // Moves forward into zone A
            robot.Straight(28);
            sleep(500);

            // Strafes toward zone A
            robot.Right_Strafe(12);
            sleep(500);

            // Drops wobble goal into zone A
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(-12);

            // Turns toward the high goal
            robot.Turn(10);
        }

        robot.motor6.setPower(0.8);
        robot.motor7.setPower(-0.8);

        if(pos != 1) {
            robot.Left_Strafe(26);
        }
        sleep(500);
        robot.servo1.setPosition(0.5);
        sleep(500);
        robot.servo1.setPosition(0);
        sleep(500);

        robot.servo1.setPosition(0.5);
        sleep(500);
        robot.servo1.setPosition(0);
        sleep(500);

        robot.servo1.setPosition(0.5);
        sleep(500);
        robot.servo1.setPosition(0);
        sleep(1000);

        robot.motor6.setPower(0);
        robot.motor7.setPower(0);

        // Strafes toward second wobble goal
        robot.Left_Strafe(17);

        // Flips wobble arm over
        robot.motor8.setPower(-1);
        sleep(1150);
        robot.motor8.setPower(0);

        if (pos == 1) {
            robot.Straight(-5);
        }

        // Backs up toward second wobble goal
        robot.Straight(-22);

        // Picks up second wobble goal
        robot.servo2.setPosition(0.3);
        sleep(1000);

        // Raises second wobble goal
        robot.motor8.setPower(1);
        sleep(900);
        robot.motor8.setPower(0);

        // ZONE B

        if(pos == 1) {
            // Moves toward zone B
            robot.Straight(48);

            // Strafes toward zone B
            robot.Right_Strafe(20);

            // Releases second wobble goal into zone B
            robot.servo2.setPosition(0);

            // Parks on white line
            robot.Straight(-10);
            sleep(500);
        }

        // ZONE C

        else if(pos == 2) {
            // Moves toward zone C
            robot.Straight(50);
            sleep(500);

            // Strafes toward zone C
            robot.Right_Strafe(12);
            sleep(500);

            // Releases second wobble goal into zone C
            robot.servo2.setPosition(0);
            sleep(500);

            // Parks on white line
            robot.Straight(-24);
        }

        // ZONE A

        else {
            // Moves toward zone A
            robot.Straight(35);

            // Strafes toward zone A
            robot.Right_Strafe(46);

            // Releases second wobble goal into zone A
            robot.servo2.setPosition(0);
            sleep(500);

            // Backs up from zone A
            robot.Straight(-10);
            sleep(500);

            // Strafes away from zone A
            robot.Left_Strafe(20);
            sleep(500);

            // Parks on white line
            robot.Straight(20);
        }
    }
}