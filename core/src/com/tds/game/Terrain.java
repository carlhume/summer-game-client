package com.tds.game;

public class Terrain {

    //TODO: Replace this with terrain info loaded from game rules
    private static final String CODE_PLAINS = "P";
    public static final Terrain PLAINS = new Terrain( CODE_PLAINS );

    private static final String CODE_FOREST = "F";
    public static final Terrain FOREST = new Terrain( CODE_FOREST );

    private String type;

    public Terrain() {
        this.type = CODE_PLAINS;
    }

    public Terrain( String type ) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType( String newType ) {
        this.type = newType;
    }

}
