class n14193056 {
	public static String readFromURL(String qzlDCa0O) {
		StringBuffer bNuyjINX = new StringBuffer();
		try {
			URL de2Oy4QU = new URL(qzlDCa0O);
			System.setProperty("http.agent", "");
			URLConnection zXVTX4kc = de2Oy4QU.openConnection();
			zXVTX4kc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			zXVTX4kc.setDoInput(true);
			InputStream imicxYid = zXVTX4kc.getInputStream();
			BufferedReader yjJrRf1O = new BufferedReader(new InputStreamReader(imicxYid, "utf8"));
			String ltFoil0E = "";
			while ((ltFoil0E = yjJrRf1O.readLine()) != null) {
				bNuyjINX.append(ltFoil0E + "\n");
			}
		} catch (Exception ezKdky09) {
			System.out.println(ezKdky09.toString());
		}
		return bNuyjINX.toString();
	}

}