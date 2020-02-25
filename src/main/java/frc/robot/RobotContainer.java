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
import frc.robot.commands.Convey;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.Empty;
import frc.robot.commands.Intake;
import frc.robot.commands.ReverseDrive;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
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
  private final ShooterSubsystem m_shoot;
  private final Shoot m_shootCommand;
  private final Convey m_conveyCommand;
  private final IntakeSubsystem m_intake;
  private final Intake m_intakeCommand;

  //private final DriveSubsystem m_drive = new DriveSubsystem();
  //private final DefaultDrive m_defaultDrive = new DefaultDrive(m_drive);
  //private final Empty m_empty = new Empty();


  private final Joystick m_stick = new Joystick(0);
  private final Joystick m_bigStick = new Joystick(1);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drive = DriveSubsystem.getInstance(); // intialize drive subsystem
    m_defaultDrive = new DefaultDrive(m_drive, this); // intialize command
    m_drive.setDefaultCommand(m_defaultDrive); // set default for drivesubsystem

    m_empty = new Empty(); //intialize empty

    m_reverseDrive = new ReverseDrive(m_drive, this); // intialize reverse drive command 

    m_shoot = ShooterSubsystem.getInstance();
    m_shootCommand = new Shoot(m_shoot,this);
    m_conveyCommand = new Convey(m_shoot, this);
    m_shoot.setDefaultCommand(m_shootCommand);

    m_intake = IntakeSubsystem.getInstance();
    m_intakeCommand = new Intake(m_intake, this);
    m_intake.setDefaultCommand(m_intakeCommand);

  }

  public DefaultDrive get_defaultDrive(){
    return m_defaultDrive;
  }
  public ReverseDrive get_reverseDrive(){
    return m_reverseDrive;
  }
  public Shoot get_shootCommand() {
    return m_shootCommand;
  }
  public Convey get_conveyCommand(){
    return m_conveyCommand;
  }

public Intake get_intakeCommand() {
  return m_intakeCommand;
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

  public Joystick bigStick() {
    return m_bigStick;
  }

  public Boolean getRB() {
    return m_stick.getRawButtonPressed(5);
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
