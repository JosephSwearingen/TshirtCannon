package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase
{

    /* Components */
    private PneumaticHub pneumaticHub; 
    private Compressor compressor;

    /* Solenoids */
    private Solenoid solenoid0; 
    private Solenoid solenoid1;  
    private Solenoid solenoid2;  

    public Pneumatics()
    {
        /* Components */
        pneumaticHub = new PneumaticHub(6);
        compressor = pneumaticHub.makeCompressor();

        /* Solenoids */
        solenoid0 = pneumaticHub.makeSolenoid(Constants.solenoid0ID);
        solenoid1 = pneumaticHub.makeSolenoid(Constants.solenoid1ID);
        solenoid2 = pneumaticHub.makeSolenoid(Constants.solenoid2ID);

        /* Turns on compressor */
        pneumaticHub.enableCompressorDigital();
    }

    /**
     * Used to turn all solenoids on. 
     */
    public void activate()
    {
        solenoid0.set(true);
        solenoid1.set(true);
        solenoid2.set(true);
    }

    /**
     * Used to turn all solenoids off. 
     */
    public void deactivate()
    {
        solenoid0.set(false);
        solenoid1.set(false);
        solenoid2.set(false); 
    }

    /**
     * Toggles all solenoids from their current state. 
     */
    public void toggle()
    {
        solenoid0.toggle();
        solenoid1.toggle();
        solenoid2.toggle();
    }

}
