class n2234704 {
	public static void readAsFile(String uOTYj8tW, String iCDfXjtt) {
		BufferedInputStream RMWLPXz1 = null;
		BufferedOutputStream IaAfiqJv = null;
		URLConnection eSce6msR = null;
		try {
			eSce6msR = new URL(iCDfXjtt).openConnection();
			eSce6msR.setDoInput(true);
			RMWLPXz1 = new BufferedInputStream(eSce6msR.getInputStream());
			IaAfiqJv = new BufferedOutputStream(new FileOutputStream(uOTYj8tW));
			int j3ym8Au8;
			while ((j3ym8Au8 = RMWLPXz1.read()) != -1) {
				IaAfiqJv.write(j3ym8Au8);
			}
		} catch (Exception xM5HGWUP) {
			log.error(xM5HGWUP.getMessage(), xM5HGWUP);
		} finally {
			if (null != RMWLPXz1) {
				try {
					RMWLPXz1.close();
				} catch (IOException RRS298qi) {
				}
			}
			if (null != IaAfiqJv) {
				try {
					IaAfiqJv.flush();
					IaAfiqJv.close();
				} catch (IOException H68V7rFo) {
				}
			}
		}
	}

}