class n21273051 {
	public RobotList<Float> sort_incr_Float(RobotList<Float> BFwhn7db, String E6d7VmR0) {
		int pZvtBn1Z = BFwhn7db.size();
		Index_value[] whwSV89V = new Index_value[pZvtBn1Z];
		for (int BsCA148l = 0; BsCA148l < pZvtBn1Z; BsCA148l++) {
			whwSV89V[BsCA148l] = new Index_value(BsCA148l, BFwhn7db.get(BsCA148l));
		}
		boolean yuxrq3py;
		do {
			yuxrq3py = false;
			for (int ZKpJ64TP = 0; ZKpJ64TP < pZvtBn1Z - 1; ZKpJ64TP++) {
				if (whwSV89V[ZKpJ64TP].value > whwSV89V[ZKpJ64TP + 1].value) {
					Index_value bWMSSYBA = whwSV89V[ZKpJ64TP];
					whwSV89V[ZKpJ64TP] = whwSV89V[ZKpJ64TP + 1];
					whwSV89V[ZKpJ64TP + 1] = bWMSSYBA;
					yuxrq3py = true;
				}
			}
		} while (yuxrq3py);
		RobotList<Float> Q6uvYGwo = new RobotList<Float>(Float.class);
		for (int jyt7mz2C = 0; jyt7mz2C < pZvtBn1Z; jyt7mz2C++) {
			Q6uvYGwo.addLast(new Float(whwSV89V[jyt7mz2C].value));
		}
		return Q6uvYGwo;
	}

}