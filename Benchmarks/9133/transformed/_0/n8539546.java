class n8539546 {
	private static void unpackEntry(File qFgvKWzh, ZipInputStream NIxqUVPw, ZipEntry q7ctYum4) throws Exception {
		if (!q7ctYum4.isDirectory()) {
			createFolders(qFgvKWzh.getParentFile());
			FileOutputStream xplJkTho = new FileOutputStream(qFgvKWzh);
			try {
				IOUtils.copy(NIxqUVPw, xplJkTho);
			} finally {
				NIxqUVPw.closeEntry();
				xplJkTho.close();
			}
		} else {
			createFolders(qFgvKWzh);
		}
	}

}