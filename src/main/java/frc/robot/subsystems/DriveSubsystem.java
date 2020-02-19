/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Victor;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */

  public static DriveSubsystem m_drive;
  public DriveSubsystem() {

  }
  public static DriveSubsystem getInstance(){
    if (m_drive == null){
      m_drive = new DriveSubsystem();
    }

    return m_drive;

  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_ddrive.tankDrive(leftSpeed, rightSpeed);
  }


  Victor m_frontRight = new Victor(1); //added motor 1 and 2 but we should group them in speed controller groups and call them right and left side them put them into differnetial drive
  Victor m_backLeft = new Victor(2);
  Victor m_backRight = new Victor(3);
  Victor m_frontLeft = new Victor(4);

  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_backRight);


  DifferentialDrive m_ddrive = new DifferentialDrive(m_left, m_right);
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
