package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

public enum RobotPart {
    leftMotor(DcMotor.class),
    rightMotor(DcMotor.class),

    latchMotor(DcMotor.class),

    gateServo(Servo.class),

    brushServo(Servo.class),

    colorSensor(NormalizedColorSensor.class),
    ;

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
