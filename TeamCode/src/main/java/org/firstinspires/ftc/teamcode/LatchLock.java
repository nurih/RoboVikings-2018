package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LatchLock {
    private final Servo latchLockServo;

    public LatchLock(HardwareMap hardwareMap){
        this.latchLockServo = RobotPart.latchLockServo.getInstance(hardwareMap);
        this.latchLockServo.setPosition(0);
    }
    public void open(){
        latchLockServo.setPosition(0.5);
    }
    public void close(){
        latchLockServo.setPosition(0);
    }
}
