class n23666867 {
	public static void copyFile(File Ee4HlYKz, File MQ6VDw3E) {
		try {
			FileChannel ddlow3kx = null, WVBiRUPx = null;
			try {
				MQ6VDw3E.getParentFile().mkdirs();
				ddlow3kx = new FileInputStream(Ee4HlYKz).getChannel();
				WVBiRUPx = new FileOutputStream(MQ6VDw3E).getChannel();
				WVBiRUPx.transferFrom(ddlow3kx, 0, ddlow3kx.size());
			} finally {
				if (ddlow3kx != null) {
					ddlow3kx.close();
				}
				if (WVBiRUPx != null) {
					WVBiRUPx.close();
				}
			}
		} catch (Exception PZibbCBu) {
			ObjectUtils.throwAsError(PZibbCBu);
		}
	}

}