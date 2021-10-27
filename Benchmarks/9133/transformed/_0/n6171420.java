class n6171420 {
	public static void copyFile(File QbwT9mjn, File GSenSX0l) throws IOException {
		log.info("Copying file '" + QbwT9mjn + "' to '" + GSenSX0l + "'");
		if (!QbwT9mjn.isFile()) {
			throw new IllegalArgumentException(
					"The sourceFile '" + QbwT9mjn + "' does not exist or is not a normal file.");
		}
		if (!GSenSX0l.exists()) {
			GSenSX0l.createNewFile();
		}
		FileChannel cgf96KeH = null;
		FileChannel YqOGyk5t = null;
		try {
			cgf96KeH = new FileInputStream(QbwT9mjn).getChannel();
			YqOGyk5t = new FileOutputStream(GSenSX0l).getChannel();
			long JhdiPkIE = YqOGyk5t.transferFrom(cgf96KeH, 0, cgf96KeH.size());
			log.debug("Transferred " + JhdiPkIE + " bytes from '" + QbwT9mjn + "' to '" + GSenSX0l + "'.");
		} finally {
			if (cgf96KeH != null) {
				cgf96KeH.close();
			}
			if (YqOGyk5t != null) {
				YqOGyk5t.close();
			}
		}
	}

}