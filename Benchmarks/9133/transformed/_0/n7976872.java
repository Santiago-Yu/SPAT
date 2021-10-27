class n7976872 {
	public static void copy_file(String ZJQw7HR9, String ifuUOWvM) throws IOException {
		File xECzMdKU = new File(ZJQw7HR9);
		File NNb2wO4r = new File(ifuUOWvM);
		if (!xECzMdKU.exists())
			throw new IOException("FileCopy: " + "no such source file: " + ZJQw7HR9);
		if (!xECzMdKU.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + ZJQw7HR9);
		if (!xECzMdKU.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + ZJQw7HR9);
		if (NNb2wO4r.isDirectory())
			NNb2wO4r = new File(NNb2wO4r, xECzMdKU.getName());
		if (NNb2wO4r.exists()) {
			if (!NNb2wO4r.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + ifuUOWvM);
			System.out.print("Overwrite existing file " + NNb2wO4r.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader O70L6wK9 = new BufferedReader(new InputStreamReader(System.in));
			String C4AWwMqk = O70L6wK9.readLine();
			if (!C4AWwMqk.equals("Y") && !C4AWwMqk.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String fHMr3F4u = NNb2wO4r.getParent();
			if (fHMr3F4u == null)
				fHMr3F4u = System.getProperty("user.dir");
			File F2tcNTyu = new File(fHMr3F4u);
			if (!F2tcNTyu.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + fHMr3F4u);
			if (F2tcNTyu.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + fHMr3F4u);
			if (!F2tcNTyu.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + fHMr3F4u);
		}
		FileInputStream BOmmnr3x = null;
		FileOutputStream YTJrb52E = null;
		try {
			BOmmnr3x = new FileInputStream(xECzMdKU);
			YTJrb52E = new FileOutputStream(NNb2wO4r);
			byte[] TnVrSM31 = new byte[4096];
			int qhYgNGZb;
			while ((qhYgNGZb = BOmmnr3x.read(TnVrSM31)) != -1)
				YTJrb52E.write(TnVrSM31, 0, qhYgNGZb);
		} finally {
			if (BOmmnr3x != null)
				try {
					BOmmnr3x.close();
				} catch (IOException YnMNNIvY) {
					;
				}
			if (YTJrb52E != null)
				try {
					YTJrb52E.close();
				} catch (IOException y43hIZMH) {
					;
				}
		}
	}

}