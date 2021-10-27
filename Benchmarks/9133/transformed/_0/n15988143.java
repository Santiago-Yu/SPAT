class n15988143 {
	public static List getUrlData(URL BLocjLEs) throws IOException {
		List Y6Sk3Sfn = new ArrayList(256);
		System.out.println("Retreiving content for: " + BLocjLEs);
		StringBuffer lAzxlhVS = new StringBuffer(4096);
		BufferedReader Z7gT9pps = new BufferedReader(new InputStreamReader(BLocjLEs.openStream()));
		String Q5PGnu6v;
		while ((Q5PGnu6v = Z7gT9pps.readLine()) != null) {
			if (Q5PGnu6v.startsWith("#")) {
				continue;
			}
			StringTokenizer b0U9iMsz = new StringTokenizer(Q5PGnu6v, "\t");
			String NRWXPeHG = b0U9iMsz.nextToken();
			String XfgpQcCZ = b0U9iMsz.nextToken();
			ReactomeBean AtBVaJNO = new ReactomeBean();
			AtBVaJNO.setReactomeID(XfgpQcCZ);
			AtBVaJNO.setInteractionAC(NRWXPeHG);
			Y6Sk3Sfn.add(AtBVaJNO);
		}
		Z7gT9pps.close();
		return Y6Sk3Sfn;
	}

}