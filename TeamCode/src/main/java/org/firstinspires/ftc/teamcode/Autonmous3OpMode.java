package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous 3 Unwind Motor")
public class Autonmous3OpMode extends LinearOpMode {
    private static final int LATCH_LOWERING_TICKS = 1000;

    AutonomousDrive drive;
    private DcMotor latchLowerMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        drive = new AutonomousDrive(hardwareMap, telemetry);

        latchLowerMotor = RobotPart.latchLowerMotor.getInstance(hardwareMap);
        latchLowerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        sleep(3000);
        telemetry.addLine("turning");

        // unwind lowering motor.
        double now;
        do {
            now = getRuntime();
            latchLowerMotor.setPower(-1);
        } while (getRuntime() < now + 0.5);

        latchLowerMotor.setPower(0);

        drive.turn(45);
        telemetry.addLine("turned");
        sleep(3000);
    }



    }



