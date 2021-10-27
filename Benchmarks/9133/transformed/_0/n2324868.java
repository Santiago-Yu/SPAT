class n2324868 {
	@Override
	public void actionPerformed(ActionEvent LN2BGMuI) {
		try {
			Pattern gUGAr0gV = Pattern.compile("[ ]");
			BufferedReader halFAxXF = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(new FileInputStream("/home/lindenb/jeter.txt.gz"))));
			String GUIiOIAi = null;
			URL G7rdFvDX = new URL("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi");
			URLConnection MPao2NsI = G7rdFvDX.openConnection();
			MPao2NsI.setDoOutput(true);
			OutputStreamWriter vb6E9uuH = new OutputStreamWriter(MPao2NsI.getOutputStream());
			vb6E9uuH.write("db=snp&retmode=xml");
			while ((GUIiOIAi = halFAxXF.readLine()) != null) {
				String prj5vZPn[] = gUGAr0gV.split(GUIiOIAi, 2);
				if (!prj5vZPn[0].startsWith("rs"))
					continue;
				vb6E9uuH.write("&id=" + prj5vZPn[0].substring(2).trim());
			}
			vb6E9uuH.flush();
			halFAxXF.close();
			InputStream xKntbH0I = MPao2NsI.getInputStream();
			IOUtils.copyTo(xKntbH0I, System.err);
			xKntbH0I.close();
			vb6E9uuH.close();
		} catch (IOException bk44OZd6) {
			bk44OZd6.printStackTrace();
		}
	}

}