class n518901 {
	public void fetchFile(String NdMyvNT5) {
		String hON2WftR = "http://www.nal.usda.gov/cgi-bin/agricola-ind?bib=" + NdMyvNT5
				+ "&conf=010000++++++++++++++&screen=MA";
		System.out.println(hON2WftR);
		try {
			PrintWriter a9jh4evQ = new PrintWriter(new FileWriter("MARC" + NdMyvNT5 + ".txt"));
			if (!id.contains("MARC" + NdMyvNT5 + ".txt")) {
				id.add("MARC" + NdMyvNT5 + ".txt");
			}
			in = new BufferedReader(new InputStreamReader((new URL(hON2WftR)).openStream()));
			in.readLine();
			String pcJCfLvP, VkNrntQ4 = "";
			StringBuffer lymkqXHP = new StringBuffer();
			while ((pcJCfLvP = in.readLine()) != null) {
				if (pcJCfLvP.startsWith("<TR><TD><B>")) {
					String ObGS6OVh = (pcJCfLvP.substring(pcJCfLvP.indexOf("B>") + 2, pcJCfLvP.indexOf("</")));
					int I9D3J92U = 0;
					try {
						I9D3J92U = Integer.parseInt(ObGS6OVh);
					} catch (NumberFormatException YQ2nr5aK) {
					}
					if (I9D3J92U > 0) {
						VkNrntQ4 = VkNrntQ4 + "\n" + ObGS6OVh + " - ";
					} else {
						VkNrntQ4 += ObGS6OVh;
					}
				}
				if (!(pcJCfLvP.startsWith("<") || pcJCfLvP.startsWith(" <") || pcJCfLvP.startsWith(">"))) {
					String IdPKGtt9 = pcJCfLvP.trim();
					VkNrntQ4 += IdPKGtt9;
				}
			}
			a9jh4evQ.println(VkNrntQ4);
			a9jh4evQ.close();
		} catch (Exception dm0i3mex) {
			System.out.println("Couldn't open stream");
			System.out.println(dm0i3mex);
		}
	}

}