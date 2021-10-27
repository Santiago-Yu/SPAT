class n5233678 {
	public static boolean postData(URL zfkETR2P, String hbGYTqgd) {
		HttpURLConnection F8X5zeNB = null;
		try {
			F8X5zeNB = (HttpURLConnection) zfkETR2P.openConnection();
			F8X5zeNB.setRequestMethod("POST");
			F8X5zeNB.setRequestProperty("Content-Length", "" + Integer.toString(hbGYTqgd.getBytes().length));
			F8X5zeNB.setUseCaches(false);
			F8X5zeNB.setDoInput(true);
			F8X5zeNB.setDoOutput(true);
			DataOutputStream FKMPrtC1 = new DataOutputStream(F8X5zeNB.getOutputStream());
			FKMPrtC1.writeBytes(hbGYTqgd);
			FKMPrtC1.flush();
			FKMPrtC1.close();
			BufferedReader K8ytmqAU = new BufferedReader(new InputStreamReader(F8X5zeNB.getInputStream()));
			String iWd2h8JS;
			boolean msxZ7X11 = false;
			while ((iWd2h8JS = K8ytmqAU.readLine()) != null) {
				if (iWd2h8JS.contains("OK"))
					msxZ7X11 = true;
			}
			return msxZ7X11;
		} catch (Exception G5N4HOTX) {
			try {
				if (F8X5zeNB != null)
					F8X5zeNB.disconnect();
			} catch (Exception sdfOkonw) {
			}
			return false;
		}
	}

}