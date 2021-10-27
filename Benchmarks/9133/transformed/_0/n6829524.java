class n6829524 {
	public String getHtmlCodeUnCharset(String qso1ZXAq) {
		StringBuffer MWAO7R1S = new StringBuffer();
		BufferedReader xvJO6woC = null;
		try {
			URL roysjWhU = new URL((qso1ZXAq));
			URLConnection w5Zq0YHn = roysjWhU.openConnection();
			xvJO6woC = new BufferedReader(new InputStreamReader(w5Zq0YHn.getInputStream()));
			String lN9na5l0 = null;
			while ((lN9na5l0 = xvJO6woC.readLine()) != null) {
				MWAO7R1S.append(lN9na5l0 + "\r\n");
			}
			xvJO6woC.close();
		} catch (MalformedURLException OwxHA1nM) {
			System.out.println("Unable to connect to URL: " + qso1ZXAq);
		} catch (IOException VLxsJsJE) {
			System.out.println("IOException when connecting to URL: " + qso1ZXAq);
		} finally {
			if (xvJO6woC != null) {
				try {
					xvJO6woC.close();
				} catch (Exception IbyPoOg4) {
					System.out.println("Exception throws at finally close reader when connecting to URL: " + qso1ZXAq);
				}
			}
		}
		return MWAO7R1S.toString();
	}

}