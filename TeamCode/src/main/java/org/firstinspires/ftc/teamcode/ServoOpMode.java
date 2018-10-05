package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Brush Servo Testing")
public class ServoOpMode extends OpMode {
    Servo brushServo;


    @Override
    public void init() {
        brushServo = RobotPart.brushServo.getInstance(hardwareMap);
    }

    @Override
    public void loop() {
        // check if right button pressed
        if (gamepad1.right_bumper) {
            moveServo(1);
        }
        // check if left button pressed
        if (gamepad1.left_bumper) {
            moveServo(-1);
        }
        // if no button pressed.
    }


    private void moveServo(double delta) {
        double currentPostion = brushServo.getPosition();
        double targetPostion = currentPostion + delta;
        brushServo.setPosition(targetPostion);
    }


}
