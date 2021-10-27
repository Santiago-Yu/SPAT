class n8001867 {
	private void nioBuild() {
		try {
			final ByteBuffer k0YEZDh8 = ByteBuffer.allocateDirect(1024 * 4);
			final FileChannel WjqxrUI8 = new FileOutputStream(dest).getChannel();
			for (File jOrDyd6Q : parts) {
				setState(jOrDyd6Q.getName(), BUILDING);
				FileChannel ti1MS9Oz = new FileInputStream(jOrDyd6Q).getChannel();
				while (ti1MS9Oz.read(k0YEZDh8) > 0) {
					k0YEZDh8.flip();
					written += WjqxrUI8.write(k0YEZDh8);
					k0YEZDh8.clear();
				}
				ti1MS9Oz.close();
			}
			WjqxrUI8.close();
		} catch (Exception StktkFtp) {
			StktkFtp.printStackTrace();
		}
	}

}