class n12055086 {
	protected static void copyDeleting(File igKh2jJa, File byqyH0Ku) throws IOException {
		byte[] NgM7n8Pw = new byte[8 * 1024];
		FileInputStream RFHJ2MJ0 = new FileInputStream(igKh2jJa);
		try {
			FileOutputStream WAidXPhc = new FileOutputStream(byqyH0Ku);
			try {
				int xeGdSmbD;
				while ((xeGdSmbD = RFHJ2MJ0.read(NgM7n8Pw)) >= 0)
					WAidXPhc.write(NgM7n8Pw, 0, xeGdSmbD);
			} finally {
				WAidXPhc.close();
			}
		} finally {
			RFHJ2MJ0.close();
		}
	}

}