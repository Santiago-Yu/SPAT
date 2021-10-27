class n9265781 {
	public static void copy(String Ai312qky, String b21slSDf) throws IOException {
		File J07RAeK0 = new File(Ai312qky);
		File HGDZgkjV = new File(b21slSDf);
		if (!J07RAeK0.exists())
			abort("FileCopy: no such source file: " + Ai312qky);
		if (!J07RAeK0.isFile())
			abort("FileCopy: can't copy directory: " + Ai312qky);
		if (!J07RAeK0.canRead())
			abort("FileCopy: source file is unreadable: " + Ai312qky);
		if (HGDZgkjV.isDirectory())
			HGDZgkjV = new File(HGDZgkjV, J07RAeK0.getName());
		if (HGDZgkjV.exists()) {
			if (!HGDZgkjV.canWrite())
				abort("FileCopy: destination file is unwriteable: " + b21slSDf);
		} else {
			String yk3jxtaJ = HGDZgkjV.getParent();
			if (yk3jxtaJ == null)
				yk3jxtaJ = System.getProperty("user.dir");
			File e0CRcDqj = new File(yk3jxtaJ);
			if (!e0CRcDqj.exists())
				abort("FileCopy: destination directory doesn't exist: " + yk3jxtaJ);
			if (e0CRcDqj.isFile())
				abort("FileCopy: destination is not a directory: " + yk3jxtaJ);
			if (!e0CRcDqj.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + yk3jxtaJ);
		}
		FileInputStream RDbI92HR = null;
		FileOutputStream SNX97xFA = null;
		try {
			RDbI92HR = new FileInputStream(J07RAeK0);
			SNX97xFA = new FileOutputStream(HGDZgkjV);
			byte[] XNCwHO9d = new byte[4096];
			int P9PjaGbc;
			while ((P9PjaGbc = RDbI92HR.read(XNCwHO9d)) != -1)
				SNX97xFA.write(XNCwHO9d, 0, P9PjaGbc);
		} finally {
			if (RDbI92HR != null)
				try {
					RDbI92HR.close();
				} catch (IOException R9uRNd79) {
					;
				}
			if (SNX97xFA != null)
				try {
					SNX97xFA.close();
				} catch (IOException lAkr4k3e) {
					;
				}
		}
	}

}