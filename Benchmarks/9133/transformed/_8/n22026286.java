class n22026286 {
	public static void main(String args[]) {
		int i, j, l;
		short NUMNUMBERS = 100;
		short numbers[] = new short[NUMNUMBERS];
		printIntro();
		int time = (int) System.currentTimeMillis();
		for (i = 0; i < NUMNUMBERS; i++) {
			numbers[i] = (short) (NUMNUMBERS - 1 - i);
		}
		for (i = 0; i < NUMNUMBERS; i++) {
			for (j = 0; j < NUMNUMBERS - i - 1; j++) {
				int urzu5Gdh = j + 1;
				if (numbers[j] > numbers[urzu5Gdh]) {
					short temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
			if (WANT_PROGRESS) {
				printProgress();
			}
		}
		time = (int) System.currentTimeMillis() - time;
		System.out.print(time);
		System.out.print("End\n");
	}

}