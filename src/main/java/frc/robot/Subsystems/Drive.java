package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase
{

    /* Motors */
    private WPI_TalonSRX leftTalon;
    private WPI_VictorSPX  leftFrontVic;
    private WPI_VictorSPX  leftBackVic;
    private WPI_TalonSRX rightTalon;
    private WPI_VictorSPX  rightFrontVic;
    private WPI_VictorSPX  rightBackVic;

    /* Motor Groups */
    private MotorControllerGroup leftDrive;
    private MotorControllerGroup rightDrive; 

    /* Drivetrain */
    DifferentialDrive driveTrain;

    public Drive()
    {
        /*Motors */
        leftTalon = new WPI_TalonSRX(Constants.leftTalonID);
        leftFrontVic = new WPI_VictorSPX(Constants.leftFrontVicID);
        leftBackVic = new WPI_VictorSPX(Constants.leftBackVicID);
        rightTalon = new WPI_TalonSRX(Constants.rightTalonID);
        rightFrontVic = new WPI_VictorSPX(Constants.rightFrontVicID);
        rightBackVic = new WPI_VictorSPX(Constants.rightBackVicID);
        
        /*Motor Groups */
        leftDrive = new MotorControllerGroup(leftTalon, leftFrontVic, leftBackVic);
        rightDrive = new MotorControllerGroup(rightTalon, rightFrontVic, rightBackVic);
        
        /*Drivetrain */
        driveTrain = new DifferentialDrive(leftDrive, rightDrive);
        
        /*Inversions */
        leftFrontVic.setInverted(true);
        leftDrive.setInverted(true);
    }

    /**
     * Method used to drive the robot using forward and backward speeds.
     * @param forwardSpeed translational forward and backward vector from -1 to 1.
     * @param rotationalSpeed rotational forward and backward input from -1 to 1.
     */
    public void arcadeDrive(double forwardSpeed, double rotationalSpeed)
    {
        driveTrain.arcadeDrive(forwardSpeed, rotationalSpeed);
    }

}
