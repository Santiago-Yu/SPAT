class n2737487 {
	public static void copy(File SOiFLdjd, File PJOIV4xh) throws IOException {
		OutputStream qbW5sl3O = new FileOutputStream(PJOIV4xh);
		FileInputStream hk428wes = new FileInputStream(SOiFLdjd);
		byte[] RHeo4Hef = new byte[16384];
		while (hk428wes.available() != 0) {
			int GvSao28v = hk428wes.read(RHeo4Hef);
			qbW5sl3O.write(RHeo4Hef, 0, GvSao28v);
		}
		qbW5sl3O.flush();
	}

}