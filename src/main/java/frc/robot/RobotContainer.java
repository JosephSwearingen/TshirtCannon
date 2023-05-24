
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.DefaultDrive;
import frc.robot.Commands.Launch;
import frc.robot.Subsystems.*;

public class RobotContainer {
    
    /* Controllers */
    private Joystick driverController;

    /* Subsystems */
    private Drive driveSubsystem; 
    private Pneumatics pneumaticsSubsystem;

    public RobotContainer() 
    {
        /* Controllers */
        driverController = new Joystick(0);
       
       /* Subsystems */
        driveSubsystem = new Drive();
        pneumaticsSubsystem = new Pneumatics();
      

        /* Sets default periodically reoccuring command for driveSubsystem */
        driveSubsystem.setDefaultCommand(
        new DefaultDrive(
        driveSubsystem,
        () -> driverController.getRawAxis(1),
        () -> driverController.getRawAxis(4)
        ));
       
        /* Configures buttons for controllers */
        configureButtonBindings();
    }


    /**
     * Method for containing buttons and controller functions with commands. 
     */
    private void configureButtonBindings() 
    {

        /* Launches T-Shirt / Fires Pneumatics */
        new JoystickButton(driverController, 1)
        .onTrue(new Launch(pneumaticsSubsystem));
    }

    /**
     * Used to schedule get the specific command to schedule in Autonomous mode. 
     * @return the selected autonomous command. 
     */
    public Command getAutonomousCommand() 
    {
        /* Currently returns empty command in Auto. */
        return new InstantCommand(); 
    }
}
    
    

