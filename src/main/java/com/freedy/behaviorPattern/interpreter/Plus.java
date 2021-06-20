package com.freedy.behaviorPattern.interpreter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Freedy
 * @date 2021/6/19 21:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Plus extends AbstractExpression{
    private AbstractExpression left;
    private AbstractExpression right;

    @Override
    public int interpret(Context context) {
        return left.interpret(context)+right.interpret(context);
    }
}
