package pl.annurb.converter;


import org.springframework.core.convert.converter.Converter;
import pl.annurb.model.ActivityType;

public class ActivityConverterToDatabase implements Converter<ActivityType, String> {
    @Override
    public String convert(ActivityType activityType) {
        return activityType.name();
    }
}