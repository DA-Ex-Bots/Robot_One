package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

    @Autonomous(name = "AutoZone3")
    public class AutoZone3 extends LinearOpMode {

        private ElapsedTime runtime = new ElapsedTime();

        DriveTrain robot = new DriveTrain();

        @Override
        public void runOpMode() {
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            robot.init(hardwareMap, this);
            waitForStart();

            //moves forward off of wall
            robot.Straight(36);
            sleep(500);

            robot.Left_Strafe(12);
            sleep(500);

            //int x = motor5.getCurrentPosition();
            int x = 3;
            if (x == 1) {
            }
            //C
            else if (x == 3) {

                robot.Straight(76);
                sleep(500);

                robot.servo4.setPosition(0.5);
                sleep(1000);

                robot.Straight(-12);
                sleep(500);

                robot.Left_Strafe(-24);
                sleep(500);

            }
            robot.Straight(39);
            sleep(500);

            robot.motor5.setPower(-1);
            sleep(3000);
            robot.motor5.setPower(0);

            robot.Straight(-50);
            sleep(500);

        }
    }


