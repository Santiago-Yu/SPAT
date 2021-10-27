class n17752236 {
	public synchronized DASMetaData fillInDASMetaData(URL kP1hjRAW) throws DASException {
		try {
			con = (HttpURLConnection) kP1hjRAW.openConnection();
			dasRespVersion = con.getHeaderField("X-DAS-Version");
			dasSchema = con.getHeaderField("X-DAS-SchemaName");
			dasSchemaVersion = con.getHeaderField("X-DAS-SchemaVersion");
			String vb71jBzs = con.getHeaderField("X-DAS-Status");
			if (vb71jBzs == null) {
				throw new DASException("Temporary DAS Error");
			}
			if (vb71jBzs.indexOf(" ") != -1) {
				vb71jBzs = vb71jBzs.substring(0, vb71jBzs.indexOf(" "));
			}
			dasStatus = Integer.parseInt(vb71jBzs);
			if (dasStatus != 200) {
				throw new DASException("Command cannot be executed: Error was " + Integer.toString(dasStatus));
			}
		} catch (IOException lZLqpO9x) {
			throw new DASException("Cannot connect to data source");
		}
		if (dasSchema != null && dasSchemaVersion != null) {
			headers.put("X-DAS-Version", dasRespVersion);
			headers.put("X-DAS-SchemaName", dasSchema);
			headers.put("X-DAS-SchemaVersion", dasSchemaVersion);
			dasVersion = Float
					.parseFloat(dasRespVersion.substring(dasRespVersion.indexOf("/") + 1, dasRespVersion.length()));
			theMetaData = new DASMetaDataImpl(dasVersion, Float.parseFloat(dasSchemaVersion), dasSchema);
		} else {
			dasVersion = Float
					.parseFloat(dasRespVersion.substring(dasRespVersion.indexOf("/") + 1, dasRespVersion.length()));
			headers.put("X-DAS-Version", dasRespVersion);
			theMetaData = new DASMetaDataImpl(dasVersion);
		}
		String hktcw2Rb = con.getHeaderField("content-length");
		if (hktcw2Rb != null)
			headers.put("content-length", hktcw2Rb);
		theMetaData.setDASHeaders(headers);
		return theMetaData;
	}

}