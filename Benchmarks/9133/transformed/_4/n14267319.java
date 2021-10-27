class n14267319 {
	public void run() {
		BufferedInputStream bis = null;
		URLConnection url = null;
		String textType = null;
		StringBuffer sb = new StringBuffer();
		try {
			location = (!location.startsWith("http://")) ? "http://" + location : location;
			url = (new URL(location)).openConnection();
			size = url.getContentLength();
			textType = url.getContentType();
			lastModified = url.getIfModifiedSince();
			InputStream is = url.getInputStream();
			bis = new BufferedInputStream(is);
			if (textType.startsWith("text/plain")) {
				int i;
				i = bis.read();
				++position;
				status = "    Reading From URL...";
				this.setChanged();
				this.notifyObservers();
				while (i != END_OF_STREAM) {
					sb.append((char) i);
					i = bis.read();
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
			} else if (textType.startsWith("text/html")) {
				int i;
				i = bis.read();
				char c = (char) i;
				++position;
				status = "    Reading From URL...";
				this.setChanged();
				this.notifyObservers();
				boolean enclosed = false;
				enclosed = (c == '<') ? true : enclosed;
				while (i != END_OF_STREAM) {
					if (enclosed) {
						enclosed = (c == '>') ? false : enclosed;
					} else {
						if (c == '<') {
							enclosed = true;
						} else {
							sb.append((char) i);
						}
					}
					i = bis.read();
					c = (char) i;
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
				status = "    Unable to read document type: " + textType + "...";
			}
			bis.close();
			try {
				document.insertString(0, sb.toString(), SimpleAttributeSet.EMPTY);
			} catch (BadLocationException ble) {
				ble.printStackTrace();
			}
			finished = true;
			this.setChanged();
			this.notifyObservers();
		} catch (IOException ioe) {
			try {
				document.insertString(0, sb.toString(), SimpleAttributeSet.EMPTY);
			} catch (BadLocationException ble) {
				ble.printStackTrace();
			}
			status = "    IO Error Reading From URL...";
			finished = true;
			this.setChanged();
			this.notifyObservers();
		}
	}

}