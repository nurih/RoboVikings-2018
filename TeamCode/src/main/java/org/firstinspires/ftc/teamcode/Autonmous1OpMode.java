package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



@Autonomous(name = "Autonomous1 no latch",group= "Competition")
public class Autonmous1OpMode extends LinearOpMode {


    AutonomousDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        drive = new AutonomousDrive(hardwareMap, telemetry);

        sleep(3000);
        telemetry.addLine("turning");
        drive.turn(45);
        telemetry.addLine("turned");
        sleep(3000);

        drive.driveStraight(162);
        sleep(3000);
        drive.turn(90);
        sleep(3000);
        drive.driveStraight(177);
        sleep(3000);
    }


}
