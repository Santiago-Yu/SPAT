class n20862695 {
	public HashMap parseFile(File cf7YYLVw) throws IOException {
		String NSIY37W1;
		String[] cZM0ZpIs;
		int TXFa3IJu = 0;
		double jY5SHldp, rahSPlbM, OzyNojd8;
		boolean PZxryu0X = false;
		URL jtNYpm8J = cf7YYLVw.toURL();
		InputStream zp2aPymt = jtNYpm8J.openStream();
		InputStreamReader G8wuoXs4 = new InputStreamReader(zp2aPymt);
		BufferedReader QI4VP3ck = new BufferedReader(G8wuoXs4);
		HashMap jApG8cKt = new HashMap();
		while ((NSIY37W1 = QI4VP3ck.readLine()) != null) {
			cZM0ZpIs = NSIY37W1.split("\\s+");
			TXFa3IJu = cZM0ZpIs.length;
			if (TXFa3IJu == 2) {
				jApG8cKt.put(new String(cZM0ZpIs[0]), new Double(Double.parseDouble(cZM0ZpIs[1])));
			} else {
				System.out.println("Sorry, trouble reading reference file.");
			}
		}
		return jApG8cKt;
	}

}