class n9520695 {
	public void parseFile(String wEhg0zW8, URL HzwkNVdJ) {
		DataInputStream tRs7jBWs;
		if (_debug > 2)
			System.out.println("PlotBox: parseFile(" + wEhg0zW8 + " " + HzwkNVdJ + ") _dataurl = " + _dataurl + " "
					+ _documentBase);
		if (wEhg0zW8 == null || wEhg0zW8.length() == 0) {
			tRs7jBWs = new DataInputStream(System.in);
		} else {
			try {
				URL vVpj3aWS;
				if (HzwkNVdJ == null && _documentBase != null) {
					HzwkNVdJ = _documentBase;
				}
				if (HzwkNVdJ == null) {
					vVpj3aWS = new URL(_dataurl);
				} else {
					try {
						vVpj3aWS = new URL(HzwkNVdJ, wEhg0zW8);
					} catch (NullPointerException E5Bj1won) {
						vVpj3aWS = new URL(_dataurl);
					}
				}
				tRs7jBWs = new DataInputStream(vVpj3aWS.openStream());
			} catch (MalformedURLException JUadBFXO) {
				try {
					tRs7jBWs = new DataInputStream(new FileInputStream(wEhg0zW8));
				} catch (FileNotFoundException rY0ZBoMd) {
					_errorMsg = new String[2];
					_errorMsg[0] = "File not found: " + wEhg0zW8;
					_errorMsg[1] = rY0ZBoMd.getMessage();
					return;
				} catch (SecurityException REx04YdY) {
					_errorMsg = new String[2];
					_errorMsg[0] = "Security Exception: " + wEhg0zW8;
					_errorMsg[1] = REx04YdY.getMessage();
					return;
				}
			} catch (IOException vcyFbzzb) {
				_errorMsg = new String[2];
				_errorMsg[0] = "Failure opening URL: " + wEhg0zW8;
				_errorMsg[1] = vcyFbzzb.getMessage();
				return;
			}
		}
		_newFile();
		try {
			if (_binary) {
				_parseBinaryStream(tRs7jBWs);
			} else {
				String RyuPbJjC = tRs7jBWs.readLine();
				while (RyuPbJjC != null) {
					_parseLine(RyuPbJjC);
					RyuPbJjC = tRs7jBWs.readLine();
				}
			}
		} catch (MalformedURLException JF6reijX) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Malformed URL: " + wEhg0zW8;
			_errorMsg[1] = JF6reijX.getMessage();
			return;
		} catch (IOException KQrKsrQj) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Failure reading data: " + wEhg0zW8;
			_errorMsg[1] = KQrKsrQj.getMessage();
		} catch (PlotDataException o43pKKsX) {
			_errorMsg = new String[2];
			_errorMsg[0] = "Incorrectly formatted plot data in " + wEhg0zW8;
			_errorMsg[1] = o43pKKsX.getMessage();
		} finally {
			try {
				tRs7jBWs.close();
			} catch (IOException u6hDcoRS) {
			}
		}
	}

}