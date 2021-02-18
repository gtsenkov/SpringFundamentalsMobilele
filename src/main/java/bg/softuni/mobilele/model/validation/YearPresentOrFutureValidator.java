package bg.softuni.mobilele.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.YearMonth;

public class YearPresentOrFutureValidator implements ConstraintValidator<YearPresentOrFuture, Integer> {

    private int minYear;

    @Override
    public void initialize(YearPresentOrFuture constraintAnnotation) {
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
