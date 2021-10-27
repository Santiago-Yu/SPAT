class n22274573 {
	public static void copy(File QD1gmfVU, File WRXYxR5F, int YGVvhGYZ) throws IOException {
		if (WRXYxR5F.exists()) {
			logger.info("File " + WRXYxR5F + " exists, will replace it.");
			WRXYxR5F.delete();
		}
		WRXYxR5F.getParentFile().mkdirs();
		WRXYxR5F.createNewFile();
		FileInputStream S4ocpirs = null;
		FileOutputStream f1ejPOGt = null;
		try {
			S4ocpirs = new FileInputStream(QD1gmfVU);
			f1ejPOGt = new FileOutputStream(WRXYxR5F);
			byte[] I6lEVl2f = new byte[YGVvhGYZ];
			int dgg4oxpl;
			while ((dgg4oxpl = S4ocpirs.read(I6lEVl2f, 0, YGVvhGYZ)) > 0) {
				f1ejPOGt.write(I6lEVl2f, 0, dgg4oxpl);
			}
			f1ejPOGt.flush();
		} finally {
			try {
				if (S4ocpirs != null)
					S4ocpirs.close();
			} catch (IOException aYxvESCZ) {
				logger.warn("Could not close file input stream " + QD1gmfVU, aYxvESCZ);
			}
			try {
				if (f1ejPOGt != null) {
					f1ejPOGt.close();
				}
			} catch (IOException R9KqiKCr) {
				logger.warn("Could not close file output stream " + WRXYxR5F, R9KqiKCr);
			}
		}
	}

}