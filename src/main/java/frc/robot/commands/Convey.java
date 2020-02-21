/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class Convey extends CommandBase {
  /**
   * Creates a new Convey.
   */
  private final RobotContainer m_robotContainer;
  private final ShooterSubsystem m_shoot;
  
  public Convey(ShooterSubsystem shoot, RobotContainer robotContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shoot = shoot;
    m_robotContainer = robotContainer;
    addRequirements(shoot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_robotContainer.stick().getRawButtonPressed(6)) {
      m_shoot.convey(0.5);
    } else {
      m_shoot.convey(0);
    }
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
