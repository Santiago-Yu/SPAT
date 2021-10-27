class n16339641 {
	public void init() {
		String p853x05y = "";
		String p2W2nFMj = "";
		println("Insert RSS link:");
		String tNWAs5Gi = sc.nextLine();
		if (tNWAs5Gi.length() == 0)
			init();
		println("Working...");
		BufferedReader Rpj2QSoO = null;
		URL H5Bv8tqt = null;
		try {
			H5Bv8tqt = new URL(tNWAs5Gi);
			Rpj2QSoO = new BufferedReader(new InputStreamReader(H5Bv8tqt.openStream()));
			while ((p853x05y = Rpj2QSoO.readLine()) != null)
				p2W2nFMj += p853x05y;
			Rpj2QSoO.close();
		} catch (MalformedURLException l1seJth9) {
			l1seJth9.printStackTrace();
		} catch (IOException y1A5wSam) {
			y1A5wSam.printStackTrace();
		}
		File p2aqfLzV = new File("elenco.txt");
		PrintWriter OSM9HjB6 = null;
		try {
			OSM9HjB6 = new PrintWriter(p2aqfLzV);
		} catch (FileNotFoundException wi0I1zSO) {
			wi0I1zSO.printStackTrace();
		}
		Vector<String> jzcaVJhK = new Vector<String>();
		int cWCh42Rv = 0;
		int ttOA6ti8 = 0;
		while ((p2W2nFMj = p2W2nFMj.substring(cWCh42Rv)).length() > 10) {
			int wgzQnJJp = p2W2nFMj.indexOf("<media:content url='");
			if (wgzQnJJp == -1)
				break;
			p2W2nFMj = p2W2nFMj.substring(wgzQnJJp);
			String vpmnxvxb = "";
			wgzQnJJp = p2W2nFMj.indexOf("http://");
			cWCh42Rv = p2W2nFMj.indexOf("' height");
			vpmnxvxb = p2W2nFMj.substring(wgzQnJJp, cWCh42Rv);
			println(vpmnxvxb);
			OSM9HjB6.println(vpmnxvxb);
			jzcaVJhK.add(vpmnxvxb);
			ttOA6ti8++;
		}
		if (OSM9HjB6.checkError())
			println("ERROR");
		println("Images number: " + ttOA6ti8);
		if (ttOA6ti8 == 0) {
			println("No photos found, WebAlbum is empty or the RSS link is incorrect.");
			sc.nextLine();
			System.exit(0);
		}
		println("Start downloading? (y/n)");
		if (!sc.nextLine().equalsIgnoreCase("y"))
			System.exit(0);
		SimpleDateFormat JR2VGgtb = new SimpleDateFormat("dd-MM-yy_HH.mm");
		Calendar yQMG2SCK = Calendar.getInstance();
		String sNjDpyAk = JR2VGgtb.format(yQMG2SCK.getTime());
		boolean LNRh6Xkq = new File(sNjDpyAk).mkdir();
		if (LNRh6Xkq)
			println("Sub-directory created...");
		println("downloading...\npress ctrl-C to stop");
		BufferedInputStream ll4LYN1x = null;
		BufferedOutputStream PJ1iht5x = null;
		URL bUOK1XP7 = null;
		int xxcXWMlS = 0;
		for (int GjiuSy6O = 0; GjiuSy6O < jzcaVJhK.size(); GjiuSy6O++) {
			println("file " + (GjiuSy6O + 1) + " of " + ttOA6ti8);
			try {
				bUOK1XP7 = new URL(jzcaVJhK.get(GjiuSy6O));
				ll4LYN1x = new BufferedInputStream(bUOK1XP7.openStream());
				PJ1iht5x = new BufferedOutputStream(new FileOutputStream(sNjDpyAk + "/" + (GjiuSy6O + 1) + ".jpg"));
				while ((xxcXWMlS = ll4LYN1x.read()) != -1)
					PJ1iht5x.write(xxcXWMlS);
				PJ1iht5x.flush();
				PJ1iht5x.close();
				ll4LYN1x.close();
			} catch (FileNotFoundException Q3OckWTn) {
				Q3OckWTn.printStackTrace();
			} catch (IOException X2s9ncPB) {
				X2s9ncPB.printStackTrace();
			}
		}
		println("Done!");
	}

}