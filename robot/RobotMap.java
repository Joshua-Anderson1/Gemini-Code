/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
/*import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;*/
import edu.wpi.first.wpilibj.Compressor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  public static final Spark leftFrontMotor = new Spark(2);
  public static final Spark rightFrontMotor = new Spark(3);
  public static final Spark leftRearMotor = new Spark(0);
  public static final Spark rightRearMotor = new Spark(1);
  public static final Spark endgameDrive = new Spark(6);
  public static final Spark ballIntake = new Spark(8);
  public static final Spark endgameElevator = new Spark(4);
  public static final Talon elevator = new Talon(7);
  public static final Spark hatchSpool = new Spark(5);
 // public static final CANSparkMax newThing = new CANSparkMax(1, MotorType.kBrushless);
  public static final Solenoid Wing = new Solenoid(1);
  public static final Solenoid Hatch = new Solenoid(0);
  public static final Compressor boi = new Compressor(0);
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
