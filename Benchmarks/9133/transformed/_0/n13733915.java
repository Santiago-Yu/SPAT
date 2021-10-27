class n13733915 {
	public static void contentTrans(String wNHj0lrD, String ky0GuAvs, String HjAM16oZ, String RNVz8lkZ, int Qa0ppEN7) {
		try {
			URL U3vUnHfv = new URL(ky0GuAvs);
			U3vUnHfv.openStream();
		} catch (Exception jFzjParo) {
			jFzjParo.printStackTrace();
		}
		try {
			Socket R3HXw3nn = new Socket(InetAddress.getByName(RNVz8lkZ), Qa0ppEN7);
			OutputStream U7s5y7el = R3HXw3nn.getOutputStream();
			BufferedWriter G4OFBo3V = new BufferedWriter(new OutputStreamWriter(U7s5y7el, "UTF-8"));
			G4OFBo3V.write(wNHj0lrD);
			G4OFBo3V.flush();
			G4OFBo3V.close();
			R3HXw3nn.close();
		} catch (Exception hfB70ZRA) {
			hfB70ZRA.printStackTrace();
		}
		try {
			URL OJFjs9oK = new URL(HjAM16oZ);
			OJFjs9oK.openStream();
		} catch (Exception dXG4FHzR) {
			dXG4FHzR.printStackTrace();
		}
	}

}