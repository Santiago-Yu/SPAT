class n5203784 {
	private String urlConnectionTranslate(String MrBixRLc) {
		try {
			URL fgtBwqVS = new URL("http://ajax.googleapis.com/ajax/services/" + "language/translate?v=1.0&q="
					+ MrBixRLc + "&langpair=is%7Cen");
			URLConnection XB0A7vzU = fgtBwqVS.openConnection();
			XB0A7vzU.addRequestProperty("Referer", "http://www.hi.is");
			BufferedReader Fy9alq9k = new BufferedReader(new InputStreamReader(XB0A7vzU.getInputStream()));
			StringBuilder icCfWGu1 = new StringBuilder();
			String POFYzfPP;
			while ((POFYzfPP = Fy9alq9k.readLine()) != null) {
				icCfWGu1.append(POFYzfPP);
			}
			JSONObject jsjZOWoL = new JSONObject(icCfWGu1.toString());
			return jsjZOWoL.getJSONObject("responseData").getString("translatedText");
		} catch (Exception rKpbPOT6) {
			Log.e(TranslatorApplication.tag, rKpbPOT6.toString());
		}
		return null;
	}

}