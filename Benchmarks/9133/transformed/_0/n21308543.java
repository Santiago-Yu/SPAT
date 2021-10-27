class n21308543 {
	private static void copyFile(String PQVNJI6m, String mgaSXVSy) throws IOException {
		FileChannel v1Unezm5 = new FileInputStream(PQVNJI6m).getChannel();
		FileChannel M8NkogRC = new FileOutputStream(mgaSXVSy).getChannel();
		v1Unezm5.transferTo(0, v1Unezm5.size(), M8NkogRC);
		v1Unezm5.close();
		M8NkogRC.close();
	}

}