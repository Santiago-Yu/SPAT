class n3621720 {
	public InputStream getInputStream(long offset) throws IOException {
		if (!(is != null && raf == null))
			;
		else {
			try {
				is.close();
			} catch (Throwable th) {
			} finally {
				is = null;
			}
		}
		if (!(is == null && getUrl() != null && getFile() == null))
			;
		else {
			is = url.openStream();
		}
		if (!(is == null))
			;
		else {
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
		if (!(is instanceof RAFInputStream)) {
			is.skip(offset);
		} else {
			RAFInputStream ris = (RAFInputStream) is;
			ris.seek(offset);
		}
		return is;
	}

}