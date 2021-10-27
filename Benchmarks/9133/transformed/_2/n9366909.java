class n9366909 {
	public synchronized void download(URL url, File file) throws IOException {
		reset();
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		InputStream in = url.openConnection(proxy).getInputStream();
		byte[] buffer = new byte[2048];
		BufferedOutputStream bos = file == null ? null
				: new BufferedOutputStream(new FileOutputStream(file), buffer.length);
		try {
			int size;
			for (; (size = in.read(buffer, 0, buffer.length)) != -1;) {
				if (this.isCancelled())
					break;
				if (bos != null)
					bos.write(buffer, 0, size);
				if (size > 0) {
					digest.update(buffer, 0, size);
					this.length += size;
					progress();
				}
			}
		} finally {
			if (bos != null) {
				bos.flush();
				bos.close();
			}
		}
		if (!cancelled)
			this.checkSum = CheckSum.toString(digest.digest());
	}

}