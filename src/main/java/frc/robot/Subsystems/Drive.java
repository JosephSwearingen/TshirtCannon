package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Drive extends SubsystemBase {

    private static WPI_TalonSRX leftTalon;
    private static WPI_VictorSPX  leftFrontVic;
    private static WPI_VictorSPX  leftBackVic;
    private static WPI_TalonSRX rightTalon;
    private static WPI_VictorSPX  rightFrontVic;
    private static WPI_VictorSPX  rightBackVic;

    private static MotorControllerGroup leftDrive;
    private static MotorControllerGroup rightDrive;

    static DifferentialDrive Drive;

    private PS4Controller controller;

    public Drive(PS4Controller controller) {
        leftTalon = new WPI_TalonSRX(Constants.Motors.leftTalonPort);
        leftFrontVic = new WPI_VictorSPX(Constants.Motors.leftFrontVicPort);
        leftBackVic = new WPI_VictorSPX(Constants.Motors.leftBackVicPort);
        rightTalon = new WPI_TalonSRX(Constants.Motors.rightTalonPort);
        rightFrontVic = new WPI_VictorSPX(Constants.Motors.rightFrontVicPort);
        rightBackVic = new WPI_VictorSPX(Constants.Motors.rightBackVicPort);
        
        leftDrive = new MotorControllerGroup(leftTalon, leftFrontVic, leftBackVic);
        rightDrive = new MotorControllerGroup(rightTalon, rightFrontVic, rightBackVic);
        
        Drive = new DifferentialDrive(leftDrive, rightDrive);

        this.controller = controller;
        
        //Inversions dependent on mechanical issues
        if (Robot.isReal()) {
            leftFrontVic.setInverted(true);
            leftDrive.setInverted(true);
        }
    }

    @Override
    public void periodic() {
        drive(-controller.getLeftY(), -controller.getRightX());
    }

    /**
     * Method used to drive the robot using speed and rotation.
     * @param Speed Speed ranging from -1 to 1.
     * @param Rotation Rotation ranging from -1 to 1.
     */
    public void drive(double Speed, double Rotation) {
        Drive.arcadeDrive(Speed, Rotation);
    }
}
