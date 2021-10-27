class n13396233 {
	public static void copyFile(File JDH1zFn8, File Sen2CLNx) throws IOException {
		FileChannel Bs8PtaXZ = new FileInputStream(JDH1zFn8).getChannel();
		FileChannel UXp6uXv0 = new FileOutputStream(Sen2CLNx).getChannel();
		try {
			Bs8PtaXZ.transferTo(0, Bs8PtaXZ.size(), UXp6uXv0);
		} catch (IOException gtm6aKkl) {
			throw gtm6aKkl;
		} finally {
			if (Bs8PtaXZ != null)
				Bs8PtaXZ.close();
			if (UXp6uXv0 != null)
				UXp6uXv0.close();
		}
	}

}