package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Servo Testing")
public class ServoOpMode extends LinearOpMode {
    Servo latchServo;

    @Override
    public void runOpMode() throws InterruptedException {
        latchServo = RobotPart.latchServo.getInstance(hardwareMap);
        waitForStart();
        // move to start

        moveAndWait(0);
        moveAndWait(0.5);

        moveAndWait(0.25);

        moveAndWait(1.0);
    }

    private void moveAndWait(double position) {

        latchServo.setPosition(position);

        sleep(2000);
    }
}
