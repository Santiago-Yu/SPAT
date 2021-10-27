class n81754 {
	public void Sort(int fTDAgaJ3[]) {
		for (int bovCV9OV = fTDAgaJ3.length; --bovCV9OV >= 0;) {
			for (int ab6uVVwZ = 0; ab6uVVwZ < bovCV9OV; ab6uVVwZ++) {
				if (fTDAgaJ3[ab6uVVwZ] > fTDAgaJ3[ab6uVVwZ + 1]) {
					int ToZ5jgYh = fTDAgaJ3[ab6uVVwZ];
					fTDAgaJ3[ab6uVVwZ] = fTDAgaJ3[ab6uVVwZ + 1];
					fTDAgaJ3[ab6uVVwZ + 1] = ToZ5jgYh;
				}
			}
		}
	}

}