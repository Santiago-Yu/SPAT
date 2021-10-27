class n13824827 {
	public static void copyFile(File XWx6avf2, File g124IXeM) {
		if (!XWx6avf2.exists()) {
			return;
		}
		if ((g124IXeM.getParentFile() != null) && (!g124IXeM.getParentFile().exists())) {
			g124IXeM.getParentFile().mkdirs();
		}
		try {
			FileChannel n0rmLO1T = new FileInputStream(XWx6avf2).getChannel();
			FileChannel ScaZ85xb = new FileOutputStream(g124IXeM).getChannel();
			ScaZ85xb.transferFrom(n0rmLO1T, 0, n0rmLO1T.size());
			n0rmLO1T.close();
			ScaZ85xb.close();
		} catch (IOException Q1KDHkOm) {
			Q1KDHkOm.printStackTrace();
		}
	}

}