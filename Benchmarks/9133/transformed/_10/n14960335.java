class n14960335 {
	private String readData(URL url) {
		try {
			StringBuffer responseBuffer = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				responseBuffer.append(line);
			}
			in.close();
			return new String(responseBuffer);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}