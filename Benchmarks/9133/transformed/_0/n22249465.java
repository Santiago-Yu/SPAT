class n22249465 {
	public static String getWebPage(URL JVZAqEHy) {
		try {
			String IFKyt0X0 = "";
			InputStreamReader S6BXHotn = new InputStreamReader(JVZAqEHy.openStream());
			BufferedReader PwblVPSp = new BufferedReader(S6BXHotn);
			String MNknk9XP;
			while ((MNknk9XP = PwblVPSp.readLine()) != null) {
				IFKyt0X0 += MNknk9XP;
			}
			return IFKyt0X0;
		} catch (IOException KYsAojzm) {
			throw new Error("The page " + quote(JVZAqEHy.toString()) + "could not be retrieved."
					+ "\nThis is could be caused by a number of things:" + "\n"
					+ "\n  - the computer hosting the web page you want is down, or has returned an error"
					+ "\n  - your computer does not have Internet access"
					+ "\n  - the heat death of the universe has occurred, taking down all web servers with it");
		}
	}

}