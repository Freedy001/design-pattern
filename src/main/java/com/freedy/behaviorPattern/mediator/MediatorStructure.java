package com.freedy.behaviorPattern.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Freedy
 * @date 2021/6/19 17:23
 */
@Getter
@Setter
public class MediatorStructure extends Mediator {
    private HouseOwner houseOwner;
    private Tenant tenant;

    @Override
    public void contact(String msg, Person person) {
        if (person == houseOwner)
            tenant.getMessage(msg);
        else
            houseOwner.getMessage(msg);
    }
}
