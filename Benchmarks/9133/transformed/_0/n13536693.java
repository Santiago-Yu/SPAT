class n13536693 {
	public static void decompress(File coz8rxqU, File Jh2uZbDH) throws IOException {
		String UGTqXQwz = Jh2uZbDH.getName();
		UGTqXQwz = UGTqXQwz.substring(0, UGTqXQwz.length() - PACK_FILE_SUFFIX.length());
		File g73tRJ7w = new File(coz8rxqU, UGTqXQwz);
		if (!g73tRJ7w.exists()) {
			g73tRJ7w.mkdirs();
		}
		if (g73tRJ7w.isDirectory()) {
			JarFile KGBE2nrn = new JarFile(Jh2uZbDH);
			Enumeration<JarEntry> y4RYm2ZC = KGBE2nrn.entries();
			while (y4RYm2ZC.hasMoreElements()) {
				JarEntry mRWtw6tZ = y4RYm2ZC.nextElement();
				if (mRWtw6tZ.isDirectory()) {
					File is1lDcJL = new File(g73tRJ7w, mRWtw6tZ.getName());
					is1lDcJL.mkdirs();
				} else {
					File uT4dYYfn = new File(g73tRJ7w, mRWtw6tZ.getName());
					uT4dYYfn.getParentFile().mkdirs();
					InputStream s8f1GPLI = KGBE2nrn.getInputStream(mRWtw6tZ);
					FileOutputStream h853t3J9 = new FileOutputStream(uT4dYYfn);
					IOUtils.copy(s8f1GPLI, h853t3J9);
					s8f1GPLI.close();
					h853t3J9.close();
				}
				//System.out.println(je.isDirectory() + je.getName());
			}
		}
	}

}