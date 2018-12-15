package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public enum RobotPart {
    leftMotor(DcMotor.class),
    rightMotor(DcMotor.class),

    // the one that lowers us from lander
    latchLiftMotor(DcMotor.class),

    armExtenderMotor(DcMotor.class),
    armLiftingMotor(DcMotor.class),

    brushMotor(DcMotor.class),

    distanceSensor(Rev2mDistanceSensor.class),

    latchExtenderLimitSwitch(RevTouchSensor.class),

    markerServo(Servo.class);

    private Class<? extends HardwareDevice> _partType;

    RobotPart(Class<? extends HardwareDevice> partType) {
        _partType = partType;
    }

    public <T> T getInstance(HardwareMap map) {
        String deviceName = this.name();

        try {
            return (T) map.get(this._partType, deviceName);
        } catch (Exception e) {
            return null;
        }
    }
}
