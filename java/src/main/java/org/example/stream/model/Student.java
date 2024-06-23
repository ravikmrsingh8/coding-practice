package org.example.stream.model;

import java.util.List;

public record Student(String name, List<Subject> subjects) {
}
