class n19038915 {
	private static String executeGet(String O9VJbmyc) {
		StringBuffer SSXwCxGX = new StringBuffer();
		try {
			Authentication.doIt();
			URL vBUZGWCG = new URL(O9VJbmyc);
			System.out.println("Host: " + vBUZGWCG.getHost());
			BufferedReader lFesnUTT = new BufferedReader(new InputStreamReader(vBUZGWCG.openStream()));
			HttpURLConnection azFbCLer = (HttpURLConnection) vBUZGWCG.openConnection();
			azFbCLer.setDoInput(true);
			String fcM2bl3r;
			while ((fcM2bl3r = lFesnUTT.readLine()) != null) {
				SSXwCxGX.append(fcM2bl3r);
			}
			lFesnUTT.close();
			azFbCLer.disconnect();
		} catch (MalformedURLException HoUpe3Qz) {
			HoUpe3Qz.printStackTrace();
		} catch (IOException AmlWA8Sx) {
			AmlWA8Sx.printStackTrace();
		}
		return SSXwCxGX.toString();
	}

}