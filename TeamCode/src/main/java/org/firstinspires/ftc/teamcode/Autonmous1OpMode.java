package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Autonomous1")
public class Autonmous1OpMode extends LinearOpMode {
    private static final int LATCH_LOWERING_TICKS = 1000;
    DcMotor latchMotor;
    AutonmousDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {


        waitForStart();
        drive = new AutonmousDrive(hardwareMap, telemetry);

        latchMotor = getLatchMotor();

        // run it a few rotations (how many)
        int targetPosition = latchMotor.getCurrentPosition() + LATCH_LOWERING_TICKS;

        telemetry.addData("Target Position is ", targetPosition);
        telemetry.update();

        latchMotor.setTargetPosition(targetPosition);

        // stop
        // drive

        // go to position 1
        drive.driveStraight(400);
        telemetry.update();

        sleep(3000);
// turn 90 degrees
        drive.turn(90);
        telemetry.addLine("Done turning");
        telemetry.update();
        sleep(3000);

    }

    private DcMotor getLatchMotor() {
        latchMotor = RobotPart.latchMotor.getInstance(hardwareMap);
        latchMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        latchMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        latchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        latchMotor.setPower(5.0);
        return latchMotor;
    }


}
