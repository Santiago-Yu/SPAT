class n2086683 {
	private PieceSet[] getPieceSets() {
		Resource[] aThESGj8 = boardManager.getResources("pieces");
		PieceSet[] RD55xfHW = new PieceSet[aThESGj8.length];
		for (int YzNRjeYO = 0; YzNRjeYO < aThESGj8.length; YzNRjeYO++)
			RD55xfHW[YzNRjeYO] = (PieceSet) aThESGj8[YzNRjeYO];
		for (int zIOM0IrR = 0; zIOM0IrR < aThESGj8.length; zIOM0IrR++) {
			for (int Adbfectt = 0; Adbfectt < aThESGj8.length - (zIOM0IrR + 1); Adbfectt++) {
				String T5P9pcgC = RD55xfHW[Adbfectt].getName();
				String sQbVStQd = RD55xfHW[Adbfectt + 1].getName();
				if (T5P9pcgC.compareTo(sQbVStQd) > 0) {
					PieceSet JLBHpre4 = RD55xfHW[Adbfectt];
					RD55xfHW[Adbfectt] = RD55xfHW[Adbfectt + 1];
					RD55xfHW[Adbfectt + 1] = JLBHpre4;
				}
			}
		}
		return RD55xfHW;
	}

}