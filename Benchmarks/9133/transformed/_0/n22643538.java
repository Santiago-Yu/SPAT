class n22643538 {
	InputStream createInputStream(FileInfo nWyNXXrc) throws IOException, MalformedURLException {
		if (nWyNXXrc.inputStream != null)
			return nWyNXXrc.inputStream;
		else if (nWyNXXrc.url != null && !nWyNXXrc.url.equals(""))
			return new URL(nWyNXXrc.url + nWyNXXrc.fileName).openStream();
		else {
			File mQcHbTah = new File(nWyNXXrc.directory + nWyNXXrc.fileName);
			if (mQcHbTah == null || mQcHbTah.isDirectory())
				return null;
			else {
				InputStream ZMyrak67 = new FileInputStream(mQcHbTah);
				if (nWyNXXrc.compression >= FileInfo.LZW)
					ZMyrak67 = new RandomAccessStream(ZMyrak67);
				return ZMyrak67;
			}
		}
	}

}