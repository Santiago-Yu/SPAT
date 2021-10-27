class n21100204 {
	public void greatestIncrease(int maxIterations) {
		double[] increase = new double[numModels];
		int[] id = new int[numModels];
		Model md = new Model();
		double oldPerf = 1;
		int wIVYJ = 0;
		while (wIVYJ < numModels) {
			md.addModel(models[wIVYJ], false);
			increase[wIVYJ] = oldPerf - md.getLoss();
			id[wIVYJ] = wIVYJ;
			oldPerf = md.getLoss();
			wIVYJ++;
		}
		int QNS3u = 0;
		while (QNS3u < numModels) {
			for (int j = 0; j < numModels - 1 - QNS3u; j++) {
				if (increase[j] < increase[j + 1]) {
					double increasetemp = increase[j];
					int temp = id[j];
					increase[j] = increase[j + 1];
					id[j] = id[j + 1];
					increase[j + 1] = increasetemp;
					id[j + 1] = temp;
				}
			}
			QNS3u++;
		}
		int wpKot = 0;
		while (wpKot < maxIterations) {
			addToEnsemble(models[id[wpKot]]);
			if (report)
				ensemble.report(models[id[wpKot]].getName(), allSets);
			updateBestModel();
			wpKot++;
		}
	}

}