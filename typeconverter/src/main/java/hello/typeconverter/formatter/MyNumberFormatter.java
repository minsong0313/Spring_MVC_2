package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    //문자 -> 숫자
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}", text, locale);
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    //숫자 -> 문자
    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        NumberFormat instance = NumberFormat.getInstance(locale);
        return instance.format(object);
    }
}
