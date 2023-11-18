// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Elevator_down;
import frc.robot.commands.Elevator_up;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

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
  public static final CommandXboxController m_controller = new CommandXboxController(0);
  


  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
  
  private void configureBindings() {
    m_controller.y().whileTrue(new Elevator_up(m_elevator, 0.2));
    m_controller.a().whileTrue(new Elevator_down(m_elevator, 0.2));
    
    
    
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
