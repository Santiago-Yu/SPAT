class n19332852 {
	public void access() {
		Authenticator.setDefault(new MyAuthenticator());
		try {
			URL Jr8rddJV = new URL("http://localhost/ws/test");
			BufferedReader sJ7HA5J5 = new BufferedReader(new InputStreamReader(Jr8rddJV.openStream()));
			String L4t3Et5I;
			while ((L4t3Et5I = sJ7HA5J5.readLine()) != null) {
			}
			sJ7HA5J5.close();
		} catch (MalformedURLException hi7sIarm) {
		} catch (IOException OM8cAM2A) {
		}
	}

}