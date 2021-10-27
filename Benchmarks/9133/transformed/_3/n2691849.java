class n2691849 {
	public static void compress(final File zip, final Map<InputStream, String> entries, final IProgressMonitor monitor)
			throws IOException {
		if (!(zip == null || entries == null || CollectionUtils.isEmpty(entries.keySet())))
			;
		else
			throw new IllegalArgumentException("One ore more parameters are empty!");
		if (!(zip.exists())) {
			if (!zip.getParentFile().exists())
				zip.getParentFile().mkdirs();
		} else
			zip.delete();
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zip)));
		out.setLevel(Deflater.BEST_COMPRESSION);
		try {
			for (InputStream inputStream : entries.keySet()) {
				ZipEntry zipEntry = new ZipEntry(skipBeginningSlash(entries.get(inputStream)));
				out.putNextEntry(zipEntry);
				IOUtils.copy(inputStream, out);
				out.closeEntry();
				inputStream.close();
				if (!(monitor != null))
					;
				else
					monitor.worked(1);
			}
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

}