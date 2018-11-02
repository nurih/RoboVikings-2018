package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

class AutonmousDrive {
    private static final double TICKS_PER_DEGREE = 10;
    private static final double TICKS_PER_CENTIMETER = 10.42;

    DcMotor leftMotor;
    DcMotor rightMotor;
    private Telemetry telemetry;

    public AutonmousDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        leftMotor = RobotPart.leftMotor.getInstance(hardwareMap);
        rightMotor = RobotPart.rightMotor.getInstance(hardwareMap);

        setupMotor(leftMotor, DcMotorSimple.Direction.REVERSE);
        setupMotor(rightMotor, DcMotorSimple.Direction.FORWARD);

        this.telemetry = telemetry;
        telemetry.addData("Ticks per degree", TICKS_PER_DEGREE);
    }

    public void driveStraight(int centimeters) {
        telemetry.addData("Driving Streight (cm)", centimeters);

        int ticksToMove = (int) centimeterToTicks(centimeters);
        moveToPosition(leftMotor, ticksToMove);
        moveToPosition(rightMotor, ticksToMove);
        waitForMotorsToFinish(leftMotor, rightMotor);
    }

    private void moveToPosition(DcMotor motor, int ticksToMove) {

        int currentPosition = motor.getCurrentPosition();
        telemetry.addData("Ticks to move", ticksToMove);

        motor.setTargetPosition(currentPosition + ticksToMove);

    }

    public void turn(int degrees) {
        telemetry.addData("Turning (degrees)", degrees);

        int howFar = degreesToTicks(degrees);
        telemetry.addData("Turning (ticks)", howFar);

        // run right  motor
        moveToPosition(rightMotor, howFar);
        moveToPosition(leftMotor, -howFar);

        waitForMotorsToFinish(leftMotor, rightMotor);
    }

    private void waitForMotorsToFinish(DcMotor motor1, DcMotor motor2) {
        while (motor1.isBusy() || motor2.isBusy()){
            // spin wait
        }
    }

    private double centimeterToTicks(int centimeters) {
        return centimeters * TICKS_PER_CENTIMETER;
    }

    private int degreesToTicks(int degrees) {
        double ticks = degrees * TICKS_PER_DEGREE;
        return (int)ticks;
    }

    private void setupMotor(DcMotor motor, DcMotorSimple.Direction direction) {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setDirection(direction);
        motor.setPower(.5);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}