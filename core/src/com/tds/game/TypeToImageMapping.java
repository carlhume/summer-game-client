package com.tds.game;

public class TypeToImageMapping {

    private String type;
    private String texturePath;

    public String getType() {
        return type;
    }

    public void setType( String newType ) {
        type = newType;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setTexturePath( String relativePath ) {
        texturePath = relativePath;
    }
}
