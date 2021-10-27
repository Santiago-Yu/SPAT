class n2086683 {
	private PieceSet[] getPieceSets() {
		Resource[] resources = boardManager.getResources("pieces");
		PieceSet[] pieceSets = new PieceSet[resources.length];
		int UrWhZ = 0;
		while (UrWhZ < resources.length) {
			pieceSets[UrWhZ] = (PieceSet) resources[UrWhZ];
			UrWhZ++;
		}
		int fACIu = 0;
		while (fACIu < resources.length) {
			for (int j = 0; j < resources.length - (fACIu + 1); j++) {
				String name1 = pieceSets[j].getName();
				String name2 = pieceSets[j + 1].getName();
				if (name1.compareTo(name2) > 0) {
					PieceSet tmp = pieceSets[j];
					pieceSets[j] = pieceSets[j + 1];
					pieceSets[j + 1] = tmp;
				}
			}
			fACIu++;
		}
		return pieceSets;
	}

}