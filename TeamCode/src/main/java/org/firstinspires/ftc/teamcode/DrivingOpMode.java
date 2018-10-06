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

    private float leftMotorPower;
    private float rightMotorPower;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo gateServo;
    private Servo brushServo;

    @Override
    public void init() {
        leftMotor = RobotPart.leftMotor.getInstance(hardwareMap);
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightMotor = RobotPart.rightMotor.getInstance(hardwareMap);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // get intake Servo
        brushServo = RobotPart.brushServo.getInstance(hardwareMap);
        brushServo.setPosition(BRUSH_STOP);
        // get brush Servo
       gateServo = RobotPart.gateServo.getInstance(hardwareMap);
       gateServo.setPosition(GATE_CLOSED_POSITION);
    }

    @Override
    public void loop() {

        doDriving();

        doBrush();

        doGateOpening();
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
            brushServo.setPosition(BRUSH_GO);
        } else {
            brushServo.setPosition(BRUSH_STOP);
        }
    }

    private void doDriving() {
        leftMotorPower = gamepad1.left_stick_y;

        leftMotor.setPower(leftMotorPower);

        rightMotorPower = gamepad1.right_stick_y;

        rightMotor.setPower(rightMotorPower);
    }
}
