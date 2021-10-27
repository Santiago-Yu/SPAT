class n5590065 {
	protected String readFileUsingHttp(String Dip8xIGg) {
		String mikg9PpL = "";
		try {
			URL skNQQMba = new URL(Dip8xIGg);
			URLConnection HHJKHS20 = skNQQMba.openConnection();
			HttpURLConnection MJQSqtIT = (HttpURLConnection) HHJKHS20;
			MJQSqtIT.setRequestProperty("Content-Type", "text/html");
			MJQSqtIT.setRequestProperty("Content-Length", "0");
			MJQSqtIT.setRequestMethod("GET");
			MJQSqtIT.setDoOutput(true);
			MJQSqtIT.setDoInput(true);
			MJQSqtIT.setAllowUserInteraction(false);
			InputStreamReader KssEqIpj = new InputStreamReader(MJQSqtIT.getInputStream());
			BufferedReader MEAKDdS9 = new BufferedReader(KssEqIpj);
			String ESP7ryS9 = "";
			while ((ESP7ryS9 = MEAKDdS9.readLine()) != null) {
				mikg9PpL += ESP7ryS9 + "\n";
			}
			if (mikg9PpL.endsWith("\n")) {
				mikg9PpL = mikg9PpL.substring(0, mikg9PpL.length() - 1);
			}
			MEAKDdS9.close();
		} catch (Exception xAYJ9Jyd) {
			xAYJ9Jyd.printStackTrace();
		}
		return mikg9PpL;
	}

}