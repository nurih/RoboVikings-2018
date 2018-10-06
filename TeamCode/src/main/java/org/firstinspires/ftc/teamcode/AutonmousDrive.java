package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

class AutonmousDrive {
    private static final int DEGREES_PER_TICK = 9600 / 360;
    private static final double CENTIMETER_PER_TICK = 0.1;
    DcMotor leftMotor;
    DcMotor rightMotor;
    private Telemetry telemetry;

    public AutonmousDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        leftMotor = RobotPart.leftMotor.getInstance(hardwareMap);
        rightMotor = RobotPart.rightMotor.getInstance(hardwareMap);

        setupMotor(leftMotor, DcMotorSimple.Direction.REVERSE);
        setupMotor(rightMotor, DcMotorSimple.Direction.FORWARD);

        this.telemetry = telemetry;
        telemetry.addData("Degrees per tick", DEGREES_PER_TICK);
    }

    public void driveStraight(int centimeters) {
        telemetry.addData("Driving Streight (cm)", centimeters);
        int ticksToMove = (int) centimeterToTicks(centimeters);
        moveToPosition(leftMotor, ticksToMove);
        moveToPosition(rightMotor, ticksToMove);
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
    }

    private double centimeterToTicks(int centimeters) {
        return centimeters + CENTIMETER_PER_TICK;
    }

    private int degreesToTicks(int degrees) {
        int ticks = degrees * DEGREES_PER_TICK;
        return ticks;
    }

    private void setupMotor(DcMotor motor, DcMotorSimple.Direction direction) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setDirection(direction);
        motor.setPower(.5);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}