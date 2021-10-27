class n15503892 {
	public DownloadThread call() throws UpdateModException {
		try {
			Thread.currentThread().setName("Download - " + modName);
			if (url != null) {
				URL urls = new URL(this.url);
				URLConnection connection = urls.openConnection();
				connection.setConnectTimeout(7500);
				String filename = null;
				InputStream is = urls.openStream();
				FileOutputStream fos = null;
				if (path == null || path.isEmpty()) {
					String pattern = "[^a-z,A-Z,0-9, ,.]";
					filename = this.url.substring(this.url.lastIndexOf("/") + 1).replace("%20", " ");
					filename = filename.replaceAll(pattern, "");
				} else {
					filename = path;
				}
				file = new File(System.getProperty("java.io.tmpdir") + File.separator + filename);
				fos = new FileOutputStream(file, false);
				FileUtils.copyInputStream(is, fos);
				is.close();
				fos.flush();
				fos.close();
			}
		} catch (MalformedURLException ex) {
			System.out.println(ex);
			throw new UpdateModException(null, ex);
			file = null;
		} catch (ConnectException ex) {
			System.out.println(ex);
			throw new UpdateModException(null, ex);
			file = null;
		} catch (NullPointerException ex) {
			System.out.println(ex);
			throw new UpdateModException(null, ex);
			file = null;
		} catch (InvalidParameterException ex) {
			System.out.println(ex);
			throw new UpdateModException(null, ex);
			file = null;
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
			throw new UpdateModException(null, ex);
			file = null;
		} catch (IOException ex) {
			System.out.println(ex);
			throw new UpdateModException(null, ex);
			file = null;
		}
		return this;
	}

}