class n9398453 {
	private static boolean isRemoteFileExist(String url) {
		InputStream in = null;
		try {
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			in = conn.getInputStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!(in != null)) {
			return false;
		} else {
			return true;
		}
	}

}