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
 * The command for the endgame elevator
 */
public class EndgameDriver extends Command {
  double motion;
  public EndgameDriver() {
    requires(Robot.m_oi2);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    double Axis1 = Robot.m_oi.coPilot.getRawAxis(3);
    if(Axis1 <= 0.5 && Axis1 >= -0.5){
      Axis1 = 0.0;
    }
    RobotMap.endgameDrive.set(Axis1);
  SmartDashboard.putNumber("Endgame Drive Value", RobotMap.endgameDrive.getSpeed());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.endgameDrive.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
