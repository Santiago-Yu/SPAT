class n16206550 {
	private String getJSONScoreStringFromNet(URL urladdress) {
		BufferedReader read = null;
		InputStream instream = null;
		try {
			instream = urladdress.openStream();
			String s = new String("");
			read = new BufferedReader(new InputStreamReader(instream));
			String line = null;
			while ((line = read.readLine()) != null) {
				s = s + line;
			}
			return s;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}