package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot;


@TeleOp(name = "teleop")
public class teleop extends LinearOpMode {

    Robot robot = new Robot();

    // DRY - DON'T REPEAT YOURSELF
    // YAGNI - YOU AREN'T GOING to NEED IT
    
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {

            while (opModeIsActive()) {

                {
                    if (gamepad1.right_stick_y != 0 || gamepad1.left_stick_y != 0) {
                        robot.rb_motor.setPower(gamepad1.left_stick_y);
                        robot.lb_motor.setPower(gamepad1.right_stick_y);
                        robot.rf_motor.setPower(gamepad1.left_stick_y);
                        robot.lf_motor.setPower(gamepad1.right_stick_y);
                    } else if (gamepad1.right_trigger > 0) {
                        robot.rb_motor.setPower(gamepad1.right_trigger * 1.0);
                        robot.lb_motor.setPower(gamepad1.right_trigger * -1.0);
                        robot.rf_motor.setPower(gamepad1.right_trigger * -1.0);
                        robot.lf_motor.setPower(gamepad1.right_trigger * 1.0);
                    } else if (gamepad1.left_trigger > 0) {
                        robot.rb_motor.setPower(gamepad1.left_trigger * -1.0);
                        robot.lb_motor.setPower(gamepad1.left_trigger * 1.0);
                        robot.rf_motor.setPower(gamepad1.left_trigger * 1.0);
                        robot.lf_motor.setPower(gamepad1.left_trigger * -1.0);
                    } else if (gamepad1.right_stick_y == 0 && gamepad1.left_stick_y == 0 && gamepad1.right_trigger == 0 && gamepad1.left_trigger == 0) {
                        robot.rb_motor.setPower(0);
                        robot.lb_motor.setPower(0);
                        robot.rf_motor.setPower(0);
                        robot.lf_motor.setPower(0);

                    }
                }
            }
        }
    }
}