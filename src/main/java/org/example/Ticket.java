package org.example;

import java.time.OffsetDateTime;

/**
 * Можно изменять по своему усмотрению, не нарушая правила приоритезации очереди
 */
public class Ticket {

    private static int idSeq;

    /**
     * Автогенерация id
     */
    int id = ++idSeq;

    /**
     * Приоритеты типов:
     * 1) pension
     * 2) любые другие
     */
    String type;

    /**
     * Приоритет для ранней регистрации
     */
    OffsetDateTime registerTime = OffsetDateTime.now();

    public Ticket(String type) {
        this.type = type;
    }

    public Ticket(int id, String type, OffsetDateTime registerTime) {
        this.id = id;
        this.type = type;
        this.registerTime = registerTime;
    }

    public Ticket(String type, OffsetDateTime registerTime) {
        this.type = type;
        this.registerTime = registerTime;
    }
}
