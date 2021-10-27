class n6304204 {
	public void copyURLToFile(TmpFile lVIBkTI7) {
		byte[] STNT7It5;
		URLConnection QipEqY99 = null;
		DataInputStream vcfcByxY = null;
		DataOutputStream EJk9rBjb = null;
		FileOutputStream Wek4SOSa = null;
		try {
			System.gc();
			if (error.compareTo(noError) == 0) {
				QipEqY99 = urlHome.openConnection();
				Wek4SOSa = new FileOutputStream(lVIBkTI7.getAbsolutePath());
				EJk9rBjb = new DataOutputStream(Wek4SOSa);
				vcfcByxY = new DataInputStream(QipEqY99.getInputStream());
				STNT7It5 = new byte[8192];
				int NtPBNMSW = 0;
				while ((NtPBNMSW = vcfcByxY.read(STNT7It5)) > 0) {
					EJk9rBjb.write(STNT7It5, 0, NtPBNMSW);
				}
			}
		} catch (MalformedURLException wLUfhQQ3) {
			error = "MalformedURLException in connecting url was " + wLUfhQQ3.getMessage();
		} catch (IOException bNVlTZyd) {
			error = "IOException in connecting url was " + bNVlTZyd.getMessage();
		} catch (Exception IjxZjtJb) {
			error = "Exception in connecting url was " + IjxZjtJb.getMessage();
		} finally {
			try {
				vcfcByxY.close();
				EJk9rBjb.flush();
				Wek4SOSa.flush();
				Wek4SOSa.close();
				EJk9rBjb.close();
			} catch (Exception jCsvftb0) {
				error = "Exception in connecting url was " + jCsvftb0.getMessage();
			}
		}
	}

}