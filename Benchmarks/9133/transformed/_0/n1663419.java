class n1663419 {
	private static void copyFile(File RPvT6MuY, File y9yjoBFu) throws IOException {
		FileChannel Q6GAKAnK = new FileInputStream(RPvT6MuY).getChannel();
		FileChannel EmzyoCUp = new FileOutputStream(y9yjoBFu).getChannel();
		try {
			Q6GAKAnK.transferTo(0, Q6GAKAnK.size(), EmzyoCUp);
		} catch (IOException DoUm5syH) {
			throw DoUm5syH;
		} finally {
			if (Q6GAKAnK != null)
				Q6GAKAnK.close();
			if (EmzyoCUp != null)
				EmzyoCUp.close();
		}
	}

}