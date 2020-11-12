package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "teleop")
public class teleop extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor motor5;
    private DcMotor motor6;

    @Override
    public void runOpMode() {

        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        motor4 = hardwareMap.get(DcMotor.class, "motor4");
        motor5 = hardwareMap.get(DcMotor.class, "motor5");
        motor6 = hardwareMap.get(DcMotor.class, "motor6");

        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        if (opModeIsActive()) {

            while (opModeIsActive()) {

                {
                    if (gamepad1.right_stick_y != 0 || gamepad1.left_stick_y != 0) {
                        motor1.setPower(-gamepad1.left_stick_y);
                        motor2.setPower(-gamepad1.right_stick_y);
                        motor3.setPower(-gamepad1.left_stick_y);
                        motor4.setPower(-gamepad1.right_stick_y);
                    } else if (gamepad1.right_trigger > 0) {
                        motor1.setPower(gamepad1.right_trigger * 1.0);
                        motor2.setPower(gamepad1.right_trigger * -1.0);
                        motor3.setPower(gamepad1.right_trigger * -1.0);
                        motor4.setPower(gamepad1.right_trigger * 1.0);
                    } else if (gamepad1.left_trigger > 0) {
                        motor1.setPower(gamepad1.left_trigger * -1.0);
                        motor2.setPower(gamepad1.left_trigger * 1.0);
                        motor3.setPower(gamepad1.left_trigger * 1.0);
                        motor4.setPower(gamepad1.left_trigger * -1.0);
                    } else if (gamepad1.right_stick_y == 0 && gamepad1.left_stick_y == 0 && gamepad1.right_trigger == 0 && gamepad1.left_trigger == 0) {
                        motor1.setPower(0);
                        motor2.setPower(0);
                        motor3.setPower(0);
                        motor4.setPower(0);
                    }
                    motor6.setPower(gamepad2.right_stick_y);
                    motor5.setPower(gamepad2.left_stick_y);
                }
            }
        }
    }
}