package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.nio.file.attribute.PosixFileAttributes;


@Autonomous
public class VuTest extends LinearOpMode {

    ConceptTensorFlowObjectDetection vu = new ConceptTensorFlowObjectDetection();

    @Override
    public void runOpMode() {
        vu.VuInit(hardwareMap, this);
        int pos = vu.VuStuff();

        telemetry.addData("Pos", pos);
        telemetry.update();

    }
}