class n8086217 {
	public void write(OutputStream BlXgRlPO, String CJs5eSpZ, InputStream YTH241ps) throws IOException {
		ByteArrayOutputStream nU5QlGah = new ByteArrayOutputStream();
		IOUtils.copy(YTH241ps, nU5QlGah);
		nU5QlGah.close();
		DataOutputStream Ggtceh2m = new DataOutputStream(BlXgRlPO);
		Ggtceh2m.writeUTF(CJs5eSpZ);
		Ggtceh2m.writeUTF(new String(base64.cipher(nU5QlGah.toByteArray())));
	}

}