package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;

public class Camera extends TimedRobot {
    
    public void robotInit() {
        CameraServer.getInstance().startAutomaticCapture();
    }
}