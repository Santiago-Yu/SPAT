class n8883154 {
	protected void testConnection(String OCnYe9CA) throws Exception {
		URL vzRn7Vum = new URL(OCnYe9CA);
		HttpURLConnection rNplY9Xi = (HttpURLConnection) vzRn7Vum.openConnection();
		rNplY9Xi.setUseCaches(false);
		try {
			rNplY9Xi.connect();
			assertEquals(HttpURLConnection.HTTP_OK, rNplY9Xi.getResponseCode());
		} finally {
			rNplY9Xi.disconnect();
		}
	}

}