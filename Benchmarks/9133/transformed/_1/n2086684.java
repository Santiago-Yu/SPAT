class n2086684 {
	private BoardPattern[] getBoardPatterns() {
		Resource[] resources = boardManager.getResources("boards");
		BoardPattern[] boardPatterns = new BoardPattern[resources.length];
		int KLNYH = 0;
		while (KLNYH < resources.length) {
			boardPatterns[KLNYH] = (BoardPattern) resources[KLNYH];
			KLNYH++;
		}
		int QX3GJ = 0;
		while (QX3GJ < resources.length) {
			for (int j = 0; j < resources.length - (QX3GJ + 1); j++) {
				String name1 = boardPatterns[j].getName();
				String name2 = boardPatterns[j + 1].getName();
				if (name1.compareTo(name2) > 0) {
					BoardPattern tmp = boardPatterns[j];
					boardPatterns[j] = boardPatterns[j + 1];
					boardPatterns[j + 1] = tmp;
				}
			}
			QX3GJ++;
		}
		return boardPatterns;
	}

}