package org.academiadecodigo.haltistas.lastsurvivor.graphics;

public enum Action {
    ATTACK("ATTACK"),
    MAGIC("MAGIC"),
    DEFEND("DEFEND"),
    ITEMS("ITEMS");

    private String action;

    Action (String action){
        this.action=action;
    }

    public String getAction() {
        return action;
    }
}

