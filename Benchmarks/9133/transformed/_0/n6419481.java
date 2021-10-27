class n6419481 {
	public static void copy(String Ju45GUAw, String ni4BmUCC) throws IOException {
		File lwGId9KJ = new File(Ju45GUAw);
		File tCigDWSS = new File(ni4BmUCC);
		if (!lwGId9KJ.exists())
			throw new IOException("FileCopy: " + "no such source file: " + Ju45GUAw);
		if (!lwGId9KJ.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + Ju45GUAw);
		if (!lwGId9KJ.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + Ju45GUAw);
		if (tCigDWSS.isDirectory())
			tCigDWSS = new File(tCigDWSS, lwGId9KJ.getName());
		if (tCigDWSS.exists()) {
			if (!tCigDWSS.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + ni4BmUCC);
			System.out.print("Overwrite existing file " + tCigDWSS.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader OZBEav22 = new BufferedReader(new InputStreamReader(System.in));
			String yUS9H5UR = OZBEav22.readLine();
			if (!yUS9H5UR.equals("Y") && !yUS9H5UR.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String uXVIu8Qf = tCigDWSS.getParent();
			if (uXVIu8Qf == null)
				uXVIu8Qf = System.getProperty("user.dir");
			File LyJkmG5U = new File(uXVIu8Qf);
			if (!LyJkmG5U.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + uXVIu8Qf);
			if (LyJkmG5U.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + uXVIu8Qf);
			if (!LyJkmG5U.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + uXVIu8Qf);
		}
		FileInputStream l9GSXpsp = null;
		FileOutputStream zr3Lkzfn = null;
		try {
			l9GSXpsp = new FileInputStream(lwGId9KJ);
			zr3Lkzfn = new FileOutputStream(tCigDWSS);
			byte[] JsmNqMd9 = new byte[4096];
			int SLmxkrSq;
			while ((SLmxkrSq = l9GSXpsp.read(JsmNqMd9)) != -1)
				zr3Lkzfn.write(JsmNqMd9, 0, SLmxkrSq);
		} finally {
			if (l9GSXpsp != null)
				try {
					l9GSXpsp.close();
				} catch (IOException F92iKraH) {
					;
				}
			if (zr3Lkzfn != null)
				try {
					zr3Lkzfn.close();
				} catch (IOException wc43qpvm) {
					;
				}
		}
	}

}