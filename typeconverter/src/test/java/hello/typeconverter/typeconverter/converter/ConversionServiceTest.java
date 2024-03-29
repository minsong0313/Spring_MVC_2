package hello.typeconverter.typeconverter.converter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter()); //1
        conversionService.addConverter(new IntegerToStringConverter()); //2
        conversionService.addConverter(new StringToIpPortConverter()); //3
        conversionService.addConverter(new IpPortToStringConverter()); //4

        //사용
        //타입정보 확인하고 1번 실행해줌
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);

        //타입정보 확인하고 2번 실행해줌
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        //타입정보 확인하고 3번 실행해줌
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        //타입정보 확인하고 4번 실행해줌
        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");

    }
}
