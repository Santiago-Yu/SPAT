class n6867571 {
	public void run() {
		synchronized (stateLock) {
			if (started) {
				return;
			} else {
				started = true;
				running = true;
			}
		}
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		BufferedReader br = null;
		try {
			checkState();
			progressString = "Opening connection to remote resource";
			progressUpdated = true;
			final URLConnection link;
			try {
				link = url.openConnection();
				link.connect();
			} catch (Exception e) {
				progressString = "Failed to open connection to remote resource";
				progressUpdated = true;
				throw e;
			}
			checkState();
			progressString = "Getting length of remote resource";
			progressUpdated = true;
			final int length = link.getContentLength();
			synchronized (lengthLock) {
				totalLength = length;
			}
			progressUpdated = true;
			checkState();
			progressString = "Opening input stream to remote resource";
			progressUpdated = true;
			try {
				final InputStream input = link.getInputStream();
				if (target instanceof File) {
					bis = new BufferedInputStream(input);
				} else if (target instanceof StringBuilder) {
					final String contentType = link.getContentType().toLowerCase(Locale.ENGLISH);
					String charset = null;
					final Matcher m = Pattern.compile(".*charset[\\s]*=([^;]++).*").matcher(contentType);
					if (m.find()) {
						charset = m.group(1).trim();
					}
					if ((charset != null) && !charset.isEmpty()) {
						try {
							br = new BufferedReader(new InputStreamReader(input, charset));
						} catch (Exception e) {
							br = null;
						}
					}
					if (null == br) {
						br = new BufferedReader(new InputStreamReader(input));
					}
				}
			} catch (Exception e) {
				progressString = "Failed to open input stream to remote resource";
				progressUpdated = true;
				throw e;
			}
			if (target instanceof File) {
				checkState();
				progressString = "Opening output stream to local file";
				progressUpdated = true;
				try {
					final File f = (File) target;
					final File parent = f.getParentFile();
					if ((parent != null) && !parent.exists()) {
						parent.mkdirs();
					}
					bos = new BufferedOutputStream(new FileOutputStream(f));
				} catch (Exception e) {
					progressString = "Failed to open output stream to local file";
					progressUpdated = true;
					throw e;
				}
			}
			progressString = "Downloading";
			progressUpdated = true;
			try {
				if (target instanceof File) {
					final byte[] byteBuffer = new byte[BUFFER_SIZE];
					while (true) {
						checkState();
						final int byteCount = bis.read(byteBuffer, 0, BUFFER_SIZE);
						if (-1 == byteCount) {
							break;
						}
						bos.write(byteBuffer, 0, byteCount);
						synchronized (lengthLock) {
							downloadedLength += byteCount;
						}
						progressUpdated = true;
					}
				} else if (target instanceof StringBuilder) {
					final char[] charBuffer = new char[BUFFER_SIZE];
					final StringBuilder sb = (StringBuilder) target;
					while (true) {
						checkState();
						final int charCount = br.read(charBuffer, 0, BUFFER_SIZE);
						if (-1 == charCount) {
							break;
						}
						sb.append(charBuffer, 0, charCount);
						synchronized (lengthLock) {
							downloadedLength += charCount;
						}
						progressUpdated = true;
					}
				}
			} catch (Exception e) {
				progressString = "Failed to download remote resource";
				progressUpdated = true;
				throw e;
			}
			progressString = "Download completed";
			progressUpdated = true;
		} catch (Exception e) {
			error = e;
		} finally {
			for (Closeable c : new Closeable[] { bis, br, bos }) {
				if (c != null) {
					try {
						c.close();
					} catch (Exception e) {
					}
				}
			}
			synchronized (stateLock) {
				running = false;
				completed = true;
			}
		}
	}

}