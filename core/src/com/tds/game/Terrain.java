package com.tds.game;

public class Terrain {

    //TODO: Replace this with terrain info loaded from game rules
    private static final String CODE_PLAINS = "P";
    private static final String LABEL_PLAINS = "Plains";
    public static final Terrain PLAINS = new Terrain( CODE_PLAINS, LABEL_PLAINS );

    private static final String CODE_FOREST = "F";
    private static final String LABEL_FOREST = "Forest";
    public static final Terrain FOREST = new Terrain( CODE_FOREST, LABEL_FOREST );

    private String type;
    private String label;

    public Terrain() {
        this.type = CODE_PLAINS;
        this.label = LABEL_PLAINS;
    }

    public Terrain(String type, String label ) {
        this.type = type;
        this.label = label;
    }

    public String getType() {
        return this.type;
    }

    public String getLabel() {
        return this.label;
    }

}
