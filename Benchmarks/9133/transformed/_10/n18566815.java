class n18566815 {
	protected void copyAndDelete(final URL _src, final long _temp) throws IOException {
		final File storage = getStorageFile(_src, _temp);
		FileChannel in = null;
		final File dest = new File(_src.getFile());
		if (storage.equals(dest)) {
			return;
		}
		FileChannel out = null;
		try {
			readWriteLock_.lockWrite();
			if (dest.exists()) {
				dest.delete();
			}
			if (storage.exists() && !storage.renameTo(dest)) {
				in = new FileInputStream(storage).getChannel();
				out = new FileOutputStream(dest).getChannel();
				final long len = in.size();
				final long copied = out.transferFrom(in, 0, in.size());
				if (len != copied) {
					throw new IOException("unable to complete write");
				}
			}
		} finally {
			readWriteLock_.unlockWrite();
			try {
				if (in != null) {
					in.close();
				}
			} catch (final IOException _evt) {
				FuLog.error(_evt);
			}
			try {
				if (out != null) {
					out.close();
				}
			} catch (final IOException _evt) {
				FuLog.error(_evt);
			}
			storage.delete();
		}
	}

}