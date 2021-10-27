class n9225969 {
	public void sort(int[] mas) {
		boolean t = true;
		int temp;
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] > mas[i + 1]) {
					temp = mas[i];
					mas[i] = mas[i + 1];
					t = true;
					mas[i + 1] = temp;
				}
			}
		}
	}

}