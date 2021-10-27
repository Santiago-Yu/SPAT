class n3945057 {
	private boolean streamDownload(URL url, File file) {
		try {
			InputStream in = url.openConnection().getInputStream();
			OutputStream out = new FileOutputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);
			int chunkSize = 63 * 1024;
			BufferedOutputStream bos = new BufferedOutputStream(out);
			byte[] ba = new byte[chunkSize];
			while (true) {
				int bytesRead = readBlocking(bis, ba, 0, chunkSize);
				if (bytesRead > 0) {
					if (bos != null)
						bos.write(ba, 0, bytesRead);
				} else {
					bos.close();
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Error writing file " + file);
			return false;
		}
		System.out.println("OK writing file " + file);
		return true;
	}

}