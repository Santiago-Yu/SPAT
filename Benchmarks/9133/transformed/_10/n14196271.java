class n14196271 {
	private synchronized File zipTempFile(File tempFile) throws BlogunityException {
		try {
			File zippedFile = new File(BlogunityManager.getSystemConfiguration().getTempDir(),
					tempFile.getName() + ".zip");
			byte[] readBuffer = new byte[2156];
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zippedFile));
			FileInputStream fis = new FileInputStream(tempFile);
			int bytesIn = 0;
			ZipEntry anEntry = new ZipEntry(tempFile.getName());
			zos.putNextEntry(anEntry);
			while ((bytesIn = fis.read(readBuffer)) != -1) {
				zos.write(readBuffer, 0, bytesIn);
			}
			fis.close();
			zos.close();
			return zippedFile;
		} catch (Exception e) {
			throw new BlogunityException(I18NStatusFactory.create(I18N.ERRORS.FEED_ZIP_FAILED, e));
		}
	}

}