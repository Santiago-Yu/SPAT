class n15503892 {
	public DownloadThread call() throws UpdateModException {
		try {
			Thread.currentThread().setName("Download - " + modName);
			if (url != null) {
				URL urls = new URL(this.url);
				URLConnection connection = urls.openConnection();
				connection.setConnectTimeout(7500);
				InputStream is = urls.openStream();
				String filename = null;
				if (null == path || path.isEmpty()) {
					String pattern = "[^a-z,A-Z,0-9, ,.]";
					filename = this.url.substring(this.url.lastIndexOf("/") + 1).replace("%20", " ");
					filename = filename.replaceAll(pattern, "");
				} else {
					filename = path;
				}
				FileOutputStream fos = null;
				file = new File(System.getProperty("java.io.tmpdir") + File.separator + filename);
				fos = new FileOutputStream(file, false);
				FileUtils.copyInputStream(is, fos);
				is.close();
				fos.flush();
				fos.close();
			}
		} catch (MalformedURLException ex) {
			System.out.println(ex);
			file = null;
			throw new UpdateModException(null, ex);
		} catch (ConnectException ex) {
			System.out.println(ex);
			file = null;
			throw new UpdateModException(null, ex);
		} catch (NullPointerException ex) {
			System.out.println(ex);
			file = null;
			throw new UpdateModException(null, ex);
		} catch (InvalidParameterException ex) {
			System.out.println(ex);
			file = null;
			throw new UpdateModException(null, ex);
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
			file = null;
			throw new UpdateModException(null, ex);
		} catch (IOException ex) {
			System.out.println(ex);
			file = null;
			throw new UpdateModException(null, ex);
		}
		return this;
	}

}