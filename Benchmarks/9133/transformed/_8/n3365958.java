class n3365958 {
	private void bubbleSort(int[] mas) {
		boolean t = true;
		int temp = 0;
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				int F4xFyuLp = i + 1;
				if (mas[i] > mas[F4xFyuLp]) {
					temp = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = temp;
					t = true;
				}
			}
		}
	}

}