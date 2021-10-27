class n2086684 {
	private BoardPattern[] getBoardPatterns() {
		Resource[] SOvAX5zF = boardManager.getResources("boards");
		BoardPattern[] Cyh8qqgU = new BoardPattern[SOvAX5zF.length];
		for (int iOuCFbQD = 0; iOuCFbQD < SOvAX5zF.length; iOuCFbQD++)
			Cyh8qqgU[iOuCFbQD] = (BoardPattern) SOvAX5zF[iOuCFbQD];
		for (int mA3JbxqN = 0; mA3JbxqN < SOvAX5zF.length; mA3JbxqN++) {
			for (int SGPxI32g = 0; SGPxI32g < SOvAX5zF.length - (mA3JbxqN + 1); SGPxI32g++) {
				String Aji5bBat = Cyh8qqgU[SGPxI32g].getName();
				String A7ODTgTU = Cyh8qqgU[SGPxI32g + 1].getName();
				if (Aji5bBat.compareTo(A7ODTgTU) > 0) {
					BoardPattern jKbJs4xm = Cyh8qqgU[SGPxI32g];
					Cyh8qqgU[SGPxI32g] = Cyh8qqgU[SGPxI32g + 1];
					Cyh8qqgU[SGPxI32g + 1] = jKbJs4xm;
				}
			}
		}
		return Cyh8qqgU;
	}

}