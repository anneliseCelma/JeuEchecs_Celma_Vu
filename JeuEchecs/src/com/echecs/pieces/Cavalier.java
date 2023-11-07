package com.echecs.pieces;

import com.echecs.Position;

public class Cavalier extends Piece{
    public Cavalier(char color){
        super(color);
    }
    @Override
    public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
        return false;
    }
}
