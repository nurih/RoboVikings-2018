package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

@TeleOp(name = "SeeColor")
public class SeeColorOpMode extends OpMode {
    private NormalizedColorSensor colorDetector;

    @Override
    public void init() {
        colorDetector = RobotPart.colorSensor.getInstance(hardwareMap);
    }

    @Override
    public void loop() {
//Read the color
        NormalizedRGBA normalizedColors = getScaledRGBA(colorDetector);
        HsvValues hsvValues = getHsvValues(normalizedColors);

        telemetry.addData("Hue", hsvValues.Hue);
        telemetry.addData("Value", hsvValues.Value);
        telemetry.addData("Saturation", hsvValues.Saturation);


        //decide if yellow or white?
        // if yellow say yellow

        if (hsvValues.Hue >= 32 && hsvValues.Hue <= 54
                && hsvValues.Saturation >= 0.474
                && hsvValues.Value >= 0.635) {
            telemetry.addLine("i see yellow");
        } else if (hsvValues.Hue >= 120 && hsvValues.Hue <= 160
                && hsvValues.Saturation >= 0.364
                && hsvValues.Value >= 0.127) {
            telemetry.addLine("i see white");
        } else if (hsvValues.Hue >= 137 && hsvValues.Hue <= 141
                && hsvValues.Saturation >= 0.372
                && hsvValues.Value >= 0.2) {
            telemetry.addLine("i see mat");

        } else {
            telemetry.addLine("I don't know what color...");
        }

        // if not yellow and not white say "i don't know"
        //
        telemetry.update();
    }

    public static NormalizedRGBA getScaledRGBA(NormalizedColorSensor sensor) {


        NormalizedRGBA colors = sensor.getNormalizedColors();


        float max = Math.max(Math.max(Math.max(colors.red, colors.green), colors.blue), colors.alpha);


        // normalize relative to maximum value found in current reading

        colors.blue /= max;

        colors.green /= max;

        colors.red /= max;


        return colors;

    }

    /**
     * Gets HSV values from NormalizedRGBA color.
     */

    public static HsvValues getHsvValues(NormalizedRGBA colors) {

        float[] hsvValues = new float[3];

        Color.colorToHSV(colors.toColor(), hsvValues);

        return new HsvValues(hsvValues);

    }
}



