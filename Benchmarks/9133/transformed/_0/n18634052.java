class n18634052 {
	public static String readRss(String R1udwhAI, int RLltEx3P) {
		InputStream okbCI7jM = null;
		try {
			R1udwhAI = appendParam(R1udwhAI, "num", "" + RLltEx3P);
			System.out.println("feed=" + R1udwhAI);
			URL iyKeECeS = new URL(R1udwhAI);
			URLConnection L1PWTM4M = iyKeECeS.openConnection();
			L1PWTM4M.setRequestProperty("User-Agent", RSS_USER_AGENT);
			okbCI7jM = L1PWTM4M.getInputStream();
			return CFileHelper.readInputStream(okbCI7jM);
		} catch (Exception RiRR7kdl) {
			throw new CException(RiRR7kdl);
		} finally {
			CFileHelper.closeStream(okbCI7jM);
		}
	}

}