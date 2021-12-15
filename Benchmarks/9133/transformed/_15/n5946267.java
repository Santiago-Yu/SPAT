class n5946267 {
	private static ISimpleChemObjectReader createReader(URL url, String urlString, String type) throws CDKException {
		if (type == null) {
			type = "mol";
		}
		ISimpleChemObjectReader cor = null;
		cor = new MDLV2000Reader(getReader(url), Mode.RELAXED);
		try {
			ReaderFactory factory = new ReaderFactory();
			cor = factory.createReader(getReader(url));
			if (cor instanceof CMLReader) {
				cor = new CMLReader(urlString);
			}
		} catch (IOException ioExc) {
		} catch (Exception exc) {
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
				} catch (MalformedURLException e) {
				} catch (IOException e) {
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
			}
		}
		return cor;
	}

}