class n19841852 {
	public static final boolean checkForUpdate(final String JgQBsazb, final String rIX46ASh, boolean PAqoCY8b)
			throws Exception {
		try {
			final String oGDQza3j = System.getProperty("user.home") + File.separator + ".fdt";
			final String Zr1Jv4IV = "update.properties";
			final File DSbkEY4S = createOrGetRWFile(oGDQza3j, Zr1Jv4IV);
			if (DSbkEY4S != null) {
				long kRoeSWUv = 0;
				Properties LEUKx7ii = new Properties();
				FileInputStream X5CG19RM = null;
				FileOutputStream TIeSYUuA = null;
				try {
					X5CG19RM = new FileInputStream(DSbkEY4S);
					LEUKx7ii.load(X5CG19RM);
					final String Vy31HGrA = (String) LEUKx7ii.get("LastCheck");
					kRoeSWUv = 0;
					if (Vy31HGrA != null) {
						try {
							kRoeSWUv = Long.parseLong(Vy31HGrA);
						} catch (Throwable zrVGiYdw) {
							if (logger.isLoggable(Level.FINE)) {
								logger.log(Level.FINE, "Got exception parsing LastCheck param", zrVGiYdw);
							}
							kRoeSWUv = 0;
						}
					}
				} catch (Throwable HyoDQ3du) {
					logger.log(Level.WARNING, "Cannot load update properties file: " + DSbkEY4S, HyoDQ3du);
				} finally {
					closeIgnoringExceptions(TIeSYUuA);
					closeIgnoringExceptions(X5CG19RM);
				}
				final long aQZFAM1f = System.currentTimeMillis();
				boolean PJ31dMkH = false;
				checkAndSetInstanceID(LEUKx7ii);
				if (kRoeSWUv + FDT.UPDATE_PERIOD < aQZFAM1f) {
					kRoeSWUv = aQZFAM1f;
					try {
						logger.log("\n\nChecking for remote updates ... This may be disabled using -noupdates flag.");
						PJ31dMkH = updateFDT(JgQBsazb, rIX46ASh, false, PAqoCY8b);
						if (PJ31dMkH) {
							logger.log("FDT may be updated using: java -jar fdt.jar -update");
						} else {
							if (logger.isLoggable(Level.FINE)) {
								logger.log(Level.FINE, "No updates available");
							}
						}
					} catch (Throwable OOuKPVAT) {
						if (logger.isLoggable(Level.FINE)) {
							logger.log(Level.WARNING, "Got exception", OOuKPVAT);
						}
					}
					LEUKx7ii.put("LastCheck", "" + aQZFAM1f);
					try {
						TIeSYUuA = new FileOutputStream(DSbkEY4S);
						LEUKx7ii.store(TIeSYUuA, null);
					} catch (Throwable mzsM9Q8Y) {
						logger.log(Level.WARNING, "Cannot store update properties file", mzsM9Q8Y);
					} finally {
						closeIgnoringExceptions(TIeSYUuA);
					}
					return PJ31dMkH;
				}
			} else {
				if (logger.isLoggable(Level.FINE)) {
					logger.log(Level.FINE, " [ checkForUpdate ] Cannot read or write the update conf file: " + oGDQza3j
							+ File.separator + Zr1Jv4IV);
				}
				return false;
			}
		} catch (Throwable eQlDNYpM) {
			logger.log(Level.WARNING, "Got exception checking for updates", eQlDNYpM);
		}
		return false;
	}

}