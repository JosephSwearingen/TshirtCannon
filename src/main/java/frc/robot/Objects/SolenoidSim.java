package frc.robot.Objects;

import edu.wpi.first.hal.SimBoolean;
import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDevice.Direction;

public class SolenoidSim {
    private SimDevice solenoid;
    private SimBoolean active;

    /** Creates a simulated solenoid. */
    public SolenoidSim(int solenoidID) {
        solenoid = SimDevice.create("Solenoid"+solenoidID, solenoidID);
        active = solenoid.createBoolean("Active", Direction.kInput, false);
    }

    public void set(boolean on) {
        active.set(on);
    }

    public boolean get() {
        return active.get();
    }

    public void toggle() {
        if (active.get()) {
            active.set(false);
        } else {
            active.set(true);
        }
    }
}