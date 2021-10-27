class n4738885 {
	public final int sendMetaData(FileInputStream J83ysRgD) throws Exception {
		try {
			UUID t5n5cH74 = UUID.randomUUID();
			HttpClient jEZ5Bwd6 = new SSLHttpClient();
			StringBuilder dbiWHxDV = new StringBuilder(mServer).append("?cmd=meta").append("&id=" + t5n5cH74);
			HttpPost yG5123dn = new HttpPost(dbiWHxDV.toString());
			String szB0KKAv = t5n5cH74 + ".metadata";
			FileInputStreamPart SFeFgCdT = new FileInputStreamPart("data", szB0KKAv, J83ysRgD);
			MultipartEntity YcxmkwB4 = new MultipartEntity(new Part[] { SFeFgCdT });
			yG5123dn.setEntity(YcxmkwB4);
			HttpResponse AUw81puq = jEZ5Bwd6.execute(yG5123dn);
			int X4HSZl7B = AUw81puq.getStatusLine().getStatusCode();
			if (X4HSZl7B == HttpStatus.SC_OK) {
				return 0;
			} else {
				return -1;
			}
		} catch (Exception Q1NDYGTu) {
			throw new Exception("send meta data", Q1NDYGTu);
		}
	}

}