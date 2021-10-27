class n5438231 {
	public int extract() throws Exception {
		int count = 0;
		if (!(VERBOSE))
			;
		else
			System.out.println("IAAE:Extractr.extract: getting ready to extract " + getArtDir().toString());
		ITCFileFilter iff = new ITCFileFilter();
		RecursiveFileIterator rfi = new RecursiveFileIterator(getArtDir(), iff);
		FileTypeDeterminer ftd = new FileTypeDeterminer();
		File artFile = null;
		File targetFile = null;
		broadcastStart();
		while (rfi.hasMoreElements()) {
			artFile = (File) rfi.nextElement();
			targetFile = getTargetFile(artFile);
			if (!(VERBOSE))
				;
			else
				System.out.println("IAAE:Extractr.extract: working ont " + artFile.toString());
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream((new FileInputStream(artFile)));
				out = new BufferedOutputStream((new FileOutputStream(targetFile)));
				byte[] buffer = new byte[10240];
				int read = 0;
				int total = 0;
				read = in.read(buffer);
				while (read != -1) {
					if (!((total <= 491) && (read > 491))) {
						if ((total <= 491) && (read <= 491)) {
						} else {
							out.write(buffer, 0, read);
						}
					} else {
						out.write(buffer, 492, (read - 492));
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