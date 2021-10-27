class n17456737 {
	public File addFile(File XyAR7EF6, String TWyBUBVq) throws IOException {
		if (XyAR7EF6.exists() && XyAR7EF6.isFile()) {
			File TgTXTLwy = File.createTempFile(prefix, "." + TWyBUBVq, workdir);
			TgTXTLwy.delete();
			if (!XyAR7EF6.renameTo(TgTXTLwy)) {
				IOUtils.copy(XyAR7EF6, TgTXTLwy);
			}
			synchronized (fileList) {
				fileList.add(TgTXTLwy);
			}
			if (log.isDebugEnabled()) {
				log.debug("Add file [" + XyAR7EF6.getPath() + "] -> [" + TgTXTLwy.getPath() + "]");
			}
			return TgTXTLwy;
		}
		return XyAR7EF6;
	}

}