package pl.annurb.converter;

import org.springframework.core.convert.converter.Converter;
import pl.annurb.model.ActivityType;

public class ActivityConverterFromDatabase implements Converter<String, ActivityType> {
    @Override
    public ActivityType convert(String type) {
        return ActivityType.valueOf(type);
    }
}
