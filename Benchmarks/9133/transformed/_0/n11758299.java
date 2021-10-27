class n11758299 {
	void readData() {
		String[] WTpCNNuZ;
		int la2Jz5sN;
		double dSSJun5M;
		URL LtIPCgVC = null;
		String QHlz9Qh3;
		try {
			for (int N8aSWDAv = 0; N8aSWDAv < names.length; N8aSWDAv++) {
				QHlz9Qh3 = "data/" + names[N8aSWDAv] + ".csv";
				LtIPCgVC = new URL(ja.getCodeBase(), QHlz9Qh3);
				System.out.println(LtIPCgVC.toString());
				InputStream HbXYuWMd = LtIPCgVC.openStream();
				CSVReader vhSTXP82 = new CSVReader(new InputStreamReader(HbXYuWMd));
				la2Jz5sN = 0;
				while ((WTpCNNuZ = vhSTXP82.readNext()) != null) {
					allset.months[la2Jz5sN] = Integer.parseInt(WTpCNNuZ[0].substring(0, 2));
					allset.years[la2Jz5sN] = Integer.parseInt(WTpCNNuZ[0].substring(6, 10));
					dSSJun5M = Double.parseDouble(WTpCNNuZ[1]);
					allset.values.getDataRef()[la2Jz5sN][N8aSWDAv] = dSSJun5M;
					la2Jz5sN++;
				}
			}
		} catch (IOException CIxbFNvm) {
			System.err.println("File Read Exception");
		}
	}

}