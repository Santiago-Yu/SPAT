class n20870396 {
	private static void copyFile(File Td0uspo2, File bdudGKor) throws IOException {
		FileChannel W99B1Fsl = new FileInputStream(Td0uspo2).getChannel();
		FileChannel xABKfDZZ = new FileOutputStream(bdudGKor).getChannel();
		try {
			W99B1Fsl.transferTo(0, W99B1Fsl.size(), xABKfDZZ);
		} catch (IOException HxQp27OZ) {
			throw HxQp27OZ;
		} finally {
			if (W99B1Fsl != null)
				W99B1Fsl.close();
			if (xABKfDZZ != null)
				xABKfDZZ.close();
		}
	}

}