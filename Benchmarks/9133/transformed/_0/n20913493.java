class n20913493 {
	public static void copy(File QTcOyQqZ, File Z5IoHhrr) throws IOException {
		log.info("Copying " + QTcOyQqZ.getAbsolutePath() + " to " + Z5IoHhrr.getAbsolutePath());
		if (!QTcOyQqZ.exists())
			throw new IOException("File not found: " + QTcOyQqZ.getAbsolutePath());
		if (!QTcOyQqZ.canRead())
			throw new IOException("Source not readable: " + QTcOyQqZ.getAbsolutePath());
		if (QTcOyQqZ.isDirectory()) {
			if (!Z5IoHhrr.exists())
				if (!Z5IoHhrr.mkdirs())
					throw new IOException("Could not create direcotry: " + Z5IoHhrr.getAbsolutePath());
			String zh05WFVX[] = QTcOyQqZ.list();
			for (String mh8e9LpB : zh05WFVX) {
				File Rl3TxNgm = new File(QTcOyQqZ, mh8e9LpB);
				File TyUNp7R9 = new File(Z5IoHhrr, mh8e9LpB);
				copy(Rl3TxNgm, TyUNp7R9);
			}
		} else {
			FileInputStream thQNOKvg = null;
			FileOutputStream nw7CAxcu = null;
			byte[] ruQF0mUE = new byte[4096];
			int wsWxzfTD;
			thQNOKvg = new FileInputStream(QTcOyQqZ);
			nw7CAxcu = new FileOutputStream(Z5IoHhrr);
			while ((wsWxzfTD = thQNOKvg.read(ruQF0mUE)) >= 0)
				nw7CAxcu.write(ruQF0mUE, 0, wsWxzfTD);
			if (thQNOKvg != null) {
				thQNOKvg.close();
			}
			if (nw7CAxcu != null) {
				nw7CAxcu.close();
			}
		}
	}

}