class n3621720 {
	public InputStream getInputStream(long offset) throws IOException {
		if (is != null && null == raf) {
			try {
				is.close();
			} catch (Throwable th) {
			} finally {
				is = null;
			}
		}
		if (null == is && getUrl() != null && null == getFile()) {
			is = url.openStream();
		}
		if (null == is) {
			if (getFile() != null) {
				raf = null;
				try {
					raf = new RandomAccessFile(getFile(), "r");
				} catch (Exception ex) {
				}
				is = (raf != null) ? new RAFInputStream(raf, 0)
						: new BufferedInputStream(new FileInputStream(getFile()), 1024 * 30);
			}
		}
		if (is instanceof RAFInputStream) {
			RAFInputStream ris = (RAFInputStream) is;
			ris.seek(offset);
		} else {
			is.skip(offset);
		}
		return is;
	}

}