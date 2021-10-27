class n22137915 {
	public static void copyFromFileToFileUsingNIO(File LhUBmdI3, File sVO4yszm)
			throws FileNotFoundException, IOException {
		FileChannel F6AYJmFt = new FileInputStream(LhUBmdI3).getChannel();
		FileChannel kOiQbaYd = new FileOutputStream(sVO4yszm).getChannel();
		try {
			F6AYJmFt.transferTo(0, F6AYJmFt.size(), kOiQbaYd);
		} catch (IOException gxWuLRkT) {
			throw gxWuLRkT;
		} finally {
			if (F6AYJmFt != null)
				F6AYJmFt.close();
			if (kOiQbaYd != null)
				kOiQbaYd.close();
		}
	}

}