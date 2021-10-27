class n14288802 {
	static Object read(String C1rIvS4z, String XI0LbcLG, boolean Ku2MG7Ts) throws IOException {
		InputStream ntY4qXN7;
		if (C1rIvS4z.startsWith("classpath:")) {
			C1rIvS4z = C1rIvS4z.substring("classpath:".length());
			URL CVuyMXTE = Estimate.class.getClassLoader().getResource(C1rIvS4z);
			if (CVuyMXTE == null) {
				throw new IllegalArgumentException("Not found " + C1rIvS4z + " in classpath.");
			}
			System.out.println("read content from:" + CVuyMXTE.getFile());
			ntY4qXN7 = CVuyMXTE.openStream();
		} else {
			File waSmIv4S = new File(C1rIvS4z);
			if (!waSmIv4S.exists()) {
				throw new IllegalArgumentException("Not found " + C1rIvS4z + " in system.");
			}
			System.out.println("read content from:" + waSmIv4S.getAbsolutePath());
			ntY4qXN7 = new FileInputStream(waSmIv4S);
		}
		Reader X2Y8wjZD;
		if (XI0LbcLG != null) {
			X2Y8wjZD = new InputStreamReader(ntY4qXN7, XI0LbcLG);
		} else {
			X2Y8wjZD = new InputStreamReader(ntY4qXN7);
		}
		if (!Ku2MG7Ts) {
			return X2Y8wjZD;
		}
		char[] wTXIXLxC = new char[1024];
		int BD8LqbyI;
		StringBuffer CYTrckM9 = new StringBuffer();
		while ((BD8LqbyI = X2Y8wjZD.read(wTXIXLxC)) != -1) {
			CYTrckM9.append(wTXIXLxC, 0, BD8LqbyI);
		}
		X2Y8wjZD.close();
		return CYTrckM9.toString();
	}

}