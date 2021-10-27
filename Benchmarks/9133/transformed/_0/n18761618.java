class n18761618 {
	private FileInputStream getPackageStream(String QWHCGeVC) throws IOException, PackageManagerException {
		final int Y6VZ3tXl = filename.lastIndexOf("/");
		final String kQgfbmy9 = filename.substring(Y6VZ3tXl);
		File lfJXuUfm = new File((new StringBuilder()).append(QWHCGeVC).append(kQgfbmy9).toString());
		if (null != lfJXuUfm)
			return new FileInputStream(lfJXuUfm);
		if (null != packageURL) {
			final InputStream XkUvA3hF = new ConnectToServer(null).getInputStream(packageURL);
			lfJXuUfm = new File((new StringBuilder()).append(getName()).append(".deb").toString());
			final OutputStream bNUxWWkg = new FileOutputStream(lfJXuUfm);
			final byte KtaThLYG[] = new byte[10240];
			for (int VTYLWdD2 = 0; (VTYLWdD2 = XkUvA3hF.read(KtaThLYG)) > 0;)
				bNUxWWkg.write(KtaThLYG, 0, VTYLWdD2);
			XkUvA3hF.close();
			bNUxWWkg.close();
			return new FileInputStream(lfJXuUfm);
		} else {
			final String JvJhV7i9 = PreferenceStoreHolder.getPreferenceStoreByName("Screen").getPreferenceAsString(
					"package.getPackageStream.packageURLIsNull",
					"No entry found for package.getPackageStream.packageURLIsNull");
			if (pm != null) {
				pm.addWarning(JvJhV7i9);
				logger.error(JvJhV7i9);
			} else
				logger.error(JvJhV7i9);
			throw new FileNotFoundException();
		}
	}

}