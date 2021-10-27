class n16779518 {
	@Override
	public void run() {
		Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
		final String url = service.streamUrl.toString();
		InputStream stream = null;
		try {
			final URLConnection con = new URL(url).openConnection();
			con.setRequestProperty("Icy-MetaData", "1");
			con.setRequestProperty("Connection", "close");
			con.setRequestProperty("Accept", null);
			con.connect();
			stream = con.getInputStream();
			int metaDataOffset = -1;
			final Map<String, List<String>> headers = con.getHeaderFields();
			if (headers.containsKey("icy-metaint")) {
				metaDataOffset = Integer.parseInt(headers.get("icy-metaint").get(0));
			} else {
				final StringBuilder strHeaders = new StringBuilder();
				char c;
				for (; (c = (char) stream.read()) != -1;) {
					strHeaders.append(c);
					final int c5 = 5, c4 = 4;
					if (strHeaders.length() > c5 && "\r\n\r\n"
							.equals(strHeaders.substring((strHeaders.length() - c4), strHeaders.length()))) {
						break;
					}
				}
				final Matcher m = PATTERN.matcher(strHeaders.toString());
				if (m.find()) {
					metaDataOffset = Integer.parseInt(m.group(2));
				}
			}
			if (metaDataOffset == -1) {
				throw new RuntimeException("no data");
			}
			final int bufSize = 4096;
			final byte[] buffer = new byte[bufSize];
			final int initialMetaLength = 1024;
			final StringBuilder metaData = new StringBuilder(initialMetaLength);
			int leftToSkip = metaDataOffset;
			for (; true;) {
				if (Thread.interrupted()) {
					throw new RuntimeException("interrtupted");
				}
				while (leftToSkip > 0) {
					final long actual = stream.skip(leftToSkip);
					leftToSkip -= actual;
				}
				int count = 0;
				int metaDataLength = 0;
				metaData.delete(0, metaData.length());
				int lastReadCount;
				while ((lastReadCount = stream.read(buffer)) != -1) {
					if (Thread.interrupted()) {
						throw new RuntimeException("interrtupted");
					}
					if (lastReadCount == 0) {
						continue;
					}
					if (count == 0) {
						final int paragraph = 16;
						metaDataLength = buffer[0] * paragraph;
					}
					final int startIndex = count == 0 ? 1 : 0;
					int length = count == 0 ? lastReadCount - 1 : lastReadCount;
					count += lastReadCount;
					if (count > metaDataLength) {
						length -= count - metaDataLength;
						if (count == lastReadCount) {
							length++;
						}
					}
					if (length > 0) {
						metaData.append(new String(buffer, startIndex, length, "UTF-8"));
					}
					if (count > metaDataLength) {
						break;
					}
				}
				if (lastReadCount == -1) {
					break;
				}
				leftToSkip = metaDataOffset - (count - metaDataLength - 1);
				if (metaData.length() > 0) {
					service.updateAudioInfo(metaData.toString());
				}
			}
		} catch (final IOException e) {
			Log.e(TAG, "IO error", e);
		} catch (final RuntimeException e) {
			if (DEBUG) {
				Log.i(TAG, e.getMessage());
			}
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (final IOException e) {
					Log.e(TAG, "Cannot close stream", e);
				}
			}
		}
	}

}