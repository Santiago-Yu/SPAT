class n2614788 {
	public String parse() {
		try {
			URL PIGCdHcY = new URL(mUrl);
			HttpURLConnection TnoCKC5x = (HttpURLConnection) PIGCdHcY.openConnection();
			TnoCKC5x.setRequestMethod("GET");
			TnoCKC5x.setDoOutput(true);
			TnoCKC5x.connect();
			BufferedReader g43T01Vr = new BufferedReader(new InputStreamReader(TnoCKC5x.getInputStream()));
			String DYaBfw1d;
			boolean N0fCj6BI = false;
			while ((DYaBfw1d = g43T01Vr.readLine()) != null) {
				DYaBfw1d = DYaBfw1d.trim();
				if (!N0fCj6BI && DYaBfw1d.contains("</center>"))
					N0fCj6BI = true;
				if (N0fCj6BI && DYaBfw1d.contains("<br><center>"))
					break;
				if (N0fCj6BI) {
					mText.append(DYaBfw1d);
				}
			}
		} catch (MalformedURLException TCWAEQ5o) {
			TCWAEQ5o.printStackTrace();
		} catch (IOException exE8cChO) {
			exE8cChO.printStackTrace();
		}
		return mText.toString();
	}

}