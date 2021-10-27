class n14196271 {
	private synchronized File zipTempFile(File Du1LNhYQ) throws BlogunityException {
		try {
			File xCE1svep = new File(BlogunityManager.getSystemConfiguration().getTempDir(),
					Du1LNhYQ.getName() + ".zip");
			ZipOutputStream HLFALDIE = new ZipOutputStream(new FileOutputStream(xCE1svep));
			byte[] zbR7hf4s = new byte[2156];
			int z2kZeaic = 0;
			FileInputStream Z4sRIBzt = new FileInputStream(Du1LNhYQ);
			ZipEntry r5ACiTyY = new ZipEntry(Du1LNhYQ.getName());
			HLFALDIE.putNextEntry(r5ACiTyY);
			while ((z2kZeaic = Z4sRIBzt.read(zbR7hf4s)) != -1) {
				HLFALDIE.write(zbR7hf4s, 0, z2kZeaic);
			}
			Z4sRIBzt.close();
			HLFALDIE.close();
			return xCE1svep;
		} catch (Exception HTc1wEA2) {
			throw new BlogunityException(I18NStatusFactory.create(I18N.ERRORS.FEED_ZIP_FAILED, HTc1wEA2));
		}
	}

}