package frc.robot.subsystems.base.common;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.utilities.FalconConfiguration;

public class FalconBuilder {
    private final TalonFX motor;

    public FalconBuilder(int port, boolean inverted, double openLoopRamp) {
        motor = new TalonFX(port);
        motor.configFactoryDefault();
        motor.setInverted(inverted);
        motor.configOpenloopRamp(openLoopRamp);
        motor.setNeutralMode(NeutralMode.Coast);
        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(12.);
        motor.overrideSoftLimitsEnable(false);
        motor.overrideLimitSwitchesEnable(false);
    }

    public static void configFalcons(FalconConfiguration configurations, TalonFX... falcons) {
        for (TalonFX falcon : falcons) {
            falcon.configAllSettings(configurations.motorConfigs);
            falcon.configVoltageCompSaturation(configurations.getVoltageCompensationSaturation());
            falcon.setNeutralMode(configurations.getNeutralMode());
            falcon.enableVoltageCompensation(configurations.isEnableVoltageCompensation());
            falcon.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(configurations.isEnableCurrentLimit(),
                    configurations.getSupplyCurrentLimit(),
                    configurations.getThreshHoldCurrent(),
                    configurations.getThreshHoldTime()));
            falcon.config_kP(0, configurations.getPidSet()[0]);
            falcon.config_kI(0, configurations.getPidSet()[1]);
            falcon.config_kD(0, configurations.getPidSet()[2]);
            falcon.config_kF(0, configurations.getPidSet()[3]);
        }
    }

    public static void configPID(double kp, double ki, double kd, double kf, TalonFX... falcons) {
        for (TalonFX motor: falcons) {
            motor.config_kP(0, kp, 10);
            motor.config_kI(0, ki, 10);
            motor.config_kD(0, kd, 10);
            motor.config_kF(0, kf, 10);
        }
    }

    public FalconBuilder overrideNeuralMode(NeutralMode mode) {
        motor.setNeutralMode(mode);
        return this;
    }

    public FalconBuilder addSensor(int position, boolean sensorPhase) {
        motor.setSelectedSensorPosition(position);
        motor.setSensorPhase(sensorPhase);

        return this;
    }

    public FalconBuilder addSensor(boolean sensorPhase) {
        return addSensor(0, sensorPhase);
    }

    public FalconBuilder addPID(int slot, double kp, double ki, double kd, double kf, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);

        return this;
    }

    public FalconBuilder addPID(int slot, double kp, double ki, double kd, double kf) {
        return addPID(slot, kp, ki, kd, kf, 10);
    }

    public FalconBuilder addPID(double kp, double ki, double kd, double kf) {
        return addPID(0, kp, ki, kd, kf);
    }

    public FalconBuilder configPhysics(boolean sofLimitEnabled, int softThreshold, int cruiseVelocity) {
        motor.configForwardSoftLimitEnable(sofLimitEnabled);
        motor.configReverseSoftLimitEnable(sofLimitEnabled);
        motor.configForwardSoftLimitThreshold(softThreshold);
        motor.configReverseSoftLimitThreshold(softThreshold);

        motor.configMotionCruiseVelocity(cruiseVelocity);
        return this;
    }

    public FalconBuilder configCurrentLimit(boolean enabled, double supply, double threshold, int thresholdTime) {
        motor.configSupplyCurrentLimit(
                new SupplyCurrentLimitConfiguration(enabled, supply, threshold, thresholdTime)
        );

        return this;
    }

    public FalconBuilder follow(TalonFX master) {
        motor.follow(master);
        return this;
    }

    public TalonFX build() {
        return motor;
    }
}
