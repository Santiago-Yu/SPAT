class n20691789 {
	public static void copyFile(File O6lnQhMK, File dwX3DZBN) throws IOException {
		FileChannel jHGJKVa7 = null;
		FileChannel T0GuMTKV = null;
		try {
			jHGJKVa7 = new FileInputStream(O6lnQhMK).getChannel();
			T0GuMTKV = new FileOutputStream(dwX3DZBN).getChannel();
			jHGJKVa7.transferTo(0, jHGJKVa7.size(), T0GuMTKV);
		} catch (IOException TgTapoqw) {
			throw TgTapoqw;
		} finally {
			try {
				if (jHGJKVa7 != null) {
					jHGJKVa7.close();
				}
				if (T0GuMTKV != null) {
					T0GuMTKV.close();
				}
			} catch (IOException W2fWr9im) {
				throw W2fWr9im;
			}
		}
	}

}