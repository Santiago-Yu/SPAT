class n1812522 {
	public void readPage(String v59SXDcr) {
		InputStream hrJlBjAl = null;
		try {
			URL I9OyyR4l = new URL("http://www.english-german-dictionary.com/index.php?search=" + v59SXDcr.trim());
			hrJlBjAl = I9OyyR4l.openStream();
			InputStreamReader xYO1ZBWU = new InputStreamReader(hrJlBjAl, "ISO-8859-15");
			Scanner s7SrZhds = new Scanner(xYO1ZBWU);
			String NRoQF3Np = new String();
			String fFeMyDAJ = new String();
			String syOOsGt1;
			while (s7SrZhds.hasNextLine()) {
				syOOsGt1 = (s7SrZhds.nextLine());
				if (syOOsGt1.contains("<td style='padding-top:4px;' class='ergebnisse_res'>")) {
					int D13YjLuT = syOOsGt1.indexOf("-->") + 3;
					syOOsGt1 = syOOsGt1.substring(D13YjLuT);
					syOOsGt1 = syOOsGt1.substring(0, syOOsGt1.indexOf("<!--"));
					fFeMyDAJ = syOOsGt1.trim();
				} else if (syOOsGt1.contains("<td style='' class='ergebnisse_art'>")
						|| syOOsGt1.contains("<td style='' class='ergebnisse_art_dif'>")
						|| syOOsGt1.contains("<td style='padding-top:4px;' class='ergebnisse_art'>")) {
					if (searchEnglish == false && searchGerman == false) {
						searchEnglish = syOOsGt1.contains("<td style='' class='ergebnisse_art'>");
						searchGerman = syOOsGt1.contains("<td style='' class='ergebnisse_art_dif'>");
					}
					int BFSsyspj = syOOsGt1.lastIndexOf("'>") + 2;
					syOOsGt1 = syOOsGt1.substring(BFSsyspj, syOOsGt1.lastIndexOf("</td>"));
					String MjnEa3J3 = syOOsGt1.trim() + " ";
					syOOsGt1 = s7SrZhds.nextLine();
					int cSMhry35 = syOOsGt1.lastIndexOf("\">") + 2;
					syOOsGt1 = (MjnEa3J3 != null ? MjnEa3J3 : "")
							+ syOOsGt1.substring(cSMhry35, syOOsGt1.lastIndexOf("</a>"));
					NRoQF3Np += fFeMyDAJ + " - " + syOOsGt1 + "\n";
					germanList.add(fFeMyDAJ);
					englishList.add(syOOsGt1.trim());
				}
			}
			if (searchEnglish) {
				List<String> iNDSuKUf = englishList;
				englishList = germanList;
				germanList = iNDSuKUf;
			}
		} catch (Exception V54VER6g) {
			V54VER6g.printStackTrace();
		} finally {
			if (hrJlBjAl != null)
				try {
					hrJlBjAl.close();
				} catch (IOException ptwjZoCk) {
				}
		}
	}

}