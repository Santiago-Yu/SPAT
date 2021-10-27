class n118288 {
	public void fetchFile(String rfjyVrmu) {
		String QEJeixzP = "http://www.nal.usda.gov/cgi-bin/agricola-ind?bib=" + rfjyVrmu
				+ "&conf=010000++++++++++++++&screen=MA";
		System.out.println(QEJeixzP);
		try {
			PrintWriter MPyCjFVT = new PrintWriter(new FileWriter("MARC" + rfjyVrmu + ".txt"));
			if (!id.contains("MARC" + rfjyVrmu + ".txt")) {
				id.add("MARC" + rfjyVrmu + ".txt");
			}
			in = new BufferedReader(new InputStreamReader((new URL(QEJeixzP)).openStream()));
			in.readLine();
			String XV2dsgpV, y89Bv1V7 = "";
			StringBuffer rsNxAsDz = new StringBuffer();
			while ((XV2dsgpV = in.readLine()) != null) {
				if (XV2dsgpV.startsWith("<TR><TD><B>")) {
					String jQPQd4oG = (XV2dsgpV.substring(XV2dsgpV.indexOf("B>") + 2, XV2dsgpV.indexOf("</")));
					int oYDgjVEI = 0;
					try {
						oYDgjVEI = Integer.parseInt(jQPQd4oG);
					} catch (NumberFormatException Lxg2swYO) {
					}
					if (oYDgjVEI > 0) {
						y89Bv1V7 = y89Bv1V7 + "\n" + jQPQd4oG + " - ";
					} else {
						y89Bv1V7 += jQPQd4oG;
					}
				}
				if (!(XV2dsgpV.startsWith("<") || XV2dsgpV.startsWith(" <") || XV2dsgpV.startsWith(">"))) {
					String zqaaQxAw = XV2dsgpV.trim();
					y89Bv1V7 += zqaaQxAw;
				}
			}
			MPyCjFVT.println(y89Bv1V7);
			MPyCjFVT.close();
		} catch (Exception pop5UvW8) {
			System.out.println("Couldn't open stream");
			System.out.println(pop5UvW8);
		}
	}

}