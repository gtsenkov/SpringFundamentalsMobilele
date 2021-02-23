package bg.softuni.mobilele.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.time.YearMonth;

public class YearInPastOrPresentValidator implements ConstraintValidator<YearsInPastOrPresent, Integer> {

    private int minYear;

    @Override
    public void initialize(YearsInPastOrPresent constraintAnnotation) {
        this.minYear = constraintAnnotation.minYear();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        int nowYear = YearMonth.now().getYear();
        return value >= minYear && value <= nowYear;
    }
}
