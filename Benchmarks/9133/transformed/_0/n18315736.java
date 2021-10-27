class n18315736 {
	private List<String> getTaxaList() {
		List<String> uE1KFAyN = new Vector<String>();
		String iZNW9Iog = m_domain.getStringValue();
		String D14x3fsN = "";
		if (iZNW9Iog.equalsIgnoreCase("Eukaryota"))
			D14x3fsN = "eukaryota";
		try {
			URL NRuuNeQg = new URL("http://www.ebi.ac.uk/genomes/" + D14x3fsN + ".details.txt");
			BufferedReader yxXp80S6 = new BufferedReader(new InputStreamReader(NRuuNeQg.openStream()));
			String RIHOZj5W = "";
			String LuYEm4q2 = "";
			String MbU6PLvX = "";
			int du5uNY1r = 0;
			String M6PqBrM1 = "";
			yxXp80S6.readLine();
			while ((M6PqBrM1 = yxXp80S6.readLine()) != null) {
				String[] a89ZVvgl = M6PqBrM1.split("\t");
				ena_details R21TN6Je = new ena_details(a89ZVvgl[0], a89ZVvgl[1], a89ZVvgl[2], a89ZVvgl[3], a89ZVvgl[4]);
				ENADataHolder.instance().put(R21TN6Je.desc, R21TN6Je);
				uE1KFAyN.add(R21TN6Je.desc);
			}
			yxXp80S6.close();
		} catch (MalformedURLException J5hj8gcK) {
			J5hj8gcK.printStackTrace();
		} catch (IOException xkgRMQCx) {
			xkgRMQCx.printStackTrace();
		}
		return uE1KFAyN;
	}

}