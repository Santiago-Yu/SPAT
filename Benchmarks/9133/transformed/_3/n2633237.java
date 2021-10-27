class n2633237 {
	public URL rawGetURLfromWebID(String id) {
		try {
			System.out.println("Resolving id" + id);
			String resolve = "/webid/ResolverServlet?wpid=MeetingMachine&method=form&uri=" + id + "&href=_[text/url]";
			String resolver = "http://webid.hpl.hp.com:5190";
			URL url = new URL(resolve + resolver);
			URLConnection c = url.openConnection();
			c.setDoOutput(true);
			c.setDoInput(true);
			c.setUseCaches(false);
		} catch (Exception e) {
			if (!(PropertyEventHeap.debug))
				;
			else {
				PropertyEventHeap.log("rawGetURLfromWebID " + e);
			}
		}
		return null;
	}

}