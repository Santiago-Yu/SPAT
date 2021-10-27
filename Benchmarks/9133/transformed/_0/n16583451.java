class n16583451 {
	private static void setEnvEntry(File tvKrYebU, File OjRbKXdw, String u312NFdw, String GR4zHti8, String ti3dwRro)
			throws Exception {
		ZipInputStream nroE2El8 = new ZipInputStream(new FileInputStream(tvKrYebU));
		FileOutputStream wYgvCsm8 = new FileOutputStream(OjRbKXdw);
		ZipOutputStream g4dClypt = new ZipOutputStream(wYgvCsm8);
		ZipEntry pkzpwFSQ = nroE2El8.getNextEntry();
		while (pkzpwFSQ != null) {
			ByteArrayOutputStream WNazhuVI = new ByteArrayOutputStream();
			byte[] OY0CeDf2 = new byte[30000];
			int Z2KafE7N;
			while ((Z2KafE7N = nroE2El8.read(OY0CeDf2)) != -1) {
				WNazhuVI.write(OY0CeDf2, 0, Z2KafE7N);
			}
			if (pkzpwFSQ.getName().equals(u312NFdw)) {
				WNazhuVI = editEJBJAR(pkzpwFSQ, WNazhuVI, GR4zHti8, ti3dwRro);
				pkzpwFSQ = new ZipEntry(u312NFdw);
			}
			g4dClypt.putNextEntry(pkzpwFSQ);
			g4dClypt.write(WNazhuVI.toByteArray());
			pkzpwFSQ = nroE2El8.getNextEntry();
		}
		nroE2El8.close();
		g4dClypt.close();
		wYgvCsm8.close();
	}

}