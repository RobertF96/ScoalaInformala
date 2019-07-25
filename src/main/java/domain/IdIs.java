package domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class IdIs {

    @EqualsAndHashCode.Exclude
    private long id;

    public IdIs(long id) {
        this.id = id;
    }
}
