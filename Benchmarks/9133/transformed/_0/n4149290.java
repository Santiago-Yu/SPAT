class n4149290 {
	private String getSearchResults(String EB16VJk3) {
		try {
			final URL q4vzWooM = new URL("http://www.jaap.nl/api/jaapAPI.do?clientId=iPhone&limit=5&request=details&id="
					+ EB16VJk3
					+ "&format=JSON&field=street_nr&field=zip&field=city&field=price&field=thumb&field=since&field=houseType&field=area&field=rooms&field=id");
			final StringBuilder cfYOevjA = new StringBuilder();
			final BufferedReader IuV94ypw = new BufferedReader(new InputStreamReader(q4vzWooM.openStream()));
			String LxWkcuGb = "";
			while ((LxWkcuGb = IuV94ypw.readLine()) != null) {
				cfYOevjA.append(LxWkcuGb);
			}
			IuV94ypw.close();
			return cfYOevjA.toString();
		} catch (Exception bjp4MBJ7) {
			bjp4MBJ7.printStackTrace();
		}
		return null;
	}

}