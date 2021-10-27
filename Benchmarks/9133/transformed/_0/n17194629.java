class n17194629 {
	public static InputStream openRemoteFile(URL xeo4omi0) throws KExceptionClass {
		InputStream oRC9Pedk = null;
		try {
			oRC9Pedk = xeo4omi0.openStream();
		} catch (IOException ne0uxjPV) {
			String F8Pk80OV = new String();
			F8Pk80OV = "No se puede abrir el recurso [";
			F8Pk80OV += xeo4omi0.toString();
			F8Pk80OV += "][";
			F8Pk80OV += ne0uxjPV.toString();
			F8Pk80OV += "]";
			throw new KExceptionClass(F8Pk80OV, ne0uxjPV);
		}
		;
		return (oRC9Pedk);
	}

}