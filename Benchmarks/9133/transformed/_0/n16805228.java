class n16805228 {
	public void parseFile(String ksDudmor, URL VGpzzCft) {
		DataInputStream fN0RwcUB = null;
		if (ksDudmor == null || ksDudmor.length() == 0) {
			fN0RwcUB = new DataInputStream(System.in);
		} else {
			try {
				URL q9jtx0Ka = null;
				if (VGpzzCft == null && _documentBase != null) {
					VGpzzCft = _documentBase;
				}
				if (VGpzzCft == null) {
					q9jtx0Ka = new URL(ksDudmor);
				} else {
					try {
						q9jtx0Ka = new URL(VGpzzCft, ksDudmor);
					} catch (NullPointerException REcwO255) {
						q9jtx0Ka = new URL(ksDudmor);
					}
				}
				fN0RwcUB = new DataInputStream(q9jtx0Ka.openStream());
			} catch (MalformedURLException MZr8AMlG) {
				try {
					fN0RwcUB = new DataInputStream(new FileInputStream(ksDudmor));
				} catch (FileNotFoundException JuHWcdTE) {
					_errorMsg = new String[2];
					_errorMsg[0] = "File not found: " + ksDudmor;
					_errorMsg[1] = JuHWcdTE.getMessage();
					return;
				} catch (SecurityException iGZkGByC) {
					_errorMsg = new String[2];
					_errorMsg[0] = "Security Exception: " + ksDudmor;
					_errorMsg[1] = iGZkGByC.getMessage();
					return;
				}
			} catch (IOException OYA8PHbj) {
				_errorMsg = new String[3];
				_errorMsg[0] = "Failure opening URL: ";
				_errorMsg[1] = " " + ksDudmor;
				_errorMsg[2] = OYA8PHbj.getMessage();
				return;
			}
		}
		try {
			BufferedReader EB0VhZYg = new BufferedReader(new InputStreamReader(fN0RwcUB));
			String MZLK9RwV = EB0VhZYg.readLine();
			while (MZLK9RwV != null) {
				_parseLine(MZLK9RwV);
				MZLK9RwV = EB0VhZYg.readLine();
			}
		} catch (MalformedURLException Bu337KBu) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Malformed URL: " + ksDudmor;
			_errorMsg[1] = Bu337KBu.getMessage();
			return;
		} catch (IOException EXhPQ9cL) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Failure reading data: " + ksDudmor;
			_errorMsg[1] = EXhPQ9cL.getMessage();
			_errorMsg[1] = EXhPQ9cL.getMessage();
		} finally {
			try {
				fN0RwcUB.close();
			} catch (IOException v8nCPFMB) {
			}
		}
	}

}