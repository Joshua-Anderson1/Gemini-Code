/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * This command lets the Robot drive whenever the F310 gamepad is being used
 */
public class Drive extends Command {
  public Drive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivingStuff);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
public void execute() {
    Robot.drivingStuff.arcadeDrive(Robot.m_oi.driver.getRawAxis(0), Robot.m_oi.driver.getRawAxis(1), Robot.m_oi.driver.getRawButton(7));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivingStuff.arcadeDrive(0.0, 0.0, false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}