package frc.robot.subsystems.base.common;

import frc.robot.subsystems.UnitModel;

public interface Shiftable {
    void shiftGear(ShiftModes mode);

    void shiftHigh();
    void shiftLow();

    boolean canShiftHigh();
    boolean canShiftLow();

    boolean isShiftedHigh();
    boolean isShiftedLow();

    UnitModel getCurrentUnitModel();
}
