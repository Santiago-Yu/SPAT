class n17079357 {
	public static void copyFile(File PnSQCxWF, String FVHJ20AH) throws IOException {
		if (!isCanReadFile(PnSQCxWF))
			throw new RuntimeException("The File can't read:" + PnSQCxWF.getPath());
		if (!isCanWriteDirectory(FVHJ20AH))
			throw new RuntimeException("The Directory can't write:" + FVHJ20AH);
		FileChannel o2HRy6G0 = null;
		FileChannel cG22GGYc = null;
		try {
			o2HRy6G0 = new FileInputStream(PnSQCxWF).getChannel();
			cG22GGYc = new FileOutputStream(FVHJ20AH + "/" + PnSQCxWF.getName()).getChannel();
			cG22GGYc.transferFrom(o2HRy6G0, 0, o2HRy6G0.size());
		} catch (IOException YXt4SH5w) {
			throw YXt4SH5w;
		} finally {
			if (o2HRy6G0 != null)
				try {
					o2HRy6G0.close();
				} catch (IOException PK3Qdycf) {
				}
			if (cG22GGYc != null)
				try {
					cG22GGYc.close();
				} catch (IOException kzjlqs7r) {
				}
		}
	}

}