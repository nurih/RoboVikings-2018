package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

public enum RobotPart {
    leftMotor(DcMotor.class),
    rightMotor(DcMotor.class),

    colorSensor(NormalizedColorSensor.class),;

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
