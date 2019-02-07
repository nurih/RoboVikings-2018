package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Autonomous3 Off Da Hook", group = "Competition")
public class Autonmous3OpMode extends LinearOpMode {

    AutonomousDrive drive;
    LatchExtenderWithEncoders latchExtender;
    RevTouchSensor touchSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        latchExtender = new LatchExtenderWithEncoders(hardwareMap, telemetry);
        touchSensor = RobotPart.latchExtenderLimitSwitch.getInstance(hardwareMap);
        waitForStart();

        drive = new AutonomousDrive(hardwareMap, telemetry);

        // unwind lowering motor.

        latchExtender.rollDown();
        telemetry.addLine("Got down");
        telemetry.update();
        sleep(1000);

        drive.turn(-45);
        telemetry.addLine("turned");
        telemetry.update();

    }

}



