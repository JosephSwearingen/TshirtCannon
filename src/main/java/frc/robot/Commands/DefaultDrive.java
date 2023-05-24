package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drive;

public class DefaultDrive extends CommandBase
{
 

    /* Subsystems */
    private Drive driveSubsystem;

    /* Suppliers */
    private DoubleSupplier forwardSupplier;
    private DoubleSupplier rotationalSupplier;
    
    public DefaultDrive(Drive driveSubsystem, DoubleSupplier forwardSupplier, DoubleSupplier rotationalSupplier)
    {
        this.driveSubsystem = driveSubsystem;
        this.forwardSupplier = forwardSupplier;
        this.rotationalSupplier = rotationalSupplier;

        /* Used so commandscheduler knows driveSubsystem is being used when command is called. */
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute()
    {
        /* Calls arcade drive to move the robot using controller inputs. */
        double forwardSpeed = forwardSupplier.getAsDouble();
        double rotationalSpeed = rotationalSupplier.getAsDouble();
        driveSubsystem.arcadeDrive(forwardSpeed, rotationalSpeed);
    }

}
