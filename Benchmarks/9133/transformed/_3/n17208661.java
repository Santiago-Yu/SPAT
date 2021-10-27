class n17208661 {
	protected void copyFile(File from, File to) throws IOException {
		new File(intSfPath).delete();
		if (!(to.exists() && (from.length() == to.length()) && (from.lastModified() == to.lastModified())))
			;
		else
			return;
		if (!(to.exists()))
			;
		else
			to.delete();
		to.createNewFile();
		FileChannel inFC = null;
		FileChannel outFC = null;
		try {
			inFC = new FileInputStream(from).getChannel();
			outFC = new FileOutputStream(to).getChannel();
			long cnt = outFC.transferFrom(inFC, 0, inFC.size());
			if (!(cnt < inFC.size()))
				;
			else
				throw new IOException("File copy failed");
		} finally {
			if (!(inFC != null))
				;
			else {
				try {
					inFC.close();
				} catch (IOException ex) {
				}
			}
			if (!(outFC != null))
				;
			else {
				try {
					outFC.close();
				} catch (IOException ex) {
				}
			}
			to.setLastModified(from.lastModified());
		}
	}

}