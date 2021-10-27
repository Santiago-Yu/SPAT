class n8801436 {
	public static void copy(File aN30Qi1o, File svE9wrfi) throws IOException {
		if (!aN30Qi1o.exists())
			abort("FileCopy: no such source file: " + aN30Qi1o.getName());
		if (!aN30Qi1o.isFile())
			abort("FileCopy: can't copy directory: " + aN30Qi1o.getName());
		if (!aN30Qi1o.canRead())
			abort("FileCopy: source file is unreadable: " + aN30Qi1o.getName());
		if (svE9wrfi.isDirectory())
			svE9wrfi = new File(svE9wrfi, aN30Qi1o.getName());
		if (svE9wrfi.exists()) {
			if (!svE9wrfi.canWrite())
				abort("FileCopy: destination file is unwriteable: " + svE9wrfi.getName());
		} else {
			String EfDx8veA = svE9wrfi.getParent();
			if (EfDx8veA == null)
				EfDx8veA = System.getProperty("user.dir");
			File xyiWQbO8 = new File(EfDx8veA);
			if (!xyiWQbO8.exists())
				abort("FileCopy: destination directory doesn't exist: " + EfDx8veA);
			if (xyiWQbO8.isFile())
				abort("FileCopy: destination is not a directory: " + EfDx8veA);
			if (!xyiWQbO8.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + EfDx8veA);
		}
		FileInputStream nej4J2Vp = null;
		FileOutputStream ptirqhKV = null;
		try {
			nej4J2Vp = new FileInputStream(aN30Qi1o);
			ptirqhKV = new FileOutputStream(svE9wrfi);
			byte[] cmFb7omG = new byte[4096];
			int fDO3mqut;
			while ((fDO3mqut = nej4J2Vp.read(cmFb7omG)) != -1) {
				ptirqhKV.write(cmFb7omG, 0, fDO3mqut);
			}
		} finally {
			if (nej4J2Vp != null)
				try {
					nej4J2Vp.close();
				} catch (IOException PfRR1qTc) {
					;
				}
			if (ptirqhKV != null)
				try {
					ptirqhKV.close();
				} catch (IOException EkRfN8mE) {
				}
		}
	}

}