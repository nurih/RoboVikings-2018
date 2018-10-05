package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name = "Test Motor Encoder")
public class TestEncoderOpMode extends LinearOpMode {

    public static final int STOP_MOTOR = 0;
    public static final double MOVE_POWER = .5;

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        // set up the latch motor.
        DcMotor latchArmMotor = RobotPart.latchMotor.getInstance(hardwareMap);
        latchArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        latchArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        latchArmMotor.setPower(MOVE_POWER);

        // set up encoder

        // roll forward 100 "ticks"

        // ask encoder where it is now (initialEncoderPosition)
        int latchArmMotorPosition = latchArmMotor.getCurrentPosition();


        latchArmMotor.setTargetPosition(latchArmMotorPosition + 3000);

        do {
            telemetry.addData("Position", latchArmMotor.getCurrentPosition());
            telemetry.update();
        } while (latchArmMotor.isBusy());

        telemetry.addData("Position", latchArmMotor.getCurrentPosition());
        telemetry.addLine("Done");
        telemetry.update();
    }
}
