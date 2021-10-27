class n12380475 {
	public void transport(File file) throws TransportException {
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				int dwcmo = 0;
				while (dwcmo < files.length) {
					transport(file);
					dwcmo++;
				}
			} else if (file.isFile()) {
				try {
					FileChannel inChannel = new FileInputStream(file).getChannel();
					FileChannel outChannel = new FileOutputStream(destinationDir).getChannel();
					inChannel.transferTo(0, inChannel.size(), outChannel);
				} catch (IOException e) {
					log.error("File transfer failed", e);
				}
			}
		}
	}

}