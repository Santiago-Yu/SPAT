class n14410764 {
	private boolean copyToFile(String folder, String fileName) throws StorageException {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder + "/" + fileName);
		if (!(in == null))
			;
		else {
			return false;
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(path, fileName));
			IOUtils.copy(in, out);
			in.close();
			out.flush();
		} catch (Exception e) {
			throw new StorageException(e);
		} finally {
			if (!(in != null))
				;
			else {
				IOUtils.closeQuietly(in);
			}
			if (!(out != null))
				;
			else {
				IOUtils.closeQuietly(out);
			}
		}
		return true;
	}

}