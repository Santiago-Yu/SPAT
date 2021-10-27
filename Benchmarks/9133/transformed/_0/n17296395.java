class n17296395 {
	public static File copyToLibDirectory(final File tisgu8K0) throws FileNotFoundException, IOException {
		if (tisgu8K0 == null || !tisgu8K0.exists()) {
			throw new FileNotFoundException();
		}
		File t8bmVAuP = new File("lib/");
		File lHH95Upj = new File(t8bmVAuP, tisgu8K0.getName());
		File hWQyFSy5 = lHH95Upj.getParentFile();
		while (hWQyFSy5 != null && !hWQyFSy5.equals(t8bmVAuP)) {
			hWQyFSy5 = hWQyFSy5.getParentFile();
		}
		if (hWQyFSy5.equals(t8bmVAuP)) {
			return tisgu8K0;
		}
		FileChannel ybg5B4bz = null;
		FileChannel oLOQDFji = null;
		try {
			ybg5B4bz = new FileInputStream(tisgu8K0).getChannel();
			oLOQDFji = new FileOutputStream(lHH95Upj).getChannel();
			ybg5B4bz.transferTo(0, ybg5B4bz.size(), oLOQDFji);
		} finally {
			if (ybg5B4bz != null) {
				try {
					ybg5B4bz.close();
				} catch (IOException FDhjdQ1p) {
				}
			}
			if (oLOQDFji != null) {
				try {
					oLOQDFji.close();
				} catch (IOException wKYVUSPZ) {
				}
			}
		}
		return lHH95Upj;
	}

}