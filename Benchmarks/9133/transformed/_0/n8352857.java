class n8352857 {
	public void sendMessage(Message LDKi5cCK) throws IOException {
		URL vKiOTmWm = new URL(strURL);
		urlcon = (HttpURLConnection) vKiOTmWm.openConnection();
		urlcon.setUseCaches(false);
		urlcon.setDefaultUseCaches(false);
		urlcon.setDoOutput(true);
		urlcon.setDoInput(true);
		urlcon.setRequestProperty("Content-type", "application/octet-stream");
		urlcon.setAllowUserInteraction(false);
		HttpURLConnection.setDefaultAllowUserInteraction(false);
		urlcon.setRequestMethod("POST");
		ObjectOutputStream MXzxHiog = new ObjectOutputStream(urlcon.getOutputStream());
		MXzxHiog.writeObject(LDKi5cCK);
		MXzxHiog.flush();
		MXzxHiog.close();
	}

}