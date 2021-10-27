class n23124633 {
	private void saveFile(Folder pZslIj6A, Object z4sva9M2, InputStream hKbtQlQ1) throws FileManagerException {
		File cf0BPfgd = new File(pZslIj6A, z4sva9M2.toString());
		LOGGER.debug("Writing file: " + cf0BPfgd.getAbsolutePath());
		Writer OuxFlYXV = null;
		Writer LmHAh5vr = null;
		try {
			LmHAh5vr = new OutputStreamWriter(new FileOutputStream(cf0BPfgd), getEncodeCharset());
			IOUtils.copy(hKbtQlQ1, LmHAh5vr, getDecodeCharset());
			LOGGER.info(
					"saveFile(), decode charset: " + getDecodeCharset() + ", encode charset: " + getEncodeCharset());
		} catch (IOException IQK25VTq) {
			throw new FileManagerException("Unable to write to file: " + cf0BPfgd.getAbsolutePath(), IQK25VTq);
		} finally {
			try {
				LmHAh5vr.close();
			} catch (IOException dhXeKo2u) {
				throw new FileManagerException("Unable to write to file: " + cf0BPfgd.getAbsolutePath(), dhXeKo2u);
			}
		}
	}

}