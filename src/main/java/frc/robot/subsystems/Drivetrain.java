package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;


public class Drivetrain extends SubsystemBase implements HardwareAdapter {
  private final DifferentialDrive dt = new DifferentialDrive(leftSideMotors, rightSideMotors);

  public Drivetrain() {
  }
  public void arcadeDrive(double speed, double rotation) {
    dt.arcadeDrive(speed, rotation, false);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    dt.tankDrive(leftSpeed, rightSpeed, false); 
  }
}
