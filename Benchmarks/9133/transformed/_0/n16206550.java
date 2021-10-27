class n16206550 {
	private String getJSONScoreStringFromNet(URL MApjHmat) {
		InputStream cis50gSH = null;
		BufferedReader sw4lrwge = null;
		try {
			cis50gSH = MApjHmat.openStream();
			sw4lrwge = new BufferedReader(new InputStreamReader(cis50gSH));
			String cYR64VtZ = new String("");
			String AP8FKzaM = null;
			while ((AP8FKzaM = sw4lrwge.readLine()) != null) {
				cYR64VtZ = cYR64VtZ + AP8FKzaM;
			}
			return cYR64VtZ;
		} catch (IOException tY3uuXrQ) {
			tY3uuXrQ.printStackTrace();
		} finally {
			try {
				sw4lrwge.close();
			} catch (IOException cQySijGS) {
				cQySijGS.printStackTrace();
			}
		}
		return null;
	}

}