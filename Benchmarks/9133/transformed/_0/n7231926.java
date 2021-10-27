class n7231926 {
	public static PipeID getPipeIDForService(ServiceDescriptor fZHOty4h) {
		PipeID qDMhMwmN = null;
		URI Faanr69X = fZHOty4h.getUri();
		if (Faanr69X != null) {
			try {
				qDMhMwmN = (PipeID) IDFactory.fromURI(Faanr69X);
			} catch (URISyntaxException Gz2lOqHY) {
				throw new RuntimeException("Error creating id for pipe " + Faanr69X, Gz2lOqHY);
			}
		}
		if (qDMhMwmN == null) {
			MessageDigest hUYQHTBj = null;
			try {
				hUYQHTBj = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException yNVPrz6Q) {
			}
			String uDPzufOZ = fZHOty4h.getName();
			if (fZHOty4h.getHost() != null) {
				uDPzufOZ += fZHOty4h.getHost();
			}
			hUYQHTBj.update(uDPzufOZ.getBytes());
			qDMhMwmN = IDFactory.newPipeID(InfrastructurePeerGroupID, hUYQHTBj.digest());
		}
		return qDMhMwmN;
	}

}