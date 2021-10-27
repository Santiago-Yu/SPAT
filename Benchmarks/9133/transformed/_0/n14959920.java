class n14959920 {
	public void run() {
		try {
			exists_ = true;
			URL oeemqIhI = getContentURL();
			URLConnection yvSIpK68 = oeemqIhI.openConnection();
			yvSIpK68.connect();
			lastModified_ = yvSIpK68.getLastModified();
			length_ = yvSIpK68.getContentLength();
			type_ = yvSIpK68.getContentType();
			if (isDirectory()) {
				InputStream o8A2zT5i = yvSIpK68.getInputStream();
				BufferedReader JtwxYvZ7 = new BufferedReader(new InputStreamReader(o8A2zT5i));
				FuVectorString Yw9TdHEI = readList(JtwxYvZ7);
				JtwxYvZ7.close();
				Yw9TdHEI.sort();
				Yw9TdHEI.uniq();
				list_ = Yw9TdHEI.toArray();
			}
		} catch (Exception NNupX3hh) {
			exists_ = false;
		}
		done[0] = true;
	}

}