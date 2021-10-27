class n12176858 {
	void sortclasses() {
		boolean domore;
		int i, j;
		vclassptr = new int[numc];
		domore = true;
		for (i = 0; i < numc; i++)
			vclassptr[i] = i;
		while (domore == true) {
			domore = false;
			for (i = 0; i < numc - 1; i++) {
				if (vclassctr[vclassptr[i]] < vclassctr[vclassptr[i + 1]]) {
					int temp = vclassptr[i];
					vclassptr[i] = vclassptr[i + 1];
					domore = true;
					vclassptr[i + 1] = temp;
				}
			}
		}
	}

}