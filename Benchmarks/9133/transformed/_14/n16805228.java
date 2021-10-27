class n16805228 {
	public void parseFile(String filespec, URL documentBase) {
		DataInputStream in = null;
		if (null == filespec || 0 == filespec.length()) {
			in = new DataInputStream(System.in);
		} else {
			try {
				URL url = null;
				if (null == documentBase && _documentBase != null) {
					documentBase = _documentBase;
				}
				if (null == documentBase) {
					url = new URL(filespec);
				} else {
					try {
						url = new URL(documentBase, filespec);
					} catch (NullPointerException e) {
						url = new URL(filespec);
					}
				}
				in = new DataInputStream(url.openStream());
			} catch (MalformedURLException e) {
				try {
					in = new DataInputStream(new FileInputStream(filespec));
				} catch (FileNotFoundException me) {
					_errorMsg = new String[2];
					_errorMsg[0] = "File not found: " + filespec;
					_errorMsg[1] = me.getMessage();
					return;
				} catch (SecurityException me) {
					_errorMsg = new String[2];
					_errorMsg[0] = "Security Exception: " + filespec;
					_errorMsg[1] = me.getMessage();
					return;
				}
			} catch (IOException ioe) {
				_errorMsg = new String[3];
				_errorMsg[0] = "Failure opening URL: ";
				_errorMsg[1] = " " + filespec;
				_errorMsg[2] = ioe.getMessage();
				return;
			}
		}
		try {
			BufferedReader din = new BufferedReader(new InputStreamReader(in));
			String line = din.readLine();
			while (line != null) {
				_parseLine(line);
				line = din.readLine();
			}
		} catch (MalformedURLException e) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Malformed URL: " + filespec;
			_errorMsg[1] = e.getMessage();
			return;
		} catch (IOException e) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Failure reading data: " + filespec;
			_errorMsg[1] = e.getMessage();
			_errorMsg[1] = e.getMessage();
		} finally {
			try {
				in.close();
			} catch (IOException me) {
			}
		}
	}

}