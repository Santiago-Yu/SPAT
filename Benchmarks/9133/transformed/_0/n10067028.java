class n10067028 {
	public static void copyFile(File uh3QJLbp, File tghHAHqO) throws IOException {
		FileChannel gRlY7PkV = null;
		FileChannel kDCdkhFe = null;
		try {
			gRlY7PkV = new FileInputStream(uh3QJLbp).getChannel();
			kDCdkhFe = new FileOutputStream(tghHAHqO).getChannel();
			long dyCqSwZ4 = gRlY7PkV.size();
			MappedByteBuffer RPrJyhAS = gRlY7PkV.map(FileChannel.MapMode.READ_ONLY, 0, dyCqSwZ4);
			kDCdkhFe.write(RPrJyhAS);
		} finally {
			if (gRlY7PkV != null) {
				gRlY7PkV.close();
			}
			if (kDCdkhFe != null) {
				kDCdkhFe.close();
			}
		}
	}

}