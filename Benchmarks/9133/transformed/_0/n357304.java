class n357304 {
	public static String get(String t8NhijWD) {
		try {
			URL vy6zsFpQ = new URL(t8NhijWD);
			HttpURLConnection WXwts9TE = (HttpURLConnection) vy6zsFpQ.openConnection();
			WXwts9TE.setDoInput(true);
			WXwts9TE.setDoOutput(true);
			WXwts9TE.setUseCaches(true);
			WXwts9TE.setAllowUserInteraction(true);
			WXwts9TE.setFollowRedirects(true);
			WXwts9TE.setInstanceFollowRedirects(true);
			WXwts9TE.setRequestProperty("User-Agent:",
					"Mozilla/5.0 (Macintosh; U; PPC Mac OS X; de-de) AppleWebKit/523.12.2 (KHTML, like Gecko) Version/3.0.4 Safari/523.12.2");
			BufferedReader UyZd6WqU = new BufferedReader(new InputStreamReader(WXwts9TE.getInputStream()));
			String IMlHund3 = "";
			String zqbLre8o = "";
			while ((IMlHund3 = UyZd6WqU.readLine()) != null) {
				zqbLre8o += '\n' + IMlHund3;
			}
			return zqbLre8o;
		} catch (MalformedURLException HiWVwq2D) {
			HiWVwq2D.printStackTrace();
		} catch (IOException L7Lbu1lF) {
			L7Lbu1lF.printStackTrace();
		}
		return "";
	}

}