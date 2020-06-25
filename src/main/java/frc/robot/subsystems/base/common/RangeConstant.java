package frc.robot.subsystems.base.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a range field is intended to override a range field value.
 * <p>
 * NOTE: The class use java reflection to replace the values at runtime.
 *
 * @author Barel
 * @version 1.0
 * @see Constant
 * @see frc.robot.utilities.Utils#swapConstants(Class)
 * @since 2020-off
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RangeConstant {
    /**
     * @return a minimum value of DoubleRange class.
     * @see org.apache.commons.lang.math.DoubleRange
     */
    double minDouble() default 0.;

    /**
     * @return a maximum value of DoubleRange class.
     * @see org.apache.commons.lang.math.DoubleRange
     */
    double maxDouble() default 0.;

    /**
     * @return a minimum value of IntRange class.
     * @see org.apache.commons.lang.math.IntRange
     */
    int minInt() default 0;

    /**
     * @return a maximum value of IntRange class.
     * @see org.apache.commons.lang.math.IntRange
     */
    int maxInt() default 0;

    /**
     * @return a minimum value of LongRange class.
     * @see org.apache.commons.lang.math.LongRange
     */
    long minLong() default 0L;

    /**
     * @return a maximum value of LongRange class.
     * @see org.apache.commons.lang.math.LongRange
     */
    long maxLong() default 0L;
}
