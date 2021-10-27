class n1951103 {
	private List<File> ungzipFile(File directory, File compressedFile) throws IOException {
		TarArchiveInputStream in = new TarArchiveInputStream(new GZIPInputStream(new FileInputStream(compressedFile)));
		List<File> files = new ArrayList<File>();
		try {
			TarArchiveEntry entry = in.getNextTarEntry();
			while (entry != null) {
				if (entry.isDirectory()) {
					log.warn("TAR archive contains directories which are being ignored");
					entry = in.getNextTarEntry();
					continue;
				}
				String fn = new File(entry.getName()).getName();
				if (fn.startsWith(".")) {
					log.warn("TAR archive contains a hidden file which is being ignored");
					entry = in.getNextTarEntry();
					continue;
				}
				File targetFile = new File(directory, fn);
				if (targetFile.exists()) {
					log.warn("TAR archive contains duplicate filenames, only the first is being extracted");
					entry = in.getNextTarEntry();
					continue;
				}
				files.add(targetFile);
				log.debug("Extracting file: " + entry.getName() + " to: " + targetFile.getAbsolutePath());
				InputStream entryIn = new FileInputStream(entry.getFile());
				OutputStream fout = new BufferedOutputStream(new FileOutputStream(targetFile));
				IOUtils.copy(entryIn, fout);
				fout.close();
				entryIn.close();
			}
		} finally {
			in.close();
		}
		return files;
	}

}