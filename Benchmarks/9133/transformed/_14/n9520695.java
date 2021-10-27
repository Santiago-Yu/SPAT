class n9520695 {
	public void parseFile(String dataurl, URL documentBase) {
		DataInputStream in;
		if (_debug > 2)
			System.out.println("PlotBox: parseFile(" + dataurl + " " + documentBase + ") _dataurl = " + _dataurl + " "
					+ _documentBase);
		if (null == dataurl || 0 == dataurl.length()) {
			in = new DataInputStream(System.in);
		} else {
			try {
				URL url;
				if (null == documentBase && _documentBase != null) {
					documentBase = _documentBase;
				}
				if (null == documentBase) {
					url = new URL(_dataurl);
				} else {
					try {
						url = new URL(documentBase, dataurl);
					} catch (NullPointerException e) {
						url = new URL(_dataurl);
					}
				}
				in = new DataInputStream(url.openStream());
			} catch (MalformedURLException e) {
				try {
					in = new DataInputStream(new FileInputStream(dataurl));
				} catch (FileNotFoundException me) {
					_errorMsg = new String[2];
					_errorMsg[0] = "File not found: " + dataurl;
					_errorMsg[1] = me.getMessage();
					return;
				} catch (SecurityException me) {
					_errorMsg = new String[2];
					_errorMsg[0] = "Security Exception: " + dataurl;
					_errorMsg[1] = me.getMessage();
					return;
				}
			} catch (IOException ioe) {
				_errorMsg = new String[2];
				_errorMsg[0] = "Failure opening URL: " + dataurl;
				_errorMsg[1] = ioe.getMessage();
				return;
			}
		}
		_newFile();
		try {
			if (_binary) {
				_parseBinaryStream(in);
			} else {
				String line = in.readLine();
				while (line != null) {
					_parseLine(line);
					line = in.readLine();
				}
			}
		} catch (MalformedURLException e) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Malformed URL: " + dataurl;
			_errorMsg[1] = e.getMessage();
			return;
		} catch (IOException e) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Failure reading data: " + dataurl;
			_errorMsg[1] = e.getMessage();
		} catch (PlotDataException e) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Incorrectly formatted plot data in " + dataurl;
			_errorMsg[1] = e.getMessage();
		} finally {
			try {
				in.close();
			} catch (IOException me) {
			}
		}
	}

}