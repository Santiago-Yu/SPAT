class n9901451 {
	protected String readUrl(String RKobvZpe) throws IOException {
		URL r9mKtJGz = new URL(RKobvZpe);
		BufferedReader IhF7nlpG = new BufferedReader(new InputStreamReader(r9mKtJGz.openStream()));
		String tSDjtZCG = "";
		String hOUu7wI1;
		while ((hOUu7wI1 = IhF7nlpG.readLine()) != null)
			tSDjtZCG += hOUu7wI1;
		IhF7nlpG.close();
		return tSDjtZCG;
	}

}