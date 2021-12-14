package cn.xin.demo01;

import java.util.EventObject;

public class EventClassOne extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventClassOne(Object source) {
        super(source);
    }
}

class EventClassTwo extends EventObject{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventClassTwo(Object source) {
        super(source);
    }
}
