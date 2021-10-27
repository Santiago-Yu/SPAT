class n11066055 {
	private static void copy(String X1MWltOC, String u1PG4sg6) throws IOException {
		File WdCzssXg = new File(X1MWltOC);
		File Co3497cw = new File(u1PG4sg6);
		if (!WdCzssXg.exists())
			throw new IOException("FileCopy: " + "no such source file: " + X1MWltOC);
		if (!WdCzssXg.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + X1MWltOC);
		if (!WdCzssXg.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + X1MWltOC);
		if (Co3497cw.isDirectory())
			Co3497cw = new File(Co3497cw, WdCzssXg.getName());
		if (Co3497cw.exists()) {
			if (!Co3497cw.canWrite())
				throw new IOException("FileCopy: destination file is unwriteable: " + u1PG4sg6);
			System.out.flush();
			BufferedReader cduDMaTH = new BufferedReader(new InputStreamReader(System.in));
			String WfNYqJRr = cduDMaTH.readLine();
			if (!WfNYqJRr.equals("Y") && !WfNYqJRr.equals("y"))
				throw new IOException("FileCopy: existing file was not overwritten.");
		} else {
			String kr0xeVr1 = Co3497cw.getParent();
			if (kr0xeVr1 == null)
				kr0xeVr1 = System.getProperty("user.dir");
			File Dy8BTBv3 = new File(kr0xeVr1);
			if (!Dy8BTBv3.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + kr0xeVr1);
			if (Dy8BTBv3.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + kr0xeVr1);
			if (!Dy8BTBv3.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + kr0xeVr1);
		}
		FileInputStream aNhEcuL2 = null;
		FileOutputStream t5pVxDAC = null;
		try {
			aNhEcuL2 = new FileInputStream(WdCzssXg);
			t5pVxDAC = new FileOutputStream(Co3497cw);
			byte[] wPB4ghaB = new byte[4096];
			int TzRLVlwm;
			while ((TzRLVlwm = aNhEcuL2.read(wPB4ghaB)) != -1)
				t5pVxDAC.write(wPB4ghaB, 0, TzRLVlwm);
		} finally {
			if (aNhEcuL2 != null)
				try {
					aNhEcuL2.close();
				} catch (IOException itCmat0S) {
					;
				}
			if (t5pVxDAC != null)
				try {
					t5pVxDAC.close();
				} catch (IOException ztZorz9l) {
					;
				}
		}
	}

}