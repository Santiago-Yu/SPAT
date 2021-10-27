class n7797615 {
	protected String readFileUsingHttp(String Bwq4uGK4) {
		String tNf9hOw8 = "";
		try {
			URL tOz58INt = new URL(Bwq4uGK4);
			URLConnection JIsYkcKy = tOz58INt.openConnection();
			HttpURLConnection pNrKSY2l = (HttpURLConnection) JIsYkcKy;
			pNrKSY2l.setRequestProperty("Content-Type", "text/html");
			pNrKSY2l.setRequestProperty("Content-Length", "0");
			pNrKSY2l.setRequestMethod("GET");
			pNrKSY2l.setDoOutput(true);
			pNrKSY2l.setDoInput(true);
			pNrKSY2l.setAllowUserInteraction(false);
			InputStreamReader IYr0XwCu = new InputStreamReader(pNrKSY2l.getInputStream());
			BufferedReader dTjOwlev = new BufferedReader(IYr0XwCu);
			String MaX7fxIB = "";
			while ((MaX7fxIB = dTjOwlev.readLine()) != null) {
				tNf9hOw8 += MaX7fxIB + "\n";
			}
			if (tNf9hOw8.endsWith("\n")) {
				tNf9hOw8 = tNf9hOw8.substring(0, tNf9hOw8.length() - 1);
			}
			dTjOwlev.close();
		} catch (Exception qqy3e6Mc) {
			qqy3e6Mc.printStackTrace();
		}
		return tNf9hOw8;
	}

}