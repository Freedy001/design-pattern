package com.freedy.behaviorPattern.responsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Freedy
 * @date 2021/6/19 0:00
 */
@AllArgsConstructor
@Getter
public class LeaveRequest {
    private final String name;
    private final int days;
    private final String content;
}
