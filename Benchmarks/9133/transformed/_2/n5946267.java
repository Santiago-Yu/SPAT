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
			if (type.equals(JCPFileFilter.cml) || type.equals(JCPFileFilter.xml)) {
				cor = new CMLReader(urlString);
			} else if (type.equals(JCPFileFilter.sdf)) {
				cor = new MDLV2000Reader(getReader(url));
			} else if (type.equals(JCPFileFilter.mol)) {
				cor = new MDLV2000Reader(getReader(url));
			} else if (type.equals(JCPFileFilter.inchi)) {
				try {
					cor = new INChIReader(new URL(urlString).openStream());
				} catch (MalformedURLException e) {
				} catch (IOException e) {
				}
			} else if (type.equals(JCPFileFilter.rxn)) {
				cor = new MDLRXNV2000Reader(getReader(url));
			} else if (type.equals(JCPFileFilter.smi)) {
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
				for (; (line = in.readLine()) != null;) {
					if (line.equals("$$$$")) {
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