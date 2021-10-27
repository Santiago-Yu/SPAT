class n11904056 {
	public static void convertEncoding(File INFzYQB6, File lzQJE9IM, String SzTm4gwS, String hFHkl6xK)
			throws IOException, UnsupportedEncodingException {
		InputStream hvojkkbJ;
		if (INFzYQB6 != null)
			hvojkkbJ = new FileInputStream(INFzYQB6);
		else
			hvojkkbJ = System.in;
		OutputStream MxL7qvOC;
		lzQJE9IM.createNewFile();
		if (lzQJE9IM != null)
			MxL7qvOC = new FileOutputStream(lzQJE9IM);
		else
			MxL7qvOC = System.out;
		if (SzTm4gwS == null)
			SzTm4gwS = System.getProperty("file.encoding");
		if (hFHkl6xK == null)
			hFHkl6xK = "Unicode";
		Reader rroOEVK8 = new BufferedReader(new InputStreamReader(hvojkkbJ, SzTm4gwS));
		Writer VLWzeJVp = new BufferedWriter(new OutputStreamWriter(MxL7qvOC, hFHkl6xK));
		char[] mAu8Fd6S = new char[4096];
		int JuyDTrds;
		while ((JuyDTrds = rroOEVK8.read(mAu8Fd6S)) != -1)
			VLWzeJVp.write(mAu8Fd6S, 0, JuyDTrds);
		rroOEVK8.close();
		VLWzeJVp.close();
	}

}