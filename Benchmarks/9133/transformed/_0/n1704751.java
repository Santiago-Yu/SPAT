class n1704751 {
	public static void copy(File UXNeTiL6, File mNwY5tjO) throws IOException {
		String lof37pOY = UXNeTiL6.getPath();
		String XzAQggGW = mNwY5tjO.getPath();
		if (!UXNeTiL6.exists())
			throw new IOException("FileCopy: " + "no such source file: " + lof37pOY);
		if (!UXNeTiL6.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + lof37pOY);
		if (!UXNeTiL6.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + lof37pOY);
		if (mNwY5tjO.isDirectory())
			mNwY5tjO = new File(mNwY5tjO, UXNeTiL6.getName());
		if (mNwY5tjO.exists()) {
			if (!mNwY5tjO.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + XzAQggGW);
			if (AppState.isVerbose())
				System.out.print("Overwrite existing file " + mNwY5tjO.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader qeqm7LtG = new BufferedReader(new InputStreamReader(System.in));
			String Fo9aAY6b = qeqm7LtG.readLine();
			if (!Fo9aAY6b.equals("Y") && !Fo9aAY6b.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String fsBJWu0z = mNwY5tjO.getParent();
			if (fsBJWu0z == null)
				fsBJWu0z = System.getProperty("user.dir");
			File zXguhqPH = new File(fsBJWu0z);
			if (!zXguhqPH.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + fsBJWu0z);
			if (zXguhqPH.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + fsBJWu0z);
			if (!zXguhqPH.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + fsBJWu0z);
		}
		FileInputStream hu1QEJkJ = null;
		FileOutputStream Mh9Kt7wA = null;
		try {
			hu1QEJkJ = new FileInputStream(UXNeTiL6);
			Mh9Kt7wA = new FileOutputStream(mNwY5tjO);
			byte[] T4VZ70JX = new byte[4096];
			int QygSiphN;
			while ((QygSiphN = hu1QEJkJ.read(T4VZ70JX)) != -1)
				Mh9Kt7wA.write(T4VZ70JX, 0, QygSiphN);
		} finally {
			if (hu1QEJkJ != null)
				try {
					hu1QEJkJ.close();
				} catch (IOException x0DKvvSD) {
					;
				}
			if (Mh9Kt7wA != null)
				try {
					Mh9Kt7wA.close();
				} catch (IOException MRwRblHa) {
					;
				}
		}
	}

}