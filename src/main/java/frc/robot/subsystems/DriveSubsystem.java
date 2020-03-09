/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;


public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */

  public static DriveSubsystem m_drive;
  private double rspeed = 0;
  private double lspeed = 0;
  private final double delta = 0.05;
  private final double maxSpeed = 0.8;

  double kP = 1;
  //Gyro gyro = new AnalogGyro(0);
  
  private final RobotContainer m_robotContainer;
  
  Victor m_frontRight = new Victor(1); //added motor 1 and 2 but we should group them in speed controller groups and call them right and left side them put them into differnetial drive
  Victor m_backLeft = new Victor(2);
  Victor m_backRight = new Victor(3);
  Victor m_frontLeft = new Victor(4);

  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_backRight);


  DifferentialDrive m_ddrive = new DifferentialDrive(m_left, m_right);

  public DriveSubsystem(RobotContainer robotContainer) {
    m_robotContainer = robotContainer;
  }

  public static DriveSubsystem getInstance(RobotContainer rc){
    if (m_drive == null){
      m_drive = new DriveSubsystem(rc);
    }
    return m_drive;
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_ddrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void trapDrive(double leftTarget, double rightTarget) {
    double leftSpeed, rightSpeed;

    leftTarget *= maxSpeed;
    rightTarget *= maxSpeed;
    if(leftTarget < lspeed) {
      leftSpeed = lspeed - delta;
    }
    else{
      leftSpeed = leftTarget;
    }
    if(rightTarget < rspeed){
      rightSpeed = rspeed - delta;
    }
    else if(rightTarget > rspeed) {
      rightSpeed = rspeed + delta;
    }
    else{
      rightSpeed = rightTarget;
    }

    lspeed = leftSpeed;
    rspeed = rightSpeed;

    m_ddrive.tankDrive(leftSpeed,rightSpeed);  
  }
  
  public void gyroTrapDrive(double leftTarget, double rightTarget) {
    // double error = 0;
    double error = -m_robotContainer.getGyro().getRate();
    double leftSpeed, rightSpeed;
    leftTarget *= maxSpeed;
    rightTarget *= maxSpeed;
    if(leftTarget < lspeed) {
      leftSpeed = lspeed - delta;
    }
    else{
      leftSpeed = leftTarget;
    }
    if(rightTarget < rspeed){
      rightSpeed = rspeed - delta;
    }
    else if(rightTarget > rspeed) {
      rightSpeed = rspeed + delta;
    }
    else{
      rightSpeed = rightTarget;
    }

    lspeed = leftSpeed;
    rspeed = rightSpeed;

    m_ddrive.tankDrive(leftSpeed + kP * error,rightSpeed - kP * error);  
  }

  public void gyroDrive(double leftSpeed ,double rightSpeed) {
    double error = -m_robotContainer.getGyro().getRate();
    double p = 1;
    m_ddrive.tankDrive(leftSpeed + p * error, rightSpeed - p * error);
  }

  public void gyroTurnFunc() {
    double error = 90 - m_robotContainer.getGyro().getAngle();
    String str = Double.toString(error);
    System.out.println(str);
    //m_drive.tankDrive(kP * error, kP * error);
  }


  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
