class n21273057 {
	public RobotList<Percentage> sort_incr_Percentage(RobotList<Percentage> cUwzNvMR, String ACntqyD8) {
		int oulqYosD = cUwzNvMR.size();
		Index_value[] kuUVv00H = new Index_value[oulqYosD];
		for (int DV8Ej1GI = 0; DV8Ej1GI < oulqYosD; DV8Ej1GI++) {
			kuUVv00H[DV8Ej1GI] = new Index_value(DV8Ej1GI, cUwzNvMR.get(DV8Ej1GI).percent);
		}
		boolean inPMcPdl;
		do {
			inPMcPdl = false;
			for (int cUyaGL7I = 0; cUyaGL7I < oulqYosD - 1; cUyaGL7I++) {
				if (kuUVv00H[cUyaGL7I].value > kuUVv00H[cUyaGL7I + 1].value) {
					Index_value QsPvVyGL = kuUVv00H[cUyaGL7I];
					kuUVv00H[cUyaGL7I] = kuUVv00H[cUyaGL7I + 1];
					kuUVv00H[cUyaGL7I + 1] = QsPvVyGL;
					inPMcPdl = true;
				}
			}
		} while (inPMcPdl);
		RobotList<Percentage> YGk1Siuw = new RobotList<Percentage>(Percentage.class);
		for (int qqm42TTp = 0; qqm42TTp < oulqYosD; qqm42TTp++) {
			YGk1Siuw.addLast(new Percentage(kuUVv00H[qqm42TTp].value));
		}
		return YGk1Siuw;
	}

}