/*package frc.robot.subsystems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import edu.wpi.first.wpilibj.vision.VisionPipeline;

import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.features2d.FeatureDetector;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;

// Stuff I Imported for VisionCode
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;
import frc.robot.Robot;
*/
/**
* GripPipeline class.
*
* <p>An OpenCV pipeline generated by GRIP.
*
* @author GRIP
*/
/*public class GripPipeline implements VisionPipeline {

	//Outputs
	private Mat cvResizeOutput = new Mat();
	private Mat hsvThresholdOutput = new Mat();
	private Mat cvErodeOutput = new Mat();
	private Mat maskOutput = new Mat();

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
*/
	/**
	 * This is the primary method that runs the entire pipeline and updates the outputs.
	 */
	/*@Override	public void process(Mat source0) {
		// Step CV_resize0:
		Mat cvResizeSrc = source0;
		Size cvResizeDsize = new Size(0, 0);
		double cvResizeFx = 1.25;
		double cvResizeFy = 1.25;
		int cvResizeInterpolation = Imgproc.INTER_LINEAR;
		cvResize(cvResizeSrc, cvResizeDsize, cvResizeFx, cvResizeFy, cvResizeInterpolation, cvResizeOutput);

		// Step HSV_Threshold0:
		Mat hsvThresholdInput = cvResizeOutput;
		double[] hsvThresholdHue = {0.0, 0.0};
		double[] hsvThresholdSaturation = {0.0, 0.0};
		double[] hsvThresholdValue = {0.0, 255.0};
		hsvThreshold(hsvThresholdInput, hsvThresholdHue, hsvThresholdSaturation, hsvThresholdValue, hsvThresholdOutput);

		// Step CV_erode0:
		Mat cvErodeSrc = hsvThresholdOutput;
		Mat cvErodeKernel = new Mat();
		Point cvErodeAnchor = new Point(-1, -1);
		double cvErodeIterations = 0.0;
		int cvErodeBordertype = Core.BORDER_ISOLATED;
		Scalar cvErodeBordervalue = new Scalar(-1);
		cvErode(cvErodeSrc, cvErodeKernel, cvErodeAnchor, cvErodeIterations, cvErodeBordertype, cvErodeBordervalue, cvErodeOutput);

		// Step Mask0:
		Mat maskInput = cvResizeOutput;
		Mat maskMask = cvErodeOutput;
		mask(maskInput, maskMask, maskOutput);

	}
*/
	/**
	 * This method is a generated getter for the output of a CV_resize.
	 * @return Mat output from CV_resize.
	 */
	/*public Mat cvResizeOutput() {
		return cvResizeOutput;
	}
*/
	/**
	 * This method is a generated getter for the output of a HSV_Threshold.
	 * @return Mat output from HSV_Threshold.
	 */
	/*public Mat hsvThresholdOutput() {
		return hsvThresholdOutput;
	}*/

	/**
	 * This method is a generated getter for the output of a CV_erode.
	 * @return Mat output from CV_erode.
	 */
	/*public Mat cvErodeOutput() {
		return cvErodeOutput;
	}
*/
	/**
	 * This method is a generated getter for the output of a Mask.
	 * @return Mat output from Mask.
	 */
	/*public Mat maskOutput() {
		return maskOutput;
	}
*/

	/**
	 * Resizes an image.
	 * @param src The image to resize.
	 * @param dSize size to set the image.
	 * @param fx scale factor along X axis.
	 * @param fy scale factor along Y axis.
	 * @param interpolation type of interpolation to use.
	 * @param dst output image.
	 */
	/*private void cvResize(Mat src, Size dSize, double fx, double fy, int interpolation,
		Mat dst) {
		if (dSize==null) {
			dSize = new Size(0,0);
		}
		Imgproc.resize(src, dst, dSize, fx, fy, interpolation);
	}
*/
	/**
	 * Segment an image based on hue, saturation, and value ranges.
	 *
	 * @param input The image on which to perform the HSL threshold.
	 * @param hue The min and max hue
	 * @param sat The min and max saturation
	 * @param val The min and max value
	 * @param output The image in which to store the output.
	 */
	/*private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
	    Mat out) {
		Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
		Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
			new Scalar(hue[1], sat[1], val[1]), out);
	}
*/
	/**
	 * Expands area of lower value in an image.
	 * @param src the Image to erode.
	 * @param kernel the kernel for erosion.
	 * @param anchor the center of the kernel.
	 * @param iterations the number of times to perform the erosion.
	 * @param borderType pixel extrapolation method.
	 * @param borderValue value to be used for a constant border.
	 * @param dst Output Image.
	 */
	/*private void cvErode(Mat src, Mat kernel, Point anchor, double iterations,
		int borderType, Scalar borderValue, Mat dst) {
		if (kernel == null) {
			kernel = new Mat();
		}
		if (anchor == null) {
			anchor = new Point(-1,-1);
		}
		if (borderValue == null) {
			borderValue = new Scalar(-1);
		}
		Imgproc.erode(src, dst, kernel, anchor, (int)iterations, borderType, borderValue);
	}
*/
	/**
	 * Filter out an area of an image using a binary mask.
	 * @param input The image on which the mask filters.
	 * @param mask The binary image that is used to filter.
	 * @param output The image in which to store the output.
	 */
	/*private void mask(Mat input, Mat mask, Mat output) {
		mask.convertTo(mask, CvType.CV_8UC1);
		Core.bitwise_xor(output, output, output);
		input.copyTo(output, mask);
	}*/
	//this helps the robot target and find what you want to target
	//all this code below is useless, but can be used as a template

	/*public class visionCode extends Robot {
		private static final int IMG_WIDTH = 400; //numbers can be changed
		private static final int IMG_HEIGHT = 400;
	
		private VisionThread visionThread;
		private double centerX = 0.0;
		private RobotDrive drive;
	
		private final Object imgLock = new Object();
	
	@Override
	public void robotInit() {
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    
    /*visionThread = new VisionThread(camera, new VisionPipeline(), pipeline -> {
        if (!pipeline.filterContoursOutput().isEmpty()) {
            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
            synchronized (imgLock) {
                centerX = r.x + (r.width / 2);
            }
        }
	});
	*/
    /*visionThread.start();
        
    drive = new RobotDrive(1, 2);
}
	@Override
	public void autonomousPeriodic() {
    	double centerX;
    	synchronized (imgLock) {
        centerX = this.centerX;
    	}
    	double turn = centerX - (IMG_WIDTH / 2);
    	drive.arcadeDrive(-0.6, turn * 0.005);
	}
}
}
*/

