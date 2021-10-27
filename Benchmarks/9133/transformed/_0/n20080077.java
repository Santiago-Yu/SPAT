class n20080077 {
	public Writer createWriter(File TErPMlOx, String cvWmLnHP) throws UnsupportedEncodingException, IOException {
		int Sy9D6bSi = 1024;
		int r6ObegdH;
		char[] MCdyJoJp = new char[Sy9D6bSi];
		ZipOutputStream NCbuO6bY = new ZipOutputStream(new FileOutputStream(TErPMlOx));
		NCbuO6bY.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter MWlDdFDV = new OutputStreamWriter(NCbuO6bY, "ISO-8859-1");
		BufferedWriter EVq7ZsvG = new BufferedWriter(MWlDdFDV);
		ZipEntry sP3C9tmU;
		ZipInputStream PTXnqsxC = new ZipInputStream(new FileInputStream(infile));
		InputStreamReader x0H4BqnF = new InputStreamReader(PTXnqsxC, "ISO-8859-1");
		BufferedReader OCyExrrb = new BufferedReader(x0H4BqnF);
		ZipEntry FF8p0SnJ;
		while ((FF8p0SnJ = PTXnqsxC.getNextEntry()) != null) {
			if (FF8p0SnJ.getName().equals("content.xml")) {
				continue;
			}
			sP3C9tmU = new ZipEntry(FF8p0SnJ.getName());
			NCbuO6bY.putNextEntry(sP3C9tmU);
			while ((r6ObegdH = OCyExrrb.read(MCdyJoJp, 0, Sy9D6bSi)) >= 0)
				EVq7ZsvG.write(MCdyJoJp, 0, r6ObegdH);
			EVq7ZsvG.flush();
			NCbuO6bY.closeEntry();
		}
		NCbuO6bY.putNextEntry(new ZipEntry("content.xml"));
		EVq7ZsvG.flush();
		return new OutputStreamWriter(NCbuO6bY, "UTF-8");
	}

}