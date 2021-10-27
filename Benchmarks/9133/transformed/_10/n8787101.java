class n8787101 {
	private void downloadThread() {
		status = false;
		int c;
		try {
			URLConnection urlc = resource.url.openConnection();
			boolean resume = false;
			File f = resource.createFile();
			resource.resetBytesDown();
			if (f.exists()) {
				if (f.lastModified() > resource.date.getTime()) {
					if ((resource.getFileSize() == f.length())) {
						status = true;
						return;
					} else {
						urlc.setRequestProperty("Range", "bytes=" + f.length() + "-");
						resume = true;
						resource.incrementBytesDown(f.length());
						System.out.println("Resume download");
						System.out.println("file length: " + f.length());
					}
				}
			}
			urlc.connect();
			bin = new BufferedInputStream(urlc.getInputStream());
			file_out = new FileOutputStream(f.getPath(), resume);
			while (life) {
				if (bin.available() > 0) {
					c = bin.read();
					if (c == -1) {
						break;
					}
					file_out.write(c);
					if (resource.incrementBytesDown()) {
						break;
					} else {
						continue;
					}
				}
				sleep(WAIT_FOR_A_BYTE_TIME);
			}
			file_out.flush();
			status = true;
		} catch (IOException e) {
			System.out.println("excepcion cpoy file");
		} catch (InterruptedException e) {
			System.out.println("InterruptException download");
			System.out.println(e);
		}
	}

}