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

        // Moves forward from wall
        robot.Straight(36);
        sleep(500);

        // Strafes left
        robot.Left_Strafe(2);
        sleep(500);

        // ZONE B

        if(pos == 1){
            // Moves forward to zone B
            robot.Straight(30);
            sleep(500);

            // Strafes left
            robot.Left_Strafe(20);
            sleep(500);

            // Moves forward into zone B
            robot.Straight(15);
            sleep(500);


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

        else if(pos == 2){
            // Moves forward into zone C
            robot.Straight(76);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(12);
            sleep(500);


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