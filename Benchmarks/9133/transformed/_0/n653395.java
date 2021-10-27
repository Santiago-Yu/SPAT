class n653395 {
	public static boolean downloadFile(String uVYi4oRj, String Za5PjMPz) throws Exception {
		BufferedInputStream W3ISSTU2 = null;
		BufferedOutputStream WO0FZEjF = null;
		File L0WyHQ98;
		java.net.URL jAbjqW1b;
		jAbjqW1b = new java.net.URL(uVYi4oRj);
		W3ISSTU2 = new BufferedInputStream(jAbjqW1b.openStream());
		L0WyHQ98 = new File(Za5PjMPz);
		if (!L0WyHQ98.createNewFile()) {
			L0WyHQ98.delete();
			L0WyHQ98.createNewFile();
		}
		WO0FZEjF = new BufferedOutputStream(new FileOutputStream(L0WyHQ98));
		int oiYtzm2T;
		while ((oiYtzm2T = W3ISSTU2.read()) != -1) {
			WO0FZEjF.write(oiYtzm2T);
		}
		W3ISSTU2.close();
		WO0FZEjF.close();
		return true;
	}

}