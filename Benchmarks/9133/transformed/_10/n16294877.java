class n16294877 {
	public static void copierFichier(URL url, File destination) throws CopieException, IOException {
		if (destination.exists()) {
			throw new CopieException("ERREUR : Copie du fichier '" + url.getPath() + "' vers '" + destination.getPath()
					+ "' impossible!\n" + "CAUSE  : Le fichier destination existe d?j?.");
		}
		URLConnection urlConnection = url.openConnection();
		FileOutputStream destinationFile = new FileOutputStream(destination);
		InputStream httpStream = urlConnection.getInputStream();
		int nbLecture;
		byte buffer[] = new byte[512 * 1024];
		while ((nbLecture = httpStream.read(buffer)) != -1) {
			destinationFile.write(buffer, 0, nbLecture);
		}
		log.debug("(COPIE) Copie du fichier : " + url.getPath() + " --> " + destination.getPath());
		httpStream.close();
		destinationFile.close();
	}

}