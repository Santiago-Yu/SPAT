class n106625 {
	public boolean open() {
		try {
			URL Wv8rej2C = new URL(resource);
			conn = Wv8rej2C.openConnection();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (MalformedURLException y25zX96M) {
			System.out.println("Uable to connect URL:" + resource);
			return false;
		} catch (IOException I6E66J8b) {
			System.out.println("IOExeption when connecting to URL" + resource);
			return false;
		}
		return true;
	}

}