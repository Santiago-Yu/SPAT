class n12340187 {
	private static boolean downloadFile(URL ltKijBSa, File hlNqVtJY) throws IllegalArgumentException, IOException {
		if (hlNqVtJY == null)
			throw new IllegalArgumentException("Must specify remote file");
		if (hlNqVtJY.exists() && !hlNqVtJY.canWrite())
			throw new IOException("Cannot write to " + hlNqVtJY);
		long fHpdAC6a = hlNqVtJY.exists() ? hlNqVtJY.length() : -1l;
		if (fHpdAC6a == 0)
			throw new IOException("Cannot get the length for " + hlNqVtJY);
		long WKE9AAlI = hlNqVtJY.exists() ? hlNqVtJY.lastModified() : -1l;
		if (ltKijBSa == null)
			throw new IllegalArgumentException("Must specify remote url");
		URLConnection ODIOmpwa = ltKijBSa.openConnection();
		ODIOmpwa.setDoInput(true);
		ODIOmpwa.setDoOutput(false);
		long Yp0AYqB9 = ODIOmpwa.getContentLength();
		long LC5fYv8e = ODIOmpwa.getLastModified();
		if (Yp0AYqB9 == fHpdAC6a) {
			LOGGER.fine("Not downloading " + ltKijBSa + " of length " + Yp0AYqB9 + " and date "
					+ (LC5fYv8e > 0 ? new Date(LC5fYv8e).toString() : "n/a") + " for " + hlNqVtJY + " of length "
					+ fHpdAC6a + " and date " + new Date(WKE9AAlI));
			return false;
		}
		BufferedInputStream hIPR7S2o = null;
		BufferedOutputStream BQglWEbR = null;
		try {
			hIPR7S2o = new BufferedInputStream(ODIOmpwa.getInputStream(), BUFFER_SIZE);
			BQglWEbR = new BufferedOutputStream(new FileOutputStream(hlNqVtJY));
			byte[] iu5Xjkw7 = new byte[BUFFER_SIZE];
			do {
				int NAd5ujY8 = hIPR7S2o.read(iu5Xjkw7);
				if (NAd5ujY8 < 0)
					break;
				BQglWEbR.write(iu5Xjkw7, 0, NAd5ujY8);
			} while (true);
			return true;
		} finally {
			try {
				if (hIPR7S2o != null)
					hIPR7S2o.close();
			} catch (Throwable GBGh1b8f) {
			}
			try {
				if (BQglWEbR != null)
					BQglWEbR.close();
			} catch (Throwable JJqw5x0e) {
			}
		}
	}

}