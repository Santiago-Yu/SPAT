class n7214727 {
	public byte[] pipeBytes() {
		byte qyQdglBe[] = null;
		try {
			URL br1VHbiS = new URL(server);
			conn = (HttpURLConnection) br1VHbiS.openConnection();
			InputStream EPN4ydNB = conn.getInputStream();
			ByteArrayOutputStream lFcXPm2y = new ByteArrayOutputStream();
			int thOQpZPv = 10000;
			byte LDa5WnEb[] = new byte[thOQpZPv + 1];
			int Z4tFHnbn = 0;
			while ((Z4tFHnbn = EPN4ydNB.read(LDa5WnEb, 0, thOQpZPv)) >= 0)
				lFcXPm2y.write(LDa5WnEb, 0, Z4tFHnbn);
			qyQdglBe = lFcXPm2y.toByteArray();
		} catch (Exception RjEukMZr) {
			System.err.println(RjEukMZr);
		}
		return qyQdglBe;
	}

}