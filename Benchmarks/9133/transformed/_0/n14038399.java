class n14038399 {
	private void run(String[] emwe2o29) throws Throwable {
		ArgParser WJST6EnF = new ArgParser("Run an experiment");
		WJST6EnF.addOptions(this, true);
		emwe2o29 = WJST6EnF.matchAllArgs(emwe2o29, 0, ArgParserOption.EXIT_ON_ERROR,
				ArgParserOption.STOP_FIRST_UNMATCHED);
		if (log4jFile != null) {
			logger.info("Using another log4j configuration: %s", log4jFile);
			PropertyConfigurator.configure(log4jFile.getAbsolutePath());
		}
		final TreeMap<TaskName, Class<Task>> lbwyEXMZ = GenericHelper.newTreeMap();
		final Enumeration<URL> u0b0opvr = About.class.getClassLoader().getResources(EXPERIMENT_PACKAGES);
		while (u0b0opvr.hasMoreElements()) {
			final URL qWUFAqU8 = u0b0opvr.nextElement();
			logger.debug("Got URL %s", qWUFAqU8);
			BufferedReader m7yiPHkw = new BufferedReader(new InputStreamReader(qWUFAqU8.openStream()));
			String Jhc79dMp;
			while ((Jhc79dMp = m7yiPHkw.readLine()) != null) {
				String rME215ps = Jhc79dMp;
				getTasks(qWUFAqU8, lbwyEXMZ, rME215ps);
			}
		}
		getTasks(null, lbwyEXMZ, getClass().getPackage().getName());
		if (lbwyEXMZ.isEmpty()) {
			logger.fatal("I did not find any valid experiment (service bpiwowar.experiments.ExperimentListProvider)");
			System.exit(1);
		}
		if (emwe2o29.length == 0 || emwe2o29[0].equals("list")) {
			System.out.format("Available experiments:%n");
			TreeMapArray<PackageName, String> IeZPTUGb = TreeMapArray.newInstance();
			for (Entry<TaskName, Class<Task>> XDPXhYQ4 : lbwyEXMZ.entrySet()) {
				TaskName dZwEBUHT = XDPXhYQ4.getKey();
				if (showClassNames)
					IeZPTUGb.add(dZwEBUHT.packageName,
							String.format("%s (%s)", dZwEBUHT.name, XDPXhYQ4.getValue().toString()));
				else
					IeZPTUGb.add(dZwEBUHT.packageName, dZwEBUHT.name);
			}
			Stack<PackageName> SXhmHqiW = new Stack<PackageName>();
			for (Entry<PackageName, ArrayList<String>> aSWt3Amn : IeZPTUGb.entrySet()) {
				final PackageName myzBI6RZ = aSWt3Amn.getKey();
				while (!SXhmHqiW.isEmpty()
						&& myzBI6RZ.commonPrefixLength(SXhmHqiW.peek()) != SXhmHqiW.peek().getLength())
					SXhmHqiW.pop();
				int uJzWk00j = SXhmHqiW.size();
				int VGKO1kbR = uJzWk00j > 0 ? SXhmHqiW.peek().getLength() : 0;
				StringBuilder jHsip76k = new StringBuilder();
				for (int rMO4zXeb = 0; rMO4zXeb < VGKO1kbR; rMO4zXeb++)
					jHsip76k.append("|");
				for (int TiiXoFvc = VGKO1kbR; TiiXoFvc < myzBI6RZ.getLength(); TiiXoFvc++) {
					jHsip76k.append("|");
					SXhmHqiW.add(new PackageName(myzBI6RZ, TiiXoFvc + 1));
					System.out.format("%s%n", jHsip76k);
					System.out.format("%s+ [%s]%n", jHsip76k, SXhmHqiW.peek());
					uJzWk00j++;
				}
				String Uyt5rrOH = jHsip76k.toString();
				for (String KybZF9Oh : aSWt3Amn.getValue())
					System.out.format("%s|- %s%n", Uyt5rrOH, KybZF9Oh);
				SXhmHqiW.add(myzBI6RZ);
			}
			return;
		} else if (emwe2o29[0].equals(SEARCH_COMMAND)) {
			final class Options {

				@OrderedArgument(required = true)
				String MQeewyKK;
			}
			Options imOr9zE1 = new Options();
			ArgParser CaU9B8yt = new ArgParser(SEARCH_COMMAND);
			CaU9B8yt.addOptions(imOr9zE1);
			CaU9B8yt.matchAllArgs(emwe2o29, 1);
			logger.info("Searching for %s", imOr9zE1.MQeewyKK);
			for (Entry<TaskName, Class<Task>> jUv0cQIb : lbwyEXMZ.entrySet()) {
				TaskName IYODoof7 = jUv0cQIb.getKey();
				if (IYODoof7.name.contains(imOr9zE1.MQeewyKK)) {
					System.err.format("[*] %s - %s%n   %s%n", IYODoof7, jUv0cQIb.getValue(),
							jUv0cQIb.getValue().getAnnotation(TaskDescription.class).description());
				}
			}
			return;
		}
		String v2oTyQZc = emwe2o29[0];
		emwe2o29 = Arrays.copyOfRange(emwe2o29, 1, emwe2o29.length);
		ArrayList<Class<Task>> Fa2pYex8 = GenericHelper.newArrayList();
		for (Entry<TaskName, Class<Task>> dGDk1UHi : lbwyEXMZ.entrySet()) {
			if (dGDk1UHi.getKey().name.equals(v2oTyQZc))
				Fa2pYex8.add(dGDk1UHi.getValue());
		}
		if (Fa2pYex8.isEmpty()) {
			System.err.println("No task match " + v2oTyQZc);
			System.exit(1);
		}
		if (Fa2pYex8.size() > 1) {
			System.err.println("Too many tasks match " + v2oTyQZc);
			System.exit(1);
		}
		Class<Task> TlPA32TY = Fa2pYex8.get(0);
		logger.info("Running experiment " + TlPA32TY.getCanonicalName());
		Task oLdbPaDn = TlPA32TY.newInstance();
		int Ek4q6J1q = 0;
		try {
			oLdbPaDn.init(emwe2o29);
			if (xstreamOutput != null) {
				OutputStream FzVOKJf6;
				if (xstreamOutput.toString().equals("-"))
					FzVOKJf6 = System.out;
				else
					FzVOKJf6 = new FileOutputStream(xstreamOutput);
				logger.info("Serializing the object into %s", xstreamOutput);
				new XStream().toXML(oLdbPaDn, FzVOKJf6);
				FzVOKJf6.close();
			} else {
				Ek4q6J1q = oLdbPaDn.run();
			}
			logger.info("Finished task");
		} catch (Throwable yb9g6XLL) {
			if (yb9g6XLL instanceof InvocationTargetException && yb9g6XLL.getCause() != null) {
				yb9g6XLL = yb9g6XLL.getCause();
			}
			logger.error("Exception thrown while executing the action:%n%s%n", yb9g6XLL);
			Ek4q6J1q = 2;
		}
		System.exit(Ek4q6J1q);
	}

}