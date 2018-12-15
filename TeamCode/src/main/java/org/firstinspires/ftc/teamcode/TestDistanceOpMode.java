package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name = "Show Distance", group = "Test")
public class TestDistanceOpMode extends OpMode {

    private Rev2mDistanceSensor distanceSensor;

    @Override
    public void init() {

        distanceSensor = RobotPart.distanceSensor.getInstance(hardwareMap);

        telemetry.addLine("Initialized");

    }

    @Override
    public void loop() {
        telemetry.addData("Range in MM", distanceSensor.getDistance(DistanceUnit.MM));
        telemetry.addData("Range in Inches", distanceSensor.getDistance(DistanceUnit.INCH));

        // Rev2mDistanceSensor specific methods.
        telemetry.addData("Is it valid?", Boolean.toString(distanceSensor.didTimeoutOccur()));

        telemetry.update();
    }
}