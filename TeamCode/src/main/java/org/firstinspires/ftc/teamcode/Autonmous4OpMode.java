package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous4 Drop Marker", group= "Competition")
public class Autonmous4OpMode extends LinearOpMode {

    AutonomousDrive drive;
    LatchExtender latchExtender;
    RevTouchSensor touchSensor;
    Servo markerServo;

    @Override
    public void runOpMode() throws InterruptedException {
        latchExtender = new LatchExtender(hardwareMap, telemetry);
        touchSensor = RobotPart.latchExtenderLimitSwitch.getInstance(hardwareMap);
        markerServo = RobotPart.markerServo.getInstance(hardwareMap);
        waitForStart();

        drive = new AutonomousDrive(hardwareMap, telemetry);

        // unwind lowering motor.
        double startTime = getRuntime();
        while (timeToStop(startTime) == false) {
            latchExtender.rollDown();
        }

        latchExtender.stop();
        telemetry.addLine("Got down");
        telemetry.update();
        sleep(1000);

        drive.turn(-25);
        telemetry.addLine("turned");
        telemetry.update();
        drive.driveStraight(10);
        drive.turn(25);

        drive.driveStraight(264);
        telemetry.addLine("left lander");
        telemetry.update();

        releaseMarker();
        telemetry.addLine("drop servo");
        telemetry.update();
    }

    private boolean timeToStop(double startTime) {

        // if stop op mode pressed
        if(isStopRequested()){ return true;}

        // if passed time
        if( getRuntime() >= startTime + 8.5) { return true;}

        // if reached limit switch
        return touchSensor.isPressed();
    }


    public void releaseMarker(){
        markerServo.setPosition(0.6);
    }
}



