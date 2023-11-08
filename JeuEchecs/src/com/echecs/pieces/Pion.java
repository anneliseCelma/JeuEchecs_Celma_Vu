package com.echecs.pieces;

import com.echecs.Position;

public class Pion extends Piece{
    public Pion(char color) {
        super(color);
    }

    @Override
    public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
        int posVert = Math.abs(pos1.getLigne() - pos2.getLigne());
        int posHori = Math.abs(pos1.getColonne() - pos2.getColonne());

        if(posVert == 1 && posHori == 0)
            return true;
        return false;
    }
}
