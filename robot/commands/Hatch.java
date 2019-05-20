package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command.  You can replace me with your own command.
 */
public class Hatch extends Command {
  public Hatch() {
    requires(Robot.m_oi4);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    RobotMap.boi.setClosedLoopControl(true);
    if(Robot.m_oi.coPilot.getRawButton(5)){
    RobotMap.Hatch.set(true);
    } else{
      RobotMap.Hatch.set(false);
    }
    SmartDashboard.putBoolean("Is Hatch happening?", RobotMap.Hatch.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.Hatch.set(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap.Hatch.set(false);
  }
}
