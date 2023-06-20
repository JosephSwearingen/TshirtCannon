
package frc.robot;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Subsystems.*;
import frc.robot.Commands.*;

public class RobotContainer {

    public static Drive drive;
    public static Pneumatics pneumatics;

    public static PS4Controller controller;

    public RobotContainer() {
        controller = new PS4Controller(0);
        initializeSubsytems();
        configureButtonBindings();
    }

    private void initializeSubsytems() {
        drive = new Drive(controller);
        pneumatics = new Pneumatics();
    }

    private void configureButtonBindings() {
        new JoystickButton(controller, PS4Controller.Button.kCross.value)
        .onTrue(new Launch(pneumatics));
    }
}
    
    

