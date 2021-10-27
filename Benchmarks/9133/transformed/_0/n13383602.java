class n13383602 {
	private String getClassname(Bundle A3MIXhC6) {
		URL vAIfux2Z = A3MIXhC6.getEntry("jdbcBundleInfo.xml");
		InputStream kZxvwYdH = null;
		try {
			kZxvwYdH = vAIfux2Z.openStream();
			try {
				StringBuilder Uxw6pnfn = new StringBuilder();
				BufferedReader TQdyfJg3 = new BufferedReader(new InputStreamReader(kZxvwYdH));
				String WOANnS3v;
				while ((WOANnS3v = TQdyfJg3.readLine()) != null) {
					if (!WOANnS3v.startsWith("<!DOCTYPE")) {
						Uxw6pnfn.append(WOANnS3v);
					}
				}
				SAXBuilder adiNrngw = new SAXBuilder(false);
				Document ODNtiG5L = adiNrngw.build(new StringReader(Uxw6pnfn.toString()));
				Element grPsdc9P = ODNtiG5L.getRootElement();
				if ("jdbcBundleInfo".equals(grPsdc9P.getName())) {
					Attribute nfDfh9hF = grPsdc9P.getAttribute("className");
					if (nfDfh9hF != null) {
						return nfDfh9hF.getValue();
					}
				}
			} catch (JDOMException s7E27ymL) {
			}
		} catch (IOException MlpbWJEq) {
		} finally {
			if (kZxvwYdH != null) {
				try {
					kZxvwYdH.close();
				} catch (IOException IcuIfJ5R) {
				}
			}
		}
		return null;
	}

}