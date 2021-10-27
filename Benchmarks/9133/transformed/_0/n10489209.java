class n10489209 {
	public static ISimpleChemObjectReader createReader(URL ObNDUaOX, String xOMb1zr3, String mtuM28Jt)
			throws CDKException {
		if (mtuM28Jt == null) {
			mtuM28Jt = "mol";
		}
		ISimpleChemObjectReader uQcVj7ta = null;
		try {
			Reader xlp2WPX8 = new BufferedReader(getReader(ObNDUaOX));
			FormatFactory T5Lp8Ust = new FormatFactory(8192);
			IChemFormat deigUCrq = T5Lp8Ust.guessFormat(xlp2WPX8);
			if (deigUCrq != null) {
				if (deigUCrq instanceof RGroupQueryFormat) {
					uQcVj7ta = new RGroupQueryReader();
					uQcVj7ta.setReader(xlp2WPX8);
				} else if (deigUCrq instanceof CMLFormat) {
					uQcVj7ta = new CMLReader(xOMb1zr3);
					uQcVj7ta.setReader(ObNDUaOX.openStream());
				} else if (deigUCrq instanceof MDLV2000Format) {
					uQcVj7ta = new MDLV2000Reader(getReader(ObNDUaOX));
					uQcVj7ta.setReader(xlp2WPX8);
				}
			}
		} catch (Exception Y7QQQZoc) {
			Y7QQQZoc.printStackTrace();
		}
		if (uQcVj7ta == null) {
			if (mtuM28Jt.equals(JCPFileFilter.cml) || mtuM28Jt.equals(JCPFileFilter.xml)) {
				uQcVj7ta = new CMLReader(xOMb1zr3);
			} else if (mtuM28Jt.equals(JCPFileFilter.sdf)) {
				uQcVj7ta = new MDLV2000Reader(getReader(ObNDUaOX));
			} else if (mtuM28Jt.equals(JCPFileFilter.mol)) {
				uQcVj7ta = new MDLV2000Reader(getReader(ObNDUaOX));
			} else if (mtuM28Jt.equals(JCPFileFilter.inchi)) {
				try {
					uQcVj7ta = new INChIReader(new URL(xOMb1zr3).openStream());
				} catch (Exception MYHQ1txA) {
					MYHQ1txA.printStackTrace();
				}
			} else if (mtuM28Jt.equals(JCPFileFilter.rxn)) {
				uQcVj7ta = new MDLRXNV2000Reader(getReader(ObNDUaOX));
			} else if (mtuM28Jt.equals(JCPFileFilter.smi)) {
				uQcVj7ta = new SMILESReader(getReader(ObNDUaOX));
			}
		}
		if (uQcVj7ta == null) {
			throw new CDKException(GT._("Could not determine file format"));
		}
		if (uQcVj7ta instanceof MDLV2000Reader) {
			try {
				BufferedReader D7kYHtfd = new BufferedReader(getReader(ObNDUaOX));
				String DECZevTu;
				while ((DECZevTu = D7kYHtfd.readLine()) != null) {
					if (DECZevTu.equals("$$$$")) {
						String Hwg1zG6w = GT._("It seems you opened a mol or sdf"
								+ " file containing several molecules. " + "Only the first one will be shown");
						JOptionPane.showMessageDialog(null, Hwg1zG6w, GT._("sdf-like file"),
								JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
			} catch (IOException We3xPLwh) {
				We3xPLwh.printStackTrace();
			}
		}
		return uQcVj7ta;
	}

}