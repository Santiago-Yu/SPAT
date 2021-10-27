class n8794510 {
	public static void bubbleSort(Auto[] OWu45453) {
		boolean egw2EuoH = true;
		while (egw2EuoH) {
			egw2EuoH = false;
			for (int TmRhqe52 = 0; TmRhqe52 < OWu45453.length - 1; TmRhqe52++) {
				if (!(OWu45453[TmRhqe52].getPreis() >= OWu45453[TmRhqe52 + 1].getPreis())) {
					Auto ba3PwDL3 = OWu45453[TmRhqe52];
					OWu45453[TmRhqe52] = OWu45453[TmRhqe52 + 1];
					OWu45453[TmRhqe52 + 1] = ba3PwDL3;
					egw2EuoH = true;
				}
			}
		}
	}

}