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
 * An example command.  You can replace me with your own command.
 */
public class EndgameElevation extends Command {
  public EndgameElevation() {
    requires(Robot.m_oi3);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.driver.getRawButton(6)){
      RobotMap.endgameElevator.set(-1.0);
    } else if(Robot.m_oi.driver.getRawButton(8)){
      RobotMap.endgameElevator.set(1.0);
    } else if(!Robot.m_oi.driver.getRawButton(6) && !Robot.m_oi.driver.getRawButton(8)){
      RobotMap.endgameElevator.set(0.0);
    }
    SmartDashboard.putNumber("Endgame Elevator Value", RobotMap.endgameElevator.getSpeed());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      RobotMap.endgameElevator.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap.endgameElevator.set(0.0);
  }
}