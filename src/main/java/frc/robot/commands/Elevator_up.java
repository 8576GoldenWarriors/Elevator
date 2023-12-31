// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

public class Elevator_up extends CommandBase {
  /** Creates a new Elevator_up. */
  Elevator elevator;
  double elevatorSpeed;

  public Elevator_up(Elevator elevator, double elevatorSpeed) {
    this.elevator = elevator;

    //ASSUMING UP IS NEGATIVE THROTTLE; CHANGE IF NEEDED
    this.elevatorSpeed = -elevatorSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elevator);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    elevator.setSpeed(elevatorSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(Robot.topLimitSwitch.get()==false){
      elevator.setSpeed(0);
      end(true);
    }
    elevator.setSpeed(elevatorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
