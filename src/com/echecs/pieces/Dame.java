package com.echecs.pieces;

import static com.echecs.util.EchecsUtil.indiceColonne;

import com.echecs.Position;

public class Dame extends Piece{
    public Dame(char color){
        super(color);
    }
    @Override
    public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
    	if (pos1.estSurLaMemeLigneQue(pos2) && echiquier[pos1.getLigne()-1][indiceColonne(pos1)].getCouleur() != echiquier[pos2.getLigne()-1][indiceColonne(pos2)].getCouleur()) {
	        if (pos1.getColonne() - pos2.getColonne() > 0) {// vers la gauche
	            int cptr = pos1.getColonne() - pos2.getColonne();
	            for (int i = 1; i < cptr; i++) {
	                if (echiquier[pos1.getLigne()-1][indiceColonne((char) (pos1.getColonne() - i))] != null) {
	                  
	                    return false;
	                }
	            }
	            System.out.println("1");
	            return true;
	        }
	        if (pos1.getColonne() - pos2.getColonne() < 0) {// vers la droite
	            int cptr = pos2.getColonne() - pos1.getColonne();
	            for (int i = 1; i < cptr; i++) {
	                if (echiquier[pos1.getLigne()-1][indiceColonne((char) (pos1.getColonne() + i))] != null) {

	                    return false;
	                }
	            }
	            System.out.println("2");
	            return true;
	        }
	    }

	    if (pos1.estSurLaMemeColonneQue(pos2)) {
	        if (pos1.getLigne() - pos2.getLigne() > 0) {// vers le haut
	            int cptr = pos1.getLigne() - pos2.getLigne();
	            for (int i = 1; i < cptr; i++) {
	                if (echiquier[pos1.getLigne() - i-1][indiceColonne(pos1)] != null) {

	                    return false;
	                }
	            }
	            System.out.println("3");
	            return true;
	        }
	        if (pos1.getLigne() - pos2.getLigne() < 0) {// vers le bas
	            int cptr = pos2.getLigne() - pos1.getLigne();
	            for (int i = 1; i < cptr; i++) {
	                if (echiquier[pos1.getLigne() + i-1][indiceColonne(pos1)] != null) {

	                    return false;
	                }
	            }
	            System.out.println("4");
	            return true;
	        }
	    }
	    
	    if (pos1.estSurLaMemeDiagonaleQue(pos2)) {
	        int diffLig = Math.abs(pos1.getLigne() - pos2.getLigne());
	        int diffCol = Math.abs(pos1.getColonne() - pos2.getColonne());

	        int ligDir = Integer.compare(pos2.getLigne(), pos1.getLigne());
	        int colDir = Integer.compare(pos2.getColonne(), pos1.getColonne());

	        for (int i = 1; i < diffLig || i < diffCol; i++) {
	        	
	            int ligInter = (pos1.getLigne()-1) + (i * ligDir);
	            int colInter = indiceColonne(pos1.getColonne()) + (i * colDir);
	            
	            System.out.println(ligInter + " " + colInter + " DIR" + ligInter + " "+ colInter);
	            if (ligInter < 0 || ligInter >= 8 || colInter < 0 || colInter >= 8) {
	                return false;
	            }

	            if (echiquier[ligInter][colInter] != null) {
	              
	                return false;
	            }
	        }
	        System.out.println("5");
	        return true;
	    }

        return false;
    }
}
