package com.echecs.pieces;

import com.echecs.PartieEchecs;
import com.echecs.Position;

import static com.echecs.util.EchecsUtil.indiceColonne;
import static com.echecs.util.EchecsUtil.indiceLigne;

public class Pion extends Piece{
	private boolean deplaceDeux = true;
	public Pion(char color) {
		super(color);
	}

	@Override
	public boolean peutSeDeplacer(Position pos1, Position pos2, Piece[][] echiquier) {
		
		if(echiquier[pos1.getLigne()-1][indiceColonne(pos1)].getCouleur() == 'b' && echiquier[pos1.getLigne()-1][indiceColonne(pos1)] != null) {
			if(pos1.estSurLaMemeColonneQue(pos2)){
				if(pos1.getLigne() - pos2.getLigne() == 1) {
					if(echiquier[pos1.getLigne()-1-1][indiceColonne(pos1)] == null) {
						deplaceDeux = false;
						System.out.println("P1");
						return true;
					}
				}
				if(pos1.getLigne() - pos2.getLigne() == 2 && deplaceDeux) {
					if(echiquier[pos1.getLigne()-1-1][indiceColonne(pos1)] == null && echiquier[pos1.getLigne()-2-1][indiceColonne(pos1)] == null) {
						deplaceDeux = false;
						System.out.println("P2");
						return true;
					}
				}
			}

			if(pos2.getLigne() == 0)
				echiquier[indiceLigne(pos2)][indiceColonne(pos2)] = new Dame(couleur);
		}
		if(echiquier[pos1.getLigne()-1][indiceColonne(pos1)].getCouleur() == 'n' && echiquier[pos1.getLigne()-1][indiceColonne(pos1)] != null) {
			if(pos1.estSurLaMemeColonneQue(pos2)){
				if(pos2.getLigne() - pos1.getLigne() == 1) {
					if(echiquier[pos1.getLigne()][indiceColonne(pos1)] == null) {
						deplaceDeux = false;
						System.out.println("P3");
						return true;
					}
				}
				if(pos2.getLigne() - pos1.getLigne() == 2 && deplaceDeux) {
					if(echiquier[pos1.getLigne()][indiceColonne(pos1)] == null && echiquier[pos1.getLigne()+1][indiceColonne(pos1)] == null) {
						deplaceDeux = false;
						System.out.println("P4");
						return true;
					}
				}
			}

			if(pos2.getLigne() == 7)
				echiquier[indiceLigne(pos2)][indiceColonne(pos2)] = new Dame(couleur);
		}

		if(echiquier[pos2.getLigne()-1][indiceColonne(pos2)] != null) {
			if (pos1.estSurLaMemeDiagonaleQue(pos2) && pos1.estVoisineDe(pos2) && echiquier[pos1.getLigne()-1][indiceColonne(pos1)].getCouleur() != echiquier[pos2.getLigne()-1][indiceColonne(pos2)].getCouleur())
				System.out.println("DIAGONALE" + pos1.getLigne() + " " + pos1.getColonne()+ ":"+pos2.getLigne() + " " + pos2.getColonne());
				return true;
		}


		return false;
	}
}
