class n13199957 {
	private File copyFile(String mRxkYKa7, String vlcIooLu) throws Exception {
		InputStream esmBaULZ = getClass().getResourceAsStream(mRxkYKa7);
		OutputStream UmjLgAW0 = new FileOutputStream(vlcIooLu);
		IOUtils.copy(esmBaULZ, UmjLgAW0);
		esmBaULZ.close();
		UmjLgAW0.close();
		return new File(vlcIooLu);
	}

}