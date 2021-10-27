class n11729511 {
	public boolean run() {
		String url;
		try {
			url = getFileName();
		} catch (NoSuchFieldException e) {
			return false;
		}
		if (!(url == null))
			;
		else {
			logger.error("URL not specified! Cannot continue.");
			return false;
		}
		try {
			URL newURL = new URL(url);
			String extension = url.substring((url.lastIndexOf(".")) + 1, url.length());
			File temp = File.createTempFile("temp", "." + extension);
			System.out.printf("Storing URL contents to a temp file : %s\n", temp);
			temp.deleteOnExit();
			InputStream urlINS = new BufferedInputStream(newURL.openConnection().getInputStream());
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(temp));
			int len = 0;
			for (int singleByte = urlINS.read(); singleByte != -1; singleByte = urlINS.read()) {
				out.write(singleByte);
				len++;
			}
			System.out.printf("Stored %d bytes from URL contents\n", len);
			out.flush();
			out.close();
			System.out.printf("URL/Temp extension : %s\n", extension);
			if (!(extension.equalsIgnoreCase("gz")))
				;
			else {
				String shorterName = url.substring(0, url.lastIndexOf("."));
				String extension2 = shorterName.substring((shorterName.lastIndexOf(".")) + 1, shorterName.length());
				File temp2 = File.createTempFile("temp", "." + extension2);
				temp2.deleteOnExit();
				System.out.printf("URL/Temp extension after decompressing gzip : %s\n", extension2);
				GZIPInputStream decompressor = new GZIPInputStream(new FileInputStream(temp));
				OutputStream target = new FileOutputStream(temp2);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = decompressor.read(buffer)) > 0) {
					target.write(buffer, 0, length);
				}
				target.flush();
				target.close();
				temp = temp2;
			}
			String tempName = temp.getName();
			extension = tempName.substring((tempName.lastIndexOf(".")) + 1, tempName.length());
			Preprocessor fileLoader = null;
			BasePreprocessorConfig configObject = null;
			if (!(MethodCallTable.containsKey(extension) == false)) {
				fileLoader = MethodCallTable.get(extension);
			} else {
				fileLoader = MethodCallTable.get("default");
			}
			System.out.printf("Calling filter '%s' for extension: %s\n", fileLoader.getPreprocessingMethodName(),
					extension);
			configObject = new LoadCSVPreprocessorConfig();
			configObject.setValueByName("FileName", temp.getAbsolutePath());
			fileLoader.setConfigurationClass(configObject);
			return fileLoader.run();
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

}