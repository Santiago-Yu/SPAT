class n21100204 {
	public void greatestIncrease(int Uz7sTR26) {
		double[] DwoWrefL = new double[numModels];
		int[] nnFt0lWO = new int[numModels];
		Model NtUJfCYU = new Model();
		double ZKhM9qKv = 1;
		for (int Jhpp1ghb = 0; Jhpp1ghb < numModels; Jhpp1ghb++) {
			NtUJfCYU.addModel(models[Jhpp1ghb], false);
			DwoWrefL[Jhpp1ghb] = ZKhM9qKv - NtUJfCYU.getLoss();
			nnFt0lWO[Jhpp1ghb] = Jhpp1ghb;
			ZKhM9qKv = NtUJfCYU.getLoss();
		}
		for (int BUDTIXDr = 0; BUDTIXDr < numModels; BUDTIXDr++) {
			for (int HvAvbZuP = 0; HvAvbZuP < numModels - 1 - BUDTIXDr; HvAvbZuP++) {
				if (DwoWrefL[HvAvbZuP] < DwoWrefL[HvAvbZuP + 1]) {
					double esEEXVs3 = DwoWrefL[HvAvbZuP];
					int VMOqvPYb = nnFt0lWO[HvAvbZuP];
					DwoWrefL[HvAvbZuP] = DwoWrefL[HvAvbZuP + 1];
					nnFt0lWO[HvAvbZuP] = nnFt0lWO[HvAvbZuP + 1];
					DwoWrefL[HvAvbZuP + 1] = esEEXVs3;
					nnFt0lWO[HvAvbZuP + 1] = VMOqvPYb;
				}
			}
		}
		for (int fu3NZMKD = 0; fu3NZMKD < Uz7sTR26; fu3NZMKD++) {
			addToEnsemble(models[nnFt0lWO[fu3NZMKD]]);
			if (report)
				ensemble.report(models[nnFt0lWO[fu3NZMKD]].getName(), allSets);
			updateBestModel();
		}
	}

}