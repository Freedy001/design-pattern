package com.freedy.behaviorPattern.memento.whiteBox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Freedy
 * @date 2021/6/19 20:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleStateMemento {
    private int vit;
    private int atk;
    private int def;
}
