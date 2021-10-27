class n6622146 {
	public Object[] bubblesort(Object[] s0Ca7aQa) {
		Boolean jU0YPgCY;
		int Xara84QJ = s0Ca7aQa.length - 1;
		do {
			jU0YPgCY = false;
			for (int US2WQYnT = 0; US2WQYnT < Xara84QJ; US2WQYnT++) {
				if (s0Ca7aQa[US2WQYnT].toString().compareTo(s0Ca7aQa[US2WQYnT + 1].toString()) < 0) {
				} else if (s0Ca7aQa[US2WQYnT].toString().compareTo(s0Ca7aQa[US2WQYnT + 1].toString()) == 0) {
					Object[] L2j1cBx0 = new Object[s0Ca7aQa.length - 1];
					for (int xqUEcSL4 = 0; xqUEcSL4 < US2WQYnT; xqUEcSL4++) {
						L2j1cBx0[xqUEcSL4] = s0Ca7aQa[xqUEcSL4];
					}
					for (int uTckm3rq = US2WQYnT; uTckm3rq < L2j1cBx0.length; uTckm3rq++) {
						L2j1cBx0[uTckm3rq] = s0Ca7aQa[uTckm3rq + 1];
					}
					s0Ca7aQa = L2j1cBx0;
					Xara84QJ = Xara84QJ - 1;
					US2WQYnT = US2WQYnT - 1;
				} else if (s0Ca7aQa[US2WQYnT].toString().compareTo(s0Ca7aQa[US2WQYnT + 1].toString()) > 0) {
					String y9UyMn7w = (String) s0Ca7aQa[US2WQYnT];
					s0Ca7aQa[US2WQYnT] = s0Ca7aQa[US2WQYnT + 1];
					s0Ca7aQa[US2WQYnT + 1] = y9UyMn7w;
					jU0YPgCY = true;
				}
			}
			Xara84QJ = Xara84QJ - 1;
		} while (jU0YPgCY);
		return s0Ca7aQa;
	}

}