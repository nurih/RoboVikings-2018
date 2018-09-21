package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
@TeleOp (name = "SeeColor")

public class SeeColorOpMode extends OpMode {
    private NormalizedColorSensor colorDetector;

    @Override
    public void init() {
        colorDetector = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");
    }

    @Override
    public void loop() {
//Read the color
        NormalizedRGBA normalizedColors = getScaledRGBA(colorDetector);
        HsvValues hsvValues = getHsvValues(normalizedColors);

        telemetry.addData("Jessie says", hsvValues.Hue);

        //decide if yellow or white?
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



