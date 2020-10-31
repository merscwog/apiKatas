package org.merscwog.tests.simple.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TwoDrivenWheelsPushBotSolution extends OpMode {
    private DcMotor rightFrontMotor;

    @Override
    public void init() {
        rightFrontMotor = hardwareMap.dcMotor.get("RightFrontMotor");
        rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

    }
}
