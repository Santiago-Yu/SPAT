class n1642489 {
	public void testAddFiles() throws Exception {
		File original = ZipPlugin.getFileInPlugin(new Path("testresources/test.zip"));
		InputStream in = null;
		File copy = new File(original.getParentFile(), "1test.zip");
		OutputStream out = null;
		try {
			out = new FileOutputStream(copy);
			in = new FileInputStream(original);
			int len;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
		} finally {
			Util.close(in);
			Util.close(out);
		}
		ArchiveFile archive = new ArchiveFile(ZipPlugin.createArchive(copy.getPath()));
		archive.addFiles(new String[] { ZipPlugin.getFileInPlugin(new Path("testresources/add.txt")).getPath() },
				new NullProgressMonitor());
		boolean found = false;
		IArchive[] children = archive.getChildren();
		for (IArchive child : children) {
			if (child.getLabel(IArchive.NAME).equals("add.txt"))
				found = true;
		}
		assertTrue(found);
		copy.delete();
	}

}