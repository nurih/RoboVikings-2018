package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LatchExtenderWithEncoders {

    private final Telemetry telemetry;
    // measured from purple line to floor
    private static final int ROLL_DOWN_TICKS = 31697;
    private DcMotor latchLiftMotor;

    public LatchExtenderWithEncoders(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        latchLiftMotor = RobotPart.latchLiftMotor.getInstance(hardwareMap);

        latchLiftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        latchLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        latchLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        stop();
    }


    public void rollDown() {
        int startingTicks = latchLiftMotor.getCurrentPosition();
        int targetTicks = startingTicks + ROLL_DOWN_TICKS;
        latchLiftMotor.setPower(1);
        latchLiftMotor.setTargetPosition(targetTicks);
        while (latchLiftMotor.isBusy()) {
            int currentTicks = latchLiftMotor.getCurrentPosition();
            telemetry.addData("Ticks at start", startingTicks);
            telemetry.addData("Ticks target", targetTicks);
            telemetry.addData("Ticks current", currentTicks);
            telemetry.update();
        }
        stop();
    }

    public void stop() {
        latchLiftMotor.setTargetPosition(latchLiftMotor.getCurrentPosition());
        latchLiftMotor.setPower(0);
    }


}
