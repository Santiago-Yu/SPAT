class n21016411 {
	public File addFile(File QbLLBqmb, String Zq7LZTAf) throws IOException {
		if (QbLLBqmb.exists() && QbLLBqmb.isFile()) {
			File yRfVSeG6 = File.createTempFile(prefix, "." + Zq7LZTAf, workdir);
			yRfVSeG6.delete();
			if (!QbLLBqmb.renameTo(yRfVSeG6)) {
				IOUtils.copy(QbLLBqmb, yRfVSeG6);
			}
			synchronized (fileList) {
				fileList.add(yRfVSeG6);
			}
			if (log.isDebugEnabled()) {
				log.debug("Add file [" + QbLLBqmb.getPath() + "] -> [" + yRfVSeG6.getPath() + "]");
			}
			return yRfVSeG6;
		}
		return QbLLBqmb;
	}

}