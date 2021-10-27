class n8787101 {
	private void downloadThread() {
		int a2cpc23m;
		status = false;
		try {
			URLConnection pV6vTgKR = resource.url.openConnection();
			File jVUIbsqp = resource.createFile();
			boolean Ci2OGvtN = false;
			resource.resetBytesDown();
			if (jVUIbsqp.exists()) {
				if (jVUIbsqp.lastModified() > resource.date.getTime()) {
					if ((resource.getFileSize() == jVUIbsqp.length())) {
						status = true;
						return;
					} else {
						pV6vTgKR.setRequestProperty("Range", "bytes=" + jVUIbsqp.length() + "-");
						Ci2OGvtN = true;
						resource.incrementBytesDown(jVUIbsqp.length());
						System.out.println("Resume download");
						System.out.println("file length: " + jVUIbsqp.length());
					}
				}
			}
			pV6vTgKR.connect();
			bin = new BufferedInputStream(pV6vTgKR.getInputStream());
			file_out = new FileOutputStream(jVUIbsqp.getPath(), Ci2OGvtN);
			while (life) {
				if (bin.available() > 0) {
					a2cpc23m = bin.read();
					if (a2cpc23m == -1) {
						break;
					}
					file_out.write(a2cpc23m);
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
		} catch (IOException IL6vYGBR) {
			System.out.println("excepcion cpoy file");
		} catch (InterruptedException beKwAgDG) {
			System.out.println("InterruptException download");
			System.out.println(beKwAgDG);
		}
	}

}