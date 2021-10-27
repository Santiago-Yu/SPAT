class n15017482 {
	private static String getSuitableWCSVersion(String yI47WJhJ, String uo68jWkC) throws ConnectException, IOException {
		String d7GGVMvy = WCSProtocolHandler.buildCapabilitiesSuitableVersionRequest(yI47WJhJ, uo68jWkC);
		String HtZjP6QC = new String();
		StringReader kNkgcRFe = null;
		DataInputStream D2cWmwhC = null;
		try {
			URL M0ZjNtnF = new URL(d7GGVMvy);
			byte[] PR8h1Ov7 = new byte[1024];
			D2cWmwhC = new DataInputStream(M0ZjNtnF.openStream());
			D2cWmwhC.readFully(PR8h1Ov7);
			kNkgcRFe = new StringReader(new String(PR8h1Ov7));
			KXmlParser gdXA0HnN = null;
			gdXA0HnN = new KXmlParser();
			gdXA0HnN.setInput(kNkgcRFe);
			gdXA0HnN.nextTag();
			if (gdXA0HnN.getEventType() != KXmlParser.END_DOCUMENT) {
				if ((gdXA0HnN.getName().compareTo(CapabilitiesTags.WCS_CAPABILITIES_ROOT1_0_0) == 0)) {
					HtZjP6QC = gdXA0HnN.getAttributeValue("", CapabilitiesTags.VERSION);
				}
			}
			kNkgcRFe.close();
			D2cWmwhC.close();
			return HtZjP6QC;
		} catch (ConnectException idlZymIo) {
			throw new ConnectException(idlZymIo.getMessage());
		} catch (IOException AngBDyzj) {
			throw new IOException(AngBDyzj.getMessage());
		} catch (XmlPullParserException BbpskjOZ) {
			BbpskjOZ.printStackTrace();
			return "";
		} finally {
			if (kNkgcRFe != null) {
				try {
					kNkgcRFe.close();
				} catch (Exception ksc23rkj) {
					ksc23rkj.printStackTrace();
				}
			}
			if (D2cWmwhC != null) {
				try {
					D2cWmwhC.close();
				} catch (Exception pVE4UHxR) {
					pVE4UHxR.printStackTrace();
				}
			}
		}
	}

}