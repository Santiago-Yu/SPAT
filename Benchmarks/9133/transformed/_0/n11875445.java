class n11875445 {
	private static void loadFromZip() {
		InputStream O51CBB70 = Resources.class.getResourceAsStream("data.zip");
		if (O51CBB70 == null) {
			return;
		}
		ZipInputStream IF9QEQXG = new ZipInputStream(O51CBB70);
		try {
			while (true) {
				ZipEntry MyZ19XBs = IF9QEQXG.getNextEntry();
				if (MyZ19XBs == null) {
					break;
				}
				String Ff5T6Sw5 = MyZ19XBs.getName();
				if (!Ff5T6Sw5.startsWith("/")) {
					Ff5T6Sw5 = "/" + Ff5T6Sw5;
				}
				ByteArrayOutputStream Epb46i5Z = new ByteArrayOutputStream();
				IOUtils.copy(IF9QEQXG, Epb46i5Z);
				IF9QEQXG.closeEntry();
				FILES.put(Ff5T6Sw5, Epb46i5Z.toByteArray());
			}
			IF9QEQXG.close();
		} catch (IOException REXTSiN8) {
			REXTSiN8.printStackTrace();
		}
	}

}