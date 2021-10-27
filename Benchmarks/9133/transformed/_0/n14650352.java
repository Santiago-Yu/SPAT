class n14650352 {
	boolean checkIfUserExists(String ZdyHyVyX) throws IOException {
		try {
			URL lhjDTcpm = new URL(WS_URL + "/user/" + URLEncoder.encode(ZdyHyVyX, "UTF-8") + "/profile.xml");
			HttpURLConnection uIfcsKFW = (HttpURLConnection) lhjDTcpm.openConnection();
			uIfcsKFW.connect();
			InputStream GhKI9sye = uIfcsKFW.getInputStream();
			GhKI9sye.close();
			return true;
		} catch (FileNotFoundException o3e5llh3) {
			return false;
		}
	}

}