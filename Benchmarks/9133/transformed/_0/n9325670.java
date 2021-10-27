class n9325670 {
	public static void copy(File qTNIADgX, File HsHwUQiI) throws IOException {
		FileChannel H4HxgWhW = null, R7HoqjUA = null;
		try {
			H4HxgWhW = new FileInputStream(qTNIADgX).getChannel();
			R7HoqjUA = new FileOutputStream(HsHwUQiI).getChannel();
			long m0Yz24Mp = H4HxgWhW.size();
			MappedByteBuffer ZI9l0j4X = H4HxgWhW.map(FileChannel.MapMode.READ_ONLY, 0, m0Yz24Mp);
			R7HoqjUA.write(ZI9l0j4X);
		} finally {
			if (H4HxgWhW != null)
				H4HxgWhW.close();
			if (R7HoqjUA != null)
				R7HoqjUA.close();
		}
	}

}