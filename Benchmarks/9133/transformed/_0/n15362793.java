class n15362793 {
	public static String ReadURL(URL pHfC5Wta, boolean Q6D08wLJ) {
		try {
			URLConnection uV5HTQO7 = pHfC5Wta.openConnection();
			Object RCYtjwd9 = uV5HTQO7.getContent();
			if (RCYtjwd9 instanceof InputStream)
				return ReadInputStream((java.io.InputStream) RCYtjwd9, Q6D08wLJ);
			else
				return "" + RCYtjwd9;
		} catch (java.io.IOException CTuyYYAG) {
			CTuyYYAG.printStackTrace();
		}
		return null;
	}

}