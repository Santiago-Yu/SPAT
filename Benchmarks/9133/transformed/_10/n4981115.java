class n4981115 {
	private String fazHttpRequest(String u) {
		URL url = null;
		StringBuilder str = new StringBuilder();
		URLConnection urlC = null;
		try {
			url = new URL(u.toString());
			urlC = url.openConnection();
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				str.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("[fazHttpRequest]" + e);
		}
		return (str.length() > 0) ? str.toString() : null;
	}

}