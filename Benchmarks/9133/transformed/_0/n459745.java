class n459745 {
	public void fetchFile(String xgJRAJUh) {
		String KKTpKygM = "http://www.nal.usda.gov/cgi-bin/agricola-ind?bib=" + xgJRAJUh
				+ "&conf=010000++++++++++++++&screen=MA";
		System.out.println(KKTpKygM);
		try {
			PrintWriter KILEVinS = new PrintWriter(new FileWriter("MARC" + xgJRAJUh + ".txt"));
			if (!id.contains("MARC" + xgJRAJUh + ".txt")) {
				id.add("MARC" + xgJRAJUh + ".txt");
			}
			in = new BufferedReader(new InputStreamReader((new URL(KKTpKygM)).openStream()));
			in.readLine();
			String irnieZyR, UHFaUwBX = "";
			StringBuffer rqPpc7Kl = new StringBuffer();
			while ((irnieZyR = in.readLine()) != null) {
				if (irnieZyR.startsWith("<TR><TD><B>")) {
					String jUllW0FD = (irnieZyR.substring(irnieZyR.indexOf("B>") + 2, irnieZyR.indexOf("</")));
					int FqVS0PYp = 0;
					try {
						FqVS0PYp = Integer.parseInt(jUllW0FD);
					} catch (NumberFormatException WCKvYBZZ) {
					}
					if (FqVS0PYp > 0) {
						UHFaUwBX = UHFaUwBX + "\n" + jUllW0FD + " - ";
					} else {
						UHFaUwBX += jUllW0FD;
					}
				}
				if (!(irnieZyR.startsWith("<") || irnieZyR.startsWith(" <") || irnieZyR.startsWith(">"))) {
					String nDMYo1YL = irnieZyR.trim();
					UHFaUwBX += nDMYo1YL;
				}
			}
			KILEVinS.println(UHFaUwBX);
			KILEVinS.close();
		} catch (Exception bOGdRXDH) {
			System.out.println("Couldn't open stream");
			System.out.println(bOGdRXDH);
		}
	}

}