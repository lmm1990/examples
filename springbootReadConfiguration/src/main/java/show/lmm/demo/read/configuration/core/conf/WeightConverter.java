package show.lmm.demo.read.configuration.core.conf;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import show.lmm.demo.read.configuration.core.model.Weight;
import show.lmm.demo.read.configuration.core.model.WeightUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 重量转换器
 *
 * @author 刘明明
 * @since 2022-02-24 16:41
 */
@ConfigurationPropertiesBinding
@Component
public class WeightConverter implements Converter<String, Weight> {


    private static final Pattern PATTERN = Pattern.compile("^([+\\-]?\\d+)([a-zA-Z]{0,2})$");

    private long weight;

    private WeightUnit weightUnit;

    @Override
    public Weight convert(String source) {
        Matcher matcher = PATTERN.matcher(source);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("'" + source + "' is not a valid weight size");
        }
        weight = Long.parseLong(matcher.group(1));
        weightUnit = WeightUnit.fromSuffix(matcher.group(2));
        return new Weight(weight, weightUnit);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Weight, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
