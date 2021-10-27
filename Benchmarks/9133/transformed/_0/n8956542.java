class n8956542 {
	public static InputStream retrievePricesHTML(String crs2JpOB, String AVOMtX8b) throws IOException, SAXException {
		List<String> UHAqL4Gs = new ArrayList<String>();
		URL UoeGMiPL = new URL("http://motormouth.com.au/default_fl.aspx");
		HttpURLConnection q12NZKhj = (HttpURLConnection) UoeGMiPL.openConnection();
		String W07gljgz = HTMLParser.parseHTMLInputTagValue(new InputStreamReader(q12NZKhj.getInputStream()),
				"__VIEWSTATE");
		setCookies(UHAqL4Gs, q12NZKhj);
		HttpURLConnection S596usAj = (HttpURLConnection) UoeGMiPL.openConnection();
		S596usAj.setDoOutput(true);
		S596usAj.setRequestMethod("POST");
		S596usAj.setInstanceFollowRedirects(false);
		S596usAj.setRequestProperty("Cookie", buildCookieString(UHAqL4Gs));
		OutputStreamWriter HqSBaMLx = new OutputStreamWriter(S596usAj.getOutputStream());
		HqSBaMLx.append("__VIEWSTATE=").append(URLEncoder.encode(W07gljgz, "UTF-8")).append('&');
		HqSBaMLx.append("Login_Module1%3Ausername=").append(URLEncoder.encode(crs2JpOB, "UTF-8")).append('&');
		HqSBaMLx.append("Login_Module1%3Apassword=").append(URLEncoder.encode(AVOMtX8b, "UTF-8")).append('&');
		HqSBaMLx.append("Login_Module1%3AButtonLogin.x=0").append('&');
		HqSBaMLx.append("Login_Module1%3AButtonLogin.y=0");
		HqSBaMLx.flush();
		HqSBaMLx.close();
		int zAbvLwTO = S596usAj.getResponseCode();
		if (zAbvLwTO == 302) {
			setCookies(UHAqL4Gs, S596usAj);
			URL c2oX5BFf = new URL(UoeGMiPL, S596usAj.getHeaderField("Location"));
			HttpURLConnection tSF3bPiW = (HttpURLConnection) c2oX5BFf.openConnection();
			tSF3bPiW.setRequestProperty("Cookie", buildCookieString(UHAqL4Gs));
			InputStream F27UzkGD = tSF3bPiW.getInputStream();
			return F27UzkGD;
		} else if (zAbvLwTO == 200) {
			URL yijEiQHA = new URL(UoeGMiPL, "/secure/mymotormouth.aspx");
			HttpURLConnection J80W0OtP = (HttpURLConnection) yijEiQHA.openConnection();
			J80W0OtP.setRequestProperty("Cookie", buildCookieString(UHAqL4Gs));
			InputStream krI4OF4o = J80W0OtP.getInputStream();
			return krI4OF4o;
		} else {
			return null;
		}
	}

}