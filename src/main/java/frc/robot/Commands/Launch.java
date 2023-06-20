package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Pneumatics;

public class Launch extends CommandBase{
    
    private Pneumatics pneumaticsSubystem;

    private static Timer timer;

    public Launch(Pneumatics pneumaticsSubystem) {
        this.pneumaticsSubystem = pneumaticsSubystem; 
    
        addRequirements(pneumaticsSubystem);

        timer = new Timer();
        timer.reset();
    }


    @Override
    public void initialize() {
        pneumaticsSubystem.launch();
        timer.restart();
        timer.start();
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        if(timer.hasElapsed(2)) {
            pneumaticsSubystem.retract();
            timer.stop();
            return true; 
        }
        return false;
    }
}
