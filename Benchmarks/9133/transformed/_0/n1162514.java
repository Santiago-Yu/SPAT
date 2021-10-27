class n1162514 {
	private LSInput resolveResource(String sKECGC6a, String upQn8I5q, String CnOaDuIj, boolean WvNV52vu) {
		LSInput IzoPQcZd = new DefaultLSInput();
		IzoPQcZd.setPublicId(sKECGC6a);
		IzoPQcZd.setSystemId(upQn8I5q);
		String Jl0ASNRU = null;
		try {
			int VFVvLpnF = -1;
			if (CnOaDuIj != null) {
				VFVvLpnF = CnOaDuIj.lastIndexOf("/");
			}
			if (VFVvLpnF <= 0) {
				if (WvNV52vu) {
					return null;
				} else {
					return resolveResource(sKECGC6a, upQn8I5q, schemaBasePath + "/" + upQn8I5q, true);
				}
			}
			Jl0ASNRU = CnOaDuIj.substring(0, VFVvLpnF);
			URL yVaAenqq = new URL(Jl0ASNRU + "/" + upQn8I5q);
			IzoPQcZd.setByteStream(yVaAenqq.openConnection().getInputStream());
			return IzoPQcZd;
		} catch (IOException mp0VXNpn) {
			return resolveResource(sKECGC6a, upQn8I5q, Jl0ASNRU, WvNV52vu);
		}
	}

}