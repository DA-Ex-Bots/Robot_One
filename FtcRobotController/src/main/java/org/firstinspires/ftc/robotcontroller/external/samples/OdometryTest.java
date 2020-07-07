package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "OdometryTest")
public class OdometryTest extends LinearOpMode {

    private DcMotor motor1;

    private int range = 10;

    @Override
    public void runOpMode(){

        waitForStart();

        setUp();

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //motor1.setTargetPosition(1120);


        while(opModeIsActive()) {
// thsi is a change
            if(runTo(motor1, 1000)) {
                break;
            }

            telemetry.addData("Encoder Pos", motor1.getCurrentPosition());
            telemetry.update();
        }

    }
    private void setUp(){
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    private boolean runTo(DcMotor motorOne, int Target){

        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        int Pos = motorOne.getCurrentPosition();


        while(Target != Pos && opModeIsActive()){
            Pos = motorOne.getCurrentPosition();
            if(Pos < Target + range){
                motorOne.setPower(-1);
            }
            else if(Pos > Target - range){
                motorOne.setPower(1);
            }
            else if(Pos <= Target + range && Pos >= Target - range){
                motorOne.setPower(0);
                return true;
            }
        }
        return true;
    }
}