class n21779336 {
	private void weightAndPlaceClasses() {
		int XpiTR2Pg = getRows();
		for (int JssCkOHO = _maxPackageRank; JssCkOHO < XpiTR2Pg; JssCkOHO++) {
			xPos = getHGap() / 2;
			ClassdiagramNode[] rsJp9qYl = getObjectsInRow(JssCkOHO);
			for (int LUZDnaet = 0; LUZDnaet < rsJp9qYl.length; LUZDnaet++) {
				if (JssCkOHO == _maxPackageRank) {
					int AZi2DGSc = rsJp9qYl[LUZDnaet].getDownlinks().size();
					rsJp9qYl[LUZDnaet].setWeight((AZi2DGSc > 0) ? (1 / AZi2DGSc) : 2);
				} else {
					Vector Q3HGyrFV = rsJp9qYl[LUZDnaet].getUplinks();
					int M8onuYsZ = Q3HGyrFV.size();
					if (M8onuYsZ > 0) {
						float Xw4FLYek = 0;
						for (int Xzdpm2R4 = 0; Xzdpm2R4 < Q3HGyrFV.size(); Xzdpm2R4++) {
							Xw4FLYek += ((ClassdiagramNode) (Q3HGyrFV.elementAt(Xzdpm2R4))).getColumn();
						}
						Xw4FLYek /= M8onuYsZ;
						rsJp9qYl[LUZDnaet].setWeight(Xw4FLYek);
					} else {
						rsJp9qYl[LUZDnaet].setWeight(1000);
					}
				}
			}
			int[] kLriKoY3 = new int[rsJp9qYl.length];
			for (int fz24J2EK = 0; fz24J2EK < kLriKoY3.length; fz24J2EK++) {
				kLriKoY3[fz24J2EK] = fz24J2EK;
			}
			boolean BwCDCkwH = true;
			while (BwCDCkwH) {
				BwCDCkwH = false;
				for (int hXw9Y86U = 0; hXw9Y86U < kLriKoY3.length - 1; hXw9Y86U++) {
					if (rsJp9qYl[kLriKoY3[hXw9Y86U]].getWeight() > rsJp9qYl[kLriKoY3[hXw9Y86U + 1]].getWeight()) {
						int MR3MqBQb = kLriKoY3[hXw9Y86U];
						kLriKoY3[hXw9Y86U] = kLriKoY3[hXw9Y86U + 1];
						kLriKoY3[hXw9Y86U + 1] = MR3MqBQb;
						BwCDCkwH = true;
					}
				}
			}
			for (int WsKurhxU = 0; WsKurhxU < kLriKoY3.length; WsKurhxU++) {
				rsJp9qYl[kLriKoY3[WsKurhxU]].setColumn(WsKurhxU);
				if ((WsKurhxU > _vMax) && (rsJp9qYl[kLriKoY3[WsKurhxU]].getUplinks().size() == 0)
						&& (rsJp9qYl[kLriKoY3[WsKurhxU]].getDownlinks().size() == 0)) {
					if (getColumns(XpiTR2Pg - 1) > _vMax) {
						XpiTR2Pg++;
					}
					rsJp9qYl[kLriKoY3[WsKurhxU]].setRank(XpiTR2Pg - 1);
				} else {
					rsJp9qYl[kLriKoY3[WsKurhxU]].setLocation(new Point(xPos, yPos));
					xPos += rsJp9qYl[kLriKoY3[WsKurhxU]].getSize().getWidth() + getHGap();
				}
			}
			yPos += getRowHeight(JssCkOHO) + getVGap();
		}
	}

}