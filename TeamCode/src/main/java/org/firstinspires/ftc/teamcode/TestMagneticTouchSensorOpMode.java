package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Magnetic Sensor", group = "Test")
public class TestMagneticTouchSensorOpMode extends OpMode {
    RevTouchSensor sensor;

    @Override
    public void init() {
        sensor= RobotPart.latchExtenderLimitSwitch.getInstance(hardwareMap);
    }

    @Override
    public void loop() {
        if (sensor.isPressed()) {
            telemetry.addLine("It is pressed");
        }
        else {
            telemetry.addLine("not pressed");
        }

    }
}
