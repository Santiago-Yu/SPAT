class n13955716 {
	public static void copier(final File xqhm5FNF, final File oa8VM3us) {
		FileChannel G39Bi0KT = null;
		FileChannel juD0ADX9 = null;
		try {
			G39Bi0KT = new FileInputStream(xqhm5FNF).getChannel();
			juD0ADX9 = new FileOutputStream(oa8VM3us).getChannel();
			G39Bi0KT.transferTo(0, G39Bi0KT.size(), juD0ADX9);
		} catch (Exception yuiDsxoF) {
			yuiDsxoF.printStackTrace();
		} finally {
			if (G39Bi0KT != null) {
				try {
					G39Bi0KT.close();
				} catch (IOException Z1ZZYUVj) {
				}
			}
			if (juD0ADX9 != null) {
				try {
					juD0ADX9.close();
				} catch (IOException FIr9jpTQ) {
				}
			}
		}
	}

}