class n2633237 {
	public URL rawGetURLfromWebID(String jCU7R9nV) {
		try {
			System.out.println("Resolving id" + jCU7R9nV);
			String tojSaMCt = "/webid/ResolverServlet?wpid=MeetingMachine&method=form&uri=" + jCU7R9nV
					+ "&href=_[text/url]";
			String Xy6GCASa = "http://webid.hpl.hp.com:5190";
			URL FVm6F61m = new URL(tojSaMCt + Xy6GCASa);
			URLConnection GCbBanYH = FVm6F61m.openConnection();
			GCbBanYH.setDoOutput(true);
			GCbBanYH.setDoInput(true);
			GCbBanYH.setUseCaches(false);
		} catch (Exception MaITMWu4) {
			if (PropertyEventHeap.debug) {
				PropertyEventHeap.log("rawGetURLfromWebID " + MaITMWu4);
			}
		}
		return null;
	}

}