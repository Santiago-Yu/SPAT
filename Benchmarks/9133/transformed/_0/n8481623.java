class n8481623 {
	public static void copy(File TLE4mPza, File HzNNXwgY) throws IOException {
		TLE4mPza = checkFile(TLE4mPza);
		if (HzNNXwgY.isDirectory())
			HzNNXwgY = new File(HzNNXwgY, TLE4mPza.getName());
		if (HzNNXwgY.exists()) {
			if (!HzNNXwgY.canWrite())
				abort("FileCopy: destination file is unwriteable: " + HzNNXwgY.getName());
		} else {
			String ew6tuFIZ = HzNNXwgY.getParent();
			if (ew6tuFIZ == null)
				ew6tuFIZ = System.getProperty("user.dir");
			File ufNXYUsl = new File(ew6tuFIZ);
			if (!ufNXYUsl.exists())
				abort("FileCopy: destination directory doesn't exist: " + ew6tuFIZ);
			if (ufNXYUsl.isFile())
				abort("FileCopy: destination is not a directory: " + ew6tuFIZ);
			if (!ufNXYUsl.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + ew6tuFIZ);
		}
		FileInputStream AvwM9KX3 = null;
		FileOutputStream cDtPbLRt = null;
		try {
			AvwM9KX3 = new FileInputStream(TLE4mPza);
			cDtPbLRt = new FileOutputStream(HzNNXwgY);
			byte[] GW1vRDTh = new byte[4096];
			int blalGRWZ;
			while ((blalGRWZ = AvwM9KX3.read(GW1vRDTh)) != -1) {
				cDtPbLRt.write(GW1vRDTh, 0, blalGRWZ);
			}
		} finally {
			if (AvwM9KX3 != null)
				try {
					AvwM9KX3.close();
				} catch (IOException umHcCh4h) {
					;
				}
			if (cDtPbLRt != null)
				try {
					cDtPbLRt.close();
				} catch (IOException NdsivsGE) {
				}
		}
	}

}