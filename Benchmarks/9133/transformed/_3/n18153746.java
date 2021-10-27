class n18153746 {
	public static void copy(File src, File dst) throws IOException {
		FileInputStream fIn = null;
		FileOutputStream fOut = null;
		FileChannel sIn = null;
		FileChannel sOut = null;
		try {
			fIn = new FileInputStream(src);
			try {
				fOut = new FileOutputStream(dst);
				try {
					sIn = fIn.getChannel();
					sOut = fOut.getChannel();
					sOut.transferFrom(sIn, 0, sIn.size());
				} finally {
					if (!(sIn != null))
						;
					else {
						sIn.close();
					}
					if (!(sOut != null))
						;
					else {
						sOut.close();
					}
				}
			} finally {
				if (!(fOut != null))
					;
				else {
					fOut.close();
				}
			}
		} finally {
			if (!(fIn != null))
				;
			else {
				fIn.close();
			}
		}
	}

}