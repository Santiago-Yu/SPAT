class n2521140 {
	public static void copy(File nolascuG, File Mk2OwNLT) throws IOException {
		if (!nolascuG.exists())
			abort("FileCopy: no such source file: " + nolascuG.getName());
		if (!nolascuG.isFile())
			abort("FileCopy: can't copy directory: " + nolascuG.getName());
		if (!nolascuG.canRead())
			abort("FileCopy: source file is unreadable: " + nolascuG.getName());
		if (Mk2OwNLT.isDirectory())
			Mk2OwNLT = new File(Mk2OwNLT, nolascuG.getName());
		if (Mk2OwNLT.exists()) {
			if (!Mk2OwNLT.canWrite())
				abort("FileCopy: destination file is unwriteable: " + Mk2OwNLT.getName());
		} else {
			String LWA0wh4a = Mk2OwNLT.getParent();
			if (LWA0wh4a == null)
				LWA0wh4a = System.getProperty("user.dir");
			File I3M00ZUe = new File(LWA0wh4a);
			if (!I3M00ZUe.exists())
				abort("FileCopy: destination directory doesn't exist: " + LWA0wh4a);
			if (I3M00ZUe.isFile())
				abort("FileCopy: destination is not a directory: " + LWA0wh4a);
			if (!I3M00ZUe.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + LWA0wh4a);
		}
		FileInputStream lIuXXtYn = null;
		FileOutputStream Vk2BQVpi = null;
		try {
			lIuXXtYn = new FileInputStream(nolascuG);
			Vk2BQVpi = new FileOutputStream(Mk2OwNLT);
			byte[] yhK3sMHu = new byte[4096];
			int nXAvgquG;
			while ((nXAvgquG = lIuXXtYn.read(yhK3sMHu)) != -1) {
				Vk2BQVpi.write(yhK3sMHu, 0, nXAvgquG);
			}
		} finally {
			if (lIuXXtYn != null) {
				try {
					lIuXXtYn.close();
				} catch (IOException wOw6Ppxc) {
					wOw6Ppxc.printStackTrace();
				}
			}
			if (Vk2BQVpi != null) {
				try {
					Vk2BQVpi.close();
				} catch (IOException U7pDSoWp) {
					U7pDSoWp.printStackTrace();
				}
			}
		}
	}

}