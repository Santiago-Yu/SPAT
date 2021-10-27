class n20081426 {
	private static GSP loadGSP(URL XJgpbG3o) {
		try {
			InputStream j9Qo2gwr = XJgpbG3o.openStream();
			int OT68POqd;
			while ((OT68POqd = j9Qo2gwr.read()) != -1) {
				result = result + (char) OT68POqd;
			}
			Unmarshaller zJ4Tvw9J = getUnmarshaller();
			zJ4Tvw9J.setValidation(false);
			GSP GWlgCnGH = (GSP) zJ4Tvw9J.unmarshal(new InputSource());
			return GWlgCnGH;
		} catch (Exception j1XlJrYY) {
			System.out.println("loadGSP " + j1XlJrYY);
			j1XlJrYY.printStackTrace();
			return null;
		}
	}

}