package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
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
        robot.servo2.setPosition(0.3);

        robot.Straight(36);
        sleep(500);

        // Strafes left
        robot.Left_Strafe(2);
        sleep(500);

        //robot.ringDetection();
        //int x = robot.ringDetection();
        sleep(500);
        //robot.ServoSensor.setPower(0.5);
        double pos = robot.motor5.getCurrentPosition();
        telemetry.addData("Motor 5", robot.motor5 .getCurrentPosition());
        telemetry.update();
int x = 1;
        // ZONE B

        if(x == 1){
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
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(-24);
        }

        // ZONE C

        else if(x == 2){
            // Moves forward into zone C
            robot.Straight(76);
            sleep(500);

            // Strafes right
            robot.Right_Strafe(12);
            sleep(500);

            // Drops wobble goal into zone C
            robot.servo2.setPosition(0);
            sleep(1000);

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
            robot.servo2.setPosition(0);
            sleep(1000);

            // Moves backward onto line
            robot.Straight(-5);
        }
    }
}