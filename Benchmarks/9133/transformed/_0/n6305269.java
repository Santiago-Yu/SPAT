class n6305269 {
	protected void copyFile(File axWIBnpL, File jgDtAQVo) {
		FileChannel KQuwNIwt = null;
		FileChannel WKzLguhD = null;
		try {
			if (!verifyOrCreateParentPath(jgDtAQVo.getParentFile())) {
				throw new IOException("Parent directory path " + jgDtAQVo.getAbsolutePath()
						+ " did not exist and could not be created");
			}
			if (jgDtAQVo.exists() || jgDtAQVo.createNewFile()) {
				KQuwNIwt = new FileInputStream(axWIBnpL).getChannel();
				WKzLguhD = new FileOutputStream(jgDtAQVo).getChannel();
				KQuwNIwt.transferTo(0, KQuwNIwt.size(), WKzLguhD);
			} else {
				throw new IOException("Couldn't create file for " + jgDtAQVo.getAbsolutePath());
			}
		} catch (IOException YbSi638t) {
			if (jgDtAQVo.exists() && jgDtAQVo.length() < axWIBnpL.length()) {
				jgDtAQVo.delete();
			}
			YbSi638t.printStackTrace();
		} finally {
			try {
				KQuwNIwt.close();
			} catch (Throwable p3q6acSu) {
			}
			try {
				WKzLguhD.close();
			} catch (Throwable XXA73sLy) {
			}
			jgDtAQVo.setLastModified(axWIBnpL.lastModified());
		}
	}

}