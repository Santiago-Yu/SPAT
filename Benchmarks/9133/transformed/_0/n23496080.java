class n23496080 {
	private void fillTemplate(String TKQbw7wT, OutputStream qqP19ZBd, Map<String, String> C57RNMdG) throws IOException {
		URL LBp5MUCn = Tools.getResource(TKQbw7wT);
		if (LBp5MUCn == null) {
			throw new IOException("could not find resource");
		}
		BufferedReader Cqj2HyHV = new BufferedReader(new InputStreamReader(LBp5MUCn.openStream()));
		BufferedWriter AZcdfdPh = new BufferedWriter(new OutputStreamWriter(qqP19ZBd, Charset.forName("UTF-8")));
		String DKLLyQv9 = null;
		do {
			DKLLyQv9 = Cqj2HyHV.readLine();
			if (DKLLyQv9 != null) {
				for (String oHeuGeh8 : C57RNMdG.keySet()) {
					String wjYpaJc1 = C57RNMdG.get(oHeuGeh8);
					if (oHeuGeh8 != null) {
						DKLLyQv9 = DKLLyQv9.replace(oHeuGeh8, wjYpaJc1);
					}
				}
				AZcdfdPh.write(DKLLyQv9);
				AZcdfdPh.newLine();
			}
		} while (DKLLyQv9 != null);
		Cqj2HyHV.close();
		AZcdfdPh.close();
	}

}