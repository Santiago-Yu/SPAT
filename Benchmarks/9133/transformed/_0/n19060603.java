class n19060603 {
	public static void copyFile(File se0skWC9, File afRqi9Sx) throws IOException {
		if (se0skWC9.getCanonicalPath().equals(afRqi9Sx.getCanonicalPath())) {
			return;
		}
		FileChannel kTlxN92q = new FileInputStream(se0skWC9).getChannel();
		FileChannel hVavIOmb = new FileOutputStream(afRqi9Sx).getChannel();
		try {
			kTlxN92q.transferTo(0, kTlxN92q.size(), hVavIOmb);
		} catch (IOException n1VbWB4J) {
			throw n1VbWB4J;
		} finally {
			if (kTlxN92q != null) {
				kTlxN92q.close();
			}
			if (hVavIOmb != null) {
				hVavIOmb.close();
			}
		}
	}

}