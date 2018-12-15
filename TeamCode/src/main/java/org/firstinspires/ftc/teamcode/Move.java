package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Move {
    private static final double SLOW = .2;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Gamepad gamepad;

    public Move(HardwareMap hardwareMap, Gamepad gamepad) {
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);


        this.gamepad = gamepad;
    }

    public void Stop() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }

    public void Go() {
        leftMotor.setPower(-gamepad.left_stick_y);
        rightMotor.setPower(-gamepad.right_stick_y);
    }

    public void turnRight() {
        leftMotor.setPower(SLOW);
        rightMotor.setPower(0);
    }

    public void turnLeft() {
        leftMotor.setPower(0);
        rightMotor.setPower(SLOW);
    }
}
