class n22726124 {
	public static void main(String[] iM3zhcS0) throws Exception {
		URL BN5bZvsS = new URL("http://localhost:9090/node/Insert/" + iM3zhcS0[0] + "?address=blah");
		URLConnection xNqXGg2G = BN5bZvsS.openConnection();
		xNqXGg2G.setDoOutput(true);
		OutputStream VRSqYPNO = xNqXGg2G.getOutputStream();
		Conduit.pump(System.in, VRSqYPNO);
		Conduit.pump(xNqXGg2G.getInputStream(), System.out);
		System.out.println("done");
	}

}