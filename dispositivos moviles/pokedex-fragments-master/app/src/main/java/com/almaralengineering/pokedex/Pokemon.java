package com.almaralengineering.pokedex;

public class Pokemon {
    private String id;
    private String name;
    private Type type;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Type getType() {
        return type;
    }
}
