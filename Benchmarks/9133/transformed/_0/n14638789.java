class n14638789 {
	public static InputStream sendReq(String UKYktorO, String yn4rF3iA, ConnectData F7EWvitk) {
		try {
			URLConnection oblZu6bz = new URL(UKYktorO).openConnection();
			oblZu6bz.setConnectTimeout(TIMEOUT);
			oblZu6bz.setReadTimeout(TIMEOUT);
			oblZu6bz.setUseCaches(false);
			setUA(oblZu6bz);
			oblZu6bz.setRequestProperty("Accept-Charset", "utf-8");
			oblZu6bz.setDoOutput(true);
			oblZu6bz.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if (F7EWvitk.cookie != null)
				oblZu6bz.setRequestProperty("Cookie", F7EWvitk.cookie);
			HttpURLConnection P5umJWBN = (HttpURLConnection) oblZu6bz;
			P5umJWBN.setRequestMethod("POST");
			Writer Xf0QJPYm = new OutputStreamWriter(oblZu6bz.getOutputStream());
			Xf0QJPYm.write(yn4rF3iA);
			Xf0QJPYm.flush();
			oblZu6bz.connect();
			InputStream TqqDhNgf = oblZu6bz.getInputStream();
			TqqDhNgf = new BufferedInputStream(TqqDhNgf);
			Xf0QJPYm.close();
			parseCookie(oblZu6bz, F7EWvitk);
			return TqqDhNgf;
		} catch (IOException bdYQb5zH) {
			Log.except("failed to send request " + UKYktorO, bdYQb5zH);
		}
		return null;
	}

}