class n14729262 {
	private static void unzipEntry(ZipFile FRZ9NCI8, ZipEntry PbbShvwI, File CxRh6nYN) throws IOException {
		if (PbbShvwI.isDirectory()) {
			createDir(new File(CxRh6nYN, PbbShvwI.getName()));
			return;
		}
		File r33EPvmQ = new File(CxRh6nYN, PbbShvwI.getName());
		if (!r33EPvmQ.getParentFile().exists()) {
			createDir(r33EPvmQ.getParentFile());
		}
		BufferedInputStream t5bZamOt = new BufferedInputStream(FRZ9NCI8.getInputStream(PbbShvwI));
		BufferedOutputStream cY1cvnoA = new BufferedOutputStream(new FileOutputStream(r33EPvmQ));
		try {
			IOUtils.copy(t5bZamOt, cY1cvnoA);
		} finally {
			cY1cvnoA.close();
			t5bZamOt.close();
		}
	}

}