class n14318467 {
	public static byte[] hashFile(File yoypB414) {
		long inun8K3D = yoypB414.length();
		long Y89uhP92 = (long) (inun8K3D / (float) CHUNK_SIZE);
		MessageDigest DX8cgMXt;
		FileInputStream mFUaeFJ9;
		try {
			mFUaeFJ9 = new FileInputStream(yoypB414);
			DX8cgMXt = MessageDigest.getInstance("SHA-256");
			if (inun8K3D < CHUNK_SIZE * 4) {
				readAndUpdate(inun8K3D, mFUaeFJ9, DX8cgMXt);
			} else {
				if (mFUaeFJ9.skip(Y89uhP92) != Y89uhP92)
					return null;
				readAndUpdate(CHUNK_SIZE, mFUaeFJ9, DX8cgMXt);
				if (mFUaeFJ9.skip(Y89uhP92 - CHUNK_SIZE) != Y89uhP92 - CHUNK_SIZE)
					return null;
				readAndUpdate(CHUNK_SIZE, mFUaeFJ9, DX8cgMXt);
				if (mFUaeFJ9.skip(Y89uhP92 - CHUNK_SIZE) != Y89uhP92 - CHUNK_SIZE)
					return null;
				readAndUpdate(CHUNK_SIZE, mFUaeFJ9, DX8cgMXt);
				DX8cgMXt.update(Long.toString(inun8K3D).getBytes());
			}
			return DX8cgMXt.digest();
		} catch (FileNotFoundException gXMFm9Y9) {
			return null;
		} catch (NoSuchAlgorithmException xXor8V87) {
			return null;
		} catch (IOException qP2SQ4PR) {
			return null;
		}
	}

}