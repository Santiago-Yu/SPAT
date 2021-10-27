class n22271237 {
	public static void copy(File vSCdPODZ, File P8r9K957) throws IOException {
		if (!P8r9K957.exists()) {
			P8r9K957.createNewFile();
		}
		FileChannel T67Mtt02 = null;
		FileChannel OLaju8kr = null;
		try {
			T67Mtt02 = new FileInputStream(vSCdPODZ).getChannel();
			OLaju8kr = new FileOutputStream(P8r9K957).getChannel();
			OLaju8kr.transferFrom(T67Mtt02, 0, T67Mtt02.size());
		} finally {
			if (T67Mtt02 != null) {
				T67Mtt02.close();
			}
			if (OLaju8kr != null) {
				OLaju8kr.close();
			}
		}
	}

}