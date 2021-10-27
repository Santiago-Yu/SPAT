class n6980854 {
	public static void copy(File ZIkfzIvc, File esNXvJ8w) throws IOException {
		FileChannel UNG7xP1u = null, iYmNlxog = null;
		try {
			UNG7xP1u = new FileInputStream(ZIkfzIvc).getChannel();
			iYmNlxog = new FileOutputStream(esNXvJ8w).getChannel();
			long dcngHFI8 = UNG7xP1u.size();
			MappedByteBuffer lLq89UAc = UNG7xP1u.map(FileChannel.MapMode.READ_ONLY, 0, dcngHFI8);
			iYmNlxog.write(lLq89UAc);
		} finally {
			if (UNG7xP1u != null)
				UNG7xP1u.close();
			if (iYmNlxog != null)
				iYmNlxog.close();
		}
	}

}