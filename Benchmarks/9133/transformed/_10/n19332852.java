class n19332852 {
	public void access() {
		Authenticator.setDefault(new MyAuthenticator());
		try {
			URL url = new URL("http://localhost/ws/test");
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = in.readLine()) != null) {
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

}