class n13439950 {
	public String readRemoteFile() throws IOException {
		boolean eof = false;
		String response = "";
		URL url = new URL(StaticData.remoteFile);
		InputStream is = url.openStream();
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		s = br.readLine();
		response = s;
		while (!eof) {
			try {
				s = br.readLine();
				if (s == null) {
					eof = true;
					br.close();
				} else
					response += s;
			} catch (EOFException eo) {
				eof = true;
			} catch (IOException e) {
				System.out.println("IO Error : " + e.getMessage());
			}
		}
		return response;
	}

}