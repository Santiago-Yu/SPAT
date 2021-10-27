class n103593 {
	public void fetchFile(String oxAb7RXl) {
		String CcA0Gbem = "http://www.nal.usda.gov/cgi-bin/agricola-ind?bib=" + oxAb7RXl
				+ "&conf=010000++++++++++++++&screen=MA";
		System.out.println(CcA0Gbem);
		try {
			PrintWriter U3XpzocK = new PrintWriter(new FileWriter("MARC" + oxAb7RXl + ".txt"));
			if (!id.contains("MARC" + oxAb7RXl + ".txt")) {
				id.add("MARC" + oxAb7RXl + ".txt");
			}
			in = new BufferedReader(new InputStreamReader((new URL(CcA0Gbem)).openStream()));
			in.readLine();
			String hJvkDwOp, hzlXAuSi = "";
			StringBuffer x1NAJmaY = new StringBuffer();
			while ((hJvkDwOp = in.readLine()) != null) {
				if (hJvkDwOp.startsWith("<TR><TD><B>")) {
					String HYLfDKpt = (hJvkDwOp.substring(hJvkDwOp.indexOf("B>") + 2, hJvkDwOp.indexOf("</")));
					int HKJIKiam = 0;
					try {
						HKJIKiam = Integer.parseInt(HYLfDKpt);
					} catch (NumberFormatException zRViuXXB) {
					}
					if (HKJIKiam > 0) {
						hzlXAuSi = hzlXAuSi + "\n" + HYLfDKpt + " - ";
					} else {
						hzlXAuSi += HYLfDKpt;
					}
				}
				if (!(hJvkDwOp.startsWith("<") || hJvkDwOp.startsWith(" <") || hJvkDwOp.startsWith(">"))) {
					String S40GZEZu = hJvkDwOp.trim();
					hzlXAuSi += S40GZEZu;
				}
			}
			U3XpzocK.println(hzlXAuSi);
			U3XpzocK.close();
		} catch (Exception CgxathwF) {
			System.out.println("Couldn't open stream");
			System.out.println(CgxathwF);
		}
	}

}