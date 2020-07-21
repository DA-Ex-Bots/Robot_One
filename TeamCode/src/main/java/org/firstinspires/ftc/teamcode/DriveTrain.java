package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//@Disabled
public class DriveTrain {

    LinearOpMode opmode;

    public DcMotor motor1 = null;
    public DcMotor motor2 = null;
    public DcMotor motor3 = null;
    public DcMotor motor4 = null;

    private double gearRatio = 1;
    //^ a variable used in both functions and can be changed from robot to robot
    private double TPR = 1120;
    //^ a variable used in both functions Ticks per revolution
    private double WheelWidth = 4;
    //^ a variable used in both functions this is the diameter of the wheel
    private double Circumfrence = Math.PI * WheelWidth;
    //^ a variable used in both functions this is the circumfrence of the wheel

    HardwareMap hwmap = null;

    public DriveTrain(LinearOpMode opmode){
        this.opmode = opmode;
    }

    public void init(HardwareMap ahwmap) {
        // this is a function used to intialize the motors
        hwmap = ahwmap;
        motor1 = (DcMotor)hwmap.get("motor1");
        motor2 = (DcMotor)hwmap.get("motor2");
        motor3 = (DcMotor)hwmap.get("motor3");
        motor4 = (DcMotor)hwmap.get("motor4");
        motor3.setDirection(DcMotor.Direction.REVERSE);
        motor4.setDirection(DcMotor.Direction.REVERSE);

    }

    public void Straight(int inches){

        double revolutions = (inches / Circumfrence); //revolutions needed to go
        int dist = (int)(revolutions * TPR * gearRatio); //  the ticks needed to go
        opmode.telemetry.addData("debug", 1);
        opmode.telemetry.update();
        //opmode.sleep(1);
        //to go that number of ticks as specified in the variable above

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor1.setTargetPosition(dist);
        motor2.setTargetPosition(dist);
        motor3.setTargetPosition(dist);
        motor4.setTargetPosition(dist);

        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //motor1.setPower(0.5);
        //motor2.setPower(0.5);
        //motor3.setPower(0.5);
        //motor4.setPower(0.5);

        /*while(motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy() && opmode.opModeIsActive()){
            opmode.telemetry.addData("Motor 1 is busy: ", motor1.isBusy());
            opmode.telemetry.update();
            //telemetry.update();
        }*/
    }

    public void Turn(int angle){
        double revolutions = (angle / Circumfrence); //revolutions needed to go
        int dist = (int)(revolutions * TPR * gearRatio); //the ticks needed to go
        double turn = 5.1; //the number needed to change from a straight to a turn
        int distance = (int)(dist / turn);

        opmode.telemetry.addData("debug", 2);
        opmode.telemetry.update();
        opmode.sleep(1000);

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor1.setTargetPosition(distance);
        motor2.setTargetPosition(distance);
        motor3.setTargetPosition(-distance);
        motor4.setTargetPosition(-distance);

        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor1.setPower(1);
        motor2.setPower(1);
        motor3.setPower(-1);
        motor4.setPower(-1);

        while(motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy() && opmode.opModeIsActive()){
            //telemetry.update();
        }
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        motor4.setPower(0);
    }

    public void Left_Strafe(int inches) {

        double revolutions = (inches / Circumfrence); //revolutions needed to go
        int dist = (int) (revolutions * TPR * gearRatio); //  the ticks needed to go

        //to go that number of ticks as specified in the variable above

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor1.setTargetPosition(dist);
        motor2.setTargetPosition(-dist);
        motor3.setTargetPosition(dist);
        motor4.setTargetPosition(-dist);

        motor1.setPower(0.5);
        motor2.setPower(0.5);
        motor3.setPower(0.5);
        motor4.setPower(0.5);

        //while (m1.isBusy()) {
          //  telemetry.update();
          //  telemetry.addData("Motor 1 is Busy:", m1.isBusy());
        }

    public void Right_Strafe(int inches) {


        double revolutions = (inches / Circumfrence); //revolutions needed to go
        int dist = (int) (revolutions * TPR * gearRatio); //  the ticks needed to go

        //to go that number of ticks as specified in the variable above

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor1.setTargetPosition(-dist);
        motor2.setTargetPosition(dist);
        motor3.setTargetPosition(-dist);
        motor4.setTargetPosition(dist);

        motor1.setPower(0.5);
        motor2.setPower(0.5);
        motor3.setPower(0.5);
        motor4.setPower(0.5);

        //while (m1.isBusy()) {
           // telemetry.update();
           // telemetry.addData("Motor 1 is Busy:", m1.isBusy());
        }

    public void Grad_Turn(int angle, int radius, char direction){
        double robot_width = 18; //used in order to calculate the distance the outer wheel will go

        //the circumference of the circle the inner and outer wheels will make (in inches)
        double inner_C = 2 * Math.PI * radius;
        double outer_C = 2 * Math.PI * radius + robot_width;

        //the distance travelled by the inner and outer wheels (in inches).
        double inner_dist = inner_C * (angle/360);
        double outer_dist = inner_C * (angle/360);

        //revolutions needed to go for the inner and outer sides
        double revolutions_I = (inner_dist / Circumfrence);
        double revolutions_O = (outer_dist / Circumfrence);
        opmode.telemetry.addData("revI", inner_dist);
        opmode.telemetry.addData("revO", outer_dist);
        opmode.telemetry.update();
        opmode.sleep(1000);
        //the ticks needed to go for the inner  and outer sides
        int dist_I = (int)(revolutions_I * TPR * gearRatio);
        int dist_O = (int)(revolutions_O * TPR * gearRatio);

        int ratio = 100 / (dist_I + dist_O); // the ratio that is used later to determine the power for each motor

        double power_I = (dist_I * ratio) / 100;
        double power_O = (dist_O * ratio) / 100;

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if (direction == 'R') { // if the turn is to the right

            motor1.setTargetPosition(dist_I);
            motor2.setTargetPosition(dist_I);
            motor3.setTargetPosition(dist_O);
            motor4.setTargetPosition(dist_O);

            motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            motor1.setPower(power_I);
            motor2.setPower(power_I);
            motor3.setPower(power_O);
            motor4.setPower(power_O);


            while (motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy() && opmode.opModeIsActive()) {
                //telemetry.update();
            }
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(0);
            motor4.setPower(0);

        }else if (direction == 'L'){ // if the turn is to the left

            motor1.setTargetPosition(dist_O);
            motor2.setTargetPosition(dist_O);
            motor3.setTargetPosition(dist_I);
            motor4.setTargetPosition(dist_I);

            motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            motor1.setPower(power_O);
            motor2.setPower(power_O);
            motor3.setPower(power_I);
            motor4.setPower(power_I);

            while (motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy() && opmode.opModeIsActive()) {
                //telemetry.update();
            }
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(0);
            motor4.setPower(0);

        }else{
            //telemetry.addData("Incorrect directional value: ", direction);
        }
    }
}