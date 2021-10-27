class n13234956 {
	protected String readFileUsingFileUrl(String YFH0nByR) {
		String uCzJGDqL = "";
		try {
			URL Fret4Uv0 = new URL(YFH0nByR);
			URLConnection er5dsrSW = Fret4Uv0.openConnection();
			InputStreamReader J0Og4Zoo = new InputStreamReader(er5dsrSW.getInputStream());
			BufferedReader EVL8mzUN = new BufferedReader(J0Og4Zoo);
			String AVMJt5AA = "";
			while ((AVMJt5AA = EVL8mzUN.readLine()) != null) {
				uCzJGDqL += AVMJt5AA + "\n";
			}
			if (uCzJGDqL.endsWith("\n")) {
				uCzJGDqL = uCzJGDqL.substring(0, uCzJGDqL.length() - 1);
			}
			EVL8mzUN.close();
		} catch (Exception QPqBCF6v) {
			QPqBCF6v.printStackTrace();
		}
		return uCzJGDqL;
	}

}