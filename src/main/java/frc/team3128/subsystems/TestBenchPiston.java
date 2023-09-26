package frc.team3128.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import edu.wpi.first.wpilibj.Compressor;

public class TestBenchPiston extends SubsystemBase {
    private static TestBenchPiston instance;
    private DoubleSolenoid m_solenoid;
    private Compressor m_compressor;

    public TestBenchPiston(){
        m_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);
        m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    }  

    public static synchronized TestBenchPiston getInstance() {
        if (instance == null) {
            instance = new TestBenchPiston();
        }
        return instance;
    }

    public void eject(){
        m_solenoid.set(kForward);
    }

    public void retract(){
        m_solenoid.set(kReverse);
    }

    public void off() {
        m_solenoid.set(kOff); 
    }
}
