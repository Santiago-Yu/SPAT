class n7135601 {
	public static String upload(File WO7QnzrB, URL QBKmjsVy) throws IOException {
		StringBuffer yGJbul2S = new StringBuffer();
		URLConnection jWXZvfPH = QBKmjsVy.openConnection();
		ClientHttpRequest SGAJjXDp = new ClientHttpRequest(jWXZvfPH);
		String djRUdbLv = "file";
		String q5T8WMWX = WO7QnzrB.getName();
		InputStream zxDzPHgN = new FileInputStream(WO7QnzrB);
		SGAJjXDp.setParameter(djRUdbLv, q5T8WMWX, zxDzPHgN);
		InputStream v0adh3oE = SGAJjXDp.post();
		BufferedReader RJhY6JZZ = new BufferedReader(new InputStreamReader(v0adh3oE));
		String Ml3qWcgo = RJhY6JZZ.readLine();
		while (Ml3qWcgo != null) {
			yGJbul2S.append(Ml3qWcgo + "\n");
			Ml3qWcgo = RJhY6JZZ.readLine();
		}
		RJhY6JZZ.close();
		return yGJbul2S.toString();
	}

}