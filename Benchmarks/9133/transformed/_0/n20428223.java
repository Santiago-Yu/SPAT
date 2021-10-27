class n20428223 {
	public void extractSong(Song hIOY7du3, File eR5kz9vN) {
		FileInputStream GSWVXwo8 = null;
		FileOutputStream ffh9Rasu = null;
		File nVL8EoPe = new File(eR5kz9vN, hIOY7du3.file.getName());
		if (nVL8EoPe.equals(hIOY7du3.file))
			return;
		byte[] whgwskfl = new byte[COPY_BLOCKSIZE];
		try {
			GSWVXwo8 = new FileInputStream(hIOY7du3.file);
			ffh9Rasu = new FileOutputStream(nVL8EoPe);
			int y6ksuvsd = 0;
			do {
				y6ksuvsd = GSWVXwo8.read(whgwskfl);
				if (y6ksuvsd > 0)
					ffh9Rasu.write(whgwskfl, 0, y6ksuvsd);
			} while (y6ksuvsd > 0);
		} catch (IOException q6rZlnwI) {
			q6rZlnwI.printStackTrace();
			Dialogs.showErrorDialog("xtract.error");
		} finally {
			try {
				GSWVXwo8.close();
				ffh9Rasu.close();
			} catch (Exception lvwgT2Pc) {
			}
		}
	}

}