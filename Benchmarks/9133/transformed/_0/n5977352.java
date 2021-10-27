class n5977352 {
	public static void copyFile(File bbVwU79l, File SA59Go72, int CPeQFfz1, boolean A3aY7434) throws IOException {
		if (SA59Go72.exists())
			if (A3aY7434)
				SA59Go72.delete();
			else
				throw new IOException("Cannot overwrite existing file: " + SA59Go72.getName());
		byte[] bR0mQuGZ = new byte[CPeQFfz1];
		int dxLIBUSf = 0;
		InputStream GCQrMJ8c = null;
		OutputStream PGxocLxi = null;
		try {
			GCQrMJ8c = new FileInputStream(bbVwU79l);
			PGxocLxi = new FileOutputStream(SA59Go72);
			while (true) {
				dxLIBUSf = GCQrMJ8c.read(bR0mQuGZ);
				if (dxLIBUSf == -1)
					break;
				PGxocLxi.write(bR0mQuGZ, 0, dxLIBUSf);
			}
		} finally {
			if (GCQrMJ8c != null)
				try {
					GCQrMJ8c.close();
				} finally {
					if (PGxocLxi != null)
						PGxocLxi.close();
				}
		}
	}

}