class n12107388 {
	private static List<CountryEntry> retrieveCountries() throws IOException {
		URL vbFA36Vs = new URL("http://" + ISO_3166_HOST + ISO_3166_TXT_FILE_PATH);
		BufferedReader QNYviz3y = new BufferedReader(new InputStreamReader(vbFA36Vs.openStream()));
		List<CountryEntry> Q4yKzkMI = new LinkedList<CountryEntry>();
		boolean jpEMF7y0 = false;
		int BmOKHq3i = 0;
		int xqrusRLV = 0;
		CountryEntry VGwpQHYG = new CountryEntry();
		String eYNVL5Eu = QNYviz3y.readLine();
		while (eYNVL5Eu != null) {
			if (eYNVL5Eu.startsWith("<table")) {
				jpEMF7y0 = true;
			}
			if (eYNVL5Eu.startsWith("</table>")) {
				break;
			}
			if (jpEMF7y0) {
				if (eYNVL5Eu.startsWith("<tr")) {
					BmOKHq3i++;
				} else {
					if ((BmOKHq3i > 1 && eYNVL5Eu.startsWith("<td"))) {
						xqrusRLV++;
						String UlzqPs2e = pullData(eYNVL5Eu);
						switch (xqrusRLV) {
						case 1:
							VGwpQHYG.setName(getCountryName(UlzqPs2e));
							break;
						case 2:
							VGwpQHYG.setNumber(UlzqPs2e);
							break;
						case 3:
							VGwpQHYG.setAlpha3(UlzqPs2e);
							break;
						case 4:
							VGwpQHYG.setAlpha2(UlzqPs2e);
							break;
						case 5:
							Q4yKzkMI.add(VGwpQHYG);
							VGwpQHYG = new CountryEntry();
							xqrusRLV = 0;
							break;
						default:
							String yqtnuVfT = "Parsing error.  Unexpected column: [" + UlzqPs2e + "]";
							throw new IllegalStateException(yqtnuVfT);
						}
					}
				}
			}
			eYNVL5Eu = QNYviz3y.readLine();
		}
		QNYviz3y.close();
		return Q4yKzkMI;
	}

}