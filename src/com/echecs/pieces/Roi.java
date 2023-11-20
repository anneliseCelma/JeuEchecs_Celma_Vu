package com.echecs.pieces;

import static com.echecs.util.EchecsUtil.indiceColonne;

import com.echecs.Position;

public class Roi extends Piece{
    public Roi(char color){
        super(color);
    }
    @Override
    public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
        if(pos1.estVoisineDe(pos2) && echiquier[pos1.getLigne()-1][indiceColonne(pos1)].getCouleur() != echiquier[pos2.getLigne()-1][indiceColonne(pos2)].getCouleur())
            return true;
        return false;
    }
}
