class n11265072 {
	public static void unzip(File sourceZipFile, File unzipDestinationDirectory, FileFilter filter) throws IOException {
		unzipDestinationDirectory.mkdirs();
		ZipFile zipFile;
		if (!unzipDestinationDirectory.exists()) {
			throw new IOException("Unable to create destination directory: " + unzipDestinationDirectory);
		}
		zipFile = new ZipFile(sourceZipFile, ZipFile.OPEN_READ);
		Enumeration<? extends ZipEntry> zipFileEntries = zipFile.entries();
		while (zipFileEntries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
			if (!entry.isDirectory()) {
				String currentEntry = entry.getName();
				File destFile = new File(unzipDestinationDirectory, currentEntry);
				if (filter == null || filter.accept(destFile)) {
					File destinationParent = destFile.getParentFile();
					destinationParent.mkdirs();
					FileOutputStream fos = new FileOutputStream(destFile);
					BufferedInputStream is = new BufferedInputStream(zipFile.getInputStream(entry));
					IOUtils.copyLarge(is, fos);
					fos.flush();
					IOUtils.closeQuietly(fos);
				}
			}
		}
		zipFile.close();
	}

}