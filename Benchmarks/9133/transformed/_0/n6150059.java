class n6150059 {
	private void nioBuild() {
		try {
			final ByteBuffer iRggzZrh = ByteBuffer.allocateDirect(1024 * 4);
			final FileChannel Cuv8NrwP = new FileOutputStream(dest).getChannel();
			for (File kSW2LyQK : parts) {
				setState(kSW2LyQK.getName(), BUILDING);
				FileChannel NAQIAg7w = new FileInputStream(kSW2LyQK).getChannel();
				while (NAQIAg7w.read(iRggzZrh) > 0) {
					iRggzZrh.flip();
					written += Cuv8NrwP.write(iRggzZrh);
					iRggzZrh.clear();
				}
				NAQIAg7w.close();
			}
			Cuv8NrwP.close();
		} catch (Exception l8m0oDui) {
			l8m0oDui.printStackTrace();
		}
	}

}