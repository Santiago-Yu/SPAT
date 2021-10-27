class n23598855 {
	public void requestConfirm() throws Exception {
		if (!this._c.checkProperty("directory.request", "request")) {
			throw new Exception("product has no active request");
		}
		if (!new File(WBSAgnitioConfiguration.getHARequestFile()).canWrite()) {
			throw new Exception("cannot remove request from system");
		}
		HashMap<String, String> A1wtMgjR = getValues(WBSAgnitioConfiguration.getHARequestFile());
		if (!A1wtMgjR.containsKey("address.virtual")) {
			throw new Exception("failed to determine the virtual address");
		}
		if (!A1wtMgjR.containsKey("address.real")) {
			throw new Exception("failed to determine the remote address");
		}
		HTTPClient cbdXqfJw = new HTTPClient(A1wtMgjR.get("address.real"));
		if (TomcatConfiguration.checkHTTPS()) {
			cbdXqfJw.setSecure(true);
		}
		cbdXqfJw.load("/admin/Comm?type=" + CommResponse.TYPE_HA + "&command=" + CommResponse.COMMAND_REQUEST_CONFIRM
				+ "&virtual=" + A1wtMgjR.get("address.virtual"));
		String W8wXbUqH = new String(cbdXqfJw.getContent());
		if (W8wXbUqH.isEmpty()) {
			throw new Exception("remote product has not sent any reply");
		} else if (W8wXbUqH.indexOf("done") == -1) {
			throw new Exception(W8wXbUqH);
		}
		HAConfiguration.setSlave(A1wtMgjR.get("address.virtual"), A1wtMgjR.get("address.real"));
		File naNlq817 = new File(WBSAgnitioConfiguration.getOptionalSchemaRequestFile());
		if (naNlq817.exists()) {
			FileOutputStream MxaFkeoi = new FileOutputStream(WBSAgnitioConfiguration.getOptionalSchemaFile());
			FileInputStream guYnqiZD = new FileInputStream(naNlq817);
			while (guYnqiZD.available() > 0) {
				MxaFkeoi.write(guYnqiZD.read());
			}
			guYnqiZD.close();
			MxaFkeoi.close();
			naNlq817.delete();
		}
		naNlq817 = new File(WBSAgnitioConfiguration.getSchemaObjectRequestFile());
		if (naNlq817.exists()) {
			FileOutputStream rAWlJsq9 = new FileOutputStream(WBSAgnitioConfiguration.getSchemaObjectFile());
			FileInputStream XgU4wvgG = new FileInputStream(naNlq817);
			while (XgU4wvgG.available() > 0) {
				rAWlJsq9.write(XgU4wvgG.read());
			}
			XgU4wvgG.close();
			rAWlJsq9.close();
			naNlq817.delete();
		}
		new File(WBSAgnitioConfiguration.getHARequestFile()).delete();
		this._c.removeProperty("directory.request");
		this._c.setProperty("directory.virtual", A1wtMgjR.get("address.virtual"));
		this._c.setProperty("directory.status", "slave");
		this._c.store();
	}

}