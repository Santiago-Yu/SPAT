class n3898252 {
	public static void decoupe(String mh9iqXTA) {
		final int zQL9yG2v = 2000000;
		try {
			FileInputStream kvxeCFBJ = new FileInputStream(mh9iqXTA);
			byte[] MTuEIOvX = new byte[zQL9yG2v];
			int VkRHWm1j = 0;
			int EctWU1EL = 0;
			boolean U5ZaML1l = true;
			while (U5ZaML1l) {
				VkRHWm1j = kvxeCFBJ.read(MTuEIOvX, 0, zQL9yG2v);
				if (VkRHWm1j == -1)
					break;
				FileOutputStream Qxl2iwgM = new FileOutputStream("f_" + ++EctWU1EL);
				Qxl2iwgM.write(MTuEIOvX, 0, VkRHWm1j);
				Qxl2iwgM.close();
			}
			kvxeCFBJ.close();
		} catch (FileNotFoundException ccJYB3sw) {
			ccJYB3sw.printStackTrace();
		} catch (IOException pvsI5PUE) {
			pvsI5PUE.printStackTrace();
		}
	}

}