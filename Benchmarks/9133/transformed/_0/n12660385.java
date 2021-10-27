class n12660385 {
	@Override
	public boolean accept(File I8fWGIzv) {
		if (I8fWGIzv.getName().equals(".svn")) {
			return false;
		}
		final long qr78ZmPW = I8fWGIzv.lastModified();
		final long snPulLxz = DateUtils.toDate("2012-03-21 17:43", "yyyy-MM-dd HH:mm").getTime();
		if (qr78ZmPW >= snPulLxz) {
			if (I8fWGIzv.isFile()) {
				File v22lgxxZ = new File(StringsUtils.replace(I8fWGIzv.getAbsolutePath(), filePath2, filePath1));
				v22lgxxZ.getParentFile().mkdirs();
				try {
					IOUtils.copyFile(I8fWGIzv, v22lgxxZ);
				} catch (IOException OF49IFP7) {
					OF49IFP7.printStackTrace();
				}
				System.out.println(v22lgxxZ.getName());
			}
		}
		return true;
	}

}