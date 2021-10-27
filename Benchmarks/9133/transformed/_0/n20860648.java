class n20860648 {
	protected void copy(File O8AkSCPm, File QU8Gqfz4) throws IOException {
		final FileChannel eeapnwFf = new FileInputStream(O8AkSCPm).getChannel();
		final FileChannel OwBBH60a = new FileOutputStream(QU8Gqfz4).getChannel();
		try {
			eeapnwFf.transferTo(0, eeapnwFf.size(), OwBBH60a);
		} finally {
			if (eeapnwFf != null) {
				eeapnwFf.close();
			}
			if (OwBBH60a != null) {
				OwBBH60a.close();
			}
		}
	}

}