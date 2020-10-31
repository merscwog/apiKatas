import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.merscwog.tests.simple.tofix.TwoDrivenWheelsPushBot
import spock.lang.Stepwise

@Stepwise
class SimpleSpec extends MockRobotSpecification {
    void 'should always pass'() {
        given:
        MockOpMode mockOpMode = prepare(new TwoDrivenWheelsPushBot(), pushBotTwoWheelDrive())

        expect:
        !mockOpMode.gamepad1.a
    }

    void 'motor direction properly set'() {
        given: "A pushbot with two drive motors that turn clockwise on positive power"
        OpMode opMode = new TwoDrivenWheelsPushBot()
        //OpMode opMode = new TwoDrivenWheelsPushBotSolution()
        MockOpMode mockOpMode = prepare(opMode, pushBotTwoWheelDrive())

        when: "INIT has happened"
        mockOpMode.init()

        then: "The right front motor (RightFrontMotor) has been configured to turn in reverse"
        1 * rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE)
    }
}
