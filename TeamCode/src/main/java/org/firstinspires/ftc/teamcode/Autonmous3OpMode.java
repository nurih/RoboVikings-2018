package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous 3 Unwind Motor")
public class Autonmous3OpMode extends LinearOpMode {
    private static final int LATCH_LOWERING_TICKS = 1000;
    Servo latchLockServo;
    AutonmousDrive drive;
    private DcMotor latchLowerMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        drive = new AutonmousDrive(hardwareMap, telemetry);
        latchLockServo = getLatchLockServo();
        latchLowerMotor = RobotPart.latchLowerMotor.getInstance(hardwareMap);
        latchLowerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        // unlock the latch
        latchLockServo.setPosition(0.5);
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


    private Servo getLatchLockServo() {
        latchLockServo = RobotPart.latchLockServo.getInstance(hardwareMap);
        latchLockServo.setPosition(0);
        return latchLockServo;
    }


}
