class n10295000 {
	public static String getByUrl(String uP3Kqflh, String wHN2kZz6) {
		URL Xrp6FBAI;
		StringBuffer PP8t7mFc = new StringBuffer("");
		try {
			Xrp6FBAI = new URL(uP3Kqflh);
			HttpURLConnection LHTPheAV = (HttpURLConnection) Xrp6FBAI.openConnection();
			LHTPheAV.setRequestMethod("POST");
			LHTPheAV.setDoOutput(true);
			OutputStreamWriter ow3nLfUe = new OutputStreamWriter(LHTPheAV.getOutputStream(), "8859_1");
			ow3nLfUe.write(wHN2kZz6);
			ow3nLfUe.flush();
			ow3nLfUe.close();
			System.out.println("para:" + wHN2kZz6);
			InputStream AJGxxydT = Xrp6FBAI.openStream();
			BufferedReader GGFceWNd = new BufferedReader(new InputStreamReader(AJGxxydT));
			String vLmG4yyr = "";
			vLmG4yyr = GGFceWNd.readLine();
			while (vLmG4yyr != null) {
				PP8t7mFc.append(vLmG4yyr + "\n");
				vLmG4yyr = GGFceWNd.readLine();
			}
		} catch (MalformedURLException PpUwNEAh) {
			PpUwNEAh.printStackTrace();
		} catch (IOException FK8EJdl4) {
			FK8EJdl4.printStackTrace();
		}
		return PP8t7mFc.toString();
	}

}