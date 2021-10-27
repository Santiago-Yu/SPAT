class n22300339 {
	public static String getDocumentAsString(URL F5mwz0tB) throws IOException {
		StringBuffer vtPzXTPL = new StringBuffer();
		InputStream qPkWlMyE = F5mwz0tB.openStream();
		int MpwLyCkA;
		while ((MpwLyCkA = qPkWlMyE.read()) != -1) {
			vtPzXTPL.append((char) MpwLyCkA);
		}
		return vtPzXTPL.toString();
	}

}