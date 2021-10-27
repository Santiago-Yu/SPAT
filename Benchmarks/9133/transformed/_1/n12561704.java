class n12561704 {
	private void bubbleSort(int[] mas) {
		boolean t = true;
		while (t) {
			t = false;
			int taBE7 = 0;
			while (taBE7 < mas.length - 1) {
				if (mas[taBE7] > mas[taBE7 + 1]) {
					int temp = mas[taBE7];
					mas[taBE7] = mas[taBE7 + 1];
					mas[taBE7 + 1] = temp;
					t = true;
				}
				taBE7++;
			}
		}
	}

}