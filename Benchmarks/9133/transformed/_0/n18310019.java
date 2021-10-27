class n18310019 {
	public static String readFromAddress(String VRM0KSgQ) throws Exception {
		StringBuilder Bvb0hVwv = new StringBuilder();
		URL DzP73mH2 = new URL(VRM0KSgQ);
		URLConnection ddyMCpIc = DzP73mH2.openConnection();
		ddyMCpIc.connect();
		InputStream YAmp4gK0 = (InputStream) ddyMCpIc.getContent();
		BufferedReader IoFoBxWJ = new BufferedReader(new InputStreamReader(YAmp4gK0));
		while (true) {
			String QLehjhHZ = IoFoBxWJ.readLine();
			if (QLehjhHZ == null)
				break;
			Bvb0hVwv.append(QLehjhHZ);
			Bvb0hVwv.append(System.getProperty("line.separator"));
		}
		IoFoBxWJ.close();
		return Bvb0hVwv.toString();
	}

}