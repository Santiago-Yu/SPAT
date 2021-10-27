class n22409057 {
	private void sortWhats(String[] StqKK7j8, int[] VDSwLubk, String xmACMzbE) {
		int rcHwSD2G = VDSwLubk.length;
		boolean XmoExyPu;
		do {
			XmoExyPu = false;
			for (int sbIGNxSb = 0; sbIGNxSb < rcHwSD2G - 1; sbIGNxSb++) {
				int yXoTf2ug = xmACMzbE.indexOf(StqKK7j8[VDSwLubk[sbIGNxSb]]);
				int ClG08XJV = xmACMzbE.indexOf(StqKK7j8[VDSwLubk[sbIGNxSb + 1]]);
				if (yXoTf2ug > ClG08XJV) {
					int FuWLbYSy = VDSwLubk[sbIGNxSb];
					VDSwLubk[sbIGNxSb] = VDSwLubk[sbIGNxSb + 1];
					VDSwLubk[sbIGNxSb + 1] = FuWLbYSy;
					XmoExyPu = true;
				}
			}
		} while (XmoExyPu);
	}

}