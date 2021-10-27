class n12718571 {
	private ArrayList loadHTML(URL pE51935R) {
		ArrayList FS2iOBtb = new ArrayList();
		try {
			URLConnection l6UNIyge = pE51935R.openConnection();
			BufferedReader CRpUCTWd = new BufferedReader(new InputStreamReader(l6UNIyge.getInputStream()));
			String JlaAYEMN;
			while ((JlaAYEMN = CRpUCTWd.readLine()) != null) {
				FS2iOBtb.add(JlaAYEMN);
			}
			CRpUCTWd.close();
		} catch (Exception cwEb7kLz) {
			System.out.println("url> " + pE51935R);
		}
		return FS2iOBtb;
	}

}