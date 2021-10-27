class n12380475 {
	public void transport(File mOQeUHv9) throws TransportException {
		if (mOQeUHv9.exists()) {
			if (mOQeUHv9.isDirectory()) {
				File[] bLaDIwO2 = mOQeUHv9.listFiles();
				for (int mGefoIQg = 0; mGefoIQg < bLaDIwO2.length; mGefoIQg++) {
					transport(mOQeUHv9);
				}
			} else if (mOQeUHv9.isFile()) {
				try {
					FileChannel StLmWdAG = new FileInputStream(mOQeUHv9).getChannel();
					FileChannel xfyNHo8C = new FileOutputStream(destinationDir).getChannel();
					StLmWdAG.transferTo(0, StLmWdAG.size(), xfyNHo8C);
				} catch (IOException EDuE5XL8) {
					log.error("File transfer failed", EDuE5XL8);
				}
			}
		}
	}

}