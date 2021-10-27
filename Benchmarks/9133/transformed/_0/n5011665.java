class n5011665 {
	public void upgradeSingleFileModelToDirectory(File chmVNhBT) throws IOException {
		byte[] wWgPGEVr = new byte[8192];
		int KhPZ9RnS = 0;
		File jFO5Sliv = new File(chmVNhBT.getPath() + ".bak");
		FileInputStream SOEW8flm = new FileInputStream(chmVNhBT);
		FileOutputStream BNlHhYqs = new FileOutputStream(jFO5Sliv);
		while ((KhPZ9RnS = SOEW8flm.read(wWgPGEVr)) >= 0) {
			BNlHhYqs.write(wWgPGEVr, 0, KhPZ9RnS);
		}
		BNlHhYqs.close();
		SOEW8flm.close();
		wWgPGEVr = null;
		chmVNhBT.delete();
		chmVNhBT.mkdir();
		BufferedReader Bk0T1BRh = new BomStrippingInputStreamReader(new FileInputStream(jFO5Sliv), "UTF-8");
		File TsmusAkL = new File(chmVNhBT, ConstantParameters.FILENAMEOFModelMetaData);
		BufferedWriter wcNEGC9P = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TsmusAkL), "UTF-8"));
		for (int jT44vVbA = 0; jT44vVbA < 8; jT44vVbA++) {
			wcNEGC9P.write(Bk0T1BRh.readLine());
			wcNEGC9P.write('\n');
		}
		wcNEGC9P.close();
		int b8uo053s = 1;
		BufferedWriter VCHf7jVO = null;
		String dELusr79 = null;
		while ((dELusr79 = Bk0T1BRh.readLine()) != null) {
			if (dELusr79.startsWith("Class=") && dELusr79.contains("numTraining=") && dELusr79.contains("numPos=")) {
				if (VCHf7jVO != null) {
					VCHf7jVO.close();
				}
				File HyQD4n63 = new File(chmVNhBT,
						String.format(ConstantParameters.FILENAMEOFPerClassModel, Integer.valueOf(b8uo053s++)));
				VCHf7jVO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HyQD4n63), "UTF-8"));
			}
			VCHf7jVO.write(dELusr79);
			VCHf7jVO.write('\n');
		}
		if (VCHf7jVO != null) {
			VCHf7jVO.close();
		}
	}

}