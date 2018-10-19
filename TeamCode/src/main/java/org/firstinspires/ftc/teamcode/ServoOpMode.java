package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo Testing")
public class ServoOpMode extends OpMode {
    private static final double GATE_CLOSED =  0.5;
    private static final double GATE_OPEN = 0;
    double targetPostion = 0;
    Servo brushMotor;
    Servo gateServo;

    @Override
    public void init() {
        brushMotor = RobotPart.brushMotor.getInstance(hardwareMap);
        gateServo = RobotPart.gateServo.getInstance(hardwareMap);
        telemetry.addLine("Got two instances");
        gateServo.setPosition(GATE_CLOSED);
        telemetry.addLine("Gate at closed position");
    }

    @Override
    public void loop() {
        // check if right button pressed
        if (gamepad1.right_bumper) {
            telemetry.addLine("Move servo +1");
            moveServo(1);
        } else if (gamepad1.left_bumper) {

            telemetry.addLine("Move servo -1");
            moveServo(-1);
        } else {
            telemetry.addLine("Move servo 0");
            moveServo(0);

        }

        controlGate();
        telemetry.update();
    }

    private void controlGate() {
        if (gamepad1.a) {
            telemetry.addLine("Close gate");
            gateServo.setPosition(GATE_OPEN);
        } else {
            telemetry.addLine("OpenGate");
            gateServo.setPosition(GATE_CLOSED);
        }

    }


    private void moveServo(double value) {
        brushMotor.setPosition(value);
        telemetry.addData("Target position", value);
    }
}