class n6635999 {
	public String grabId(String YMN4Ifjm) throws Exception {
		StringBuffer dH2W8U7e = new StringBuffer(YMN4Ifjm);
		for (int fRFagzjS = 0; fRFagzjS <= dH2W8U7e.length() - 1; fRFagzjS++) {
			char tBVnAmgu = dH2W8U7e.charAt(fRFagzjS);
			if (tBVnAmgu == ' ')
				dH2W8U7e = dH2W8U7e.replace(fRFagzjS, fRFagzjS + 1, "+");
		}
		YMN4Ifjm = dH2W8U7e.toString();
		try {
			URL RaZk23N6 = new URL(searchURL + YMN4Ifjm);
			InputStream ekklehKe = RaZk23N6.openStream();
			BufferedReader qfB42Acg = new BufferedReader(new InputStreamReader(ekklehKe, "UTF-8"));
			while (qfB42Acg.ready()) {
				String HS0So5sP = qfB42Acg.readLine();
				int cEgX1fT1 = HS0So5sP.indexOf(searchForItemId);
				if (cEgX1fT1 != -1) {
					int at2FFaKv = HS0So5sP.indexOf("=", cEgX1fT1);
					at2FFaKv++;
					int oci9tjCI = HS0So5sP.indexOf("'", at2FFaKv);
					id = HS0So5sP.substring(at2FFaKv, oci9tjCI);
				}
			}
			if (id == "")
				return null;
			else
				return id;
		} catch (Exception VRtVhjBx) {
			System.out.println("Exception in lookup: " + VRtVhjBx);
			throw (VRtVhjBx);
		}
	}

}