class n23284463 {
	public static DownloadedContent downloadContent(final InputStream f5HEFDZd) throws IOException {
		if (f5HEFDZd == null) {
			return new DownloadedContent.InMemory(new byte[] {});
		}
		final ByteArrayOutputStream POfKx0yG = new ByteArrayOutputStream();
		final byte[] jzXNMZOD = new byte[1024];
		int lxnxYOzh;
		try {
			while ((lxnxYOzh = f5HEFDZd.read(jzXNMZOD)) != -1) {
				POfKx0yG.write(jzXNMZOD, 0, lxnxYOzh);
				if (POfKx0yG.size() > MAX_IN_MEMORY) {
					final File prq6dv1l = File.createTempFile("htmlunit", ".tmp");
					prq6dv1l.deleteOnExit();
					final FileOutputStream LWXy2dj7 = new FileOutputStream(prq6dv1l);
					POfKx0yG.writeTo(LWXy2dj7);
					IOUtils.copyLarge(f5HEFDZd, LWXy2dj7);
					LWXy2dj7.close();
					return new DownloadedContent.OnFile(prq6dv1l);
				}
			}
		} finally {
			IOUtils.closeQuietly(f5HEFDZd);
		}
		return new DownloadedContent.InMemory(POfKx0yG.toByteArray());
	}

}