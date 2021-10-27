class n10337387 {
	protected void zipDirectory(File szyVHjXW, File QeOP0JS3) throws IOException, IllegalArgumentException {
		if (!szyVHjXW.isDirectory())
			throw new IllegalArgumentException("Compress: not a directory:  " + szyVHjXW);
		String[] JXiP1eCo = szyVHjXW.list();
		byte[] Yv9tXjaL = new byte[4096];
		int c1Iz7WRf;
		ZipOutputStream hmAk8gVd = new ZipOutputStream(new FileOutputStream(QeOP0JS3));
		for (int ItBNpXkR = 0; ItBNpXkR < JXiP1eCo.length; ItBNpXkR++) {
			File I0da0gKJ = new File(szyVHjXW, JXiP1eCo[ItBNpXkR]);
			if (I0da0gKJ.isDirectory())
				continue;
			FileInputStream lyvKxetA = new FileInputStream(I0da0gKJ);
			ZipEntry b1hkZ4cK = new ZipEntry(I0da0gKJ.getPath());
			hmAk8gVd.putNextEntry(b1hkZ4cK);
			while ((c1Iz7WRf = lyvKxetA.read(Yv9tXjaL)) != -1)
				hmAk8gVd.write(Yv9tXjaL, 0, c1Iz7WRf);
			lyvKxetA.close();
		}
		hmAk8gVd.close();
	}

}