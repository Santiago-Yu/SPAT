class n635006 {
	public static void copy(String xlCWYjd2, String avq2SlfY) throws IOException {
		File e5G3UF05 = new File(xlCWYjd2);
		File WaYBgRWS = new File(avq2SlfY);
		if (!e5G3UF05.exists())
			abort("FileCopy: no such source file: " + xlCWYjd2);
		if (!e5G3UF05.isFile())
			abort("FileCopy: can't copy directory: " + xlCWYjd2);
		if (!e5G3UF05.canRead())
			abort("FileCopy: source file is unreadable: " + xlCWYjd2);
		if (WaYBgRWS.isDirectory())
			WaYBgRWS = new File(WaYBgRWS, e5G3UF05.getName());
		if (WaYBgRWS.exists()) {
			if (!WaYBgRWS.canWrite())
				abort("FileCopy: destination file is unwriteable: " + avq2SlfY);
			System.out.print("Overwrite existing file " + avq2SlfY + "? (Y/N): ");
			System.out.flush();
			BufferedReader TcttIp8O = new BufferedReader(new InputStreamReader(System.in));
			String w7lWWf5t = TcttIp8O.readLine();
			if (!w7lWWf5t.equals("Y") && !w7lWWf5t.equals("y"))
				abort("FileCopy: existing file was not overwritten.");
		} else {
			String SOh8SHRZ = WaYBgRWS.getParent();
			if (SOh8SHRZ == null)
				SOh8SHRZ = System.getProperty("user.dir");
			File gkqhd5zm = new File(SOh8SHRZ);
			if (!gkqhd5zm.exists())
				abort("FileCopy: destination directory doesn't exist: " + SOh8SHRZ);
			if (gkqhd5zm.isFile())
				abort("FileCopy: destination is not a directory: " + SOh8SHRZ);
			if (!gkqhd5zm.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + SOh8SHRZ);
		}
		FileInputStream UooITOqS = null;
		FileOutputStream R9Qg74sl = null;
		try {
			UooITOqS = new FileInputStream(e5G3UF05);
			R9Qg74sl = new FileOutputStream(WaYBgRWS);
			byte[] scBFrDh0 = new byte[4096];
			int wPdlaibL;
			while ((wPdlaibL = UooITOqS.read(scBFrDh0)) != -1)
				R9Qg74sl.write(scBFrDh0, 0, wPdlaibL);
		} finally {
			if (UooITOqS != null)
				try {
					UooITOqS.close();
				} catch (IOException XyCOCjzH) {
					;
				}
			if (R9Qg74sl != null)
				try {
					R9Qg74sl.close();
				} catch (IOException ufE5YwZW) {
					;
				}
		}
	}

}