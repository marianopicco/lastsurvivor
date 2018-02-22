package org.academiadecodigo.haltistas.lastsurvivor.characters;

public enum CharacterPictures {
    BLASTERCYST ("assets/blastercyst.png"),
    BUZZILISK("assets/buzzilisk.png"),
    FRAGNETIC("assets/fragnetic.png"),
    JUNJO("assets/junjo.png"),
    REPULSATE("assets/repulsate.png"),
    STREPTILE("assets/streptile.png");

    private String filePath;

    CharacterPictures (String filePath){
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
