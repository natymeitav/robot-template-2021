package frc.robot.subsystems.base.turret;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class TurretBase extends SubsystemBase {

    public TalonFX configMotorBase(int port, boolean inverted, boolean sensorPhase, int timeout) {
        TalonFX motor = new TalonFX(port);
        motor.setInverted(inverted);

        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, timeout);
        motor.setSensorPhase(sensorPhase);

        motor.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
        motor.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);

        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(12.0);

        return motor;
    }

    public TalonFX configMotorBase(int port, boolean inverted, boolean sensorPhase) {
        return configMotorBase(port, inverted, sensorPhase, 10);
    }

    public void configMotorSoftLimits(TalonFX motor, int minThresholdsTick, int maxThresholdsTick, boolean enableSoftLimits, boolean disableOnLos, int timeout) {
        motor.configReverseSoftLimitEnable(enableSoftLimits, timeout);
        motor.configForwardSoftLimitEnable(enableSoftLimits, timeout);

        motor.configSoftLimitDisableNeutralOnLOS(disableOnLos, timeout);

        motor.configReverseSoftLimitThreshold(minThresholdsTick);
        motor.configForwardSoftLimitThreshold(maxThresholdsTick);

        motor.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
        motor.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
    }

    public void configPIDAndPhysics(TalonFX motor, int slot, double kp, double ki, double kd, double kf, int acceleration, int cruiseVelocity, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);

        motor.configMotionAcceleration(acceleration);
        motor.configMotionCruiseVelocity(cruiseVelocity);
    }

    public void configPIDAndPhysics(TalonFX motor, int slot, double kp, double ki, double kd, double kf, int acceleration, int cruiseVelocity) {
        configPIDAndPhysics(motor, slot, kp, ki, kd, kf, acceleration, cruiseVelocity, 10);
    }

    public void configPIDAndPhysics(TalonFX motor, double kp, double ki, double kd, double kf, int acceleration, int cruiseVelocity) {
        configPIDAndPhysics(motor, 10, kp, ki, kd, kf, acceleration, cruiseVelocity);
    }

    public abstract double getAngle();

    public abstract void setAngle(double angle);

    public abstract void setPower(double speed);

    public abstract void stop();

    public abstract double getNearestPosition(double targetAngle, double currentPosition, double minPos, double maxPos);

    public abstract boolean isReady();

    public abstract boolean inCorrectRange();

    public abstract boolean inDeadZone();
}
