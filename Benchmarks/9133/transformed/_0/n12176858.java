class n12176858 {
	void sortclasses() {
		int uMZDR2Dx, U2wENf6u;
		boolean HXEH3PaT;
		vclassptr = new int[numc];
		for (uMZDR2Dx = 0; uMZDR2Dx < numc; uMZDR2Dx++)
			vclassptr[uMZDR2Dx] = uMZDR2Dx;
		HXEH3PaT = true;
		while (HXEH3PaT == true) {
			HXEH3PaT = false;
			for (uMZDR2Dx = 0; uMZDR2Dx < numc - 1; uMZDR2Dx++) {
				if (vclassctr[vclassptr[uMZDR2Dx]] < vclassctr[vclassptr[uMZDR2Dx + 1]]) {
					int LjvJOcY6 = vclassptr[uMZDR2Dx];
					vclassptr[uMZDR2Dx] = vclassptr[uMZDR2Dx + 1];
					vclassptr[uMZDR2Dx + 1] = LjvJOcY6;
					HXEH3PaT = true;
				}
			}
		}
	}

}