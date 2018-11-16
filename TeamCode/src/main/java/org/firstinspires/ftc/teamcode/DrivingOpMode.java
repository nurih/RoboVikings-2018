package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Driving Test")
public class DrivingOpMode extends OpMode {


    private static final double BRUSH_STOP = 0;
    private static final double BRUSH_GO = 1.0;
    public static final double LATCH_POWER = 0.5;


    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor latchLiftMotor;
    private DcMotor armExtenderMotor;
    private DcMotor armLiftingMotor;
    private DcMotor latchLowerMotor;
    private DcMotor brushMotor;

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


        latchLiftMotor = RobotPart.latchLiftMotor.getInstance(hardwareMap);
        latchLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        latchLiftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        latchLowerMotor = RobotPart.latchLowerMotor.getInstance(hardwareMap);
        latchLowerMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        latchLowerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
        doLatchLowerMotor();

        doArmExtend();

        doArmLift();
    }

    private void doLatchLiftMotor() {
        if (gamepad2.right_bumper) {
            latchLiftMotor.setPower(LATCH_POWER);
        } else if (gamepad2.left_bumper) {
            latchLiftMotor.setPower(-LATCH_POWER);
        } else {
            latchLiftMotor.setPower(0);
        }

    }

    private void doLatchLowerMotor() {
        if (gamepad2.a) {
            latchLowerMotor.setPower(LATCH_POWER);
        } else if (gamepad2.b) {
            latchLowerMotor.setPower(-LATCH_POWER);
        } else {
            latchLowerMotor.setPower(0);
        }

    }


    private void doBrush() {
        if (gamepad2.left_bumper) {
            brushMotor.setPower(BRUSH_GO);
        } else {
            brushMotor.setPower(BRUSH_STOP);
            ;
        }
    }

    private void doDriving() {

        leftMotor.setPower(gamepad1.left_stick_y);

        rightMotor.setPower(gamepad1.right_stick_y);


    }

    private void doArmExtend() {

        armExtenderMotor.setPower(gamepad2.left_stick_y);
    }

    private void doArmLift() {
        // maximum power not 1 because it's too much
        armLiftingMotor.setPower(-gamepad2.right_stick_y / 2.0);
    }


}







