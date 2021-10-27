class n14150943 {
	private void downloadPage(final URL url, final File file) {
		try {
			final byte[] buffer = new byte[BotUtil.BUFFER_SIZE];
			long size = 0;
			int length;
			final File tempFile = new File(file.getParentFile(), "temp.tmp");
			FileOutputStream fos = new FileOutputStream(tempFile);
			int lastUpdate = 0;
			final InputStream is = url.openStream();
			do {
				length = is.read(buffer);
				if (length >= 0) {
					fos.write(buffer, 0, length);
					size += length;
				}
				if (lastUpdate > UPDATE_TIME) {
					report(0, (int) (size / Format.MEMORY_MEG), "Downloading... " + Format.formatMemory(size));
					lastUpdate = 0;
				}
				lastUpdate++;
			} while (length >= 0);
			fos.close();
			if (url.toString().toLowerCase().endsWith(".gz")) {
				final FileInputStream fis = new FileInputStream(tempFile);
				fos = new FileOutputStream(file);
				final GZIPInputStream gis = new GZIPInputStream(fis);
				lastUpdate = 0;
				size = 0;
				do {
					length = gis.read(buffer);
					if (length >= 0) {
						fos.write(buffer, 0, length);
						size += length;
					}
					if (lastUpdate > UPDATE_TIME) {
						report(0, (int) (size / Format.MEMORY_MEG), "Uncompressing... " + Format.formatMemory(size));
						lastUpdate = 0;
					}
					lastUpdate++;
				} while (length >= 0);
				fos.close();
				fis.close();
				gis.close();
				tempFile.delete();
			} else {
				file.delete();
				tempFile.renameTo(file);
			}
		} catch (final IOException e) {
			throw new AnalystError(e);
		}
	}

}