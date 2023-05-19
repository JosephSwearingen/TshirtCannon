package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drive;

public class DefaultDrive extends CommandBase
{
    /* Controller */
    private Joystick controller; 

    /* Subsystems */
    private Drive driveSubsystem;
    
    public DefaultDrive(Joystick controller, Drive driveSubsystem)
    {
        this.controller = controller;
        this.driveSubsystem = driveSubsystem;

        /* Used so commandscheduler knows driveSubsystem is being used when command is called. */
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute()
    {
        /* Calls arcade drive to move the robot using controller inputs. */
        double forwardSpeed = controller.getRawAxis(1);
        double rotationalSpeed = controller.getRawAxis(4);
        driveSubsystem.arcadeDrive(forwardSpeed, rotationalSpeed);
    }

}
