package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.DoNothingAuto;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.Intake.SpinIntakeIn;
import frc.robot.commands.pneumatics.Intake.DeployIntake;
import frc.robot.commands.pneumatics.Intake.RetractIntake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatics;
import frc.libs.*;

public class RobotContainer implements Constants.ElectricalPortConstants {

  public static final Drivetrain dt = new Drivetrain();
  public static final Pneumatics pn = new Pneumatics();
  public static final Intake in = new Intake();
  

  // public static final AutoGenerator ag = new AutoGenerator();
  private static final SendableChooser<Command> chooser = new SendableChooser<>();

  // Xbox controllers
  public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
  public static final Joystick joystick = new Joystick(joystickDriver);

  private UsbCamera camera;

  public RobotContainer() {
    //TALK TO DRIVERS AND SEE IF THEY WANT/NEED A CAMERA AND ADJUST ACCORDINGLY
    camera = CameraServer.startAutomaticCapture();
    camera.setFPS(30);
    camera.setResolution(
      Constants.GeneralConstants.RobotPhysicalConstants.x_resolution, 
      Constants.GeneralConstants.RobotPhysicalConstants.y_resolution
    );

    chooser.setDefaultOption("Do Nothing Auto", new DoNothingAuto());
    chooser.addOption("TD: 2s", new TimedDrive(0.25, 2));
    chooser.addOption("TD: 5s", new TimedDrive(0.25, 5));
    chooser.addOption("RTD: 2s", new TimedDrive(-0.25, 2));
    chooser.addOption("RTD: 5s", new TimedDrive(-0.25, 5));
    //NO AUTOS OTHER THAN TAXI, CHECK HOW FAR THACKER GOES *BEOFRE* OFFICIAL MATCHES

    Shuffleboard.getTab("Selector").add(chooser);
    

    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {

    new JoystickButton(xbox, Button.kLeftBumper.value)
      .whenPressed(new DeployIntake())
      .whenPressed(new SpinIntakeIn())
      .whenReleased(new RetractIntake());
      //WORK WITH DRIVERS TO FIGURE OUT CONTROLS AND CHECK THAT THEY ALL WORK
  } 

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }

  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}
