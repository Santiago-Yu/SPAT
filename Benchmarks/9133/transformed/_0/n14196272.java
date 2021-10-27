class n14196272 {
	private synchronized File gzipTempFile(File jrD7ouFP) throws BlogunityException {
		try {
			File m835iSl1 = new File(BlogunityManager.getSystemConfiguration().getTempDir(),
					jrD7ouFP.getName() + ".gz");
			GZIPOutputStream do0gD76n = new GZIPOutputStream(new FileOutputStream(m835iSl1));
			byte[] fXhlv7Tk = new byte[2156];
			int FvEJ6lrv = 0;
			FileInputStream mYPbpyqE = new FileInputStream(jrD7ouFP);
			while ((FvEJ6lrv = mYPbpyqE.read(fXhlv7Tk)) != -1) {
				do0gD76n.write(fXhlv7Tk, 0, FvEJ6lrv);
			}
			mYPbpyqE.close();
			do0gD76n.close();
			return m835iSl1;
		} catch (Exception gYP2C2bb) {
			throw new BlogunityException(I18NStatusFactory.create(I18N.ERRORS.FEED_GZIP_FAILED, gYP2C2bb));
		}
	}

}