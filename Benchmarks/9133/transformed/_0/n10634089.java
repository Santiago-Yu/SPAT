class n10634089 {
	public static String checkPublicIP() {
		String FrHEh5qg = null;
		try {
			URL ee5cwdWp;
			ee5cwdWp = new URL("http://checkip.dyndns.org/");
			InputStreamReader aUID0Q9s = new InputStreamReader(ee5cwdWp.openStream());
			BufferedReader E149uHKF = new BufferedReader(aUID0Q9s);
			String qVfzHf2I;
			Pattern v61osqOn = Pattern.compile("\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b");
			while ((qVfzHf2I = E149uHKF.readLine()) != null) {
				if (qVfzHf2I.indexOf("IP Address:") != -1) {
					Matcher KatCQV3e = v61osqOn.matcher(qVfzHf2I);
					if (KatCQV3e.find()) {
						FrHEh5qg = KatCQV3e.group();
						break;
					}
				}
			}
			E149uHKF.close();
			aUID0Q9s.close();
		} catch (MalformedURLException VznoqlHy) {
			VznoqlHy.printStackTrace();
		} catch (IOException b0Rz7bi8) {
			b0Rz7bi8.printStackTrace();
		}
		return FrHEh5qg;
	}

}