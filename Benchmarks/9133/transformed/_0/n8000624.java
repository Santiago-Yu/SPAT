class n8000624 {
	private void CopyTo(File ZzXkqamL) throws IOException {
		FileReader aQkvzQzW = null;
		FileWriter dpR3oNYq = null;
		int euFAX8ci;
		try {
			aQkvzQzW = new FileReader(image);
			dpR3oNYq = new FileWriter(ZzXkqamL);
			while ((euFAX8ci = aQkvzQzW.read()) != -1)
				dpR3oNYq.write(euFAX8ci);
		} finally {
			if (aQkvzQzW != null)
				try {
					aQkvzQzW.close();
				} catch (Exception vkZkwErK) {
				}
			if (dpR3oNYq != null)
				try {
					dpR3oNYq.close();
				} catch (Exception cD2Cxz8X) {
				}
		}
	}

}