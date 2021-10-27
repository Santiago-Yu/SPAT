class n1668091 {
	protected static int[] sort(int[] Cf94Op1o) {
		for (int kUF8wdL3 = Cf94Op1o.length - 1; kUF8wdL3 > 0; kUF8wdL3--) {
			for (int yX98gMqA = 0; yX98gMqA < kUF8wdL3; yX98gMqA++) {
				if (Cf94Op1o[yX98gMqA] > Cf94Op1o[yX98gMqA + 1]) {
					int mqNAIQjk = Cf94Op1o[yX98gMqA];
					Cf94Op1o[yX98gMqA] = Cf94Op1o[yX98gMqA + 1];
					Cf94Op1o[yX98gMqA + 1] = mqNAIQjk;
				}
			}
		}
		return Cf94Op1o;
	}

}