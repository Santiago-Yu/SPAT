class n23613195 {
	public static void copy(File Hw9Keqj8, File ORN7SHP0) throws IOException {
		FileChannel O2r8Y2W2 = null, B3BXUrDS = null;
		try {
			O2r8Y2W2 = new FileInputStream(Hw9Keqj8).getChannel();
			B3BXUrDS = new FileOutputStream(ORN7SHP0).getChannel();
			long LtYFHMTs = O2r8Y2W2.size();
			MappedByteBuffer zeKvnbTy = O2r8Y2W2.map(FileChannel.MapMode.READ_ONLY, 0, LtYFHMTs);
			B3BXUrDS.write(zeKvnbTy);
		} finally {
			if (O2r8Y2W2 != null)
				O2r8Y2W2.close();
			if (B3BXUrDS != null)
				B3BXUrDS.close();
		}
	}

}