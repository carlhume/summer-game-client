package com.tds.game;

public class MapData {

    private Terrain terrain;

    public MapData() {
        this.terrain = new Terrain();
    }

    public MapData(Terrain newTerrain ) {
        this.terrain = newTerrain;
    }

    public Terrain getTerrain() {
        return this.terrain;
    }

}
