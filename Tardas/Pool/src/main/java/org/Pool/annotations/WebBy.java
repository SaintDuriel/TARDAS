package org.Pool.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD, LOCAL_VARIABLE })
public @interface WebBy {

    public String id() default ""; 
    public String css() default ""; 
    public String xpath() default ""; 
    public String tagName() default ""; 
    public String className() default ""; 
    public String linkText() default ""; 
    public String partialLinkText() default "" ;
}
