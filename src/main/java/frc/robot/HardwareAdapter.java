package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;

public interface HardwareAdapter extends Constants.ElectricalPortConstants {
    // Other CAN
    public static final PowerDistribution pdp = new PowerDistribution();
    public static final PneumaticsControlModule pcm = new PneumaticsControlModule();

    // Drivetrain
    public static WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(12);
    public static WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(5);
    public static WPI_TalonSRX rightMotor3 = new WPI_TalonSRX(4);
    public final MotorControllerGroup rightSideMotors = new MotorControllerGroup(rightMotor1,rightMotor2,rightMotor3);
    //CHECK THAT THE GROUP IS WORKING CORRECTLY *BEFORE* OFFICIAL MATCHES

    public static WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(3);
    public static WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(6);
    public static WPI_TalonSRX leftMotor3 = new WPI_TalonSRX(9);
    public final MotorControllerGroup leftSideMotors = new MotorControllerGroup(leftMotor1,leftMotor2,leftMotor3);
    //CHECK THAT THE GROUP IS WORKING CORRECTLY *BEFORE* OFFICIAL MATCHES

    //Intake
    public final CANSparkMax intakeMotor1 = new CANSparkMax(9, MotorType.kBrushless); 
    public final CANSparkMax intakeMotor2 = new CANSparkMax(10, MotorType.kBrushless);
    //CHECK THESE NUMBERS

    // Pnuematics
    public static final Compressor compressor = new Compressor(1, PneumaticsModuleType.CTREPCM);
    public static final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1,PneumaticsModuleType.CTREPCM, 7, 0);
    public static final DoubleSolenoid tiltSolenoid = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, 6, 1);
    //CHECK THESE NUMBERS
    // tiltSolenoid had a weird isCompetitionRobot? 6:1 for the ext/ret values so may have to be switched once you can test.
}
