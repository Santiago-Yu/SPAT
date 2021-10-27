class n3533700 {
	public Object next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		this.currentGafFilePath = this.url;
		try {
			if (this.httpURL != null) {
				LOG.info("Reading URL :" + httpURL);
				InputStream is = this.httpURL.openStream();
				int index = this.httpURL.toString().lastIndexOf('/');
				String file = this.httpURL.toString().substring(index + 1);
				File downloadLocation = new File(GoConfigManager.getInstance().getGafUploadDir(), "tmp-" + file);
				OutputStream out = new FileOutputStream(downloadLocation);
				IOUtils.copy(is, out);
				out.close();
				is = new FileInputStream(downloadLocation);
				is = (url.endsWith(".gz")) ? new GZIPInputStream(is) : is;
				this.currentGafFile = this.currentGafFilePath.substring(this.currentGafFilePath.lastIndexOf("/") + 1);
				this.httpURL = null;
				return is;
			} else {
				String file = files[counter++].getName();
				this.currentGafFile = file;
				currentGafFilePath = (!this.currentGafFilePath.endsWith(file)) ? file : currentGafFilePath;
				LOG.info("Returning input stream for the file: " + file);
				_connect();
				ftpClient.changeWorkingDirectory(path);
				InputStream is = ftpClient.retrieveFileStream(file);
				File downloadLocation = new File(GoConfigManager.getInstance().getGafUploadDir(), file);
				OutputStream out = new FileOutputStream(downloadLocation);
				IOUtils.copy(is, out);
				out.close();
				System.out.println("Download complete.....");
				is = new FileInputStream(downloadLocation);
				is = (file.endsWith(".gz")) ? new GZIPInputStream(is) : is;
				return is;
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

}