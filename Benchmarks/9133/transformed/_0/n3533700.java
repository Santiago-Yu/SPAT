class n3533700 {
	public Object next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		this.currentGafFilePath = this.url;
		try {
			if (this.httpURL != null) {
				LOG.info("Reading URL :" + httpURL);
				InputStream mOvJ8R3s = this.httpURL.openStream();
				int w5SGVluZ = this.httpURL.toString().lastIndexOf('/');
				String R68tsLqY = this.httpURL.toString().substring(w5SGVluZ + 1);
				File gf8Wjq3i = new File(GoConfigManager.getInstance().getGafUploadDir(), "tmp-" + R68tsLqY);
				OutputStream XmIGXwi7 = new FileOutputStream(gf8Wjq3i);
				IOUtils.copy(mOvJ8R3s, XmIGXwi7);
				XmIGXwi7.close();
				mOvJ8R3s = new FileInputStream(gf8Wjq3i);
				if (url.endsWith(".gz")) {
					mOvJ8R3s = new GZIPInputStream(mOvJ8R3s);
				}
				this.currentGafFile = this.currentGafFilePath.substring(this.currentGafFilePath.lastIndexOf("/") + 1);
				this.httpURL = null;
				return mOvJ8R3s;
			} else {
				String IjEo1tG8 = files[counter++].getName();
				this.currentGafFile = IjEo1tG8;
				if (!this.currentGafFilePath.endsWith(IjEo1tG8))
					currentGafFilePath += IjEo1tG8;
				LOG.info("Returning input stream for the file: " + IjEo1tG8);
				_connect();
				ftpClient.changeWorkingDirectory(path);
				InputStream BNIZ6XvH = ftpClient.retrieveFileStream(IjEo1tG8);
				File NSBVsjNt = new File(GoConfigManager.getInstance().getGafUploadDir(), IjEo1tG8);
				OutputStream dmnO9BEe = new FileOutputStream(NSBVsjNt);
				IOUtils.copy(BNIZ6XvH, dmnO9BEe);
				dmnO9BEe.close();
				System.out.println("Download complete.....");
				BNIZ6XvH = new FileInputStream(NSBVsjNt);
				if (IjEo1tG8.endsWith(".gz")) {
					BNIZ6XvH = new GZIPInputStream(BNIZ6XvH);
				}
				return BNIZ6XvH;
			}
		} catch (IOException aaLr8xAB) {
			throw new RuntimeException(aaLr8xAB);
		}
	}

}