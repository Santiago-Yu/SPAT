class n10878119 {
	public void notifyIterationEnds(final IterationEndsEvent IsfoY291) {
		log.info("moving files...");
		File FY4EZQwV = new File("deqsim.log");
		if (FY4EZQwV.exists()) {
			File kKbQVKSf = new File(Controler.getIterationFilename("deqsim.log"));
			if (!IOUtils.renameFile(FY4EZQwV, kKbQVKSf)) {
				log.info("WARNING: Could not move deqsim.log to its iteration directory.");
			}
		}
		int vmDNIHrR = 0;
		FY4EZQwV = new File("deqsim.log." + vmDNIHrR);
		while (FY4EZQwV.exists()) {
			File P4Tvg7dE = new File(Controler.getIterationFilename("deqsim.log." + vmDNIHrR));
			if (!IOUtils.renameFile(FY4EZQwV, P4Tvg7dE)) {
				log.info("WARNING: Could not move deqsim.log." + vmDNIHrR + " to its iteration directory.");
			}
			vmDNIHrR++;
			FY4EZQwV = new File("deqsim.log." + vmDNIHrR);
		}
		FY4EZQwV = new File("loads_out.txt");
		if (FY4EZQwV.exists()) {
			File zCz0k9Id = new File(Controler.getIterationFilename("loads_out.txt"));
			try {
				IOUtils.copyFile(FY4EZQwV, zCz0k9Id);
			} catch (FileNotFoundException KltE3qyt) {
				log.info("WARNING: Could not copy loads_out.txt to its iteration directory.");
			} catch (IOException hQw0zaOf) {
				log.info("WARNING: Could not copy loads_out.txt to its iteration directory.");
			}
			zCz0k9Id = new File("loads_in.txt");
			if (!IOUtils.renameFile(FY4EZQwV, zCz0k9Id)) {
				log.info("WARNING: Could not move loads_out.txt to loads_in.txt.");
			}
		}
		FY4EZQwV = new File("linkprocs.txt");
		if (FY4EZQwV.exists()) {
			File r8SZHFNz = new File(Controler.getIterationFilename("linkprocs.txt"));
			if (!IOUtils.renameFile(FY4EZQwV, r8SZHFNz)) {
				log.info("WARNING: Could not move linkprocs.txt to its iteration directory.");
			}
		}
	}

}