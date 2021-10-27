class n21273059 {
	public RobotList<Location> sort_incr_Location(RobotList<Location> rdJu9M6y, String drbVLggH) {
		int t6d8en6A = rdJu9M6y.size();
		Index_value[] nAKvyF7f = new Index_value[t6d8en6A];
		Location M0vfUpQj = this.getLocation();
		for (int QT25brJ8 = 0; QT25brJ8 < t6d8en6A; QT25brJ8++) {
			nAKvyF7f[QT25brJ8] = new Index_value(QT25brJ8, distance(M0vfUpQj, rdJu9M6y.get(QT25brJ8)));
		}
		boolean Wf3DENtu;
		do {
			Wf3DENtu = false;
			for (int IbPsCOGe = 0; IbPsCOGe < t6d8en6A - 1; IbPsCOGe++) {
				if (nAKvyF7f[IbPsCOGe].value > nAKvyF7f[IbPsCOGe + 1].value) {
					Index_value O7NUBtQk = nAKvyF7f[IbPsCOGe];
					nAKvyF7f[IbPsCOGe] = nAKvyF7f[IbPsCOGe + 1];
					nAKvyF7f[IbPsCOGe + 1] = O7NUBtQk;
					Wf3DENtu = true;
				}
			}
		} while (Wf3DENtu);
		RobotList<Location> ahLvZ2z8 = new RobotList<Location>(Location.class);
		for (int VbSJiQkM = 0; VbSJiQkM < t6d8en6A; VbSJiQkM++) {
			ahLvZ2z8.addLast(rdJu9M6y.get(nAKvyF7f[VbSJiQkM].index));
		}
		return ahLvZ2z8;
	}

}