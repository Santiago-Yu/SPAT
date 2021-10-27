class n14267319 {
	public void run() {
		BufferedInputStream eqMaE5GJ = null;
		URLConnection F87bEQAq = null;
		String fd5wBX9i = null;
		StringBuffer DwVtGoTZ = new StringBuffer();
		try {
			if (!location.startsWith("http://")) {
				location = "http://" + location;
			}
			F87bEQAq = (new URL(location)).openConnection();
			size = F87bEQAq.getContentLength();
			fd5wBX9i = F87bEQAq.getContentType();
			lastModified = F87bEQAq.getIfModifiedSince();
			InputStream V98ui751 = F87bEQAq.getInputStream();
			eqMaE5GJ = new BufferedInputStream(V98ui751);
			if (fd5wBX9i.startsWith("text/plain")) {
				int GIYNSwx1;
				GIYNSwx1 = eqMaE5GJ.read();
				++position;
				status = "    Reading From URL...";
				this.setChanged();
				this.notifyObservers();
				while (GIYNSwx1 != END_OF_STREAM) {
					DwVtGoTZ.append((char) GIYNSwx1);
					GIYNSwx1 = eqMaE5GJ.read();
					++position;
					if (position % (size / 25) == 0) {
						this.setChanged();
						this.notifyObservers();
					}
					if (abortLoading) {
						break;
					}
				}
				status = "    Finished reading URL...";
			} else if (fd5wBX9i.startsWith("text/html")) {
				int G920FEYe;
				G920FEYe = eqMaE5GJ.read();
				char T2xyefkf = (char) G920FEYe;
				++position;
				status = "    Reading From URL...";
				this.setChanged();
				this.notifyObservers();
				boolean LvxsOSly = false;
				if (T2xyefkf == '<') {
					LvxsOSly = true;
				}
				while (G920FEYe != END_OF_STREAM) {
					if (LvxsOSly) {
						if (T2xyefkf == '>') {
							LvxsOSly = false;
						}
					} else {
						if (T2xyefkf == '<') {
							LvxsOSly = true;
						} else {
							DwVtGoTZ.append((char) G920FEYe);
						}
					}
					G920FEYe = eqMaE5GJ.read();
					T2xyefkf = (char) G920FEYe;
					++position;
					if (size == 0) {
						if (position % (size / 25) == 0) {
							this.setChanged();
							this.notifyObservers();
						}
					}
					if (abortLoading) {
						break;
					}
				}
				status = "    Finished reading URL...";
			} else {
				status = "    Unable to read document type: " + fd5wBX9i + "...";
			}
			eqMaE5GJ.close();
			try {
				document.insertString(0, DwVtGoTZ.toString(), SimpleAttributeSet.EMPTY);
			} catch (BadLocationException Plp2ZET5) {
				Plp2ZET5.printStackTrace();
			}
			finished = true;
			this.setChanged();
			this.notifyObservers();
		} catch (IOException AyPKO7sv) {
			try {
				document.insertString(0, DwVtGoTZ.toString(), SimpleAttributeSet.EMPTY);
			} catch (BadLocationException QABObkEp) {
				QABObkEp.printStackTrace();
			}
			status = "    IO Error Reading From URL...";
			finished = true;
			this.setChanged();
			this.notifyObservers();
		}
	}

}