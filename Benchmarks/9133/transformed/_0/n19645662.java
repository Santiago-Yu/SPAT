class n19645662 {
	public void notifyIterationEnds(final IterationEndsEvent fdKQINyq) {
		log.info("moving files...");
		File Nc7IligM = new File("deqsim.log");
		if (Nc7IligM.exists()) {
			File RVHeQR3J = new File(Controler.getIterationFilename("deqsim.log"));
			if (!IOUtils.renameFile(Nc7IligM, RVHeQR3J)) {
				log.info("WARNING: Could not move deqsim.log to its iteration directory.");
			}
		}
		int IJxhxwB5 = 0;
		Nc7IligM = new File("deqsim.log." + IJxhxwB5);
		while (Nc7IligM.exists()) {
			File K7tinojk = new File(Controler.getIterationFilename("deqsim.log." + IJxhxwB5));
			if (!IOUtils.renameFile(Nc7IligM, K7tinojk)) {
				log.info("WARNING: Could not move deqsim.log." + IJxhxwB5 + " to its iteration directory.");
			}
			IJxhxwB5++;
			Nc7IligM = new File("deqsim.log." + IJxhxwB5);
		}
		Nc7IligM = new File("loads_out.txt");
		if (Nc7IligM.exists()) {
			File wg6jHCbu = new File(Controler.getIterationFilename("loads_out.txt"));
			try {
				IOUtils.copyFile(Nc7IligM, wg6jHCbu);
			} catch (FileNotFoundException K5OpEtTP) {
				log.info("WARNING: Could not copy loads_out.txt to its iteration directory.");
			} catch (IOException oZYcfCFG) {
				log.info("WARNING: Could not copy loads_out.txt to its iteration directory.");
			}
			wg6jHCbu = new File("loads_in.txt");
			if (!IOUtils.renameFile(Nc7IligM, wg6jHCbu)) {
				log.info("WARNING: Could not move loads_out.txt to loads_in.txt.");
			}
		}
		Nc7IligM = new File("linkprocs.txt");
		if (Nc7IligM.exists()) {
			File XKcR93TO = new File(Controler.getIterationFilename("linkprocs.txt"));
			if (!IOUtils.renameFile(Nc7IligM, XKcR93TO)) {
				log.info("WARNING: Could not move linkprocs.txt to its iteration directory.");
			}
		}
	}

}