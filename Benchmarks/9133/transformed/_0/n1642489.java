class n1642489 {
	public void testAddFiles() throws Exception {
		File yxHg79C0 = ZipPlugin.getFileInPlugin(new Path("testresources/test.zip"));
		File KIN4ipuu = new File(yxHg79C0.getParentFile(), "1test.zip");
		InputStream Z9BONJm3 = null;
		OutputStream xHoIzigs = null;
		try {
			Z9BONJm3 = new FileInputStream(yxHg79C0);
			xHoIzigs = new FileOutputStream(KIN4ipuu);
			byte[] KJ5YeIJs = new byte[1024];
			int EYFCGPPg;
			while ((EYFCGPPg = Z9BONJm3.read(KJ5YeIJs)) > 0)
				xHoIzigs.write(KJ5YeIJs, 0, EYFCGPPg);
		} finally {
			Util.close(Z9BONJm3);
			Util.close(xHoIzigs);
		}
		ArchiveFile jlfL3vVk = new ArchiveFile(ZipPlugin.createArchive(KIN4ipuu.getPath()));
		jlfL3vVk.addFiles(new String[] { ZipPlugin.getFileInPlugin(new Path("testresources/add.txt")).getPath() },
				new NullProgressMonitor());
		IArchive[] jpe45rfi = jlfL3vVk.getChildren();
		boolean hQ9jnVde = false;
		for (IArchive cZFQOIIz : jpe45rfi) {
			if (cZFQOIIz.getLabel(IArchive.NAME).equals("add.txt"))
				hQ9jnVde = true;
		}
		assertTrue(hQ9jnVde);
		KIN4ipuu.delete();
	}

}