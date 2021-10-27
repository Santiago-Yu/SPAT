class n12561704 {
	private void bubbleSort(int[] mas) {
		boolean t = true;
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				if (!(mas[i] > mas[i + 1]))
					;
				else {
					int temp = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = temp;
					t = true;
				}
			}
		}
	}

}