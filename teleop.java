 package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "teleop")
public class teleop extends LinearOpMode {

    DriveTrain DT = new DriveTrain();


    @Override
    public void runOpMode() {

        DT.init(hardwareMap, this);

        waitForStart();
        if (opModeIsActive()) {
            DT.WobbleArm.setPosition(0.5);
            while (opModeIsActive()) {
                telemetry.addData("debug1", DT.motor1.getCurrentPosition());
                {
                    if (gamepad1.right_stick_y != 0 || gamepad1.left_stick_y != 0) {
                        DT.motor1.setPower(gamepad1.left_stick_y);
                        DT.motor2.setPower(gamepad1.right_stick_y);
                        DT.motor3.setPower(gamepad1.left_stick_y);
                        DT.motor4.setPower(gamepad1.right_stick_y);
                    } else if (gamepad1.right_trigger > 0) {
                        DT.motor1.setPower(gamepad1.right_trigger * -1.0);
                        DT.motor2.setPower(gamepad1.right_trigger * 1.0);
                        DT.motor3.setPower(gamepad1.right_trigger * 1.0);
                        DT.motor4.setPower(gamepad1.right_trigger * -1.0);
                    } else if (gamepad1.left_trigger > 0) {
                        DT.motor1.setPower(gamepad1.left_trigger * 1.0);
                        DT.motor2.setPower(gamepad1.left_trigger * -1.0);
                        DT.motor3.setPower(gamepad1.left_trigger * -1.0);
                        DT.motor4.setPower(gamepad1.left_trigger * 1.0);
                    } else if (gamepad1.right_stick_y == 0 && gamepad1.left_stick_y == 0 && gamepad1.right_trigger == 0 && gamepad1.left_trigger == 0) {
                        DT.motor1.setPower(0);
                        DT.motor2.setPower(0);
                        DT.motor3.setPower(0);
                        DT.motor4.setPower(0);
                    }
                    DT.motor6.setPower(gamepad2.right_stick_y);
                    DT.motor5.setPower(-gamepad2.left_stick_y);
                    DT.motor7.setPower(-gamepad2.left_stick_y);

                    if(gamepad1.a) {
                        DT.WobbleArm.setPosition(1);
                    }else if(gamepad1.b) {
                        DT.WobbleArm.setPosition(0);
                    }else if(gamepad1.x) {
                        DT.WobbleGrabber.setPower(0);
                    }

                    if(gamepad1.dpad_down) {
                        DT.WobbleArm.setPosition(1);
                    }
                    if(gamepad1.dpad_up) {
                        DT.WobbleArm.setPosition(0);
                    }
                    if(gamepad1.dpad_left){
                        DT.WobbleArm.setPosition(0.55);
                    }
                    if(gamepad2.a){
                        DT.servo4.setPosition(0.5);
                    }
                    if(gamepad2.b){
                        DT.servo4.setPosition(0);
                    }
                }
            }
        }
    }
}