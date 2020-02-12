/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.Empty;
import frc.robot.commands.ReverseDrive;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DefaultDrive m_defaultDrive;
  private final DriveSubsystem m_drive;
  private static RobotContainer m_robotContainer;
  private final Empty m_empty;
  private final ReverseDrive m_reverseDrive;

  //private final DriveSubsystem m_drive = new DriveSubsystem();
  //private final DefaultDrive m_defaultDrive = new DefaultDrive(m_drive);
  //private final Empty m_empty = new Empty();
  private final Joystick m_stick = new Joystick(0);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drive = DriveSubsystem.getInstance();
    m_defaultDrive = new DefaultDrive(m_drive, this);
    m_drive.setDefaultCommand(m_defaultDrive);
    m_empty = new Empty();
    m_reverseDrive = new ReverseDrive(m_drive, this);
  }

  public DefaultDrive get_defaultDrive(){
    return m_defaultDrive;
  }
  public ReverseDrive get_reverseDrive(){
    return m_reverseDrive;
  }

  public static RobotContainer getInstance(){
    if(m_robotContainer == null){
      m_robotContainer = new RobotContainer();
    } 
    return m_robotContainer;
   }

  public Joystick stick() {
    return m_stick;
  }

   
/**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return (Command) m_empty;
  }
}