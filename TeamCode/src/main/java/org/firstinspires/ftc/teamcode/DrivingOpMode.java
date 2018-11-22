package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Driving Test")
public class DrivingOpMode extends OpMode {


    private static final double BRUSH_STOP = 0;
    private static final double BRUSH_GO = 1.0;


    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private LatchExtender latchExtender;
    private DcMotor armExtenderMotor;
    private DcMotor armLiftingMotor;

    private DcMotor brushMotor;

    private boolean isReverseDriving = false;

    @Override
    public void init() {
        leftMotor = RobotPart.leftMotor.getInstance(hardwareMap);
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightMotor = RobotPart.rightMotor.getInstance(hardwareMap);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // get intake Motor
        brushMotor = RobotPart.brushMotor.getInstance(hardwareMap);
        brushMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        brushMotor.setPower(BRUSH_STOP);


        latchExtender = new LatchExtender(hardwareMap, telemetry);

        armExtenderMotor = RobotPart.armExtenderMotor.getInstance(hardwareMap);
        armExtenderMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armExtenderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armLiftingMotor = RobotPart.armLiftingMotor.getInstance(hardwareMap);
        armLiftingMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armLiftingMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    @Override
    public void loop() {

        doDriving();

        doBrush();

        doLatchLiftMotor();

        doArmExtend();

        doArmLift();
    }

    private void doLatchLiftMotor() {
        latchExtender.pullUp(gamepad1.right_trigger);
        latchExtender.rollDown(gamepad1.left_trigger);
    }


    private void doBrush() {
        if (gamepad2.right_bumper) {
            brushMotor.setPower(BRUSH_GO);
        } else {
            brushMotor.setPower(BRUSH_STOP);
            ;
        }
    }

    private void doDriving() {


        if (gamepad1.a) {
            isReverseDriving = false;
        } else if (gamepad1.b) {
            isReverseDriving = true;
        }

        float leftMotorPower = gamepad1.left_stick_y;
        float rightMotorPower = gamepad1.right_stick_y;


        // if is reverse driving, switch controls
        if (isReverseDriving) {
            leftMotorPower = -gamepad1.right_stick_y;
            rightMotorPower = -gamepad1.left_stick_y;
        }

        leftMotor.setPower(leftMotorPower);
        rightMotor.setPower(rightMotorPower);


    }

    private void doArmExtend() {

        armExtenderMotor.setPower(gamepad2.right_stick_y);
    }

    private void doArmLift() {
        // maximum power not 1 because it's too much
        armLiftingMotor.setPower(-gamepad2.left_stick_y / 2.0);
    }


}







