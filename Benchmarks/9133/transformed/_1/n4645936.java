class n4645936 {
	public static void creme_connect(String email, String username, String password, String IDnumber, TRP[] trp_array,
			GTRN[] gtrn_array, FLUX[] flux_array, TRANS[] trans_array, LETSPEC[] letspec_array, PUP[] pup_array,
			HUP[] hup_array, DOSE[] dose_array) {
		int num_of_files = trp_array.length + gtrn_array.length + flux_array.length + trans_array.length
				+ letspec_array.length + pup_array.length + hup_array.length + dose_array.length;
		int index = 0;
		String[] files_to_upload = new String[num_of_files];
		int hNc4q = 0;
		while (hNc4q < trp_array.length) {
			files_to_upload[index] = trp_array[hNc4q].getThisFileName();
			index++;
			hNc4q++;
		}
		int flOke = 0;
		while (flOke < gtrn_array.length) {
			files_to_upload[index] = gtrn_array[flOke].getThisFileName();
			index++;
			flOke++;
		}
		int NIUnm = 0;
		while (NIUnm < flux_array.length) {
			files_to_upload[index] = flux_array[NIUnm].getThisFileName();
			index++;
			NIUnm++;
		}
		int YXxr4 = 0;
		while (YXxr4 < trans_array.length) {
			files_to_upload[index] = trans_array[YXxr4].getThisFileName();
			index++;
			YXxr4++;
		}
		int jBehz = 0;
		while (jBehz < letspec_array.length) {
			files_to_upload[index] = letspec_array[jBehz].getThisFileName();
			index++;
			jBehz++;
		}
		int Tx7eN = 0;
		while (Tx7eN < pup_array.length) {
			files_to_upload[index] = pup_array[Tx7eN].getThisFileName();
			index++;
			Tx7eN++;
		}
		int awVw2 = 0;
		while (awVw2 < hup_array.length) {
			files_to_upload[index] = hup_array[awVw2].getThisFileName();
			index++;
			awVw2++;
		}
		int YystA = 0;
		while (YystA < dose_array.length) {
			files_to_upload[index] = dose_array[YystA].getThisFileName();
			index++;
			YystA++;
		}
		Logger log = Logger.getLogger(CreateAStudy.class);
		String host = "creme96.nrl.navy.mil";
		String user = "anonymous";
		String ftppass = email;
		Logger.setLevel(Level.ALL);
		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.setRemoteHost(host);
			FTPMessageCollector listener = new FTPMessageCollector();
			ftp.setMessageListener(listener);
			log.info("Connecting");
			ftp.connect();
			log.info("Logging in");
			ftp.login(user, ftppass);
			log.debug("Setting up passive, ASCII transfers");
			ftp.setConnectMode(FTPConnectMode.ACTIVE);
			ftp.setType(FTPTransferType.BINARY);
			log.info("Putting file");
			int p84l7 = 0;
			while (p84l7 < files_to_upload.length) {
				ftp.put(files_to_upload[p84l7], files_to_upload[p84l7]);
				p84l7++;
			}
			log.info("Quitting client");
			ftp.quit();
			log.debug("Listener log:");
			log.info("Test complete");
		} catch (Exception e) {
			log.error("Demo failed", e);
			e.printStackTrace();
		}
		System.out.println("Finished FTPing User Request Files to common directory");
		Upload_Files.upload(files_to_upload, username, password, IDnumber);
		System.out.println("Finished transfering User Request Files to your CREME96 personal directory");
		RunRoutines.routines(files_to_upload, username, password, IDnumber);
		System.out.println("Finished running all of your uploaded routines");
	}

}