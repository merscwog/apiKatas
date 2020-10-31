import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

class MockOpMode extends OpMode {
    // NOTE: 20 milliseconds means 500 loops per second (which is reasonable)
    static final long MILLIS_PER_LOOP = 20
    static final double MILLIS_PER_SECOND = 1000

    @Delegate
    OpMode delegate

    long loopCount = 0

    MockOpMode(OpMode delegate, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry, HardwareMap hardwareMap) {
        this.delegate = delegate
        this.gamepad1 = gamepad1
        this.gamepad2 = gamepad2
        this.telemetry = telemetry
        this.hardwareMap = hardwareMap
        this.delegate.gamepad1 = this.gamepad1
        this.delegate.gamepad2 = this.gamepad2
        this.delegate.telemetry = this.telemetry
        this.delegate.hardwareMap = this.hardwareMap

    }

    @Override
    void init() {
        // NOTE: Called ONCE when "INIT" pressed
        delegate.init()
    }

    @Override
    void init_loop() {
        // NOTE: Called REPEATEDLY after "INIT" pressed, but before "START"/"PLAY" pressed
        delegate.init_loop()
    }

    @Override
    void start() {
        delegate.start()
        // NOTE: Called ONCE when "START" pressed
    }

    @Override
    void loop() {
        delegate.loop()
        // NOTE: Called REPEATEDLY after "START" pressed
    }

    @Override
    void resetStartTime() {
        loopCount = 0
    }

    @Override
    double getRuntime() {
        (double)(loopCount * MILLIS_PER_LOOP) / MILLIS_PER_SECOND
    }
}