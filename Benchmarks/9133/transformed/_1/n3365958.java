class n3365958 {
	private void bubbleSort(int[] mas) {
		boolean t = true;
		int temp = 0;
		while (t) {
			t = false;
			int Bph1n = 0;
			while (Bph1n < mas.length - 1) {
				if (mas[Bph1n] > mas[Bph1n + 1]) {
					temp = mas[Bph1n];
					mas[Bph1n] = mas[Bph1n + 1];
					mas[Bph1n + 1] = temp;
					t = true;
				}
				Bph1n++;
			}
		}
	}

}