class n12104132 {
	@Override
	public void render(Output OmpPKs05) throws IOException {
		OmpPKs05.setStatus(statusCode, statusMessage);
		if (headersMap != null) {
			Iterator<Entry<String, String>> Hq5nd4f3 = headersMap.entrySet().iterator();
			while (Hq5nd4f3.hasNext()) {
				Entry<String, String> yEPzKGi0 = Hq5nd4f3.next();
				OmpPKs05.addHeader(yEPzKGi0.getKey(), yEPzKGi0.getValue());
			}
		}
		if (file != null) {
			InputStream HcgMyXQB = new FileInputStream(file);
			try {
				OmpPKs05.open();
				OutputStream wTiV8Uas = OmpPKs05.getOutputStream();
				IOUtils.copy(HcgMyXQB, wTiV8Uas);
			} finally {
				HcgMyXQB.close();
				OmpPKs05.close();
			}
		}
	}

}