// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Elevator_down;
import frc.robot.commands.Elevator_up;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Elevator m_elevator = new Elevator();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final Joystick controller = new Joystick(0);
  public static final JoystickButton elevatorUp = new JoystickButton(controller, 4);
  public static final JoystickButton elevatorDown = new JoystickButton(controller, 2);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
  
  private void configureBindings() {
    
    elevatorUp.whileTrue(new Elevator_up(m_elevator, 0.1));
    elevatorDown.whileTrue(new Elevator_down(m_elevator, 0.1));
    
  }

  public Elevator getElevator(){
    return m_elevator;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return Autos.exampleAuto(m_exampleSubsystem);
  // }
}
