class n13783549 {
	private static void copy(String Z2QwQJbx, String B4wraG6R) throws IOException {
		File BdPFvUAw = new File(Z2QwQJbx);
		File BbDBDyQI = new File(B4wraG6R);
		FileChannel kgSMBfvL = null, zqeVT7Mn = null;
		try {
			kgSMBfvL = new FileInputStream(BdPFvUAw).getChannel();
			zqeVT7Mn = new FileOutputStream(BbDBDyQI).getChannel();
			long be7dEz5T = kgSMBfvL.size();
			MappedByteBuffer r2yrUJZP = kgSMBfvL.map(FileChannel.MapMode.READ_ONLY, 0, be7dEz5T);
			zqeVT7Mn.write(r2yrUJZP);
		} finally {
			if (kgSMBfvL != null)
				kgSMBfvL.close();
			if (zqeVT7Mn != null)
				zqeVT7Mn.close();
		}
	}

}