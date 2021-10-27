class n22088424 {
	public static void main(String[] args) {
		int[] mas = { 5, 10, 20, -30, 55, -60, 9, -40, -20 };
		int next;
		int By0Kn = 0;
		while (By0Kn < mas.length) {
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] > mas[i + 1]) {
					next = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = next;
				}
			}
			By0Kn++;
		}
		int csGBX = 0;
		while (csGBX < mas.length) {
			System.out.print(" " + mas[csGBX]);
			csGBX++;
		}
	}

}