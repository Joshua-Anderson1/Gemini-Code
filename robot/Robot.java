/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.BallIntake;
import frc.robot.commands.Drive;
import frc.robot.commands.Elevator;
import frc.robot.commands.EndgameDriver;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Hatch;
import frc.robot.commands.HatchIn;
import frc.robot.oi.F310;
import frc.robot.subsystems.OI;
import frc.robot.subsystems.DrivingStuff;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SparkyThing;
import frc.robot.subsystems.OI1;
import frc.robot.subsystems.OI2;
import frc.robot.subsystems.OI3;
import frc.robot.subsystems.OI4;
import frc.robot.subsystems.OI5;
import frc.robot.subsystems.OI6;
//import any vision files here

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi = new OI();
  public static OI1 m_oi1 = new OI1();
  public static OI2 m_oi2 = new OI2();
  public static OI3 m_oi3 = new OI3();
  public static OI4 m_oi4 = new OI4();
  public static OI5 m_oi5 = new OI5();
  public static OI6 m_oi6 = new OI6();
  public static BallIntake ballIntake;
  public static HatchIn hatchIn;
  public static DrivingStuff drivingStuff;
  public static Drive Drive;
  public static Elevator Elevator;
  public static EndgameDriver EndgameDriver;
  public static Hatch hatch;
  public static F310 F310;
  public static SparkyThing sparkyThing;
  //new subsystem for vision tracking here//
  // put vision initalizations here
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    sparkyThing = new SparkyThing();
    ballIntake = new BallIntake();
    drivingStuff = new DrivingStuff();
    Drive = new Drive();
    Elevator = new Elevator();
    EndgameDriver = new EndgameDriver();
    hatch = new Hatch();
    hatchIn = new HatchIn();
    //vision = new Vision();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  // This function is called periodically during autonomous.

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
//Yeetith 
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic(){
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
