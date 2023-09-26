package frc.team3128;

import common.hardware.input.NAR_Joystick;
import common.utility.NAR_Shuffleboard;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.team3128.subsystems.TestBenchPiston;
import frc.team3128.subsystems.TestBenchDIO;
import frc.team3128.subsystems.TestBenchMotor;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private TestBenchMotor testBenchMotor;
    // private TestBenchPiston testBenchPiston;
    // private TestBenchDIO testBenchDIO;
    private NAR_Joystick m_rightStick;

    public RobotContainer() {

        m_rightStick = new NAR_Joystick(1);
        testBenchMotor = TestBenchMotor.getInstance("neo", 4, "relative");
        // testBenchPiston = TestBenchPiston.getInstance();
        // testBenchDIO = TestBenchDIO.getInstance(); 

        configureButtonBindings();
        dashboardInit();
    }   

    private void configureButtonBindings() {
        m_rightStick.getButton(1).onTrue(new RunCommand(()-> testBenchMotor.runMotor(0.2), testBenchMotor));
        m_rightStick.getButton(1).onFalse(new RunCommand(()-> testBenchMotor.stopMotor(), testBenchMotor));
    }

    private void dashboardInit() {
        testBenchMotor.initShuffleboard();
    }

    public void updateDashboard() {
        NAR_Shuffleboard.update();
    }
}
