package frc.robot.subsystems.base.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.utilities.Utils;


public class Drivetrain extends DrivetrainSubsystemBase {

    private Drivetrain() {
    }

    private Drivetrain(int[] ports, boolean[] inverted, double kp, double ki, double kd, double kf, double ticksPerMeter) {
        super(ports, inverted, kp, ki, kd, kf, ticksPerMeter);
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
        return conversionModel.toVelocity(leftMaster.getSelectedSensorVelocity());
    }

    /**
     * @return the velocity of the tight motor.
     */
    @Override
    public double getRightVelocity() {
        return conversionModel.toVelocity(rightMaster.getSelectedSensorVelocity());
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

    public static class Builder extends DrivetrainSubsystemBase.Builder {

        public Builder(double kp, double ki, double kd, double kf, double ticksPerMeter) {
            super(kp, ki, kd, kf, ticksPerMeter);
        }

        @Override
        public DrivetrainSubsystemBase.Builder setPorts(int leftMasterPort, int leftSlavePort, int rightMasterPort, int rightSlavePort) {
            return super.setPorts(leftMasterPort, leftSlavePort, rightMasterPort, rightSlavePort);
        }

        @Override
        public DrivetrainSubsystemBase.Builder setInverted(boolean isLeftMasterInverted, boolean isLeftSlaveInverted, boolean isRightMasterInverted, boolean isRightSlaveInverted) {
            return super.setInverted(isLeftMasterInverted, isLeftSlaveInverted, isRightMasterInverted, isRightSlaveInverted);
        }

        @Override
        @SuppressWarnings("unchecked")
        public Drivetrain build() {
            if (Utils.arrayContains(ports, 0))
                throw new IllegalStateException("You need to specify ALL of the ports for the subsystem in order to create it.");
            return new Drivetrain(ports, inverts,
                    kp, ki, kd, kf, ticksPerMeter);
        }
    }

}
