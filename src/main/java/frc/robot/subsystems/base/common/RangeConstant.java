package frc.robot.subsystems.base.common;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RangeConstant {
    double minDouble() default 0.;
    double maxDouble() default 0.;
    int minInt() default 0;
    int maxInt() default 0;
    long minLong() default 0L;
    long maxLong() default 0L;
}
