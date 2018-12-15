package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Test Motor Encoder", group = "Test")
public class TestEncoderOpMode extends LinearOpMode {

    public static final int STOP_MOTOR = 0;
    public static final double MOVE_POWER = .5;

    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousDrive drive = new AutonomousDrive(hardwareMap,telemetry);
        waitForStart();

        drive.driveStraight(100);

        telemetry.addLine("done");

        telemetry.update();
        sleep(10000);

    }
}
