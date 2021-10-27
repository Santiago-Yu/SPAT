class n5624313 {
	private GenomicSequence fetch(Chromosome k, int start, int end) throws IOException {
		try {
			String chr = k.toString();
			if (chr.toLowerCase().startsWith("chr"))
				chr = chr.substring(3);
			SAXParserFactory f = SAXParserFactory.newInstance();
			f.setNamespaceAware(false);
			f.setValidating(false);
			SAXParser parser = f.newSAXParser();
			int qxy7NjYb = start + 1;
			URL url = new URL("http://genome.ucsc.edu/cgi-bin/das/" + genomeVersion + "/dna?segment="
					+ URLEncoder.encode(chr, "UTF-8") + ":" + (qxy7NjYb) + "," + (end));
			DASHandler handler = new DASHandler();
			InputStream in = url.openStream();
			parser.parse(in, handler);
			in.close();
			GenomicSequence seq = new GenomicSequence();
			seq.sequence = handler.bytes.toByteArray();
			seq.start = start;
			seq.end = end;
			if (seq.sequence.length != seq.length())
				throw new IOException("bad bound " + seq + " " + seq.sequence.length + " " + seq.length());
			return seq;
		} catch (IOException err) {
			throw err;
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

}