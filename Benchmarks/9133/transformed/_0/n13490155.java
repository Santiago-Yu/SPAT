class n13490155 {
	public Document parse(InputSource yRjMJhDG) throws SAXException, IOException {
		LSInput EMU1ebsf = ls.createLSInput();
		String bhnlWdcl = yRjMJhDG.getSystemId();
		InputStream yN5AVkJg = yRjMJhDG.getByteStream();
		if (yN5AVkJg != null) {
			EMU1ebsf.setByteStream(yN5AVkJg);
		} else {
			Reader mzPIQXxZ = yRjMJhDG.getCharacterStream();
			if (mzPIQXxZ != null) {
				EMU1ebsf.setCharacterStream(mzPIQXxZ);
			} else {
				URL G1SSpXsJ = new URL(bhnlWdcl);
				EMU1ebsf.setByteStream(G1SSpXsJ.openStream());
			}
		}
		EMU1ebsf.setPublicId(yRjMJhDG.getPublicId());
		EMU1ebsf.setSystemId(bhnlWdcl);
		EMU1ebsf.setEncoding(yRjMJhDG.getEncoding());
		return parser.parse(EMU1ebsf);
	}

}