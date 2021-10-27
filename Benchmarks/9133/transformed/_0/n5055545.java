class n5055545 {
	public static void copy(File iwLLyf3E, File RFOGSmnt) throws IOException {
		if (!iwLLyf3E.exists())
			throw new IOException("FileCopy: " + "no such source file: " + iwLLyf3E.getAbsolutePath());
		if (!iwLLyf3E.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + iwLLyf3E.getAbsolutePath());
		if (!iwLLyf3E.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + iwLLyf3E.getAbsolutePath());
		if (RFOGSmnt.isDirectory())
			RFOGSmnt = new File(RFOGSmnt, iwLLyf3E.getName());
		String JESLGYml = RFOGSmnt.getParent();
		if (JESLGYml == null)
			JESLGYml = System.getProperty("user.dir");
		File kCR8D3kB = new File(JESLGYml);
		if (!kCR8D3kB.exists())
			throw new IOException("FileCopy: " + "destination directory doesn't exist: " + JESLGYml);
		if (kCR8D3kB.isFile())
			throw new IOException("FileCopy: " + "destination is not a directory: " + JESLGYml);
		if (!kCR8D3kB.canWrite())
			throw new IOException("FileCopy: " + "destination directory is unwriteable: " + JESLGYml);
		FileInputStream GbACpbJ6 = null;
		FileOutputStream cUMnEWED = null;
		try {
			GbACpbJ6 = new FileInputStream(iwLLyf3E);
			cUMnEWED = new FileOutputStream(RFOGSmnt);
			byte[] j21e5hHS = new byte[4096];
			int ot1l8qAV;
			while ((ot1l8qAV = GbACpbJ6.read(j21e5hHS)) != -1)
				cUMnEWED.write(j21e5hHS, 0, ot1l8qAV);
		} finally {
			if (GbACpbJ6 != null)
				try {
					GbACpbJ6.close();
				} catch (IOException hqcv3tj4) {
				}
			if (cUMnEWED != null)
				try {
					cUMnEWED.close();
				} catch (IOException geS6RZsT) {
				}
		}
	}

}