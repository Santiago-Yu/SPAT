class n200484 {
	void bubbleSort(int[] fRrDjO6y) {
		int C9usWuWc = 0;
		int dZLfq8lz = fRrDjO6y.length - 1;
		int LxkwIVf3 = 0;
		int igSt91pl = 0;
		while (igSt91pl == 0) {
			igSt91pl = 1;
			C9usWuWc = 0;
			while (C9usWuWc < dZLfq8lz) {
				if (fRrDjO6y[C9usWuWc] > fRrDjO6y[C9usWuWc + 1]) {
					LxkwIVf3 = fRrDjO6y[C9usWuWc];
					fRrDjO6y[C9usWuWc] = fRrDjO6y[C9usWuWc + 1];
					fRrDjO6y[C9usWuWc + 1] = LxkwIVf3;
					igSt91pl = 0;
				}
				C9usWuWc = C9usWuWc + 1;
			}
			dZLfq8lz = dZLfq8lz - 1;
		}
	}

}