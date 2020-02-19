/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  public static ShooterSubsystem m_shoot = new ShooterSubsystem();
  public ShooterSubsystem() {
    
  }
  
  static Victor m_l_shooter = new Victor(6);
  static Victor m_r_shooter = new Victor(7);
  Victor m_conveyer = new Victor(5);

  public static ShooterSubsystem getInstance() {
    if (m_shoot == null) {
      m_shoot = new ShooterSubsystem();
    }

    return m_shoot;
  }

  public void shoot(double shootSpeed) {
    m_l_shooter.set(shootSpeed);
    m_r_shooter.set(-shootSpeed);
  }
  
  public void convey(double conveySpeed) {
    m_conveyer.set(conveySpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
