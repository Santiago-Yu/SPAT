class n12660384 {
	public static void main(String[] vpueSZBo) {
		final String JuppGBIU = "e:\\mysite\\data\\up\\itsite";
		final String k1KgiIOX = "d:\\works\\itsite\\itsite";
		IOUtils.listAllFilesNoRs(new File(k1KgiIOX), new FileFilter() {

			@Override
			public boolean accept(File dddUSgKY) {
				if (dddUSgKY.getName().equals(".svn")) {
					return false;
				}
				final long BcfXREfu = dddUSgKY.lastModified();
				final long rnqrzL6J = DateUtils.toDate("2012-03-21 17:43", "yyyy-MM-dd HH:mm").getTime();
				if (BcfXREfu >= rnqrzL6J) {
					if (dddUSgKY.isFile()) {
						File bDEk2Bvc = new File(StringsUtils.replace(dddUSgKY.getAbsolutePath(), k1KgiIOX, JuppGBIU));
						bDEk2Bvc.getParentFile().mkdirs();
						try {
							IOUtils.copyFile(dddUSgKY, bDEk2Bvc);
						} catch (IOException buuS5pwv) {
							buuS5pwv.printStackTrace();
						}
						System.out.println(bDEk2Bvc.getName());
					}
				}
				return true;
			}
		});
	}

}