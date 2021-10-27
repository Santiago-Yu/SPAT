class n12340187 {
	private static boolean downloadFile(URL remote, File local) throws IllegalArgumentException, IOException {
		if (local == null)
			throw new IllegalArgumentException("Must specify remote file");
		if (local.exists() && !local.canWrite())
			throw new IOException("Cannot write to " + local);
		long lengthCurrent;
		if (local.exists())
			lengthCurrent = local.length();
		else
			lengthCurrent = -1l;
		if (lengthCurrent == 0)
			throw new IOException("Cannot get the length for " + local);
		long lastModifiedCurrent;
		if (local.exists())
			lastModifiedCurrent = local.lastModified();
		else
			lastModifiedCurrent = -1l;
		if (remote == null)
			throw new IllegalArgumentException("Must specify remote url");
		URLConnection urlConnection = remote.openConnection();
		urlConnection.setDoInput(true);
		urlConnection.setDoOutput(false);
		long lengthRemote = urlConnection.getContentLength();
		long lastModifiedRemote = urlConnection.getLastModified();
		if (lengthRemote == lengthCurrent) {
			if (lastModifiedRemote > 0)
				LOGGER.fine("Not downloading " + remote + " of length " + lengthRemote + " and date "
						+ (new Date(lastModifiedRemote).toString()) + " for " + local + " of length " + lengthCurrent
						+ " and date " + new Date(lastModifiedCurrent));
			else
				LOGGER.fine(
						"Not downloading " + remote + " of length " + lengthRemote + " and date " + ("n/a") + " for "
								+ local + " of length " + lengthCurrent + " and date " + new Date(lastModifiedCurrent));
			return false;
		}
		BufferedInputStream inputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			inputStream = new BufferedInputStream(urlConnection.getInputStream(), BUFFER_SIZE);
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(local));
			byte[] buffer = new byte[BUFFER_SIZE];
			do {
				int count = inputStream.read(buffer);
				if (count < 0)
					break;
				bufferedOutputStream.write(buffer, 0, count);
			} while (true);
			return true;
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (Throwable throwable) {
			}
			try {
				if (bufferedOutputStream != null)
					bufferedOutputStream.close();
			} catch (Throwable throwable) {
			}
		}
	}

}