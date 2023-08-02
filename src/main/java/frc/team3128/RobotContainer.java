package frc.team3128;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.team3128.common.hardware.input.NAR_Joystick;
import frc.team3128.common.utility.NAR_Shuffleboard;
import frc.team3128.subsystems.TestBenchPiston;
import frc.team3128.subsystems.Led;

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


    //private NAR_Drivetrain m_drive;
    //private TestBenchMotor testBenchMotor;
    //private TestBenchPiston testBenchPiston;
    //private TestBenchMotor testBenchMotor;
    //private TestBenchPiston testBenchPiston;
    //private TestBenchDIO testBenchDIO;
    private NAR_Joystick m_leftStick;
    private NAR_Joystick m_rightStick;
    private Led m_LedStrip;

    private CommandScheduler m_commandScheduler = CommandScheduler.getInstance();
    //private Command auto;

    private boolean DEBUG = false;

    public RobotContainer() {

        m_leftStick = new NAR_Joystick(0);
        m_rightStick = new NAR_Joystick(1);
      
        //testBenchPiston = new TestBenchPiston();

        m_LedStrip = new Led();
        // testBenchMotor = new TestBenchMotor(); 
        //m_commandScheduler.setDefaultCommand(testBenchSubsystem, new TestDrive(testBenchSubsystem));

        configureButtonBindings();
        dashboardInit();
        new InstantCommand(m_LedStrip::setYellow,m_LedStrip);
    }   

    private void configureButtonBindings() {

        // m_rightStick.getButton(1).onTrue(new RunCommand(testBenchMotor::runFalcon,testBenchMotor));
        // m_rightStick.getButton(1).onFalse(new RunCommand(testBenchMotor::stopFalcon,testBenchMotor));

        //m_rightStick.getButton(1).onTrue(new RunCommand(testBenchPiston::eject,testBenchPiston));

        //m_rightStick.getButton(2).onTrue(new RunCommand(testBenchPiston::retract,testBenchPiston)); 
        m_rightStick.getButton(3).onTrue(new InstantCommand(m_LedStrip::setYellow,m_LedStrip));

        m_rightStick.getButton(4).onTrue(new InstantCommand(()-> m_LedStrip.ChangeValue(-1)));
        m_rightStick.getButton(5).onTrue(new InstantCommand(()-> m_LedStrip.ChangeValue(1)));

        m_rightStick.getButton(6).onTrue(new InstantCommand(()-> m_LedStrip.ChangeSaturation(-1)));
        m_rightStick.getButton(7).onTrue(new InstantCommand(()-> m_LedStrip.ChangeSaturation(1)));

        m_rightStick.getButton(8).onTrue(new InstantCommand(()-> m_LedStrip.ChangeValue(-1)));
        m_rightStick.getButton(9).onTrue(new InstantCommand(()-> m_LedStrip.ChangeValue(1)));
    }

    private void dashboardInit() {
        // if (DEBUG) {
        //     SmartDashboard.putData("CommandScheduler", CommandScheduler.getInstance());
        //     SmartDashboard.putNumber("xxxxxxMotorRPMxxxxxxx", testBenchMotor.logRPM());
        // }
            
    }

    public void stopDrivetrain() {

    }

    //public Command getAutonomousCommand() {
        //return auto;
    //}

    public void updateDashboard() {
        //NAR_Shuffleboard.addData("Sensor", "megSwitch", testBenchDIO.sense(), 0, 0);
        // SmartDashboard.putBoolean("-----MagSwitch-----", testBenchDIO.sense());
    }
}
