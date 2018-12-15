package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous 2 Just turn", group= "Competition")
public class Autonmous2OpMode extends LinearOpMode {
    private static final int LATCH_LOWERING_TICKS = 1000;

    AutonomousDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        drive = new AutonomousDrive(hardwareMap, telemetry);


        waitForStart();



        sleep(3000);
        telemetry.addLine("turning");
        drive.turn(45);
        telemetry.addLine("turned");
        sleep(3000);
    }




    }





