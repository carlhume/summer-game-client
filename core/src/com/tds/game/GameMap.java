package com.tds.game;

public class GameMap {

    private static final long HARDCODED_PLAINS_MAP_ID = 111;

    private long id;
    private MapData[][] mapData;

    public GameMap() {}

    public GameMap(long mapID ) {
        this.id = mapID;
        mapData = new MapData[3][3];
        mapData[0][0] = new MapData( Terrain.PLAINS );
        mapData[0][1] = new MapData( Terrain.FOREST );
        mapData[0][2] = new MapData( Terrain.FOREST );
        mapData[1][0] = new MapData( Terrain.PLAINS );
        mapData[1][1] = new MapData( Terrain.FOREST );
        mapData[1][2] = new MapData( Terrain.FOREST );
        mapData[2][0] = new MapData( Terrain.PLAINS );
        mapData[2][1] = new MapData( Terrain.FOREST );
        mapData[2][2] = new MapData( Terrain.FOREST );
    }

    public long getId() {
        return this.id;
    }

    public MapData[][] getMapData() {
        return this.mapData;
    }

}
