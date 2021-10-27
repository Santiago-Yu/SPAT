class n22991420 {
	public void notifyIterationEnds(final IterationEndsEvent swsUPyPP) {
		log.info("moving files...");
		File j4ukjMP2 = new File("deqsim.log");
		if (j4ukjMP2.exists()) {
			File J2kgdzWJ = new File(Controler.getIterationFilename("deqsim.log"));
			if (!IOUtils.renameFile(j4ukjMP2, J2kgdzWJ)) {
				log.info("WARNING: Could not move deqsim.log to its iteration directory.");
			}
		}
		int e2ZTkub7 = 0;
		j4ukjMP2 = new File("deqsim.log." + e2ZTkub7);
		while (j4ukjMP2.exists()) {
			File qTKBAgM8 = new File(Controler.getIterationFilename("deqsim.log." + e2ZTkub7));
			if (!IOUtils.renameFile(j4ukjMP2, qTKBAgM8)) {
				log.info("WARNING: Could not move deqsim.log." + e2ZTkub7 + " to its iteration directory.");
			}
			e2ZTkub7++;
			j4ukjMP2 = new File("deqsim.log." + e2ZTkub7);
		}
		j4ukjMP2 = new File("loads_out.txt");
		if (j4ukjMP2.exists()) {
			File cVYvufUA = new File(Controler.getIterationFilename("loads_out.txt"));
			try {
				IOUtils.copyFile(j4ukjMP2, cVYvufUA);
			} catch (FileNotFoundException LtDknotM) {
				log.info("WARNING: Could not copy loads_out.txt to its iteration directory.");
			} catch (IOException CWyZ5VoY) {
				log.info("WARNING: Could not copy loads_out.txt to its iteration directory.");
			}
			cVYvufUA = new File("loads_in.txt");
			if (!IOUtils.renameFile(j4ukjMP2, cVYvufUA)) {
				log.info("WARNING: Could not move loads_out.txt to loads_in.txt.");
			}
		}
		j4ukjMP2 = new File("linkprocs.txt");
		if (j4ukjMP2.exists()) {
			File F0psIYIN = new File(Controler.getIterationFilename("linkprocs.txt"));
			if (!IOUtils.renameFile(j4ukjMP2, F0psIYIN)) {
				log.info("WARNING: Could not move linkprocs.txt to its iteration directory.");
			}
		}
	}

}