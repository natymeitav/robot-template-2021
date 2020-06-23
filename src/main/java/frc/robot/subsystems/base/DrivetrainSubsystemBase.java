package frc.robot.subsystems.base;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.UnitModel;
import frc.robot.utilities.FalconConfiguration;
import frc.robot.utilities.Utils;

public abstract class DrivetrainSubsystemBase extends SubsystemBase {
    protected TalonFX leftMaster;
    protected TalonFX leftSlave;
    protected TalonFX rightMaster;
    protected TalonFX rightSlave;
    protected UnitModel conversionModel;

    protected DrivetrainSubsystemBase() {
    }

    protected DrivetrainSubsystemBase(int[] ports, boolean[] inverted, double kp, double ki, double kd, double kf, double ticksPerMeter) {
        if (ports.length < 4)
            throw new java.lang.IllegalArgumentException("You need at least 4 port for 4 motors, but you have only " + ports.length);
        if (inverted.length < 4)
            throw new IllegalArgumentException("You need at least 4 reversed values for 4 motors, but you have only " + inverted.length);

        leftMaster = new TalonFX(ports[0]);
        leftSlave = new TalonFX(ports[1]);
        rightMaster = new TalonFX(ports[2]);
        rightSlave = new TalonFX(ports[3]);
        conversionModel = new UnitModel(ticksPerMeter);

        FalconConfiguration motorConfigurations = new FalconConfiguration();

        leftMaster.configFactoryDefault();
        leftSlave.configFactoryDefault();
        rightMaster.configFactoryDefault();
        rightSlave.configFactoryDefault();

        leftMaster.setSelectedSensorPosition(0);
        leftSlave.follow(leftMaster);
        rightMaster.setSelectedSensorPosition(0);
        rightSlave.follow(rightMaster);

        //Inversions
        leftMaster.setInverted(inverted[0]);
        leftSlave.setInverted(inverted[1]);
        rightMaster.setInverted(inverted[2]);
        rightSlave.setInverted(inverted[3]);

        leftMaster.configOpenloopRamp(3); //TODO: use real number
        leftSlave.configOpenloopRamp(3);
        rightMaster.configOpenloopRamp(3);
        rightSlave.configOpenloopRamp(3);

        motorConfigurations.setNeutralMode(NeutralMode.Coast);
        motorConfigurations.setEnableVoltageCompensation(true);
        motorConfigurations.configureVoltageCompensationSaturation(12);
        motorConfigurations.setPidSet(kp, ki, kd, kf);
        motorConfigurations.setEnableCurrentLimit(true);
        motorConfigurations.setEnableCurrentLimit(true);
        motorConfigurations.setSupplyCurrentLimit(40);

        Utils.configAllFalcons(motorConfigurations, leftMaster, leftSlave, rightMaster, rightSlave);
    }

    public abstract void setPower(double leftPower, double rightPower);

    public abstract double getLeftVelocity();

    public abstract double getRightVelocity();


}
