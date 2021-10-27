class n14410764 {
	private boolean copyToFile(String folder, String fileName) throws StorageException {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder + "/" + fileName);
		FileOutputStream out = null;
		if (in == null) {
			return false;
		}
		try {
			out = new FileOutputStream(new File(path, fileName));
			IOUtils.copy(in, out);
			in.close();
			out.flush();
		} catch (Exception e) {
			throw new StorageException(e);
		} finally {
			if (in != null) {
				IOUtils.closeQuietly(in);
			}
			if (out != null) {
				IOUtils.closeQuietly(out);
			}
		}
		return true;
	}

}