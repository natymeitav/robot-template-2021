package frc.robot.subsystems.base.common;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constant {
    double doubleVal() default 0.0;
    int intVal() default 0;
    long longVal() default 0L;
}
