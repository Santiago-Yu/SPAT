class n12646326 {
	private void weightAndPlaceClasses() {
		int C6I67m66 = getRows();
		for (int tiaL7BV9 = _maxPackageRank; tiaL7BV9 < C6I67m66; tiaL7BV9++) {
			xPos = getHGap() / 2;
			BOTLRuleDiagramNode[] sa6PHO9g = getObjectsInRow(tiaL7BV9);
			for (int lhy8x2bU = 0; lhy8x2bU < sa6PHO9g.length; lhy8x2bU++) {
				if (tiaL7BV9 == _maxPackageRank) {
					int ZByBoqvJ = sa6PHO9g[lhy8x2bU].getDownlinks().size();
					sa6PHO9g[lhy8x2bU].setWeight((ZByBoqvJ > 0) ? (1 / ZByBoqvJ) : 2);
				} else {
					Vector nFJqDlkk = sa6PHO9g[lhy8x2bU].getUplinks();
					int W7FIOjNQ = nFJqDlkk.size();
					if (W7FIOjNQ > 0) {
						float RDKdOvt8 = 0;
						for (int UWZqioDS = 0; UWZqioDS < nFJqDlkk.size(); UWZqioDS++) {
							RDKdOvt8 += ((BOTLRuleDiagramNode) (nFJqDlkk.elementAt(UWZqioDS))).getColumn();
						}
						RDKdOvt8 /= W7FIOjNQ;
						sa6PHO9g[lhy8x2bU].setWeight(RDKdOvt8);
					} else {
						sa6PHO9g[lhy8x2bU].setWeight(1000);
					}
				}
			}
			int[] z8MU1fPZ = new int[sa6PHO9g.length];
			for (int Xt1BG92y = 0; Xt1BG92y < z8MU1fPZ.length; Xt1BG92y++) {
				z8MU1fPZ[Xt1BG92y] = Xt1BG92y;
			}
			boolean MSMUMtqz = true;
			while (MSMUMtqz) {
				MSMUMtqz = false;
				for (int LMNeoF99 = 0; LMNeoF99 < z8MU1fPZ.length - 1; LMNeoF99++) {
					if (sa6PHO9g[z8MU1fPZ[LMNeoF99]].getWeight() > sa6PHO9g[z8MU1fPZ[LMNeoF99 + 1]].getWeight()) {
						int oLfBvjUw = z8MU1fPZ[LMNeoF99];
						z8MU1fPZ[LMNeoF99] = z8MU1fPZ[LMNeoF99 + 1];
						z8MU1fPZ[LMNeoF99 + 1] = oLfBvjUw;
						MSMUMtqz = true;
					}
				}
			}
			for (int qz2k59rW = 0; qz2k59rW < z8MU1fPZ.length; qz2k59rW++) {
				sa6PHO9g[z8MU1fPZ[qz2k59rW]].setColumn(qz2k59rW);
				if ((qz2k59rW > _vMax) && (sa6PHO9g[z8MU1fPZ[qz2k59rW]].getUplinks().size() == 0)
						&& (sa6PHO9g[z8MU1fPZ[qz2k59rW]].getDownlinks().size() == 0)) {
					if (getColumns(C6I67m66 - 1) > _vMax) {
						C6I67m66++;
					}
					sa6PHO9g[z8MU1fPZ[qz2k59rW]].setRank(C6I67m66 - 1);
				} else {
					sa6PHO9g[z8MU1fPZ[qz2k59rW]].setLocation(new Point(xPos, yPos));
					xPos += sa6PHO9g[z8MU1fPZ[qz2k59rW]].getSize().getWidth() + getHGap();
				}
			}
			yPos += getRowHeight(tiaL7BV9) + getVGap();
		}
	}

}