class n5946267 {
	private static ISimpleChemObjectReader createReader(URL lZF3cDKL, String pGFF4Ey2, String SRPdZZYQ)
			throws CDKException {
		if (SRPdZZYQ == null) {
			SRPdZZYQ = "mol";
		}
		ISimpleChemObjectReader cAqVWkpB = null;
		cAqVWkpB = new MDLV2000Reader(getReader(lZF3cDKL), Mode.RELAXED);
		try {
			ReaderFactory I0BUcefu = new ReaderFactory();
			cAqVWkpB = I0BUcefu.createReader(getReader(lZF3cDKL));
			if (cAqVWkpB instanceof CMLReader) {
				cAqVWkpB = new CMLReader(pGFF4Ey2);
			}
		} catch (IOException jkIlrY9t) {
		} catch (Exception CzPvRYDk) {
		}
		if (cAqVWkpB == null) {
			if (SRPdZZYQ.equals(JCPFileFilter.cml) || SRPdZZYQ.equals(JCPFileFilter.xml)) {
				cAqVWkpB = new CMLReader(pGFF4Ey2);
			} else if (SRPdZZYQ.equals(JCPFileFilter.sdf)) {
				cAqVWkpB = new MDLV2000Reader(getReader(lZF3cDKL));
			} else if (SRPdZZYQ.equals(JCPFileFilter.mol)) {
				cAqVWkpB = new MDLV2000Reader(getReader(lZF3cDKL));
			} else if (SRPdZZYQ.equals(JCPFileFilter.inchi)) {
				try {
					cAqVWkpB = new INChIReader(new URL(pGFF4Ey2).openStream());
				} catch (MalformedURLException RoEEC863) {
				} catch (IOException ibb7n5zf) {
				}
			} else if (SRPdZZYQ.equals(JCPFileFilter.rxn)) {
				cAqVWkpB = new MDLRXNV2000Reader(getReader(lZF3cDKL));
			} else if (SRPdZZYQ.equals(JCPFileFilter.smi)) {
				cAqVWkpB = new SMILESReader(getReader(lZF3cDKL));
			}
		}
		if (cAqVWkpB == null) {
			throw new CDKException(GT._("Could not determine file format"));
		}
		if (cAqVWkpB instanceof MDLV2000Reader) {
			try {
				BufferedReader uIXrhXtb = new BufferedReader(getReader(lZF3cDKL));
				String wkYn4iaK;
				while ((wkYn4iaK = uIXrhXtb.readLine()) != null) {
					if (wkYn4iaK.equals("$$$$")) {
						String J0rxs5Qr = GT._("It seems you opened a mol or sdf"
								+ " file containing several molecules. " + "Only the first one will be shown");
						JOptionPane.showMessageDialog(null, J0rxs5Qr, GT._("sdf-like file"),
								JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
			} catch (IOException APaDUba7) {
			}
		}
		return cAqVWkpB;
	}

}