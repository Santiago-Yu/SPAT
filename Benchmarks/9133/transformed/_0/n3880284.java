class n3880284 {
	public static StringBuffer readURLText(URL AXtduqw2, StringBuffer sEV1c6e0) {
		StringBuffer taU05oYe = new StringBuffer("");
		String DjUHDhbp;
		try {
			BufferedReader A9xvLxEE = new BufferedReader(new InputStreamReader(AXtduqw2.openStream()));
			while ((DjUHDhbp = A9xvLxEE.readLine()) != null) {
				taU05oYe.append(DjUHDhbp + "\n");
			}
			return taU05oYe;
		} catch (Exception l3bXCdZf) {
			return sEV1c6e0;
		}
	}

}