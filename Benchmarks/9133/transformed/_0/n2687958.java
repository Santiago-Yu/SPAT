class n2687958 {
	@Override
	public void run() {
		try {
			File DmQPzghi = new File(location);
			if ((DmQPzghi.getParent() != null && !DmQPzghi.getParentFile().isDirectory()
					&& !DmQPzghi.getParentFile().mkdirs())) {
				throw new IOException("Impossible de cr¨¦er un dossier (" + DmQPzghi.getParent() + ").");
			} else if (DmQPzghi.exists() && !DmQPzghi.delete()) {
				throw new IOException("Impossible de supprimer un ancien fichier (" + DmQPzghi + ").");
			} else if (!DmQPzghi.createNewFile()) {
				throw new IOException("Impossible de cr¨¦er un fichier (" + DmQPzghi + ").");
			}
			FileChannel JKBCC8ne = new FileInputStream(file).getChannel();
			FileChannel k91dwZ6j = new FileOutputStream(DmQPzghi).getChannel();
			try {
				JKBCC8ne.transferTo(0, JKBCC8ne.size(), k91dwZ6j);
			} finally {
				JKBCC8ne.close();
				k91dwZ6j.close();
			}
		} catch (Exception RQ3oBAfV) {
			Main.fenetre().erreur(Fenetre.ERREUR_FATALE_UPDATE, RQ3oBAfV);
		} finally {
			file.delete();
		}
	}

}