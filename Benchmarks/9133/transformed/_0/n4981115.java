class n4981115 {
	private String fazHttpRequest(String IvRVwFgO) {
		StringBuilder FkElAXnw = new StringBuilder();
		URL Ozel8VDB = null;
		URLConnection Fbp3TcNE = null;
		try {
			Ozel8VDB = new URL(IvRVwFgO.toString());
			Fbp3TcNE = Ozel8VDB.openConnection();
			BufferedReader XgWWZBxv = new BufferedReader(new InputStreamReader(Fbp3TcNE.getInputStream()));
			String zobA5P6V;
			while ((zobA5P6V = XgWWZBxv.readLine()) != null) {
				FkElAXnw.append(zobA5P6V);
			}
			XgWWZBxv.close();
		} catch (Exception D8giwrsR) {
			System.out.println("[fazHttpRequest]" + D8giwrsR);
		}
		return (FkElAXnw.length() > 0) ? FkElAXnw.toString() : null;
	}

}