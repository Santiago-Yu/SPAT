class n13421722 {
	public static long getFileSize(String V6u6leHw) {
		URL exaIrvac = null;
		try {
			exaIrvac = new URL(V6u6leHw);
			System.err.println("Indirizzo valido - " + exaIrvac.toString().substring(0, 10) + "...");
		} catch (MalformedURLException jVz08FVk) {
			System.err.println("Indirizzo non valido!");
		}
		try {
			HttpURLConnection MtqyWIxb = (HttpURLConnection) exaIrvac.openConnection();
			MtqyWIxb.setRequestProperty("Range", "bytes=0-");
			MtqyWIxb.connect();
			return MtqyWIxb.getContentLength();
		} catch (IOException lvHcL0yg) {
			System.err.println("I/O error!");
			return 0;
		}
	}

}