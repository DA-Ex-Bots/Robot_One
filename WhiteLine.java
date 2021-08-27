
    package org.firstinspires.ftc.teamcode;

    import com.qualcomm.robotcore.util.ElapsedTime;
    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
    import com.qualcomm.robotcore.eventloop.opmode.Disabled;
    import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    import com.qualcomm.robotcore.hardware.DcMotor;
    import com.qualcomm.robotcore.hardware.DcMotorController;

    @Autonomous(name="WhiteLine", group="Linear Opmode")

    public class WhiteLine extends LinearOpMode
    {

        private ElapsedTime runtime = new ElapsedTime();
        private DcMotor motor1 = null;
        private DcMotor motor2 = null;
        private DcMotor motor3 = null;
        private DcMotor motor4 = null;

        @Override
        public void runOpMode() {
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            motor1 = hardwareMap.get(DcMotor.class, "motor1");
            motor2 = hardwareMap.get(DcMotor.class, "motor2");
            motor3 = hardwareMap.get(DcMotor.class, "motor3");
            motor4 = hardwareMap.get(DcMotor.class, "motor4");

            motor1.setDirection(DcMotor.Direction.REVERSE);
            motor3.setDirection(DcMotor.Direction.REVERSE);
            motor2.setDirection(DcMotor.Direction.FORWARD);
            motor4.setDirection(DcMotor.Direction.FORWARD);

            waitForStart();
            runtime.reset();

            motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


            motor1.setTargetPosition(2600);
            motor2.setTargetPosition(2600);
            motor3.setTargetPosition(2600);
            motor4.setTargetPosition(2600);

            motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            telemetry.addData("Status","Run Time: " + runtime.toString());
            telemetry.update();

            motor1.setPower(0.5);
            motor2.setPower(0.5);
            motor3.setPower(0.5);
            motor4.setPower(0.5);

            while(motor1.isBusy()&& motor2.isBusy()&& motor3.isBusy()&& motor4.isBusy()){
                telemetry.update();
            }
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(0);
            motor4.setPower(0);
        }

    }
