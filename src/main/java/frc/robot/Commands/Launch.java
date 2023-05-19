package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Pneumatics;

public class Launch extends CommandBase{
    
    /* Subsystems */
    private Pneumatics pneumaticsSubystem;

    /* Timer instance */
    private Timer timer;

    public Launch(Pneumatics pneumaticsSubystem)
    {
        /* Subsystems */
        this.pneumaticsSubystem = pneumaticsSubystem; 
    
        /*  Used so the command scheduler knows that the pneumatics subsystem is in use when the command is executing.  */
        addRequirements(pneumaticsSubystem);

        /* Timer */
        timer = new Timer();
    }


    @Override
    public void initialize()
    {
        /* Launches the solenoids and then starts a timer. */ 
        pneumaticsSubystem.activate();
        timer.restart();
        timer.start();
    }

    @Override
    public void execute()
    {
        
    }

    @Override
    public boolean isFinished()
    {
        /* Only finishes command 2 seconds after pneumatics launch. */
        if(timer.hasElapsed(2))
        {
            pneumaticsSubystem.deactivate();
            return true; 
        }
        return false;
    }
}
