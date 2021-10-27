class n9398453 {
	private static boolean isRemoteFileExist(String VrB66teM) {
		InputStream WaBwbncp = null;
		try {
			HttpURLConnection B72MGTTH = (HttpURLConnection) (new URL(VrB66teM)).openConnection();
			WaBwbncp = B72MGTTH.getInputStream();
		} catch (MalformedURLException W9YZTve8) {
			W9YZTve8.printStackTrace();
		} catch (IOException yXbGb9hK) {
			yXbGb9hK.printStackTrace();
		}
		if (WaBwbncp != null) {
			return true;
		} else {
			return false;
		}
	}

}