package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Driving Test 1")
public class DrivingOpMode extends OpMode {


    private float leftMotorPower;
    private float rightMotorPower;
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE );

    }

    @Override
    public void loop() {

        leftMotorPower = gamepad1.left_stick_y;

        leftMotor.setPower(leftMotorPower);

        rightMotorPower = gamepad1.right_stick_y;

        rightMotor.setPower(rightMotorPower);
    }
}
