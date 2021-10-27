class n8351048 {
	public InputStream getResourceStream(String oAvIzlvJ) {
		try {
			URL qDqYDeUZ = getClass().getResource(oAvIzlvJ);
			System.out.println("URL: " + qDqYDeUZ);
			System.out.println("Read ROM " + oAvIzlvJ);
			if (qDqYDeUZ == null)
				qDqYDeUZ = new URL(codebase + oAvIzlvJ);
			return qDqYDeUZ.openConnection().getInputStream();
		} catch (Exception wrR0TfAS) {
			wrR0TfAS.printStackTrace();
		}
		return null;
	}

}