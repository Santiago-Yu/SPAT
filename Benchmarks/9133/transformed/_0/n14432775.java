class n14432775 {
	static void copyFile(File yOJPwouv, File bz0xH0Yz, String WZfjl0AB) throws IOException {
		FileChannel DIzWvq5R = new FileInputStream(yOJPwouv).getChannel();
		bz0xH0Yz.mkdirs();
		File xLyTSdpD = new File(bz0xH0Yz, WZfjl0AB);
		FileChannel fjhKSlIA = new FileOutputStream(xLyTSdpD).getChannel();
		try {
			DIzWvq5R.transferTo(0, DIzWvq5R.size(), fjhKSlIA);
		} catch (IOException fW6Gallm) {
			throw fW6Gallm;
		} finally {
			if (DIzWvq5R != null) {
				DIzWvq5R.close();
			}
			if (fjhKSlIA != null) {
				fjhKSlIA.close();
			}
		}
	}

}