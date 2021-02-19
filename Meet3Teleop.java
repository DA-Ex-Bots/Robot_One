package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Meet3Teleop")
public class Meet3Teleop extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    double time;
    DriveTrain DT = new DriveTrain();

    private boolean pressed = false;
    private double timeTwo = 0;

    @Override
    public void runOpMode() {

        DT.init(hardwareMap, this);

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                {
                    if (gamepad1.left_stick_y != 0 || gamepad1.right_stick_y != 0) {
                        DT.motor1.setPower(0.9 * -gamepad1.right_stick_y);
                        DT.motor2.setPower(0.9 * -gamepad1.left_stick_y);
                        DT.motor3.setPower(0.9 * -gamepad1.right_stick_y);
                        DT.motor4.setPower(0.9 * -gamepad1.left_stick_y);
                    } else if (gamepad1.left_trigger > 0) {
                        DT.motor1.setPower(gamepad1.left_trigger * -1.0);
                        DT.motor2.setPower(gamepad1.left_trigger * 1.0);
                        DT.motor3.setPower(gamepad1.left_trigger * 1.0);
                        DT.motor4.setPower(gamepad1.left_trigger * -1.0);
                    } else if (gamepad1.right_trigger > 0) {
                        DT.motor1.setPower(gamepad1.right_trigger * 1.0);
                        DT.motor2.setPower(gamepad1.right_trigger * -1.0);
                        DT.motor3.setPower(gamepad1.right_trigger * -1.0);
                        DT.motor4.setPower(gamepad1.right_trigger * 1.0);
                    } else if (gamepad1.right_stick_y == 0 && gamepad1.left_stick_y == 0 && gamepad1.right_trigger == 0 && gamepad1.left_trigger == 0) {
                        DT.motor1.setPower(0);
                        DT.motor2.setPower(0);
                        DT.motor3.setPower(0);
                        DT.motor4.setPower(0);
                    }

                    DT.motor5.setPower(gamepad2.right_stick_y);
                    if(gamepad2.right_trigger > 0) {
                        DT.motor6.setPower(0.9 * gamepad2.right_trigger);
                        DT.motor7.setPower(0.9 * -gamepad2.right_trigger);
                    }else{
                        DT.motor6.setPower(gamepad2.left_trigger * 0.75);
                        DT.motor7.setPower(-gamepad2.left_trigger * 0.75);
                    }
                    DT.motor8.setPower(gamepad2.left_stick_y);

                    if(gamepad1.a && pressed == false && runtime.milliseconds() >=  timeTwo + 300) {
                        DT.servo1.setPosition(0.7);
                        time = runtime.milliseconds();
                        pressed = true;
                    }
                    if(runtime.milliseconds() >= time + 300 && pressed == true) {
                        DT.servo1.setPosition(0);
                        pressed = false;
                        timeTwo = runtime.milliseconds();
                    }
                    if(gamepad1.x) {
                        DT.servo2.setPosition(0);
                    }

                    if(gamepad2.a){
                        DT.servo2.setPosition(0);
                    }
                    if(gamepad2.b){
                        DT.servo2.setPosition(0.3);
                    }
                }
            }
        }
    }
}