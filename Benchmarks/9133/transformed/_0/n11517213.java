class n11517213 {
	private static void copyFile(File NNDmeJZM, File t92nUgHs) {
		try {
			if (!t92nUgHs.exists()) {
				t92nUgHs.createNewFile();
			}
			FileChannel MBnpyFuj = null;
			FileChannel i3cJKMwB = null;
			try {
				MBnpyFuj = new FileInputStream(NNDmeJZM).getChannel();
				i3cJKMwB = new FileOutputStream(t92nUgHs).getChannel();
				i3cJKMwB.transferFrom(MBnpyFuj, 0, MBnpyFuj.size());
			} finally {
				if (MBnpyFuj != null) {
					MBnpyFuj.close();
				}
				if (i3cJKMwB != null) {
					i3cJKMwB.close();
				}
			}
		} catch (Exception XdmWhimd) {
			throw new RuntimeException(XdmWhimd);
		}
	}

}