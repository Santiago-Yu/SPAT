class n10006681 {
	public static void copyFile(File a2llNOET, File gGAy2BKi, int spcFr6kU, boolean k5VTQ5ZJ) throws IOException {
		if (gGAy2BKi.exists()) {
			if (k5VTQ5ZJ) {
				gGAy2BKi.delete();
			} else {
				throw new IOException("Cannot overwrite existing file: " + gGAy2BKi.getName());
			}
		}
		byte[] GeRQ4tMQ = new byte[spcFr6kU];
		int FwpsnA4f = 0;
		InputStream B7BRJXr7 = null;
		OutputStream wrcIwiDK = null;
		try {
			B7BRJXr7 = new FileInputStream(a2llNOET);
			wrcIwiDK = new FileOutputStream(gGAy2BKi);
			while (true) {
				FwpsnA4f = B7BRJXr7.read(GeRQ4tMQ);
				if (FwpsnA4f == -1) {
					break;
				}
				wrcIwiDK.write(GeRQ4tMQ, 0, FwpsnA4f);
			}
		} finally {
			if (B7BRJXr7 != null) {
				try {
					B7BRJXr7.close();
				} finally {
					if (wrcIwiDK != null) {
						wrcIwiDK.close();
					}
				}
			}
		}
	}

}