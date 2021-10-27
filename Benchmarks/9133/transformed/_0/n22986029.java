class n22986029 {
	private boolean doDelete(String dVhrnycl) throws IOException, MalformedURLException {
		URL nq70d2Wa = new URL(baseurl.toString() + "/" + dVhrnycl);
		HttpURLConnection UyiYMHtt = (HttpURLConnection) (nq70d2Wa.openConnection());
		UyiYMHtt.setRequestMethod("DELETE");
		UyiYMHtt.connect();
		if (UyiYMHtt.getResponseCode() == 200) {
			return true;
		} else
			return false;
	}

}