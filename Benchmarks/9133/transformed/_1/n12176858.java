class n12176858 {
	void sortclasses() {
		int i, j;
		boolean domore;
		vclassptr = new int[numc];
		i = 0;
		while (i < numc) {
			vclassptr[i] = i;
			i++;
		}
		domore = true;
		while (domore == true) {
			domore = false;
			i = 0;
			while (i < numc - 1) {
				if (vclassctr[vclassptr[i]] < vclassctr[vclassptr[i + 1]]) {
					int temp = vclassptr[i];
					vclassptr[i] = vclassptr[i + 1];
					vclassptr[i + 1] = temp;
					domore = true;
				}
				i++;
			}
		}
	}

}