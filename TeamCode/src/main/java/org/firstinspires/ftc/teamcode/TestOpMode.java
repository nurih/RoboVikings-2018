package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class TestOpMode extends OpMode {

    Move move;

    @Override
    public void init() {
        move = new Move(hardwareMap, gamepad1);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            move.turnRight();
        }
        else if (gamepad1.b){
            move.turnLeft();
        }
        move.Go();
    }
}
