class n2418918 {
	public static void copyFile(File ov28fn09, File vfIRS1CK) throws IOException {
		FileChannel W9OHLRhf = null, zUtiDwFp = null;
		try {
			W9OHLRhf = new FileInputStream(ov28fn09).getChannel();
			zUtiDwFp = new FileOutputStream(vfIRS1CK).getChannel();
			long R8dGAzhG = W9OHLRhf.size();
			MappedByteBuffer YB9ndDT4 = W9OHLRhf.map(FileChannel.MapMode.READ_ONLY, 0, R8dGAzhG);
			zUtiDwFp.write(YB9ndDT4);
		} finally {
			if (W9OHLRhf != null)
				W9OHLRhf.close();
			if (zUtiDwFp != null)
				zUtiDwFp.close();
		}
	}

}