class n22221629 {
	public static List<ReactomeBean> getUrlData(URL cGjq252L) throws IOException {
		List<ReactomeBean> gFqZxOQ4 = new ArrayList<ReactomeBean>(256);
		log.debug("Retreiving content for: " + cGjq252L);
		StringBuffer RDmOS1du = new StringBuffer(4096);
		BufferedReader A5mIrDeq = new BufferedReader(new InputStreamReader(cGjq252L.openStream()));
		String v3T0xcps;
		while ((v3T0xcps = A5mIrDeq.readLine()) != null) {
			if (v3T0xcps.startsWith("#")) {
				continue;
			}
			StringTokenizer nq3F8tXI = new StringTokenizer(v3T0xcps, "\t");
			String cLPuQaCn = nq3F8tXI.nextToken();
			String AUvJl0Cc = nq3F8tXI.nextToken();
			ReactomeBean upYYm708 = new ReactomeBean();
			upYYm708.setReactomeID(AUvJl0Cc);
			upYYm708.setInteractionAC(cLPuQaCn);
			gFqZxOQ4.add(upYYm708);
		}
		A5mIrDeq.close();
		return gFqZxOQ4;
	}

}