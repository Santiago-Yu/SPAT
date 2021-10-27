class n3621720 {
	public InputStream getInputStream(long offset) throws IOException {
		if (is != null && raf == null) {
			try {
				is.close();
			} catch (Throwable th) {
			} finally {
				is = null;
			}
		}
		is = (is == null && getUrl() != null && getFile() == null) ? url.openStream() : is;
		if (is == null) {
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