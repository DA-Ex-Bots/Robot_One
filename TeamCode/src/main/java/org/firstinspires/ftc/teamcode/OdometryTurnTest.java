package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "OdometryTurnTest")
public class OdometryTurnTest extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;

    private int range = 10;

    @Override
    public void runOpMode() {

        waitForStart();

        setUp();

        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        while (opModeIsActive()) {
            if (runTo(motor1, motor2, motor3, motor4, -90)) {
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

    private boolean runTo(DcMotor motorOne, DcMotor motorTwo, DcMotor motorThree, DcMotor motorFour, int Target) {

        motorOne.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorThree.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFour.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        int RightPos = motorTwo.getCurrentPosition();
        int LeftPos = motorOne.getCurrentPosition();

        if (Target == 0) {
            return true;
        }

        if (Target > 0) {
            while (Target != RightPos && opModeIsActive()) {
                if (RightPos < Target + range) {
                    motorOne.setPower(-0.5);
                    motorTwo.setPower(0.5);
                    motorThree.setPower(-0.5);
                    motorFour.setPower(0.5);
                } else if (RightPos > Target - range) {
                    motorOne.setPower(0.5);
                    motorTwo.setPower(-0.5);
                    motorThree.setPower(0.5);
                    motorFour.setPower(-0.5);
                } else if (RightPos <= Target + range && RightPos >= Target - range) {
                    motorOne.setPower(0);
                    motorTwo.setPower(0);
                    motorThree.setPower(0);
                    motorFour.setPower(0);
                    return true;
                }
            }
        }
        if (Target < 0) {
            while (Target != LeftPos && opModeIsActive()) {
                if (LeftPos < Target + range) {
                    motorOne.setPower(0.5);
                    motorTwo.setPower(-0.5);
                    motorThree.setPower(0.5);
                    motorFour.setPower(-0.5);
                } else if (LeftPos > Target - range) {
                    motorOne.setPower(-0.5);
                    motorTwo.setPower(0.5);
                    motorThree.setPower(-0.5);
                    motorFour.setPower(0.5);
                } else if (LeftPos <= Target + range && LeftPos >= Target - range) {
                    motorOne.setPower(0);
                    motorTwo.setPower(0);
                    motorThree.setPower(0);
                    motorFour.setPower(0);
                    return true;

                }
            }
            return true;
        }
    return true;
    }
}