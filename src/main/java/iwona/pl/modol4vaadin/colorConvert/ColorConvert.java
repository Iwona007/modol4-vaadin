package iwona.pl.modol4vaadin.colorConvert;

import iwona.pl.modol4vaadin.model.Color;
import java.util.EnumSet;
import org.springframework.stereotype.Component;

@Component
public class ColorConvert {
    public Color convertToEnum(String color) {
        return EnumSet.allOf(Color.class).stream()
                .filter(color1 -> color1.name().equalsIgnoreCase(color))
                .findAny().get();
//                .orElseThrow(() -> new ColorNotFound(color));
    }

    public boolean convertToString(Color color){
        return   color.name().equalsIgnoreCase(String.valueOf(color));
    }
}
