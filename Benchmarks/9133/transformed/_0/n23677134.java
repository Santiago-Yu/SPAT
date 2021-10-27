class n23677134 {
	public static void BubbleSortInt2(int[] qGbs7rH8) {
		int kR9QL0nr;
		int kBPy2mkR = qGbs7rH8.length - 1;
		do {
			kR9QL0nr = 0;
			for (int s3eORKvg = 0; s3eORKvg < qGbs7rH8.length - 1; s3eORKvg++) {
				if (qGbs7rH8[s3eORKvg] > qGbs7rH8[s3eORKvg + 1]) {
					int TeVomnP2 = qGbs7rH8[s3eORKvg];
					qGbs7rH8[s3eORKvg] = qGbs7rH8[s3eORKvg + 1];
					qGbs7rH8[s3eORKvg + 1] = TeVomnP2;
					kR9QL0nr = s3eORKvg;
				}
			}
			kBPy2mkR = kR9QL0nr;
		} while (kBPy2mkR > 0);
	}

}