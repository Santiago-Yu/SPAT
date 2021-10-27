class n22026286 {
	public static void main(String args[]) {
		short NUMNUMBERS = 100;
		int i, j, l;
		short numbers[] = new short[NUMNUMBERS];
		printIntro();
		for (i = 0; i < NUMNUMBERS; i++) {
			numbers[i] = (short) (NUMNUMBERS - 1 - i);
		}
		int time = (int) System.currentTimeMillis();
		time = (int) System.currentTimeMillis() - time;
		for (i = 0; i < NUMNUMBERS; i++) {
			for (j = 0; j < NUMNUMBERS - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					short temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
			if (WANT_PROGRESS) {
				printProgress();
			}
		}
		System.out.print(time);
		System.out.print("End\n");
	}

}