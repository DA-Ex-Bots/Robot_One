package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "BasicJacksonProgram", group = "Linear OpMode")
public class BasicJacksonProgram extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DriveTrain robot = new DriveTrain(this);

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        robot.Straight(10);

    }
}