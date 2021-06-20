package com.freedy.behaviorPattern.interpreter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Freedy
 * @date 2021/6/19 21:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Variable extends AbstractExpression {

    private String name;

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

}
