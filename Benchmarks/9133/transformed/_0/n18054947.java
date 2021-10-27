class n18054947 {
	public void copyFile(String PLKGoGrC, String mm8XC91A) throws IOException {
		File lr39Fdpn = new File(PLKGoGrC);
		File CUEYxBFA = new File(mm8XC91A);
		Reader wQelicSZ = null;
		Writer fltZzGEO = null;
		char[] v6Nk7b05;
		int RhDLxZeR;
		try {
			if (!lr39Fdpn.exists() || !lr39Fdpn.isFile())
				throw new FileCopyException("FileCopy: no such source file: " + PLKGoGrC);
			if (!lr39Fdpn.canRead())
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + PLKGoGrC);
			if (CUEYxBFA.exists()) {
				if (CUEYxBFA.isFile()) {
					DataInputStream Or9wSAq9 = new DataInputStream(System.in);
					String mjodqfEK;
					if (!CUEYxBFA.canWrite())
						throw new FileCopyException("FileCopy: destination " + "file is unwriteable: " + mm8XC91A);
				} else {
					throw new FileCopyException("FileCopy: destination " + "is not a file: " + mm8XC91A);
				}
			} else {
				File jWQdSzOL = parent(CUEYxBFA);
				if (!jWQdSzOL.exists())
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + mm8XC91A);
				if (!jWQdSzOL.canWrite())
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + mm8XC91A);
			}
			wQelicSZ = new BufferedReader(new FileReader(lr39Fdpn));
			fltZzGEO = new BufferedWriter(new FileWriter(CUEYxBFA));
			v6Nk7b05 = new char[1024];
			while (true) {
				RhDLxZeR = wQelicSZ.read(v6Nk7b05, 0, 1024);
				if (RhDLxZeR == -1)
					break;
				fltZzGEO.write(v6Nk7b05, 0, RhDLxZeR);
			}
		} finally {
			if (wQelicSZ != null) {
				try {
					wQelicSZ.close();
				} catch (IOException P55QYRop) {
					;
				}
			}
			if (fltZzGEO != null) {
				try {
					fltZzGEO.close();
				} catch (IOException Xn58fsYe) {
					;
				}
			}
		}
	}

}