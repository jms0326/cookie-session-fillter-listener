package com.example.cookiesession.step2;

public record DTO(String name, int count) {
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}