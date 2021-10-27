class n14770729 {
	public static boolean joinFiles(File dest, Collection<File> sources) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		byte[] buf = new byte[1000000];
		boolean rv = false;
		if (!dest.getParentFile().exists())
			dest.getParentFile().mkdirs();
		int bytesRead = 0;
		try {
			fos = new FileOutputStream(dest);
			for (File source : sources) {
				fis = new FileInputStream(source);
				while ((bytesRead = fis.read(buf)) > 0)
					fos.write(buf, 0, bytesRead);
				fis.close();
				fis = null;
			}
			fos.close();
			rv = true;
			fos = null;
		} catch (Throwable t) {
			throw new ApplicationException("error joining files to " + dest.getAbsolutePath(), t);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
				}
				fis = null;
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
				fos = null;
			}
		}
		return rv;
	}

}