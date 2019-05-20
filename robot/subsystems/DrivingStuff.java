/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.Drive;
import frc.robot.RobotMap;

/**
 * This is where the Drive motors get grouped
 * 
 */
public class DrivingStuff extends Subsystem {
  public static SpeedControllerGroup m_left = new SpeedControllerGroup(RobotMap.leftFrontMotor, RobotMap.leftRearMotor);
  public static SpeedControllerGroup m_right = new SpeedControllerGroup(RobotMap.rightFrontMotor, RobotMap.rightRearMotor);
  public static SpeedControllerGroup driveMotors = new SpeedControllerGroup(m_left, m_right);
  
  public void arcadeDrive(double xSpeed, double zRotation, boolean trigger) {

    // Square the inputs (while preserving the sign) to increase fine control
    // while permitting full power.

    double leftMotorOutput;
    double rightMotorOutput;

    if(xSpeed < 0.25 && xSpeed > -0.25){
      xSpeed = 0.0;
    }

    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

    if (xSpeed >= 0.0) {
        if (zRotation >= 0.0) {
          leftMotorOutput = maxInput;
          rightMotorOutput = xSpeed - zRotation;
      } else {
          leftMotorOutput = xSpeed + zRotation;
          rightMotorOutput = maxInput;
      }
    } else {
        if (zRotation >= 0.0) {
          leftMotorOutput = xSpeed + zRotation;
          rightMotorOutput = maxInput;
        } else {
          leftMotorOutput = maxInput;
          rightMotorOutput = xSpeed - zRotation;
      }
    }

    if(trigger){
      leftMotorOutput /= 2;
      rightMotorOutput /= 2;
    }
    
    if(xSpeed == 0.0){
      leftMotorOutput *= -1.0;
      rightMotorOutput *= -1.0;
    }
    m_left.set(leftMotorOutput);
    m_right.set(rightMotorOutput);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}