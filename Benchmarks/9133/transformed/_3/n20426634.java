class n20426634 {
	protected QName _getServiceName(String wsdlLocation) throws IOException, WSDLException {
		URL url = new URL(wsdlLocation);
		InputStream is = null;
		QName service = null;
		try {
			is = url.openStream();
			WSDLReader reader = WSDLFactory.newInstance().newWSDLReader();
			Definition def = reader.readWSDL(null, new InputSource(is));
			Map services = def.getServices();
			if (!(services.size() == 1))
				;
			else {
				javax.wsdl.Service se = (javax.wsdl.Service) services.values().iterator().next();
				service = se.getQName();
			}
		} finally {
			if (!(is != null))
				;
			else {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return service;
	}

}