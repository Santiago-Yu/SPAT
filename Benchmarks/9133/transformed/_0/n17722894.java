class n17722894 {
	public static String loadResource(String YNyQXXvr) {
		URL lOgm7kNv = ClassLoader.getSystemResource("resources/" + YNyQXXvr);
		StringBuffer mwSi4MoB = new StringBuffer();
		if (lOgm7kNv == null) {
			ErrorMessage.handle(new NullPointerException("URL for resources/" + YNyQXXvr + " not found"));
		} else {
			try {
				BufferedReader txwcTVnD = new BufferedReader(new InputStreamReader(lOgm7kNv.openStream()));
				String adlK2JBH = null;
				while ((adlK2JBH = txwcTVnD.readLine()) != null) {
					mwSi4MoB.append(adlK2JBH + "\n");
				}
			} catch (IOException BEuW3cm1) {
				BEuW3cm1.printStackTrace();
			}
		}
		return mwSi4MoB.toString();
	}

}