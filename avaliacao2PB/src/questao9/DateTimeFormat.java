package questao9;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DateTimeFormat {
SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy/MM/dd");




}
