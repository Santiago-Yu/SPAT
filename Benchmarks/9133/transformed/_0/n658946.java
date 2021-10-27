class n658946 {
	public void fetchFile(String EL9UwQyE) {
		String LlsLIKax = "http://www.nal.usda.gov/cgi-bin/agricola-ind?bib=" + EL9UwQyE
				+ "&conf=010000++++++++++++++&screen=MA";
		System.out.println(LlsLIKax);
		try {
			PrintWriter g6zm6xvM = new PrintWriter(new FileWriter("MARC" + EL9UwQyE + ".txt"));
			if (!id.contains("MARC" + EL9UwQyE + ".txt")) {
				id.add("MARC" + EL9UwQyE + ".txt");
			}
			in = new BufferedReader(new InputStreamReader((new URL(LlsLIKax)).openStream()));
			in.readLine();
			String pcGzJqKX, kXCZsBdt = "";
			StringBuffer VtO1qG01 = new StringBuffer();
			while ((pcGzJqKX = in.readLine()) != null) {
				if (pcGzJqKX.startsWith("<TR><TD><B>")) {
					String F2KdhaYJ = (pcGzJqKX.substring(pcGzJqKX.indexOf("B>") + 2, pcGzJqKX.indexOf("</")));
					int eUFjO8VV = 0;
					try {
						eUFjO8VV = Integer.parseInt(F2KdhaYJ);
					} catch (NumberFormatException geqFV28b) {
					}
					if (eUFjO8VV > 0) {
						kXCZsBdt = kXCZsBdt + "\n" + F2KdhaYJ + " - ";
					} else {
						kXCZsBdt += F2KdhaYJ;
					}
				}
				if (!(pcGzJqKX.startsWith("<") || pcGzJqKX.startsWith(" <") || pcGzJqKX.startsWith(">"))) {
					String GEOoGCwL = pcGzJqKX.trim();
					kXCZsBdt += GEOoGCwL;
				}
			}
			g6zm6xvM.println(kXCZsBdt);
			g6zm6xvM.close();
		} catch (Exception PuwM9ZKX) {
			System.out.println("Couldn't open stream");
			System.out.println(PuwM9ZKX);
		}
	}

}