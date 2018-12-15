package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LatchExtender {

    private static final float LATCH_POWER = 0.5f;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;

    private DcMotor latchLiftMotor;

    public LatchExtender(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        latchLiftMotor = RobotPart.latchLiftMotor.getInstance(hardwareMap);
        latchLiftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        latchLiftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        stop();

    }

    public void pullUp() {
        pullUp(LATCH_POWER);
    }

    public void pullUp(float power) {
        telemetry.addLine("Pull up");
        latchLiftMotor.setPower(power);
    }

    public void rollDown() {
        rollDown(LATCH_POWER);
    }

    public void rollDown(float power) {
        telemetry.addLine("Roll down");
        latchLiftMotor.setPower(-power);
    }

    public void stop() {
        latchLiftMotor.setPower(0);
    }


}
