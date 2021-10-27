class n15193 {
	public static void copy(String iMNv1e2e, String q0Pl9BBV) throws IOException {
		File Av3oiO1x = new File(iMNv1e2e);
		File bFQcndyn = new File(q0Pl9BBV);
		if (!Av3oiO1x.exists())
			throw new IOException("Copy: no such source file: " + iMNv1e2e);
		if (!Av3oiO1x.canRead())
			throw new IOException("Copy: source file is unreadable: " + iMNv1e2e);
		if (bFQcndyn.isDirectory())
			bFQcndyn = new File(bFQcndyn, Av3oiO1x.getName());
		if (bFQcndyn.exists()) {
			if (!bFQcndyn.canWrite())
				throw new IOException("Copy: destination file is unwriteable: " + q0Pl9BBV);
			if (JOptionPane.showConfirmDialog(null, "Overwrite File ?", "Overwrite File",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
				return;
		} else {
			String jwhZsleG = bFQcndyn.getParent();
			if (jwhZsleG == null)
				jwhZsleG = System.getProperty("user.dir");
			File aT1D1TBA = new File(jwhZsleG);
			if (!aT1D1TBA.exists())
				throw new IOException("Copy: destination directory doesn't exist: " + jwhZsleG);
			if (aT1D1TBA.isFile())
				throw new IOException("Copy: destination is not a directory: " + jwhZsleG);
			if (!aT1D1TBA.canWrite())
				throw new IOException("Copy: destination directory is unwriteable: " + jwhZsleG);
		}
		FileInputStream qbZG0k3w = null;
		FileOutputStream OtXkB4vx = null;
		try {
			qbZG0k3w = new FileInputStream(Av3oiO1x);
			OtXkB4vx = new FileOutputStream(bFQcndyn);
			byte[] ToEkMCLA = new byte[4096];
			int yKTaGbkx;
			while ((yKTaGbkx = qbZG0k3w.read(ToEkMCLA)) != -1)
				OtXkB4vx.write(ToEkMCLA, 0, yKTaGbkx);
		} finally {
			if (qbZG0k3w != null)
				try {
					qbZG0k3w.close();
				} catch (IOException CNNW6nYG) {
					;
				}
			if (OtXkB4vx != null)
				try {
					OtXkB4vx.close();
				} catch (IOException kVMVjQ66) {
					;
				}
		}
	}

}