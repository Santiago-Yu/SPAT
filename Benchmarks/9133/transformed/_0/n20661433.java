class n20661433 {
	public static void copyFile(String XZ1PDjLQ, String Ca5fjcG6, boolean OmMPZcPE) throws IOException {
		File B1w25HnK = new File(XZ1PDjLQ);
		File tfK3Kv6T = new File(Ca5fjcG6);
		if (!B1w25HnK.exists())
			throw new IOException("FileCopy: " + "no such source file: " + XZ1PDjLQ);
		if (!B1w25HnK.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + XZ1PDjLQ);
		if (!B1w25HnK.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + XZ1PDjLQ);
		if (tfK3Kv6T.isDirectory())
			tfK3Kv6T = new File(tfK3Kv6T, B1w25HnK.getName());
		if (tfK3Kv6T.exists()) {
			if (!OmMPZcPE) {
				throw new IOException(Ca5fjcG6 + " already exists!");
			}
			if (!tfK3Kv6T.canWrite()) {
				throw new IOException("FileCopy: destination file is unwriteable: " + Ca5fjcG6);
			}
			String qWaxvT8Q = tfK3Kv6T.getParent();
			if (qWaxvT8Q == null) {
				qWaxvT8Q = System.getProperty("user.dir");
			}
			File C39zL8aA = new File(qWaxvT8Q);
			if (!C39zL8aA.exists()) {
				throw new IOException("FileCopy: destination directory doesn't exist: " + qWaxvT8Q);
			}
			if (C39zL8aA.isFile()) {
				throw new IOException("FileCopy: destination is not a directory: " + qWaxvT8Q);
			}
			if (!C39zL8aA.canWrite()) {
				throw new IOException("FileCopy: destination directory is unwriteable: " + qWaxvT8Q);
			}
		}
		FileInputStream lyYV3TUx = null;
		FileOutputStream iln0lb3I = null;
		try {
			lyYV3TUx = new FileInputStream(B1w25HnK);
			iln0lb3I = new FileOutputStream(tfK3Kv6T);
			byte[] UdlCLULY = new byte[4096];
			int k31sCZGd;
			while ((k31sCZGd = lyYV3TUx.read(UdlCLULY)) != -1)
				iln0lb3I.write(UdlCLULY, 0, k31sCZGd);
		} finally {
			long tetRwjbQ = B1w25HnK.lastModified();
			tfK3Kv6T.setLastModified(tetRwjbQ);
			if (lyYV3TUx != null) {
				try {
					lyYV3TUx.close();
				} catch (IOException vaaR9Q1v) {
				}
			}
			if (iln0lb3I != null) {
				try {
					iln0lb3I.close();
				} catch (IOException FjfatuqE) {
				}
			}
		}
	}

}