package frc.robot.subsystems.base.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.subsystems.base.common.motors.FalconBuilder;

public class Drivetrain extends DrivetrainBase {
    private final TalonFX leftMaster;
    private final TalonFX leftSlave;
    private final TalonFX rightMaster;
    private final TalonFX rightSlave;


    public Drivetrain() {
        leftMaster = new FalconBuilder(1, true, 3).addSensor(true).build();
//        leftMaster = configMaster(1, true);
        leftSlave = new FalconBuilder(2, false, 3).addSensor(true).follow(leftMaster).build();
        rightMaster = new FalconBuilder(3, true, 3).addSensor(true).build();
        rightSlave = new FalconBuilder(4, false, 3).addSensor(true).follow(rightMaster).build();

        FalconBuilder.configPID(0, 1, 2, 3, leftMaster, leftSlave, rightMaster, rightSlave);
    }


    /**
     * set the power to the motors of the drivetrain.
     *
     * @param leftPower  power to apply on the left side of the drivetrain,
     * @param rightPower power to apply on the right side of the drivetrain,
     */
    @Override
    public void setPower(double leftPower, double rightPower) {
        leftMaster.set(ControlMode.PercentOutput, leftPower);
        rightMaster.set(ControlMode.PercentOutput, rightPower);
    }

    /**
     * @return the velocity of the left motor.
     */
    @Override
    public double getLeftVelocity() {
        return defaultConversionModel.toVelocity(leftMaster.getSelectedSensorVelocity());
    }

    /**
     * @return the velocity of the tight motor.
     */
    @Override
    public double getRightVelocity() {
        return defaultConversionModel.toVelocity(rightMaster.getSelectedSensorVelocity());
    }

    /**
     * set the brake mode of the motors.
     *
     * @param brake whether or not the motor should be using brake mode or coast mode.
     * @see com.ctre.phoenix.motorcontrol.NeutralMode
     */
    @Override
    public void setBrake(boolean brake) {
        NeutralMode neutralMode = brake ? NeutralMode.Brake : NeutralMode.Coast;
        leftMaster.setNeutralMode(neutralMode);
        leftSlave.setNeutralMode(neutralMode);
        rightMaster.setNeutralMode(neutralMode);
        rightMaster.setNeutralMode(neutralMode);
    }
}
