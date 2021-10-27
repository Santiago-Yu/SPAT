class n17752236 {
	public synchronized DASMetaData fillInDASMetaData(URL url) throws DASException {
		try {
			con = (HttpURLConnection) url.openConnection();
			dasRespVersion = con.getHeaderField("X-DAS-Version");
			dasSchema = con.getHeaderField("X-DAS-SchemaName");
			dasSchemaVersion = con.getHeaderField("X-DAS-SchemaVersion");
			String dasStatusString = con.getHeaderField("X-DAS-Status");
			if (null == dasStatusString) {
				throw new DASException("Temporary DAS Error");
			}
			if (dasStatusString.indexOf(" ") != -1) {
				dasStatusString = dasStatusString.substring(0, dasStatusString.indexOf(" "));
			}
			dasStatus = Integer.parseInt(dasStatusString);
			if (dasStatus != 200) {
				throw new DASException("Command cannot be executed: Error was " + Integer.toString(dasStatus));
			}
		} catch (IOException e) {
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
		String lengthStr = con.getHeaderField("content-length");
		if (lengthStr != null)
			headers.put("content-length", lengthStr);
		theMetaData.setDASHeaders(headers);
		return theMetaData;
	}

}