package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Ko Test")
public class Test extends LinearOpMode {

    DriveTrain robot = new DriveTrain();

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap, this);
        robot.motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        while(opModeIsActive()){

            telemetry.addData("Motor 4", robot.motor4 .getCurrentPosition());
            telemetry.update();
            robot.motor4.setPower(1);
        }
    }
}
