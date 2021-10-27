class n10361727 {
	void queryInactive() {
		try {
			XMLConfigParser.readUrlHost();
			String i24bakUz = XMLConfigParser.urlHost;
			Date NXArQz4i = new Date();
			String b9hB7dYd;
			String V6X143RY = "op=queryinactive";
			String DHP3OHoL = "time=" + NXArQz4i.getTime();
			b9hB7dYd = String.format("%s&%s", V6X143RY, DHP3OHoL);
			openConnection(b9hB7dYd, i24bakUz);
			String Z3Y939sA = br.readLine();
			NetworkLog.logMsg(NetworkLog.LOG_DEBUG, this, "(Query inactive)Response of the server: " + Z3Y939sA);
			br.close();
		} catch (MalformedURLException i2XTepUW) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, "Error" + i2XTepUW);
		} catch (IOException YJnvcSls) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, YJnvcSls.getMessage());
		}
	}

}