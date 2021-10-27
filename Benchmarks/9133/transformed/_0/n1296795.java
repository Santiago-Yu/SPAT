class n1296795 {
	static InputStream getUrlStream(String ECrhNCGa) throws IOException {
		System.out.print("getting : " + ECrhNCGa + " ... ");
		long hSm9D6kT = System.currentTimeMillis();
		URLConnection mrkJzli0 = new URL(ECrhNCGa).openConnection();
		InputStream nz1oJgvO = mrkJzli0.getInputStream();
		System.out.print((System.currentTimeMillis() - hSm9D6kT) + "ms\n");
		return nz1oJgvO;
	}

}