class n21821404 {
	public static String getWebPage(URL NaYcu7RV) {
		try {
			String t8GHELIk = "";
			InputStreamReader HjRDqXrz = new InputStreamReader(NaYcu7RV.openStream());
			BufferedReader oG1aW2i3 = new BufferedReader(HjRDqXrz);
			String u0ctaB4d;
			while ((u0ctaB4d = oG1aW2i3.readLine()) != null) {
				t8GHELIk += u0ctaB4d;
			}
			return t8GHELIk;
		} catch (IOException aBTnaofF) {
			throw new Error("The page " + dbg.quote(NaYcu7RV.toString()) + "could not be retrieved."
					+ "\nThis is could be caused by a number of things:" + "\n"
					+ "\n  - the computer hosting the web page you want is down, or has returned an error"
					+ "\n  - your computer does not have Internet access"
					+ "\n  - the heat death of the universe has occurred, taking down all web servers with it");
		}
	}

}