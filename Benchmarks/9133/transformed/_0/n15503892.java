class n15503892 {
	public DownloadThread call() throws UpdateModException {
		try {
			Thread.currentThread().setName("Download - " + modName);
			if (url != null) {
				URL kMZaUORb = new URL(this.url);
				URLConnection CHV47FOt = kMZaUORb.openConnection();
				CHV47FOt.setConnectTimeout(7500);
				InputStream kCOC1egl = kMZaUORb.openStream();
				String q4GQHIIA = null;
				if (path == null || path.isEmpty()) {
					String E0knioF2 = "[^a-z,A-Z,0-9, ,.]";
					q4GQHIIA = this.url.substring(this.url.lastIndexOf("/") + 1).replace("%20", " ");
					q4GQHIIA = q4GQHIIA.replaceAll(E0knioF2, "");
				} else {
					q4GQHIIA = path;
				}
				FileOutputStream HPvwFheM = null;
				file = new File(System.getProperty("java.io.tmpdir") + File.separator + q4GQHIIA);
				HPvwFheM = new FileOutputStream(file, false);
				FileUtils.copyInputStream(kCOC1egl, HPvwFheM);
				kCOC1egl.close();
				HPvwFheM.flush();
				HPvwFheM.close();
			}
		} catch (MalformedURLException t9YzU66a) {
			System.out.println(t9YzU66a);
			file = null;
			throw new UpdateModException(null, t9YzU66a);
		} catch (ConnectException ZyBdtGVq) {
			System.out.println(ZyBdtGVq);
			file = null;
			throw new UpdateModException(null, ZyBdtGVq);
		} catch (NullPointerException Y4WkEfv0) {
			System.out.println(Y4WkEfv0);
			file = null;
			throw new UpdateModException(null, Y4WkEfv0);
		} catch (InvalidParameterException frO40Cdv) {
			System.out.println(frO40Cdv);
			file = null;
			throw new UpdateModException(null, frO40Cdv);
		} catch (FileNotFoundException nMZ9jPti) {
			System.out.println(nMZ9jPti);
			file = null;
			throw new UpdateModException(null, nMZ9jPti);
		} catch (IOException iFCyBABv) {
			System.out.println(iFCyBABv);
			file = null;
			throw new UpdateModException(null, iFCyBABv);
		}
		return this;
	}

}