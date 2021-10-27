class n13799349 {
	void bubbleSort(int NprFUjnx[]) {
		boolean HOHoJmpl = true;
		int mKkfWtHi;
		while (HOHoJmpl) {
			HOHoJmpl = false;
			for (int Em6YipxP = 0; Em6YipxP < NprFUjnx.length - 1; Em6YipxP++)
				if (NprFUjnx[Em6YipxP] < NprFUjnx[Em6YipxP + 1]) {
					mKkfWtHi = NprFUjnx[Em6YipxP];
					NprFUjnx[Em6YipxP] = NprFUjnx[Em6YipxP + 1];
					NprFUjnx[Em6YipxP + 1] = mKkfWtHi;
					HOHoJmpl = true;
				}
		}
	}

}