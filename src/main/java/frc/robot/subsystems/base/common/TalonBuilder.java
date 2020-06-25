package frc.robot.subsystems.base.common;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.utilities.TalonConfiguration;

public class TalonBuilder {
    private final TalonSRX motor;

    public TalonBuilder(int port, boolean inverted, double openLoopRamp) {
        motor = new TalonSRX(port);
        motor.configFactoryDefault();
        motor.setInverted(inverted);
        motor.configOpenloopRamp(openLoopRamp);
        motor.setNeutralMode(NeutralMode.Coast);
        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(12.);
    }

    public static void configFalcons(TalonConfiguration configurations, TalonSRX... talons) {
        for (TalonSRX talonSRX : talons) {
            talonSRX.configAllSettings(configurations.motorConfigs);
            talonSRX.configVoltageCompSaturation(configurations.getVoltageCompensationSaturation());
            talonSRX.setNeutralMode(configurations.getNeutralMode());
            talonSRX.enableVoltageCompensation(configurations.isEnableVoltageCompensation());
            talonSRX.config_kP(0, configurations.getPidSet()[0]);
            talonSRX.config_kI(0, configurations.getPidSet()[1]);
            talonSRX.config_kD(0, configurations.getPidSet()[2]);
            talonSRX.config_kF(0, configurations.getPidSet()[3]);
        }
    }

    public static void configPID(double kp, double ki, double kd, double kf, TalonSRX... talons) {
        for (TalonSRX motor : talons) {
            motor.config_kP(0, kp, 10);
            motor.config_kI(0, ki, 10);
            motor.config_kD(0, kd, 10);
            motor.config_kF(0, kf, 10);
        }
    }

    public TalonBuilder overrideNeuralMode(NeutralMode mode) {
        motor.setNeutralMode(mode);
        return this;
    }

    public TalonBuilder addSensor(int position, boolean sensorPhase) {
        motor.setSelectedSensorPosition(position);
        motor.setSensorPhase(sensorPhase);

        return this;
    }

    public TalonBuilder addSensor(boolean sensorPhase) {
        return addSensor(0, sensorPhase);
    }

    public TalonBuilder addPID(int slot, double kp, double ki, double kd, double kf, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);

        return this;
    }

    public TalonBuilder addPID(int slot, double kp, double ki, double kd, double kf) {
        return addPID(slot, kp, ki, kd, kf, 10);
    }

    public TalonBuilder addPID(double kp, double ki, double kd, double kf) {
        return addPID(0, kp, ki, kd, kf);
    }

    public TalonBuilder configPhysics(boolean sofLimitEnabled, int softThreshold, int cruiseVelocity) {
        motor.configForwardSoftLimitEnable(sofLimitEnabled);
        motor.configReverseSoftLimitEnable(sofLimitEnabled);
        motor.configForwardSoftLimitThreshold(softThreshold);
        motor.configReverseSoftLimitThreshold(softThreshold);

        motor.configMotionCruiseVelocity(cruiseVelocity);
        return this;
    }

    public TalonBuilder configCurrentLimit(boolean enabled, double supply, double threshold, int thresholdTime) {
        motor.configSupplyCurrentLimit(
                new SupplyCurrentLimitConfiguration(enabled, supply, threshold, thresholdTime)
        );

        return this;
    }

    public TalonBuilder follow(TalonFX master) {
        motor.follow(master);
        return this;
    }

    public TalonSRX build() {
        return motor;
    }
}
