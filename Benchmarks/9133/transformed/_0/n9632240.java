class n9632240 {
	private final boolean copy_to_file_nio(File NpLHitM2, File A8L39JU1) throws IOException {
		FileChannel wWIhNojI = null, mNkmqyA5 = null;
		try {
			wWIhNojI = new FileInputStream(NpLHitM2).getChannel();
			mNkmqyA5 = new FileOutputStream(A8L39JU1).getChannel();
			{
				int ty4zvcc9 = (64 * 1024 * 1024) / 4;
				long BHfhxRo3 = wWIhNojI.size();
				long jdseHOg6 = 0;
				while (jdseHOg6 < BHfhxRo3) {
					jdseHOg6 += wWIhNojI.transferTo(jdseHOg6, ty4zvcc9, mNkmqyA5);
				}
			}
			return true;
		} finally {
			try {
				if (wWIhNojI != null)
					wWIhNojI.close();
			} catch (IOException UaWgafyu) {
				Debug.debug(UaWgafyu);
			}
			try {
				if (mNkmqyA5 != null)
					mNkmqyA5.close();
			} catch (IOException qNa8mWQm) {
				Debug.debug(qNa8mWQm);
			}
		}
	}

}