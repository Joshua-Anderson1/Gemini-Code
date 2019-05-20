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
 * The command for the elevator with the ball intake and hatch
 */
public class Elevator extends Command {
  double move;
  public Elevator() {
    requires(Robot.m_oi1);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    double Axis = Robot.m_oi.coPilot.getRawAxis(1);
    if(Axis <= 0.25 && Axis >= -0.25 ){
      Axis = 0.0;
    }
    if(Axis != 0.0){
    RobotMap.elevator.set(Robot.m_oi.coPilot.getRawAxis(1));
    } else {
      RobotMap.elevator.set(-0.3);
    }
   SmartDashboard.putNumber("Elevator Value", RobotMap.elevator.getSpeed());
   SmartDashboard.putNumber("CoPilot Y Axis", Robot.m_oi.coPilot.getRawAxis(1));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.elevator.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
