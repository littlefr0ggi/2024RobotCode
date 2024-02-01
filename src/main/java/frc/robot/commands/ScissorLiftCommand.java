// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ScissorLift;
import edu.wpi.first.wpilibj2.command.Command;

public class ScissorLiftCommand extends Command {
  private final ScissorLift scissorLift;
  
  boolean isAscending = true;

  public ScissorLiftCommand(ScissorLift containerScissorLift, boolean lift) {
    scissorLift = containerScissorLift;
    isAscending = lift;
    addRequirements(scissorLift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // if rise, then scissorLift ??  else then run down
    if (isAscending) {
      scissorLift.cleave();
    } else {
      scissorLift.dismantle();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    scissorLift.turnoff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
