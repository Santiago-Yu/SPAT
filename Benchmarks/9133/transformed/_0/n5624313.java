class n5624313 {
	private GenomicSequence fetch(Chromosome kw4KfQ7n, int XX1PmZ5g, int Y9H2G6VA) throws IOException {
		try {
			String pezknwAy = kw4KfQ7n.toString();
			if (pezknwAy.toLowerCase().startsWith("chr"))
				pezknwAy = pezknwAy.substring(3);
			SAXParserFactory B5E3j86H = SAXParserFactory.newInstance();
			B5E3j86H.setNamespaceAware(false);
			B5E3j86H.setValidating(false);
			SAXParser kf64cCqJ = B5E3j86H.newSAXParser();
			URL mKTnnfta = new URL("http://genome.ucsc.edu/cgi-bin/das/" + genomeVersion + "/dna?segment="
					+ URLEncoder.encode(pezknwAy, "UTF-8") + ":" + (XX1PmZ5g + 1) + "," + (Y9H2G6VA));
			DASHandler EHAdNgbo = new DASHandler();
			InputStream bY2LI6ZF = mKTnnfta.openStream();
			kf64cCqJ.parse(bY2LI6ZF, EHAdNgbo);
			bY2LI6ZF.close();
			GenomicSequence J2OsisVK = new GenomicSequence();
			J2OsisVK.sequence = EHAdNgbo.bytes.toByteArray();
			J2OsisVK.start = XX1PmZ5g;
			J2OsisVK.end = Y9H2G6VA;
			if (J2OsisVK.sequence.length != J2OsisVK.length())
				throw new IOException(
						"bad bound " + J2OsisVK + " " + J2OsisVK.sequence.length + " " + J2OsisVK.length());
			return J2OsisVK;
		} catch (IOException XpmY8TtD) {
			throw XpmY8TtD;
		} catch (Exception VxsOb01q) {
			throw new IOException(VxsOb01q);
		}
	}

}