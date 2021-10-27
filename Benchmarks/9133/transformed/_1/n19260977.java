class n19260977 {
	public int[] sort() {
		boolean t = true;
		int temp = 0;
		int[] mas = new int[N];
		Random rand = new Random();
		int JQJMj = 0;
		while (JQJMj < N) {
			mas[JQJMj] = rand.nextInt(10) + 1;
			JQJMj++;
		}
		while (t) {
			t = false;
			int jxWNJ = 0;
			while (jxWNJ < mas.length - 1) {
				if (mas[jxWNJ] > mas[jxWNJ + 1]) {
					temp = mas[jxWNJ];
					mas[jxWNJ] = mas[jxWNJ + 1];
					mas[jxWNJ + 1] = temp;
					t = true;
				}
				jxWNJ++;
			}
		}
		return mas;
	}

}