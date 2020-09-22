package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "JacksonOdometryTurnTest")
public class JacksonOdometryTurnTest extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;

    private int range = 50;

    @Override
    public void runOpMode() {

        waitForStart();

        setUp();

        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        while (opModeIsActive()) {
            if (runTo(motor1, motor2, motor3, motor4, 90)) {
                break;
            }

            telemetry.addData("Encoder Pos", motor1.getCurrentPosition());
            telemetry.update();
        }

    }

    private void setUp() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        motor4 = hardwareMap.get(DcMotor.class, "motor4");
    }

    private boolean runTo(DcMotor motorOne, DcMotor motorTwo, DcMotor motorThree, DcMotor motorFour, int degrees) {

        double Target = (((degrees / 360) * (13 * Math.PI)) / (1.5 * Math.PI)) * 1000;

        motorOne.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorThree.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFour.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        int RightPos = motorTwo.getCurrentPosition();
        int LeftPos = motorOne.getCurrentPosition();

        if (Target == 0) {
            telemetry.addData("Target", Target);
            sleep(5000);
            return true;
        }

        if (Target < 0) {
            while (Target != RightPos && opModeIsActive()) {
                telemetry.addData("Target", Target);
                sleep(5000);
                RightPos = motorTwo.getCurrentPosition();
                if(RightPos < Target + range) {
                    motorOne.setPower(-0.3);
                    motorTwo.setPower(0.3);
                    motorThree.setPower(-0.3);
                    motorFour.setPower(0.3);
                } else if (RightPos > Target - range) {
                    motorOne.setPower(0.3);
                    motorTwo.setPower(-0.3);
                    motorThree.setPower(0.3);
                    motorFour.setPower(-0.3);
                } else if (RightPos >= Target + range && RightPos <= Target - range) {
                    motorOne.setPower(0);
                    motorTwo.setPower(0);
                    motorThree.setPower(0);
                    motorFour.setPower(0);
                    return true;
                }
                telemetry.addData("Right Position", RightPos);
                telemetry.update();
            }
            return true;
        }
        if (Target > 0) {
            while (Target != LeftPos && opModeIsActive()) {
                telemetry.addData("Target", Target);
                sleep(5000);
                LeftPos = motorOne.getCurrentPosition();
                if (LeftPos > Target + range) {
                    motorOne.setPower(0.3);
                    motorTwo.setPower(-0.3);
                    motorThree.setPower(0.3);
                    motorFour.setPower(-0.3);
                } else if (LeftPos < Target - range) {
                    motorOne.setPower(-0.3);
                    motorTwo.setPower(0.3);
                    motorThree.setPower(-0.3);
                    motorFour.setPower(0.3);
                } else if (LeftPos >= Target + range && LeftPos <= Target - range) {
                    motorOne.setPower(0);
                    motorTwo.setPower(0);
                    motorThree.setPower(0);
                    motorFour.setPower(0);
                    return true;

                }
                telemetry.addData("LeftPos", LeftPos);
                telemetry.update();
            }
            return true;
        }
        sleep(5000);
        return true;
    }
}