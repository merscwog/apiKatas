import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry
import spock.lang.Specification

class MockRobotSpecification extends Specification {
    static String LEFT_FRONT_MOTOR = "LeftFrontMotor"
    static String RIGHT_FRONT_MOTOR = "RightFrontMotor"

    Gamepad gamepad_1 = new Gamepad()
    Gamepad gamepad_2 = new Gamepad()
    Telemetry mockTelemetry = Mock(Telemetry)

    DcMotor leftFrontMotor = Mock(DcMotor)
    DcMotor rightFrontMotor = Mock(DcMotor)

    protected MockOpMode prepare(OpMode delegate, HardwareMap hardwareMap) {
        new MockOpMode(delegate, gamepad_1, gamepad_2, mockTelemetry, hardwareMap)
    }

    protected HardwareMap pushBotTwoWheelDrive() {
        HardwareMap hardwareMap = new HardwareMap(null)
        hardwareMap.dcMotor.put(LEFT_FRONT_MOTOR, leftFrontMotor)
        hardwareMap.dcMotor.put(RIGHT_FRONT_MOTOR, rightFrontMotor)
        hardwareMap
    }
}
