package frc.robot.subsystems.base.elevator;

import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.base.common.TalonType;

public abstract class ElevatorBase extends SubsystemBase {
    protected final TalonType type;

    private ElevatorBase() {
        type = TalonType.DEFAULT;
    }

    protected ElevatorBase(TalonType talonType) {
        type = talonType;
    }

    protected BaseTalon configMaster(int port, boolean inverted, boolean sensorPhase) {
        return type.configElevator(port, inverted, sensorPhase);
    }

    protected BaseTalon configSlave(BaseTalon master, int port, boolean inverted, boolean sensorPhase) {
        BaseTalon slave = configMaster(port, inverted, sensorPhase);
        slave.follow(master);
        return slave;
    }

    public abstract void setHeight(double height);
    public abstract double getHeight();

    public abstract double getTicks();

    public abstract double getSpeed();
    public abstract void setSpeed(double speed);

    public abstract boolean atTop();
    public abstract boolean atBottom();
}
