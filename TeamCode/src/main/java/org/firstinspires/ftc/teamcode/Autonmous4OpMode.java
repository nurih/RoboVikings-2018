package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous4 Drop Marker", group = "Competition")
public class Autonmous4OpMode extends LinearOpMode {

    AutonomousDrive drive;
    LatchExtenderWithEncoders latchExtender;
    RevTouchSensor touchSensor;
    Servo markerServo;

    @Override
    public void runOpMode() throws InterruptedException {
        latchExtender = new LatchExtenderWithEncoders(hardwareMap, telemetry);
        touchSensor = RobotPart.latchExtenderLimitSwitch.getInstance(hardwareMap);
        markerServo = RobotPart.markerServo.getInstance(hardwareMap);
        waitForStart();

        drive = new AutonomousDrive(hardwareMap, telemetry);


        latchExtender.rollDown();
        telemetry.addLine("Got down");
        telemetry.update();
        sleep(1000);

        drive.turn(-28);
        telemetry.addLine("turned");
        telemetry.update();
        drive.driveStraight(10);
        drive.turn(18);

        drive.driveStraight(264);
        telemetry.addLine("left lander");
        telemetry.update();

        releaseMarker();
        telemetry.addLine("drop servo");
        telemetry.update();
    }

    public void releaseMarker() {
        markerServo.setPosition(0.6);
    }
}



