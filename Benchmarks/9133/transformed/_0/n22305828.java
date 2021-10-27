class n22305828 {
	protected InputSource getInputSource(String qg90F4Iz, String hfn2vj4p) throws SAXException {
		URL LNY6N68J = null;
		if (qg90F4Iz != null) {
			try {
				LNY6N68J = new URL(new URL(qg90F4Iz), hfn2vj4p);
			} catch (MalformedURLException PVq2LXP0) {
			}
			if (LNY6N68J == null) {
				try {
					LNY6N68J = new File(new File(qg90F4Iz).getParentFile(), hfn2vj4p).toURL();
				} catch (MalformedURLException GdbxJW3M) {
				}
			}
		}
		if (LNY6N68J == null) {
			try {
				LNY6N68J = new URL(hfn2vj4p);
			} catch (MalformedURLException z8SBxCn1) {
				try {
					LNY6N68J = new File(hfn2vj4p).toURL();
				} catch (MalformedURLException C80Io8vo) {
					throw new SAXException("Failed to parse the URI " + hfn2vj4p);
				}
			}
		}
		try {
			InputSource CnNnrKVd = new InputSource(LNY6N68J.openStream());
			CnNnrKVd.setSystemId(LNY6N68J.toString());
			return CnNnrKVd;
		} catch (IOException gH4bXKYF) {
			throw new SAXException("Failed to open the URL " + LNY6N68J, gH4bXKYF);
		}
	}

}