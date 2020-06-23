package frc.robot.subsystems.base.common;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public enum TalonType {
    DEFAULT {
        @Override
        public TalonSRX configElevator(int port, boolean inverted, boolean sensorPhase) {
            return (TalonSRX) SRX.configElevator(port, inverted, sensorPhase);
        }
    },
    SRX {
        @Override
        public TalonSRX configElevator(int port, boolean inverted, boolean sensorPhase) {
            TalonSRX motor = new TalonSRX(port);
            motor.setNeutralMode(NeutralMode.Brake);
            motor.setInverted(inverted);
            motor.setSensorPhase(sensorPhase);

            motor.configContinuousCurrentLimit(15);
            motor.configPeakCurrentLimit(30);
            motor.configPeakCurrentDuration(1000);
            motor.enableCurrentLimit(true);

            motor.overrideSoftLimitsEnable(false);
            motor.overrideLimitSwitchesEnable(false);

            motor.configVoltageCompSaturation(12);
            motor.enableVoltageCompensation(true);
            return motor;
        }
    },
    FALCON {
        @Override
        public TalonFX configElevator(int port, boolean inverted, boolean sensorPhase) {
            TalonFX motor = new TalonFX(port);
            motor.setNeutralMode(NeutralMode.Brake);
            motor.setInverted(inverted);
            motor.setSensorPhase(sensorPhase);

            motor.overrideSoftLimitsEnable(false);
            motor.overrideLimitSwitchesEnable(false);

            motor.configVoltageCompSaturation(12);
            motor.enableVoltageCompensation(true);
            return motor;
        }
    };

    TalonType() {
    }

    public abstract BaseTalon configElevator(int port, boolean inverted, boolean sensorPhase);
}
