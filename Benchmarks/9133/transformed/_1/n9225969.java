class n9225969 {
	public void sort(int[] mas) {
		int temp;
		boolean t = true;
		while (t) {
			t = false;
			int nYqke = 0;
			while (nYqke < mas.length - 1) {
				if (mas[nYqke] > mas[nYqke + 1]) {
					temp = mas[nYqke];
					mas[nYqke] = mas[nYqke + 1];
					mas[nYqke + 1] = temp;
					t = true;
				}
				nYqke++;
			}
		}
	}

}