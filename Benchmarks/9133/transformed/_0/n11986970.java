class n11986970 {
	public void Copy() throws IOException {
		if (!FileDestination.exists()) {
			FileDestination.createNewFile();
		}
		FileChannel LKYpXAEI = null;
		FileChannel coyc73KV = null;
		try {
			LKYpXAEI = new FileInputStream(FileSource).getChannel();
			coyc73KV = new FileOutputStream(FileDestination).getChannel();
			coyc73KV.transferFrom(LKYpXAEI, 0, LKYpXAEI.size());
		} finally {
			if (LKYpXAEI != null) {
				LKYpXAEI.close();
			}
			if (coyc73KV != null) {
				coyc73KV.close();
			}
		}
	}

}