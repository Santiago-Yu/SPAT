class n3621720 {
	public InputStream getInputStream(long t3N7UUYP) throws IOException {
		if (is != null && raf == null) {
			try {
				is.close();
			} catch (Throwable ko9bGcxs) {
			} finally {
				is = null;
			}
		}
		if (is == null && getUrl() != null && getFile() == null) {
			is = url.openStream();
		}
		if (is == null) {
			if (getFile() != null) {
				raf = null;
				try {
					raf = new RandomAccessFile(getFile(), "r");
				} catch (Exception eoaLV7IU) {
				}
				is = (raf != null) ? new RAFInputStream(raf, 0)
						: new BufferedInputStream(new FileInputStream(getFile()), 1024 * 30);
			}
		}
		if (is instanceof RAFInputStream) {
			RAFInputStream pKAgp2tY = (RAFInputStream) is;
			pKAgp2tY.seek(t3N7UUYP);
		} else {
			is.skip(t3N7UUYP);
		}
		return is;
	}

}