package com.sourav.kafka.model;

import java.time.LocalDateTime;

public record Message(String record, LocalDateTime localDateTime) {
}
