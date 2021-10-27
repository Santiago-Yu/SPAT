class n7945594 {
	public static void fileDownload(String fAddress, String destinationDir) {
		int slashIndex = fAddress.lastIndexOf('/');
		int periodIndex = fAddress.lastIndexOf('.');
		URL url;
		String fileName = fAddress.substring(slashIndex + 1);
		try {
			url = new URL(fAddress);
			URLConnection uc = url.openConnection();
			File file = new File(destinationDir + "/download.pdf");
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			FileOutputStream fos = new FileOutputStream(file);
			int inputLine;
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			while ((inputLine = in.read()) != -1)
				out.write(inputLine);
			in.close();
		} catch (Exception ex) {
			Logger.getLogger(UrlDownload.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}