package com.bwgjoseph.spring_boot_mongodb_observability.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Pokemon(@Id String id, String name, int baseExperience) {

}
