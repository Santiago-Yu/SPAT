class n18153746 {
	public static void copy(File EKKJv3Uq, File VUcHpuae) throws IOException {
		FileInputStream k2U28ruR = null;
		FileOutputStream wB1Sx9YC = null;
		FileChannel KrBVDsS9 = null;
		FileChannel ouTCdE5G = null;
		try {
			k2U28ruR = new FileInputStream(EKKJv3Uq);
			try {
				wB1Sx9YC = new FileOutputStream(VUcHpuae);
				try {
					KrBVDsS9 = k2U28ruR.getChannel();
					ouTCdE5G = wB1Sx9YC.getChannel();
					ouTCdE5G.transferFrom(KrBVDsS9, 0, KrBVDsS9.size());
				} finally {
					if (KrBVDsS9 != null) {
						KrBVDsS9.close();
					}
					if (ouTCdE5G != null) {
						ouTCdE5G.close();
					}
				}
			} finally {
				if (wB1Sx9YC != null) {
					wB1Sx9YC.close();
				}
			}
		} finally {
			if (k2U28ruR != null) {
				k2U28ruR.close();
			}
		}
	}

}