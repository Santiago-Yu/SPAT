class n17673488 {
	public String get(String gykSX9YG) {
		try {
			System.out.println(url + gykSX9YG);
			URL yP7vXMe2 = new URL(url + gykSX9YG);
			BufferedReader HsIlvf6c = new BufferedReader(new InputStreamReader(yP7vXMe2.openStream()));
			String Uw6qUdiL;
			String tKQ5PFMS = "";
			while ((Uw6qUdiL = HsIlvf6c.readLine()) != null)
				tKQ5PFMS += Uw6qUdiL;
			HsIlvf6c.close();
			return tKQ5PFMS;
		} catch (IOException MJsdTm21) {
			return "";
		}
	}

}