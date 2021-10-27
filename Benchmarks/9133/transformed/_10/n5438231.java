class n5438231 {
	public int extract() throws Exception {
		if (VERBOSE)
			System.out.println("IAAE:Extractr.extract: getting ready to extract " + getArtDir().toString());
		int count = 0;
		ITCFileFilter iff = new ITCFileFilter();
		FileTypeDeterminer ftd = new FileTypeDeterminer();
		RecursiveFileIterator rfi = new RecursiveFileIterator(getArtDir(), iff);
		File targetFile = null;
		File artFile = null;
		broadcastStart();
		while (rfi.hasMoreElements()) {
			artFile = (File) rfi.nextElement();
			targetFile = getTargetFile(artFile);
			BufferedInputStream in = null;
			if (VERBOSE)
				System.out.println("IAAE:Extractr.extract: working ont " + artFile.toString());
			BufferedOutputStream out = null;
			try {
				out = new BufferedOutputStream((new FileOutputStream(targetFile)));
				in = new BufferedInputStream((new FileInputStream(artFile)));
				int read = 0;
				byte[] buffer = new byte[10240];
				read = in.read(buffer);
				int total = 0;
				while (read != -1) {
					if ((total <= 491) && (read > 491)) {
						out.write(buffer, 492, (read - 492));
					} else if ((total <= 491) && (read <= 491)) {
					} else {
						out.write(buffer, 0, read);
					}
					total = total + read;
					read = in.read(buffer);
				}
			} catch (Exception e) {
				e.printStackTrace();
				broadcastFail();
			} finally {
				in.close();
				out.close();
			}
			broadcastSuccess();
			count++;
		}
		broadcastDone();
		return count;
	}

}