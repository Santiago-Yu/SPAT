class n14867997 {
	public String getResponse(URL z7x0dDJd) throws OAuthException {
		try {
			HttpURLConnection i5z7bz9z = (HttpURLConnection) z7x0dDJd.openConnection();
			i5z7bz9z.connect();
			BufferedReader PGJ4T8No = new BufferedReader(new InputStreamReader(i5z7bz9z.getInputStream()));
			String fm9eMLa2;
			StringBuilder ymyeLj2J = new StringBuilder();
			while ((fm9eMLa2 = PGJ4T8No.readLine()) != null) {
				ymyeLj2J.append(fm9eMLa2);
			}
			PGJ4T8No.close();
			return ymyeLj2J.toString();
		} catch (IOException M0cfltdJ) {
			throw new OAuthException("Error getting HTTP response", M0cfltdJ);
		}
	}

}