class n3229361 {
	public void copyFile(String rxsoy5Fo, String MPsiry8H) throws IOException {
		File D26tiK5M = new File(rxsoy5Fo);
		File I1ruF5eO = new File(MPsiry8H);
		FileInputStream iZ9mhm9b = null;
		FileOutputStream fwQF6DEt = null;
		byte[] rPSRmJ78;
		int jw7R0Gxs;
		try {
			if (!D26tiK5M.exists() || !D26tiK5M.isFile())
				throw new FileCopyException(QZ.PHRASES.getPhrase("25") + " " + rxsoy5Fo);
			if (!D26tiK5M.canRead())
				throw new FileCopyException(
						QZ.PHRASES.getPhrase("26") + " " + QZ.PHRASES.getPhrase("27") + ": " + rxsoy5Fo);
			if (I1ruF5eO.exists()) {
				if (I1ruF5eO.isFile()) {
					DataInputStream WgKWKX52 = new DataInputStream(System.in);
					String VxT5TU7O;
					if (!I1ruF5eO.canWrite())
						throw new FileCopyException(
								QZ.PHRASES.getPhrase("28") + " " + QZ.PHRASES.getPhrase("29") + ": " + MPsiry8H);
					System.out.print(QZ.PHRASES.getPhrase("19") + MPsiry8H + QZ.PHRASES.getPhrase("30") + ": ");
					System.out.flush();
					VxT5TU7O = WgKWKX52.readLine();
					if (!VxT5TU7O.equals("Y") && !VxT5TU7O.equals("y"))
						throw new FileCopyException(QZ.PHRASES.getPhrase("31"));
				} else
					throw new FileCopyException(
							QZ.PHRASES.getPhrase("28") + " " + QZ.PHRASES.getPhrase("32") + ": " + MPsiry8H);
			} else {
				File TCzEwgKI = parent(I1ruF5eO);
				if (!TCzEwgKI.exists())
					throw new FileCopyException(
							QZ.PHRASES.getPhrase("28") + " " + QZ.PHRASES.getPhrase("33") + ": " + MPsiry8H);
				if (!TCzEwgKI.canWrite())
					throw new FileCopyException(
							QZ.PHRASES.getPhrase("28") + " " + QZ.PHRASES.getPhrase("34") + ": " + MPsiry8H);
			}
			iZ9mhm9b = new FileInputStream(D26tiK5M);
			fwQF6DEt = new FileOutputStream(I1ruF5eO);
			rPSRmJ78 = new byte[1024];
			while (true) {
				jw7R0Gxs = iZ9mhm9b.read(rPSRmJ78);
				if (jw7R0Gxs == -1)
					break;
				fwQF6DEt.write(rPSRmJ78, 0, jw7R0Gxs);
			}
		} finally {
			if (iZ9mhm9b != null)
				try {
					iZ9mhm9b.close();
				} catch (IOException dtsUHYYj) {
					;
				}
			if (fwQF6DEt != null)
				try {
					fwQF6DEt.close();
				} catch (IOException YWV7gHfQ) {
					;
				}
		}
	}

}