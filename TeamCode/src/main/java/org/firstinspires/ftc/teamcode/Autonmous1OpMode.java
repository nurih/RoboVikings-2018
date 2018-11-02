package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous1")
public class Autonmous1OpMode extends LinearOpMode {
    private static final int LATCH_LOWERING_TICKS = 1000;
    DcMotor latchLiftMotor;
    DcMotor latchLowerMotor;
    Servo latchLockServo;
    AutonmousDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {


        waitForStart();

        drive = new AutonmousDrive(hardwareMap, telemetry);

        latchLiftMotor = getLatchLiftMotor();
        latchLowerMotor = getLatchLowerMotor();
        latchLockServo = getLatchLockServo();


        // unlock the latch
        latchLockServo.setPosition(0.5);
        sleep(3000);
        telemetry.addLine("turning");
        drive.turn(45);
        telemetry.addLine("turned");
        sleep(3000);

        drive.driveStraight(162);
        sleep(3000);
        drive.turn(90);
        sleep(3000);
        drive.driveStraight(177);
        sleep(3000);
    }



    private Servo getLatchLockServo() {
        latchLockServo = RobotPart.latchLockServo.getInstance(hardwareMap);
        latchLockServo.setPosition(0);
        return latchLockServo;
    }

    private DcMotor getLatchLiftMotor() {
        DcMotor motor = RobotPart.latchLiftMotor.getInstance(hardwareMap);
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        return motor;
    }

    private DcMotor getLatchLowerMotor() {
        DcMotor motor = RobotPart.latchLowerMotor.getInstance(hardwareMap);
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        return motor;
    }


}
