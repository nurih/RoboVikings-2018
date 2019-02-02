package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "Latch Extender Encoding Test", group = "Test")
public class TestMotorEncoderOpMode extends OpMode {
    DcMotor latchMotor;
    @Override
    public void init() {
        latchMotor = RobotPart.latchLiftMotor.getInstance(hardwareMap);
        latchMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        latchMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        latchMotor.setPower(0);

    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            latchMotor.setPower(1);
        }
        if(gamepad1.left_bumper){
            latchMotor.setPower(-1);
        }
        else {
            latchMotor.setPower(0);
        }

        showPosition();
    }

    private void showPosition() {
        double ticks    = latchMotor.getCurrentPosition();
        telemetry.addData("Latch Position:", ticks);
        telemetry.addData("Now:", this.getRuntime());
        telemetry.update();
    }

}
