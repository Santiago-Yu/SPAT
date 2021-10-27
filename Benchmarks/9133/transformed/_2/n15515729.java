class n15515729 {
	public void get(File fileToGet) throws IOException {
		String fileName = fileToGet.getName();
		URL url = new URL(this.endpointURL + fileName);
		URLConnection connection = url.openConnection();
		InputStream input = connection.getInputStream();
		log.debug("get: " + fileName);
		try {
			FileOutputStream fileStream = new FileOutputStream(fileToGet);
			byte[] bt = new byte[10000];
			int cnt = input.read(bt);
			log.debug("Read bytes: " + cnt);
			for (; cnt != -1;) {
				fileStream.write(bt, 0, cnt);
				cnt = input.read(bt);
			}
			input.close();
			fileStream.close();
		} catch (IOException e) {
			new File(fileName).delete();
			throw e;
		}
	}

}