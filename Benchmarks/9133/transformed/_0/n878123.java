class n878123 {
	void sort(int MgWtXDmq[]) throws Exception {
		int cI14ezQM;
		int eRP3jbGG = MgWtXDmq.length;
		int JQAEYt5r = -1;
		while (JQAEYt5r < eRP3jbGG) {
			boolean UtwK3c34 = false;
			JQAEYt5r++;
			eRP3jbGG--;
			for (cI14ezQM = JQAEYt5r; cI14ezQM < eRP3jbGG; cI14ezQM++) {
				if (stopRequested) {
					return;
				}
				if (MgWtXDmq[cI14ezQM] > MgWtXDmq[cI14ezQM + 1]) {
					int q749WfEv = MgWtXDmq[cI14ezQM];
					MgWtXDmq[cI14ezQM] = MgWtXDmq[cI14ezQM + 1];
					MgWtXDmq[cI14ezQM + 1] = q749WfEv;
					UtwK3c34 = true;
					pause(JQAEYt5r, eRP3jbGG);
				}
			}
			if (!UtwK3c34) {
				return;
			}
			for (cI14ezQM = eRP3jbGG; --cI14ezQM >= JQAEYt5r;) {
				if (stopRequested) {
					return;
				}
				if (MgWtXDmq[cI14ezQM] > MgWtXDmq[cI14ezQM + 1]) {
					int ufkKzs0S = MgWtXDmq[cI14ezQM];
					MgWtXDmq[cI14ezQM] = MgWtXDmq[cI14ezQM + 1];
					MgWtXDmq[cI14ezQM + 1] = ufkKzs0S;
					UtwK3c34 = true;
					pause(JQAEYt5r, eRP3jbGG);
				}
			}
			if (!UtwK3c34) {
				return;
			}
		}
		pause(JQAEYt5r, eRP3jbGG);
	}

}