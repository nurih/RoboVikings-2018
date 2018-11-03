package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous 2 JustDrop")
public class Autonmous2OpMode extends LinearOpMode {
    private static final int LATCH_LOWERING_TICKS = 1000;
    Servo latchLockServo;
    AutonmousDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        drive = new AutonmousDrive(hardwareMap, telemetry);
        latchLockServo = getLatchLockServo();

        waitForStart();

        // unlock the latch
        latchLockServo.setPosition(0.5);
        sleep(3000);
        telemetry.addLine("turning");
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
