class n8597004 {
	public String getHtmlSource(String Wau0oKsB) {
		StringBuffer TquLhMTK = null;
		BufferedReader rPbwBm9A = null;
		URLConnection GgQKv7KN = null;
		try {
			GgQKv7KN = new URL(Wau0oKsB).openConnection();
			GgQKv7KN.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			rPbwBm9A = new BufferedReader(new InputStreamReader(GgQKv7KN.getInputStream(), "utf-8"));
			TquLhMTK = new StringBuffer();
			String TD4vLA4G = "";
			while ((TD4vLA4G = rPbwBm9A.readLine()) != null) {
				TquLhMTK.append(TD4vLA4G).append("\n");
			}
			rPbwBm9A.close();
			TD4vLA4G = null;
		} catch (MalformedURLException Tb6mfwXB) {
			Tb6mfwXB.printStackTrace();
		} catch (IOException UbN2JdJ9) {
			UbN2JdJ9.printStackTrace();
		} finally {
			if (null != rPbwBm9A)
				rPbwBm9A = null;
			if (null != GgQKv7KN)
				GgQKv7KN = null;
		}
		return TquLhMTK.toString();
	}

}