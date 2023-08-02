package frc.team3128.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Led extends SubsystemBase{
    private static Led instance;
    private AddressableLED m_led;
    private AddressableLEDBuffer m_ledBuffer;
    private int Hue;
    private int Saturation;
    private int Value;

    public Led(){
        InitLeds();
    }
    public static synchronized Led getInstance() {
        if (instance == null) {
            instance = new Led();
        }
        return instance;
    }
    
    public void InitLeds() {
        m_led = new AddressableLED(9);

        m_ledBuffer = new AddressableLEDBuffer(288);
        m_led.setLength(m_ledBuffer.getLength());

        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    public void setYellow() {
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the RGB values for red
            m_ledBuffer.setHSV(i, 130, 255, 50);
            Hue = 140;
            Saturation = 252;
            Value = 252;
         }
         
         m_led.setData(m_ledBuffer);
    }
    
    public void setRGB(int r, int g, int b) {
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the RGB values for red
            m_ledBuffer.setRGB(i, r, g, b);
         }
         
         m_led.setData(m_ledBuffer);
    }
    public void setHSV(int h, int s, int v) {
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the HSV values for red
            m_ledBuffer.setHSV(i, h, s, v);
         }
         
         m_led.setData(m_ledBuffer);
    }

    public void ChangeHue(int change) {
        Hue = Hue + change;
        setHSV(Hue, Saturation, Value);
    }
    public void ChangeSaturation(int change) {
        Saturation = Saturation + change;
        setHSV(Hue, Saturation, Value);
    }
    public void ChangeValue(int change) {
        Value = Value + change;
        setHSV(Hue, Saturation, Value);
    }


    
}
