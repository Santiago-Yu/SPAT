class n6853664 {
	public static String getServiceContent(String iO9R4GTt) throws IOException {
		URL BCLXlKF6 = new URL(iO9R4GTt);
		HttpURLConnection wrYnO94D = (HttpURLConnection) BCLXlKF6.openConnection();
		wrYnO94D.setRequestMethod("GET");
		wrYnO94D.connect();
		int Lqlm3Je6 = wrYnO94D.getResponseCode();
		if (Lqlm3Je6 == HttpURLConnection.HTTP_OK) {
			InputStream bVcUQ3ea = wrYnO94D.getInputStream();
			byte[] HAIXgcW2 = null;
			String tMQnnR4A = "";
			HAIXgcW2 = new byte[4096];
			int GHwHtF3J, HzhMPR1X, k2T5RTc2 = 0;
			GHwHtF3J = wrYnO94D.getContentLength();
			while (true) {
				HzhMPR1X = bVcUQ3ea.read(HAIXgcW2);
				if (HzhMPR1X <= 0)
					break;
				tMQnnR4A = tMQnnR4A + new String(HAIXgcW2);
			}
			return tMQnnR4A;
		}
		return null;
	}

}