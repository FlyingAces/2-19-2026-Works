package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final WPI_TalonSRX motor;
  private final TalonFX launchMotor1;
  private final TalonFX launchMotor2;

  public Shooter(int canID, int launchID1, int launchID2) {
    // ************** instantiate test motor ************** //
    motor = new WPI_TalonSRX(canID);
    motor.configFactoryDefault();
    motor.setInverted(false);
    motor.configVoltageCompSaturation(12.0);
    motor.enableVoltageCompensation(true);
    // ************** instantiate test motor ************** //



    // ************** instantiate launch motor 1 ************** //
    // Configure motor settings
    TalonFXConfiguration config = new TalonFXConfiguration();
    // Example: set PID values for position control
    config.Slot0.kP = 0.1;
    config.Slot0.kI = 0.0;
    config.Slot0.kD = 0.0;
    launchMotor1 = new TalonFX(launchID1);
    launchMotor1.getConfigurator().apply(config);

    // ************** instantiate launch motor 1 ************** //


    // ************** instantiate launch motor 2 ************** //


    launchMotor2 = new TalonFX(launchID1);
    launchMotor2.getConfigurator().apply(config);

    // ************** instantiate launch motor 2 ************** //
  }

  /** Run shooter at given speed (-1.0 to 1.0) */
  public void run(double speed) {
    motor.set(ControlMode.PercentOutput, speed);
    launchMotor1.set(speed);
    launchMotor2.set(speed);
  }

  /** Stop shooter */
  public void stop() {
    motor.set(ControlMode.PercentOutput, 0);
    launchMotor1.stopMotor();
    launchMotor2.stopMotor();
  }
}
