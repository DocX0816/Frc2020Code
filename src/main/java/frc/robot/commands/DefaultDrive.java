/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDrive extends CommandBase {
  /**
   * Creates a new DefaultDrive.
   */
  //private final DriveSubsystem m_drive = new DriveSubsystem();
  private final DriveSubsystem m_drive;
  private final RobotContainer m_robotContainer;
  
  public DefaultDrive(DriveSubsystem drive, RobotContainer robotContainer) {
    m_drive = drive;
    m_robotContainer = robotContainer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.tankDrive(0.9 * (m_robotContainer.stick().getThrottle()) , 0.8 * (m_robotContainer.stick().getY()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
