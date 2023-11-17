// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

public class Elevator_down extends CommandBase {
  /** Creates a new Elevator_down. */
  Elevator elevator;
  double elevatorSpeed;
  public Elevator_down(Elevator elevator, double elevatorSpeed) {
    this.elevator = elevator;

    //ASSUMING UP IS POSITIVE THROTTLE; CHANGE IF NEEDED
    this.elevatorSpeed = -elevatorSpeed;

    addRequirements(elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    elevator.setSpeed(elevatorSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.bottomLimitSwitch.get()==true){
      elevator.setSpeed(0);
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
