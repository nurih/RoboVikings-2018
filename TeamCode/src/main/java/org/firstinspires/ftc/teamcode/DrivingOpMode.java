package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Driving Test")
public class DrivingOpMode extends OpMode {


    public static final double GATE_CLOSED_POSITION = .5;
    private static final double GATE_OPEN_POSITION = 0;

    private static final double BRUSH_STOP = 0;
    private static final double BRUSH_GO = 1.0;
    public static final double LATCH_POWER = 0.5;

    private float leftMotorPower;
    private float rightMotorPower;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo gateServo;
    private DcMotor brushMotor;
    private DcMotor latchMotor;
    private DcMotor armExtenderMotor;
    private DcMotor armLiftingMotor;

    @Override
    public void init() {
        leftMotor = RobotPart.leftMotor.getInstance(hardwareMap);
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightMotor = RobotPart.rightMotor.getInstance(hardwareMap);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // get intake Servo
        brushMotor = RobotPart.brushMotor.getInstance(hardwareMap);
        brushMotor.setPower(BRUSH_STOP);
        // get brush Servo
        gateServo = RobotPart.gateServo.getInstance(hardwareMap);
        gateServo.setPosition(GATE_CLOSED_POSITION);

        latchMotor = RobotPart.latchMotor.getInstance(hardwareMap);
        latchMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        latchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armExtenderMotor = RobotPart.armExtenderMotor.getInstance(hardwareMap);
        armExtenderMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armExtenderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armLiftingMotor = RobotPart.armLiftingMotor.getInstance(hardwareMap);
        armLiftingMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armLiftingMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void loop() {

        doDriving();

        doBrush();

        doGateOpening();

        doLatchMotor();

        doExtend();

        doLift();
    }

    private void doLatchMotor() {
        if (gamepad2.right_bumper) {
            latchMotor.setPower(LATCH_POWER);
        } else if (gamepad2.left_bumper) {
            latchMotor.setPower(-LATCH_POWER);
        } else {
            latchMotor.setPower(0);
        }

    }

    private void doGateOpening() {
        if (gamepad1.right_bumper) {
            gateServo.setPosition(GATE_OPEN_POSITION);
        } else {
            gateServo.setPosition(GATE_CLOSED_POSITION);
        }
    }

    private void doBrush() {
        if (gamepad1.left_bumper) {
            brushMotor.setPower(BRUSH_GO);
        } else {
            brushMotor.setPower(BRUSH_STOP);;
        }
    }

    private void doDriving() {
        leftMotorPower = gamepad1.left_stick_y;

        leftMotor.setPower(leftMotorPower);

        rightMotorPower = gamepad1.right_stick_y;

        rightMotor.setPower(rightMotorPower);


    }

    private void doExtend() {
        armExtenderMotor.setPower((gamepad2.left_stick_y));
    }

    private void doLift() {
        armLiftingMotor.setPower(gamepad2.right_stick_y);
    }

}




