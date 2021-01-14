package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "CombinedAuto")
public class Auto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    ConceptTensorFlowObjectDetection vu = new ConceptTensorFlowObjectDetection();
    DriveTrain robot = new DriveTrain();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap, this);
        vu.VuInit(hardwareMap, this);
        int pos = vu.VuStuff();

        telemetry.addData("Pos", pos);
        telemetry.update();

        waitForStart();

        robot.servo2.setPosition(0.3);

        // Moves forward from wall
        robot.Straight(-36);
        sleep(500);

        // Strafes left
        robot.Left_Strafe(-2);
        sleep(500);

        // ZONE B

        if(pos == 1){
            robot.Straight(-30);
            sleep(500);

            // Strafes left
            robot.Left_Strafe(-20);
            sleep(500);

            // Moves forward into zone B
            robot.Straight(-15);
            sleep(500);

            // Drops wobble goal into zone B
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(24);
        }

        // ZONE C

        else if(pos == 2){
            // Moves forward into zone C
            robot.Straight(-84);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(-12);
            sleep(500);

            // Drops wobble goal into zone C
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(50);
        }

        // ZONE A

        else {
            // Moves forward into zone A
            robot.Straight(-20);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(-12);
            sleep(500);

            // Drops wobble goal into zone A
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(5);
        }

        robot.motor6.setPower(0.9);
        robot.motor7.setPower(-0.9);

        if(pos != 1) {
            robot.Left_Strafe(10);
        }
        robot.servo1.setPosition(0.25);
        sleep(500);
        robot.servo1.setPosition(0);
        sleep(500);

        robot.servo1.setPosition(0.25);
        sleep(500);
        robot.servo1.setPosition(0);
        sleep(500);

        robot.servo1.setPosition(0.25);
        sleep(500);
        robot.servo1.setPosition(0);
        sleep(1000);

        robot.motor6.setPower(0);
        robot.motor7.setPower(0);


        robot.Straight(-10);
    }
}
