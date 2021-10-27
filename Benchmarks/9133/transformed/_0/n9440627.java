class n9440627 {
	protected URLConnection openConnection(URL Jmv2nTxg) throws IOException {
		log.log(Level.FINE, Jmv2nTxg.toString());
		MSServletRequest acU31qJa = new MSServletRequest(Jmv2nTxg);
		MicroServlet kPkykr8z = getServlet(acU31qJa);
		return (new MSConnection(Jmv2nTxg, kPkykr8z, acU31qJa));
	}

}