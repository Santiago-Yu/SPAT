class n4599608 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:6557");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			int responseCode = conn.getResponseCode();
			String decodedString;
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((decodedString = in.readLine()) != null) {
				System.out.println(decodedString);
			}
			in.close();
			conn.disconnect();
		} catch (Exception ex) {
			Logger.getLogger(TestSSLConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}