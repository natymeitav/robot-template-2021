package frc.robot.subsystems.base.shooter;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class ShooterBase extends SubsystemBase {

    public TalonFX configMaster(int port, int timeout, boolean inverted, boolean sensorPhase) {
        TalonFX motor = new TalonFX(port);
        motor.configFactoryDefault();
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, timeout);
        motor.setInverted(inverted);
        motor.setSensorPhase(sensorPhase);
        motor.setNeutralMode(NeutralMode.Coast);

        motor.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
        motor.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);

        return motor;
    }

    public TalonSRX configSlave(TalonFX master, int port, boolean inverted) {
        TalonSRX motor = new TalonSRX(port);

        motor.configFactoryDefault();

        motor.setInverted(inverted);
        motor.setNeutralMode(NeutralMode.Coast);
        motor.follow(master);

        return motor;
    }

    public void configPID(TalonFX motor, double kp, double ki, double kd, double kf, int slot, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);
    }

    public void configPID(TalonFX motor, double kp, double ki, double kd, double kf) {
        configPID(motor, kp, ki, kd, kf, 0, 10);
    }

    public abstract double getSpeed();

    public abstract void setSpeed(double speed);

    public abstract boolean isShooterReady();

    public abstract boolean isShooting();

    public abstract void setPower(double power);

    public void stop() {
        setPower(0);
    }


}
