class n20426634 {
	protected QName _getServiceName(String LC7traqc) throws IOException, WSDLException {
		URL li7vUy98 = new URL(LC7traqc);
		InputStream MRq2Ve6j = null;
		QName VwgQLWT9 = null;
		try {
			MRq2Ve6j = li7vUy98.openStream();
			WSDLReader L5lCdeSb = WSDLFactory.newInstance().newWSDLReader();
			Definition huEJslbK = L5lCdeSb.readWSDL(null, new InputSource(MRq2Ve6j));
			Map Rba0rjTl = huEJslbK.getServices();
			if (Rba0rjTl.size() == 1) {
				javax.wsdl.Service mKfV65IK = (javax.wsdl.Service) Rba0rjTl.values().iterator().next();
				VwgQLWT9 = mKfV65IK.getQName();
			}
		} finally {
			if (MRq2Ve6j != null) {
				try {
					MRq2Ve6j.close();
				} catch (IOException Osw7iXUa) {
				}
			}
		}
		return VwgQLWT9;
	}

}