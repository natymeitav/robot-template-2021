package frc.robot.subsystems.base.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.UnitModel;
import frc.robot.utilities.FalconConfiguration;
import frc.robot.utilities.Utils;

public abstract class DrivetrainBase extends SubsystemBase {
    protected UnitModel defaultConversionModel;
    private final double openLoopRamp;

    private DrivetrainBase() {
        this.openLoopRamp = 0.0;
    }

    protected DrivetrainBase(double openLoopRamp) {
        this.openLoopRamp = openLoopRamp;
    }

    protected TalonFX configMaster(int port, boolean inverted) {
        TalonFX master = new TalonFX(port);
        master.configFactoryDefault();
        master.setSelectedSensorPosition(0);
        master.setInverted(inverted);
        master.configOpenloopRamp(openLoopRamp);

        return master;
    }

    protected TalonFX configSlave(TalonFX master, int port, boolean inverted) {
        TalonFX slave = configMaster(port, inverted);
        slave.follow(master);
        return slave;
    }

    protected void configFalcons(double kp, double ki, double kd, double kf, TalonFX... talons) {
        FalconConfiguration motorConfigurations = new FalconConfiguration();

        motorConfigurations.setNeutralMode(NeutralMode.Coast);
        motorConfigurations.setEnableVoltageCompensation(true);
        motorConfigurations.configureVoltageCompensationSaturation(12);
        motorConfigurations.setPidSet(kp, ki, kd, kf);
        motorConfigurations.setEnableCurrentLimit(true);
        motorConfigurations.setEnableCurrentLimit(true);
        motorConfigurations.setSupplyCurrentLimit(40);

        Utils.configAllFalcons(motorConfigurations, talons);
    }

    public abstract void setPower(double leftPower, double rightPower);

    public abstract double getLeftVelocity();

    public abstract double getRightVelocity();

    public abstract void setBrake(boolean brake);

}
