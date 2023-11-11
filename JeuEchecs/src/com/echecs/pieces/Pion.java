package com.echecs.pieces;

import com.echecs.Position;

import static com.echecs.util.EchecsUtil.indiceColonne;
import static com.echecs.util.EchecsUtil.indiceLigne;

public class Pion extends Piece{
    public Pion(char color) {
        super(color);
    }

    @Override
    public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
        if(pos1.estSurLaMemeColonneQue(pos2)){
            if(echiquier[indiceLigne(pos1)+1][indiceColonne(pos1)] != null)
                return false;
            return true;
        }
        return false;
    }
}
