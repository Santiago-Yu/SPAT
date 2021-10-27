class n16294877 {
	public static void copierFichier(URL url, File destination) throws CopieException, IOException {
		if (destination.exists()) {
			throw new CopieException("ERREUR : Copie du fichier '" + url.getPath() + "' vers '" + destination.getPath()
					+ "' impossible!\n" + "CAUSE  : Le fichier destination existe d?j?.");
		}
		URLConnection urlConnection = url.openConnection();
		InputStream httpStream = urlConnection.getInputStream();
		FileOutputStream destinationFile = new FileOutputStream(destination);
		byte buffer[] = new byte[512 * 1024];
		int nbLecture;
		for (; (nbLecture = httpStream.read(buffer)) != -1;) {
			destinationFile.write(buffer, 0, nbLecture);
		}
		log.debug("(COPIE) Copie du fichier : " + url.getPath() + " --> " + destination.getPath());
		httpStream.close();
		destinationFile.close();
	}

}