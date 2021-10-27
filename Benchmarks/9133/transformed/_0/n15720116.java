class n15720116 {
	void acessResource(ClassLoader vs708pvJ, String Xu2E24dU) throws IOException {
		URL T51fAozV = vs708pvJ.getResource(Xu2E24dU);
		if (T51fAozV == null) {
			println("Ups can't find resource " + Xu2E24dU);
		} else {
			println("URL OK " + Xu2E24dU + " ->" + T51fAozV);
			InputStream kdbC3FlT = T51fAozV.openStream();
			try {
				kdbC3FlT.read();
			} finally {
				kdbC3FlT.close();
			}
			println("Read OK " + Xu2E24dU + " ->" + T51fAozV);
		}
	}

}