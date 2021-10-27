class n3229363 {
	public void copyFile2(String WHnLmrLn, String apo5mgK1) throws IOException {
		String CBxaI7gh = System.getProperty("line.separator");
		FileWriter lKDorkpC = null;
		FileReader mkVNmM7B = null;
		BufferedReader EsXdyYfr = null;
		BufferedWriter wEZWp0et = null;
		File uAB1wCXy = null;
		try {
			mkVNmM7B = new FileReader(WHnLmrLn);
			lKDorkpC = new FileWriter(apo5mgK1);
			EsXdyYfr = new BufferedReader(mkVNmM7B);
			wEZWp0et = new BufferedWriter(lKDorkpC);
			uAB1wCXy = new File(WHnLmrLn);
			int kMMEThN2 = (int) uAB1wCXy.length();
			char KsWmZKUw[] = new char[kMMEThN2];
			while (EsXdyYfr.read(KsWmZKUw, 0, kMMEThN2) != -1)
				wEZWp0et.write(KsWmZKUw, 0, kMMEThN2);
		} catch (FileNotFoundException aVV7rp1h) {
			throw new FileCopyException(WHnLmrLn + " " + QZ.PHRASES.getPhrase("35"));
		} catch (IOException CtNL2j1v) {
			throw new FileCopyException(QZ.PHRASES.getPhrase("36"));
		} finally {
			try {
				if (EsXdyYfr != null)
					EsXdyYfr.close();
				if (wEZWp0et != null)
					wEZWp0et.close();
			} catch (IOException r4D71hbx) {
			}
		}
	}

}