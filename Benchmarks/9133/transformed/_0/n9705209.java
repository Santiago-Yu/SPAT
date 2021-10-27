class n9705209 {
	public static void main(String[] bDWI4uaj) throws Exception {
		PatternLayout y0ogQG6H = new PatternLayout("%d{ISO8601} %-5p %c: %m\n");
		ConsoleAppender wZVye3OB = new ConsoleAppender(y0ogQG6H);
		Logger.getRoot().addAppender(wZVye3OB);
		Logger.getRoot().setLevel(Level.INFO);
		Options l2wHFWWb = new Options();
		l2wHFWWb.addOption("p", "put", false, "put a file in the DHT overlay");
		l2wHFWWb.addOption("g", "get", false, "get a file from the DHT");
		l2wHFWWb.addOption("r", "remove", false, "remove a file from the DHT");
		l2wHFWWb.addOption("u", "update", false, "updates the lease");
		l2wHFWWb.addOption("j", "join", false, "join the DHT overlay");
		l2wHFWWb.addOption("c", "config", true, "the configuration file");
		l2wHFWWb.addOption("k", "key", true, "the key to read a file from");
		l2wHFWWb.addOption("f", "file", true, "the file to read or write");
		l2wHFWWb.addOption("a", "app", true, "the application ID");
		l2wHFWWb.addOption("s", "secret", true, "the secret used to hide data");
		l2wHFWWb.addOption("t", "ttl", true, "how long in seconds data should persist");
		CommandLineParser eYUgHjOO = new PosixParser();
		CommandLine B9OdjXS1 = eYUgHjOO.parse(l2wHFWWb, bDWI4uaj);
		String Wc2NFcmA = null;
		String Gt2zc1nT = null;
		String iCnZtgkU = null;
		int MKekLIul = 9999;
		String p3iVqcwo = null;
		String RWoKb0uQ = null;
		int IObg0Tqg = 0;
		if (B9OdjXS1.hasOption("j")) {
			Gt2zc1nT = "join";
		}
		if (B9OdjXS1.hasOption("p")) {
			Gt2zc1nT = "put";
		}
		if (B9OdjXS1.hasOption("g")) {
			Gt2zc1nT = "get";
		}
		if (B9OdjXS1.hasOption("r")) {
			Gt2zc1nT = "remove";
		}
		if (B9OdjXS1.hasOption("u")) {
			Gt2zc1nT = "update";
		}
		if (B9OdjXS1.hasOption("c")) {
			Wc2NFcmA = B9OdjXS1.getOptionValue("c");
		}
		if (B9OdjXS1.hasOption("k")) {
			p3iVqcwo = B9OdjXS1.getOptionValue("k");
		}
		if (B9OdjXS1.hasOption("f")) {
			RWoKb0uQ = B9OdjXS1.getOptionValue("f");
		}
		if (B9OdjXS1.hasOption("s")) {
			iCnZtgkU = B9OdjXS1.getOptionValue("s");
		}
		if (B9OdjXS1.hasOption("t")) {
			MKekLIul = Integer.parseInt(B9OdjXS1.getOptionValue("t"));
		}
		if (B9OdjXS1.hasOption("a")) {
			IObg0Tqg = Integer.parseInt(B9OdjXS1.getOptionValue("a"));
		}
		if (Gt2zc1nT == null) {
			System.err.println("ERROR: --put or --get or --remove or --join or --update is required");
			HelpFormatter hnQoAx17 = new HelpFormatter();
			hnQoAx17.printHelp("DHT", l2wHFWWb);
			System.exit(1);
		}
		if (Wc2NFcmA == null) {
			System.err.println("ERROR: --config is required");
			HelpFormatter ne07yHqd = new HelpFormatter();
			ne07yHqd.printHelp("DHT", l2wHFWWb);
			System.exit(1);
		}
		Properties byazuBgo = new Properties();
		byazuBgo.load(new FileInputStream(Wc2NFcmA));
		DHT LAR9XnHq = new DHT(byazuBgo);
		if (Gt2zc1nT.equals("join")) {
			LAR9XnHq.join();
		} else if (Gt2zc1nT.equals("put")) {
			if (RWoKb0uQ == null) {
				System.err.println("ERROR: --file is required");
				HelpFormatter Qhm7LlZI = new HelpFormatter();
				Qhm7LlZI.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			if (p3iVqcwo == null) {
				System.err.println("ERROR: --key is required");
				HelpFormatter vnOU8abA = new HelpFormatter();
				vnOU8abA.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			if (iCnZtgkU == null) {
				System.err.println("ERROR: --secret is required");
				HelpFormatter p5TxHoMJ = new HelpFormatter();
				p5TxHoMJ.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			logger.info("putting file " + RWoKb0uQ);
			FileInputStream z1lXDm0K = new FileInputStream(RWoKb0uQ);
			byte[] sR6fdCaU = new byte[1000000];
			int lDaV1dyv = z1lXDm0K.read(sR6fdCaU);
			byte[] yWtRyqEe = new byte[lDaV1dyv];
			System.arraycopy(sR6fdCaU, 0, yWtRyqEe, 0, lDaV1dyv);
			z1lXDm0K.close();
			if (LAR9XnHq.put((short) IObg0Tqg, p3iVqcwo.getBytes(), yWtRyqEe, MKekLIul, iCnZtgkU.getBytes()) < 0) {
				logger.info("There was an error while putting a key-value.");
				System.exit(0);
			}
			System.out.println("Ok!");
		} else if (Gt2zc1nT.equals("get")) {
			if (RWoKb0uQ == null) {
				System.err.println("ERROR: --file is required");
				HelpFormatter jL1XOWCk = new HelpFormatter();
				jL1XOWCk.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			if (p3iVqcwo == null) {
				System.err.println("ERROR: --key is required");
				HelpFormatter lhpDyMFx = new HelpFormatter();
				lhpDyMFx.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			logger.info("getting file " + RWoKb0uQ);
			ArrayList<byte[]> rwmSKGcc = new ArrayList<byte[]>();
			if (LAR9XnHq.get((short) IObg0Tqg, p3iVqcwo.getBytes(), Integer.MAX_VALUE, rwmSKGcc) < 0) {
				logger.info("There was an error while getting a value.");
				System.exit(0);
			}
			if (rwmSKGcc.size() == 0 || rwmSKGcc == null) {
				System.out.println("No values returned.");
				System.exit(0);
			}
			FileOutputStream JPmh8unb = new FileOutputStream(RWoKb0uQ);
			System.out.println("Found " + rwmSKGcc.size() + " values -- saving the first one only.");
			JPmh8unb.write(rwmSKGcc.get(0));
			JPmh8unb.close();
			System.out.println("Ok!");
		} else if (Gt2zc1nT.equals("remove")) {
			if (p3iVqcwo == null) {
				System.err.println("ERROR: --key is required");
				HelpFormatter qcJKbSOy = new HelpFormatter();
				qcJKbSOy.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			if (iCnZtgkU == null) {
				System.err.println("ERROR: --secret is required");
				HelpFormatter lOir8WoB = new HelpFormatter();
				lOir8WoB.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			logger.info("removing <key,value> for key=" + p3iVqcwo);
			if (LAR9XnHq.remove((short) IObg0Tqg, p3iVqcwo.getBytes(), iCnZtgkU.getBytes()) < 0) {
				logger.info("There was an error while removing a key.");
				System.exit(0);
			}
			System.out.println("Ok!");
		} else if (Gt2zc1nT.equals("update")) {
			if (p3iVqcwo == null) {
				System.err.println("ERROR: --key is required");
				HelpFormatter qHiWbpll = new HelpFormatter();
				qHiWbpll.printHelp("DHT", l2wHFWWb);
				System.exit(1);
			}
			logger.info("updating <key,value> for key=" + p3iVqcwo);
			if (LAR9XnHq.updateLease((short) IObg0Tqg, p3iVqcwo.getBytes(), MKekLIul) < 0) {
				logger.info("There was an error while updating data lease.");
				System.exit(0);
			}
			System.out.println("Ok!");
		}
		DHT.getInstance().stop();
	}

}