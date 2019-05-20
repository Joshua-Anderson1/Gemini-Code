/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The command that makes the ball intake grab the cargo or release it
 */
public class BallIntake extends Command {
  public BallIntake() {
    requires(Robot.m_oi);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.coPilot.getRawButton(3)){
    RobotMap.ballIntake.set(-1.0);
  } else if(Robot.m_oi.coPilot.getRawButton(2)){
    RobotMap.ballIntake.set(1.0);
  } else if(!Robot.m_oi.coPilot.getRawButton(2) || !Robot.m_oi.coPilot.getRawButton(3)){
    RobotMap.ballIntake.set(0.0);
  }
   SmartDashboard.putNumber("Ball Intake Value", RobotMap.ballIntake.getSpeed());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.ballIntake.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap.ballIntake.set(0.0);
  }
}
