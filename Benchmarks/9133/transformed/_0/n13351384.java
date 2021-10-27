class n13351384 {
	public void copieFichier(String volapsXi, String LdI6mvqd) {
		FileChannel mgFa8SZZ = null;
		FileChannel hMdfxa8h = null;
		try {
			mgFa8SZZ = new FileInputStream(volapsXi).getChannel();
			hMdfxa8h = new FileOutputStream(LdI6mvqd).getChannel();
			mgFa8SZZ.transferTo(0, mgFa8SZZ.size(), hMdfxa8h);
		} catch (Exception oHYleolL) {
			oHYleolL.printStackTrace();
		} finally {
			if (mgFa8SZZ != null) {
				try {
					mgFa8SZZ.close();
				} catch (IOException bsV42PIJ) {
				}
			}
			if (hMdfxa8h != null) {
				try {
					hMdfxa8h.close();
				} catch (IOException XXuFFq4k) {
				}
			}
		}
	}

}