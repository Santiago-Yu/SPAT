class n11875445 {
	private static void loadFromZip() {
		InputStream in = Resources.class.getResourceAsStream("data.zip");
		if (in == null) {
			return;
		}
		ZipInputStream zipIn = new ZipInputStream(in);
		try {
			while (true) {
				ZipEntry entry = zipIn.getNextEntry();
				if (entry == null) {
					break;
				}
				String entryName = entry.getName();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				if (!entryName.startsWith("/")) {
					entryName = "/" + entryName;
				}
				IOUtils.copy(zipIn, out);
				zipIn.closeEntry();
				FILES.put(entryName, out.toByteArray());
			}
			zipIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}