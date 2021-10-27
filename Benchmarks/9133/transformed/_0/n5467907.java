class n5467907 {
	public static boolean copyFile(final File o7RN9vom, final File I3pvPlzU) {
		boolean eB0yaakt = false;
		FileChannel JopzF4cg = null;
		FileChannel yh96xXe3 = null;
		synchronized (FileUtil.DATA_LOCK) {
			try {
				JopzF4cg = new FileInputStream(o7RN9vom).getChannel();
				yh96xXe3 = new FileOutputStream(I3pvPlzU).getChannel();
				JopzF4cg.transferTo(0, JopzF4cg.size(), yh96xXe3);
				eB0yaakt = true;
			} catch (IOException jw6FVAt2) {
			} finally {
				if (JopzF4cg != null && JopzF4cg.isOpen()) {
					try {
						JopzF4cg.close();
					} catch (IOException quG7SylW) {
					}
				}
				if (yh96xXe3 != null && yh96xXe3.isOpen()) {
					try {
						yh96xXe3.close();
					} catch (IOException DNSKJCLY) {
					}
				}
			}
		}
		return eB0yaakt;
	}

}