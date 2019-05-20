package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Wing;
import frc.robot.Robot;
import frc.robot.oi.F310;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI6 extends Subsystem{
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
  public Joystick driver = new Joystick(0);
  public Joystick coPilot = new Joystick(1);
  public double leftdriverX = driver.getRawAxis(1);
  public double leftdriverY = driver.getRawAxis(0);
 // public static double rightDriverX = Robot.m_oi.driver.getRawAxis(4);
 //public static double rightDriverY = Robot.m_oi.driver.getRawAxis(5);
 // public static double coPilotX = Robot.m_oi.coPilot.getX();
  //public static double coPilotY = Robot.m_oi.coPilot.getY();
 public static Button SpoolIn = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_B);
  public static Button SpoolOut = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_A);
  public static Button BallIn = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_TRIGGER_RIGHT);
  public static Button BallOut = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_SHOULDER_RIGHT);
  public static Button Level1 = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_SHOULDER_LEFT);
  public static Button Level2 = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_X);
  public static Button Level3 = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_Y);
  public static Button HatchGrabber = new JoystickButton(Robot.m_oi.coPilot, F310.BUTTON_TRIGGER_LEFT);
  public static Button EndgameElevator = new JoystickButton(Robot.m_oi.driver, F310.BUTTON_SHOULDER_RIGHT);

  //HatchGrabber.whileHeld(new Hatch());
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Wing());
  }
}
