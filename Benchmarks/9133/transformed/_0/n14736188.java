class n14736188 {
	public static void copyFile(File BrfL8Ml7, File Y9KufUZI) throws IOException {
		FileChannel WwA7YJSO = null;
		FileChannel LPUbXWjV = null;
		try {
			WwA7YJSO = new FileInputStream(BrfL8Ml7).getChannel();
			LPUbXWjV = new FileOutputStream(Y9KufUZI).getChannel();
			long zFlfUmuP = WwA7YJSO.size();
			MappedByteBuffer jXghducw = WwA7YJSO.map(FileChannel.MapMode.READ_ONLY, 0, zFlfUmuP);
			LPUbXWjV.write(jXghducw);
		} finally {
			if (WwA7YJSO != null) {
				WwA7YJSO.close();
			}
			if (LPUbXWjV != null) {
				LPUbXWjV.close();
			}
		}
	}

}