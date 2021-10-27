class n14196272 {
	private synchronized File gzipTempFile(File tempFile) throws BlogunityException {
		try {
			File gzippedFile = new File(BlogunityManager.getSystemConfiguration().getTempDir(),
					tempFile.getName() + ".gz");
			byte[] readBuffer = new byte[2156];
			GZIPOutputStream zos = new GZIPOutputStream(new FileOutputStream(gzippedFile));
			FileInputStream fis = new FileInputStream(tempFile);
			int bytesIn = 0;
			while ((bytesIn = fis.read(readBuffer)) != -1) {
				zos.write(readBuffer, 0, bytesIn);
			}
			fis.close();
			zos.close();
			return gzippedFile;
		} catch (Exception e) {
			throw new BlogunityException(I18NStatusFactory.create(I18N.ERRORS.FEED_GZIP_FAILED, e));
		}
	}

}