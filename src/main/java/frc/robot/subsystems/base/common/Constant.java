package frc.robot.subsystems.base.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a field is intended to override a field value.
 * <p>
 * The class use java reflection to replace the values at runtime,
 * <b>NOTE: when you use this annotation on primitive object type, you need to use CONST() method.</b>
 *
 * @author Barel
 * @version 1.0
 * @see org.apache.commons.lang3.ObjectUtils#CONST(int)
 * @see org.apache.commons.lang3.ObjectUtils#CONST(double)
 * @see org.apache.commons.lang3.ObjectUtils#CONST(long)
 * @see frc.robot.utilities.Utils#swapConstants(Class)
 * @since 2020-off
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constant {
    /**
     * @return a value of double object.
     */
    double doubleVal() default 0.0;

    /**
     * @return a value of integer object.
     */
    int intVal() default 0;

    /**
     * @return a value of long object.
     */
    long longVal() default 0L;
}
