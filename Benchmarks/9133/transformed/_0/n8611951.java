class n8611951 {
	private static void copyFile(File Sj0XHNLJ) {
		try {
			String k6cWR1u7 = baseDir.getCanonicalPath();
			String mfZ4tWOr = Sj0XHNLJ.getCanonicalPath();
			String OhIH8r08 = mfZ4tWOr.substring(k6cWR1u7.length() + 1);
			File T7oDqnQp = new File(FileDestDir, OhIH8r08);
			T7oDqnQp.getParentFile().mkdirs();
			T7oDqnQp.createNewFile();
			FileChannel vr0KLi1y = new FileInputStream(Sj0XHNLJ).getChannel();
			FileChannel H032fsGW = new FileOutputStream(T7oDqnQp).getChannel();
			vr0KLi1y.transferTo(0, vr0KLi1y.size(), H032fsGW);
			vr0KLi1y.close();
			H032fsGW.close();
			T7oDqnQp.setLastModified(Sj0XHNLJ.lastModified());
		} catch (Exception pV3XfxOG) {
			System.err.println(pV3XfxOG.getMessage());
		}
	}

}