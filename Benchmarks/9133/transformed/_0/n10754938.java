class n10754938 {
	public static URL getIconURLForUser(String XewsQ22r) {
		try {
			URL pGVhbPXQ = new URL("http://profiles.yahoo.com/" + XewsQ22r);
			BufferedReader zZdn5aIK = new BufferedReader(new InputStreamReader(pGVhbPXQ.openStream()));
			String ZENCRAAv = null;
			while ((ZENCRAAv = zZdn5aIK.readLine()) != null) {
				if (ZENCRAAv.indexOf("<a href=\"") < 0)
					continue;
				if (ZENCRAAv.indexOf("<img src=\"") < 0)
					continue;
				if (ZENCRAAv.indexOf("<a href=\"") > ZENCRAAv.indexOf("<img src=\""))
					continue;
				String cBcTvNdS = ZENCRAAv.substring(ZENCRAAv.indexOf("<a href=\"") + 9);
				String TKasa3tX = ZENCRAAv.substring(ZENCRAAv.indexOf("<img src=\"") + 10);
				if (cBcTvNdS.indexOf("\"") < 0)
					continue;
				if (TKasa3tX.indexOf("\"") < 0)
					continue;
				cBcTvNdS = cBcTvNdS.substring(0, cBcTvNdS.indexOf("\""));
				TKasa3tX = TKasa3tX.substring(0, TKasa3tX.indexOf("\""));
				if (cBcTvNdS.equals(TKasa3tX)) {
					return new URL(cBcTvNdS);
				}
			}
		} catch (IOException tV96csq8) {
		}
		URL V1BmtO2F = null;
		try {
			V1BmtO2F = new URL("http://us.i1.yimg.com/us.yimg.com/i/ppl/no_photo.gif");
		} catch (MalformedURLException HUREn1q9) {
			Debug.assrt(false);
		}
		return V1BmtO2F;
	}

}