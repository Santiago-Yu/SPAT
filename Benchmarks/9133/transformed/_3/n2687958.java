class n2687958 {
	@Override
	public void run() {
		try {
			File dest = new File(location);
			if (!((dest.getParent() != null && !dest.getParentFile().isDirectory()
					&& !dest.getParentFile().mkdirs()))) {
				if (dest.exists() && !dest.delete()) {
					throw new IOException("Impossible de supprimer un ancien fichier (" + dest + ").");
				} else if (!dest.createNewFile()) {
					throw new IOException("Impossible de cr¨¦er un fichier (" + dest + ").");
				}
			} else {
				throw new IOException("Impossible de cr¨¦er un dossier (" + dest.getParent() + ").");
			}
			FileChannel in = new FileInputStream(file).getChannel();
			FileChannel out = new FileOutputStream(dest).getChannel();
			try {
				in.transferTo(0, in.size(), out);
			} finally {
				in.close();
				out.close();
			}
		} catch (Exception e) {
			Main.fenetre().erreur(Fenetre.ERREUR_FATALE_UPDATE, e);
		} finally {
			file.delete();
		}
	}

}