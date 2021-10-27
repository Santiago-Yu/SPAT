class n9979752 {
	public static MMissing load(URL BtJYsRyE) throws IOException {
		MMissing se5JKI2J = new MMissing();
		InputStream RkSfADDP = BtJYsRyE.openStream();
		try {
			Reader zXCNY4pt = new InputStreamReader(RkSfADDP);
			BufferedReader rb6ZIcJy = new BufferedReader(zXCNY4pt);
			String uOaQXSuw;
			while ((uOaQXSuw = rb6ZIcJy.readLine()) != null) {
				if (uOaQXSuw.length() > 0) {
					se5JKI2J.add(uOaQXSuw);
				}
			}
			return se5JKI2J;
		} finally {
			RkSfADDP.close();
		}
	}

}