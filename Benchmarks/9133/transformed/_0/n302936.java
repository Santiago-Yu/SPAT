class n302936 {
	public static void copy(String xqEfxeMl, String OMomF10K, boolean Rwp4ukKy) throws IOException {
		File vrpxVYCO = new File(xqEfxeMl);
		File jH3iF5jJ = new File(OMomF10K);
		if (!vrpxVYCO.exists())
			abort("FileCopy: no such source file: " + xqEfxeMl);
		if (!vrpxVYCO.isFile())
			abort("FileCopy: can't copy directory: " + xqEfxeMl);
		if (!vrpxVYCO.canRead())
			abort("FileCopy: source file is unreadable: " + xqEfxeMl);
		if (jH3iF5jJ.isDirectory())
			jH3iF5jJ = new File(jH3iF5jJ, vrpxVYCO.getName());
		if (jH3iF5jJ.exists()) {
			if (!jH3iF5jJ.canWrite())
				abort("FileCopy: destination file is unwriteable: " + OMomF10K);
			if (!Rwp4ukKy) {
				System.out.print("Overwrite existing file " + OMomF10K + "? (Y/N): ");
				System.out.flush();
				BufferedReader oRrhBQbv = new BufferedReader(new InputStreamReader(System.in));
				String TKBsMd4y = oRrhBQbv.readLine();
				if (!TKBsMd4y.equals("Y") && !TKBsMd4y.equals("y"))
					abort("FileCopy: existing file was not overwritten.");
			}
		} else {
			String fRGdPkLe = jH3iF5jJ.getParent();
			if (fRGdPkLe == null)
				fRGdPkLe = System.getProperty("user.dir");
			File dA2UASgE = new File(fRGdPkLe);
			if (!dA2UASgE.exists())
				abort("FileCopy: destination directory doesn't exist: " + fRGdPkLe);
			if (dA2UASgE.isFile())
				abort("FileCopy: destination is not a directory: " + fRGdPkLe);
			if (!dA2UASgE.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + fRGdPkLe);
		}
		FileInputStream sdZb7EUi = null;
		FileOutputStream QdVEau1C = null;
		try {
			sdZb7EUi = new FileInputStream(vrpxVYCO);
			QdVEau1C = new FileOutputStream(jH3iF5jJ);
			byte[] QYOdTHfJ = new byte[4096];
			int IS096ZPV;
			while ((IS096ZPV = sdZb7EUi.read(QYOdTHfJ)) != -1)
				QdVEau1C.write(QYOdTHfJ, 0, IS096ZPV);
		} finally {
			if (sdZb7EUi != null)
				try {
					sdZb7EUi.close();
				} catch (IOException YJhdI5vU) {
					;
				}
			if (QdVEau1C != null)
				try {
					QdVEau1C.close();
				} catch (IOException pyYO6AEs) {
					;
				}
		}
	}

}