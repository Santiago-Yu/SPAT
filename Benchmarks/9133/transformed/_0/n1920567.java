class n1920567 {
	public static void sortSeries(double[] txy1NLZj) {
		if (txy1NLZj == null) {
			throw new IllegalArgumentException("Incorrect series. It's null-pointed");
		}
		int sfgtvcdR = 0;
		int Ud45boqU = txy1NLZj.length - 1;
		while (Ud45boqU > 0) {
			sfgtvcdR = 0;
			for (int jyBy5enV = 0; jyBy5enV <= Ud45boqU - 1; jyBy5enV++) {
				if (txy1NLZj[jyBy5enV] > txy1NLZj[jyBy5enV + 1]) {
					sfgtvcdR = jyBy5enV;
					double IDGKVQhN = txy1NLZj[jyBy5enV];
					txy1NLZj[jyBy5enV] = txy1NLZj[jyBy5enV + 1];
					txy1NLZj[jyBy5enV + 1] = IDGKVQhN;
				}
			}
			Ud45boqU = sfgtvcdR;
		}
	}

}