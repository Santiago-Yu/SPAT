class n6963063 {
	public static void main(String args[]) {
		int[] mas = { 3, 5, 6, 9, 1, -3, -4, -88 };
		int sort = 0;
		int R34ml = 0;
		while (R34ml < (mas.length)) {
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] > mas[i + 1]) {
					sort = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = sort;
				}
			}
			R34ml++;
		}
		int ORozy = 0;
		while (ORozy < mas.length) {
			System.out.print(" " + mas[ORozy]);
			ORozy++;
		}
	}

}