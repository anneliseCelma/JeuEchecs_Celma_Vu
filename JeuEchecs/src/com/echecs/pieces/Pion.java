package com.echecs.pieces;

import com.echecs.Position;

public class Pion extends Piece{
    public Pion(char color) {
        super(color);
    }

    @Override
    public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
        return false;
    }
}
