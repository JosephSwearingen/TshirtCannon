package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Objects.SolenoidSim;

public class Pneumatics extends SubsystemBase {
    private static PneumaticHub pneumaticHub; 

    private static Solenoid solenoid0; 
    private static Solenoid solenoid1;  
    private static Solenoid solenoid2;

    public Pneumatics() {
        pneumaticHub = new PneumaticHub(Constants.Pneumatics.phPort);
        pneumaticHub.makeCompressor();

        solenoid0 = pneumaticHub.makeSolenoid(Constants.Pneumatics.solenoid0Port);
        solenoid1 = pneumaticHub.makeSolenoid(Constants.Pneumatics.solenoid1Port);
        solenoid2 = pneumaticHub.makeSolenoid(Constants.Pneumatics.solenoid2Port);
        //solenoid0 = new SolenoidSim(Constants.Pneumatics.solenoid0Port);
        //solenoid1 = new SolenoidSim(Constants.Pneumatics.solenoid1Port);
        //solenoid2 = new SolenoidSim(Constants.Pneumatics.solenoid2Port);

        pneumaticHub.enableCompressorDigital();
    }

    public void launch() {
        solenoid0.set(true);
        solenoid1.set(true);
        solenoid2.set(true);
    }

    public void retract() {
        solenoid0.set(false);
        solenoid1.set(false);
        solenoid2.set(false); 
    }
}
