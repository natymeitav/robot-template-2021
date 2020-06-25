package frc.robot.subsystems.base.common;

import frc.robot.subsystems.UnitModel;

/**
 * Add methods that indicated that the subsystem using shifting.
 * <p>
 *
 * @author Barel
 * @version 1.0
 * @see ShiftModes
 * @since 2020-off
 */
public interface Shiftable {

    /**
     * Shift the gear based {@code mode} param.
     *
     * @param mode the mode to shift to
     */
    void shiftGear(ShiftModes mode);

    /**
     * Shift the gear to high mode.
     */
    void shiftHigh();

    /**
     * Shift the gear to low mode.
     */
    void shiftLow();

    /**
     * Toggle between the modes
     */
    void toggle();

    /**
     * @return whether the subsystem can shift to high mode.
     */
    boolean canShiftHigh();

    /**
     * @return whether the subsystem can shift to low mode.
     */
    boolean canShiftLow();

    /**
     * @return whether the shifter is shifted to high mode.
     */
    boolean isShiftedHigh();

    /**
     * @return whether the shifter is shifted to low mode.
     */
    boolean isShiftedLow();

    /**
     * @return the current unit model based on the shift mode.
     */
    UnitModel getCurrentUnitModel();
}
