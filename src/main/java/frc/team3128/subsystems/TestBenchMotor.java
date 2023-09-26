package frc.team3128.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import common.hardware.motorcontroller.NAR_CANSparkMax;
import common.hardware.motorcontroller.NAR_Motor;
import common.hardware.motorcontroller.NAR_TalonFX;
import common.hardware.motorcontroller.NAR_TalonSRX;
import common.hardware.motorcontroller.NAR_CANSparkMax.EncoderType;
import common.utility.NAR_Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestBenchMotor extends SubsystemBase {
    private static TestBenchMotor instance;
    private NAR_Motor m_motor;
    
    /**
	 * Creates a TestBenchMotor object.
	 *
	 * <p>All types of motor can be created from this class.
	 *
	 * @param motorName The name of the motor: "neo", "775", or "falcon".
	 * @param id The id of the motor.
	 * @param encoderType The encodor type: "absolute" or "relative".
	 */

    public TestBenchMotor(String motorName, int id, String encoderType) {
        if (motorName.equals("neo")) {
            m_motor = new NAR_CANSparkMax(id, MotorType.kBrushless, (encoderType.equals("absolute")) ? EncoderType.Absolute : EncoderType.Relative);
        } else if (motorName.equals("775")) {
            m_motor = new NAR_TalonSRX(id);
        } else if (motorName.equals("falcon")) {
            m_motor = new NAR_TalonFX(id);
        }
    }

    public static synchronized TestBenchMotor getInstance(String motorName, int id, String encoderType) {
        if (instance == null) {
            instance = new TestBenchMotor(motorName, id, encoderType);
        }
        return instance;
    }

    public void runMotor(Double power) {
        m_motor.set(power);
    }

    public void stopMotor() {
        m_motor.set(0);
    }

    public double getAngle() {
        return m_motor.getPosition();
    }
    
    public void initShuffleboard() {
        NAR_Shuffleboard.addData("Neo", "Angle", () -> getAngle(), 0, 1);
    }
}
