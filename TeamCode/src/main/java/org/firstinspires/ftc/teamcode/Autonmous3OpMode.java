package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Autonomous 3 Unwind Motor")
public class Autonmous3OpMode extends LinearOpMode {

    AutonomousDrive drive;
    LatchExtender latchExtender;
    RevTouchSensor touchSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        latchExtender = new LatchExtender(hardwareMap, telemetry);
        touchSensor = RobotPart.latchExtenderLimitSwitch.getInstance(hardwareMap);
        waitForStart();

        drive = new AutonomousDrive(hardwareMap, telemetry);


        sleep(3000);
        telemetry.addLine("turning");

        // unwind lowering motor.
        double startTime = getRuntime();
        while (timeToStop(startTime) == false) {
            latchExtender.rollDown();
        }
        latchExtender.stop();
        telemetry.addLine("Got down");
        telemetry.update();
        sleep(3000);

        drive.turn(45);
        telemetry.addLine("turned");
        telemetry.update();
    }

    private boolean timeToStop(double startTime) {

        // if stop op mode pressed
        if(isStopRequested()){ return true;}

        // if passed time
        if( getRuntime() >= startTime + 4) { return true;}

        // if reached limit switch
        return touchSensor.isPressed();
    }


}



