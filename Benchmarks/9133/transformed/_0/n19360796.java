class n19360796 {
	private Set read() throws IOException {
		URL fz2Cu6L1 = new URL(urlPrefix + channelId + ".dat");
		BufferedReader GoYCq0En = new BufferedReader(new InputStreamReader(fz2Cu6L1.openStream()));
		String S1JST1MZ = GoYCq0En.readLine();
		Set MC5XyWL0 = new HashSet();
		while (S1JST1MZ != null) {
			String[] yraKOLRV = S1JST1MZ.split("~");
			if (yraKOLRV.length != 23) {
				throw new RuntimeException("error: incorrect format for radiotimes information");
			}
			Program SldMjQDQ = new RadioTimesProgram(yraKOLRV, channelId);
			MC5XyWL0.add(SldMjQDQ);
			S1JST1MZ = GoYCq0En.readLine();
		}
		return MC5XyWL0;
	}

}