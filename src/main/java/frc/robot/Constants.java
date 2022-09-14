package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public interface Constants {
	public interface GeneralConstants {
		public final static Value EXT = Value.kForward;
		public final static Value RET = Value.kReverse;
		public final static Value OFF = Value.kOff;
		public final static double DEADBAND = 0.2;

		public interface RobotPhysicalConstants {						
			// Camera offsets
			public static final int x_resolution = 640;
			public static final int y_resolution = 480;
		}
	}

	public interface ElectricalPortConstants {
		// Xbox Controllers
		public static final int xboxPrimaryDriver = 0;
		public static final int xboxSecondaryDriver = 2;
		public static final int joystickDriver = 1;

		// Other Can Bus
		public final static int PDP = 0;
		public final static int PCM = 1;

		// Drivetrain
		public final static int rightMotor1 = 12;
		public final static int rightMotor2 = 5;
		public final static int rightMotor3 = 4;
		public final static int leftMotor1 = 3;
		public final static int leftMotor2 = 6;
		public final static int leftMotor3 = 9;

		public static enum TurnMode {Right, Left};

		// Intake
		public final static int intakeMotor1 = 1;
		public final static int intakeMotor2 = 0;

	}
}