class n3731077 {
	public static void copyFile(File rigs4YXw, File LLRMZWqt) throws IOException {
		assert(rigs4YXw != null);
		assert(LLRMZWqt != null);
		if (!LLRMZWqt.exists()) {
			File Xu9E2MBa = LLRMZWqt.getParentFile();
			if (!Xu9E2MBa.exists())
				Xu9E2MBa.mkdirs();
			LLRMZWqt.createNewFile();
		}
		FileInputStream XWJn19TY = null;
		FileOutputStream w4ouJtbH = null;
		try {
			XWJn19TY = new FileInputStream(rigs4YXw);
			try {
				w4ouJtbH = new FileOutputStream(LLRMZWqt);
				FileChannel BUL1YduK = XWJn19TY.getChannel();
				try {
					FileChannel E7r9NAIx = w4ouJtbH.getChannel();
					try {
						E7r9NAIx.transferFrom(BUL1YduK, 0, rigs4YXw.length());
					} finally {
						if (E7r9NAIx != null) {
							E7r9NAIx.close();
						}
					}
				} finally {
					if (BUL1YduK != null) {
						BUL1YduK.close();
					}
				}
			} finally {
				if (w4ouJtbH != null) {
					w4ouJtbH.close();
				}
			}
		} finally {
			if (XWJn19TY != null) {
				XWJn19TY.close();
			}
		}
	}

}