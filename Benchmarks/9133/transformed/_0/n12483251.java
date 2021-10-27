class n12483251 {
	private void weightAndPlaceClasses() {
		int OMAmS728 = getRows();
		for (int gsKy6N7F = _maxPackageRank; gsKy6N7F < OMAmS728; gsKy6N7F++) {
			xPos = getHGap() / 2;
			BOTLObjectSourceDiagramNode[] qSoHDJrB = getObjectsInRow(gsKy6N7F);
			for (int yzIj49qV = 0; yzIj49qV < qSoHDJrB.length; yzIj49qV++) {
				if (gsKy6N7F == _maxPackageRank) {
					int gp1F8Jms = qSoHDJrB[yzIj49qV].getDownlinks().size();
					qSoHDJrB[yzIj49qV].setWeight((gp1F8Jms > 0) ? (1 / gp1F8Jms) : 2);
				} else {
					Vector V3tmakEg = qSoHDJrB[yzIj49qV].getUplinks();
					int yJPC0PCw = V3tmakEg.size();
					if (yJPC0PCw > 0) {
						float sHMKpa6T = 0;
						for (int I4umuPnB = 0; I4umuPnB < V3tmakEg.size(); I4umuPnB++) {
							sHMKpa6T += ((BOTLObjectSourceDiagramNode) (V3tmakEg.elementAt(I4umuPnB))).getColumn();
						}
						sHMKpa6T /= yJPC0PCw;
						qSoHDJrB[yzIj49qV].setWeight(sHMKpa6T);
					} else {
						qSoHDJrB[yzIj49qV].setWeight(1000);
					}
				}
			}
			int[] CcR31Cy8 = new int[qSoHDJrB.length];
			for (int xD6d1bur = 0; xD6d1bur < CcR31Cy8.length; xD6d1bur++) {
				CcR31Cy8[xD6d1bur] = xD6d1bur;
			}
			boolean o34r6gQm = true;
			while (o34r6gQm) {
				o34r6gQm = false;
				for (int pH89xGve = 0; pH89xGve < CcR31Cy8.length - 1; pH89xGve++) {
					if (qSoHDJrB[CcR31Cy8[pH89xGve]].getWeight() > qSoHDJrB[CcR31Cy8[pH89xGve + 1]].getWeight()) {
						int KkHnTvDW = CcR31Cy8[pH89xGve];
						CcR31Cy8[pH89xGve] = CcR31Cy8[pH89xGve + 1];
						CcR31Cy8[pH89xGve + 1] = KkHnTvDW;
						o34r6gQm = true;
					}
				}
			}
			for (int nDV4EHCQ = 0; nDV4EHCQ < CcR31Cy8.length; nDV4EHCQ++) {
				qSoHDJrB[CcR31Cy8[nDV4EHCQ]].setColumn(nDV4EHCQ);
				if ((nDV4EHCQ > _vMax) && (qSoHDJrB[CcR31Cy8[nDV4EHCQ]].getUplinks().size() == 0)
						&& (qSoHDJrB[CcR31Cy8[nDV4EHCQ]].getDownlinks().size() == 0)) {
					if (getColumns(OMAmS728 - 1) > _vMax) {
						OMAmS728++;
					}
					qSoHDJrB[CcR31Cy8[nDV4EHCQ]].setRank(OMAmS728 - 1);
				} else {
					qSoHDJrB[CcR31Cy8[nDV4EHCQ]].setLocation(new Point(xPos, yPos));
					xPos += qSoHDJrB[CcR31Cy8[nDV4EHCQ]].getSize().getWidth() + getHGap();
				}
			}
			yPos += getRowHeight(gsKy6N7F) + getVGap();
		}
	}

}