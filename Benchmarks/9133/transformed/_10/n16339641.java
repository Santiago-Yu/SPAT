class n16339641 {
	public void init() {
		String inputLine = "";
		String registeredLine = "";
		println("Insert RSS link:");
		String urlString = sc.nextLine();
		if (urlString.length() == 0)
			init();
		println("Working...");
		URL url = null;
		BufferedReader in = null;
		File elenco = new File("elenco.txt");
		try {
			url = new URL(urlString);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null)
				registeredLine += inputLine;
			in.close();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pout = null;
		Vector<String> vector = new Vector<String>();
		try {
			pout = new PrintWriter(elenco);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int numeroFoto = 0;
		int endIndex = 0;
		while ((registeredLine = registeredLine.substring(endIndex)).length() > 10) {
			int startIndex = registeredLine.indexOf("<media:content url='");
			if (startIndex == -1)
				break;
			String address = "";
			registeredLine = registeredLine.substring(startIndex);
			startIndex = registeredLine.indexOf("http://");
			endIndex = registeredLine.indexOf("' height");
			address = registeredLine.substring(startIndex, endIndex);
			println(address);
			pout.println(address);
			vector.add(address);
			numeroFoto++;
		}
		if (pout.checkError())
			println("ERROR");
		println("Images number: " + numeroFoto);
		if (numeroFoto == 0) {
			println("No photos found, WebAlbum is empty or the RSS link is incorrect.");
			sc.nextLine();
			System.exit(0);
		}
		println("Start downloading? (y/n)");
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yy_HH.mm");
		if (!sc.nextLine().equalsIgnoreCase("y"))
			System.exit(0);
		Calendar oggi = Calendar.getInstance();
		String cartella = data.format(oggi.getTime());
		boolean success = new File(cartella).mkdir();
		if (success)
			println("Sub-directory created...");
		println("downloading...\npress ctrl-C to stop");
		BufferedOutputStream bout = null;
		BufferedInputStream bin = null;
		int len = 0;
		URL photoAddr = null;
		for (int x = 0; x < vector.size(); x++) {
			println("file " + (x + 1) + " of " + numeroFoto);
			try {
				photoAddr = new URL(vector.get(x));
				bout = new BufferedOutputStream(new FileOutputStream(cartella + "/" + (x + 1) + ".jpg"));
				bin = new BufferedInputStream(photoAddr.openStream());
				while ((len = bin.read()) != -1)
					bout.write(len);
				bout.flush();
				bout.close();
				bin.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		println("Done!");
	}

}