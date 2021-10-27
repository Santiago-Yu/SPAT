class n1718146 {
	public static void main(String[] oQv84jY3) {
		try {
			String mogJq60N = "http://www.cs.nmsu.edu/~bchisham/cgi-bin/phylows/tree/Tree3099?format=graphml";
			URL TI7jPii0 = new URL(mogJq60N);
			InputStream h5LorEpJ = TI7jPii0.openStream();
			Scanner zPjJtkV8 = new Scanner(h5LorEpJ);
			while (zPjJtkV8.hasNext()) {
				System.out.println(zPjJtkV8.next());
			}
		} catch (MalformedURLException RBdVNLlK) {
			Logger.getLogger(GraphUrlLoader.class.getName()).log(Level.SEVERE, null, RBdVNLlK);
		} catch (IOException xhPMVzqG) {
		}
	}

}