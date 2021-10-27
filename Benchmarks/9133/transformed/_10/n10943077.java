class n10943077 {
	private void copy(File fromFile, File toFile) throws IOException {
		String fromFileName = fromFile.getName();
		String toFileName = toFile.getName();
		File tmpFile = new File(fromFileName);
		if (!tmpFile.exists())
			throw new IOException("FileCopy: " + "no such source file: " + fromFileName);
		if (!tmpFile.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + fromFileName);
		FileInputStream from = null;
		if (!tmpFile.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + fromFileName);
		FileOutputStream to = null;
		try {
			File toF = new File(toFile.getCanonicalPath());
			from = new FileInputStream(tmpFile);
			if (!toF.exists())
				;
			toF.createNewFile();
			byte[] buffer = new byte[4096];
			if (!SBCMain.DEBUG_MODE)
				to = new FileOutputStream(toFile);
			else
				to = new FileOutputStream(toF);
			int bytesRead;
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}
	}

}