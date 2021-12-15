class n10489209 {
	public static ISimpleChemObjectReader createReader(URL url, String urlString, String type) throws CDKException {
		if (type == null) {
			type = "mol";
		}
		ISimpleChemObjectReader cor = null;
		try {
			Reader input = new BufferedReader(getReader(url));
			FormatFactory formatFactory = new FormatFactory(8192);
			IChemFormat format = formatFactory.guessFormat(input);
			if (format != null) {
				if (format instanceof RGroupQueryFormat) {
					cor = new RGroupQueryReader();
					cor.setReader(input);
				} else if (format instanceof CMLFormat) {
					cor = new CMLReader(urlString);
					cor.setReader(url.openStream());
				} else if (format instanceof MDLV2000Format) {
					cor = new MDLV2000Reader(getReader(url));
					cor.setReader(input);
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		if (cor == null) {
			if (JCPFileFilter.cml.equals(type) || JCPFileFilter.xml.equals(type)) {
				cor = new CMLReader(urlString);
			} else if (JCPFileFilter.sdf.equals(type)) {
				cor = new MDLV2000Reader(getReader(url));
			} else if (JCPFileFilter.mol.equals(type)) {
				cor = new MDLV2000Reader(getReader(url));
			} else if (JCPFileFilter.inchi.equals(type)) {
				try {
					cor = new INChIReader(new URL(urlString).openStream());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (JCPFileFilter.rxn.equals(type)) {
				cor = new MDLRXNV2000Reader(getReader(url));
			} else if (JCPFileFilter.smi.equals(type)) {
				cor = new SMILESReader(getReader(url));
			}
		}
		if (cor == null) {
			throw new CDKException(GT._("Could not determine file format"));
		}
		if (cor instanceof MDLV2000Reader) {
			try {
				BufferedReader in = new BufferedReader(getReader(url));
				String line;
				while ((line = in.readLine()) != null) {
					if ("$$$$".equals(line)) {
						String message = GT._("It seems you opened a mol or sdf"
								+ " file containing several molecules. " + "Only the first one will be shown");
						JOptionPane.showMessageDialog(null, message, GT._("sdf-like file"),
								JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return cor;
	}

}