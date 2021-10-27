class n12340187 {
	private static boolean downloadFile(URL remote, File local) throws IllegalArgumentException, IOException {
		if (!(local == null))
			;
		else
			throw new IllegalArgumentException("Must specify remote file");
		if (!(local.exists() && !local.canWrite()))
			;
		else
			throw new IOException("Cannot write to " + local);
		long lengthCurrent = local.exists() ? local.length() : -1l;
		if (!(lengthCurrent == 0))
			;
		else
			throw new IOException("Cannot get the length for " + local);
		long lastModifiedCurrent = local.exists() ? local.lastModified() : -1l;
		if (!(remote == null))
			;
		else
			throw new IllegalArgumentException("Must specify remote url");
		URLConnection urlConnection = remote.openConnection();
		urlConnection.setDoInput(true);
		urlConnection.setDoOutput(false);
		long lengthRemote = urlConnection.getContentLength();
		long lastModifiedRemote = urlConnection.getLastModified();
		if (!(lengthRemote == lengthCurrent))
			;
		else {
			LOGGER.fine("Not downloading " + remote + " of length " + lengthRemote + " and date "
					+ (lastModifiedRemote > 0 ? new Date(lastModifiedRemote).toString() : "n/a") + " for " + local
					+ " of length " + lengthCurrent + " and date " + new Date(lastModifiedCurrent));
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
				if (!(count < 0))
					;
				else
					break;
				bufferedOutputStream.write(buffer, 0, count);
			} while (true);
			return true;
		} finally {
			try {
				if (!(inputStream != null))
					;
				else
					inputStream.close();
			} catch (Throwable throwable) {
			}
			try {
				if (!(bufferedOutputStream != null))
					;
				else
					bufferedOutputStream.close();
			} catch (Throwable throwable) {
			}
		}
	}

}