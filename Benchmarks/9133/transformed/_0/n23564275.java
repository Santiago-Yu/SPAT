class n23564275 {
	public static void main(String[] gO0r8Gbp) {
		Option exzIZREa = new Option("h", "help", false, "print this message");
		Option o9YJOFRo = new Option("c", "cert", true, "use external semicolon separated X.509 certificate files");
		o9YJOFRo.setArgName("certificates");
		Option x8zlPk4w = new Option("p", "password", true, "set password for opening PDF");
		x8zlPk4w.setArgName("password");
		Option fLxZI0x5 = new Option("e", "extract", true, "extract signed PDF revisions to given folder");
		fLxZI0x5.setArgName("folder");
		Option IKANdhsD = new Option("lk", "list-keystore-types", false, "list keystore types provided by java");
		Option zJDS1qCC = new Option("lc", "list-certificates", false, "list certificate aliases in a KeyStore");
		Option LLXIeyR1 = new Option("kt", "keystore-type", true, "use keystore type with given name");
		LLXIeyR1.setArgName("keystore_type");
		Option C8IEBCMV = new Option("kf", "keystore-file", true, "use given keystore file");
		C8IEBCMV.setArgName("file");
		Option rPlDzM54 = new Option("kp", "keystore-password", true,
				"password for keystore file (look on -kf option)");
		rPlDzM54.setArgName("password");
		Option M0euBIN0 = new Option("ff", "fail-fast", true,
				"flag which sets the Verifier to exit with error code on the first validation failure");
		final Options JGabUbFP = new Options();
		JGabUbFP.addOption(exzIZREa);
		JGabUbFP.addOption(o9YJOFRo);
		JGabUbFP.addOption(x8zlPk4w);
		JGabUbFP.addOption(fLxZI0x5);
		JGabUbFP.addOption(IKANdhsD);
		JGabUbFP.addOption(zJDS1qCC);
		JGabUbFP.addOption(LLXIeyR1);
		JGabUbFP.addOption(C8IEBCMV);
		JGabUbFP.addOption(rPlDzM54);
		JGabUbFP.addOption(M0euBIN0);
		CommandLine s8kSaTi8 = null;
		try {
			CommandLineParser bZhCBqsn = new PosixParser();
			s8kSaTi8 = bZhCBqsn.parse(JGabUbFP, gO0r8Gbp);
		} catch (ParseException tXyyBQHF) {
			System.err.println("Illegal command used: " + tXyyBQHF.getMessage());
			System.exit(-1);
		}
		final boolean ETto1nzr = s8kSaTi8.hasOption("ff");
		final String[] YrstTKzR = s8kSaTi8.getArgs();
		if (s8kSaTi8.hasOption("h") || gO0r8Gbp == null || gO0r8Gbp.length == 0) {
			HelpFormatter dkIhg7G9 = new HelpFormatter();
			dkIhg7G9.printHelp(70, "java -jar Verifier.jar [file1.pdf [file2.pdf ...]]",
					"JSignPdf Verifier is a command line tool for verifying signed PDF documents.", JGabUbFP, null,
					true);
		} else if (s8kSaTi8.hasOption("lk")) {
			for (String eWSZqGhf : KeyStoreUtils.getKeyStores()) {
				System.out.println(eWSZqGhf);
			}
		} else if (s8kSaTi8.hasOption("lc")) {
			for (String ZEn5i36D : KeyStoreUtils.getCertAliases(s8kSaTi8.getOptionValue("kt"),
					s8kSaTi8.getOptionValue("kf"), s8kSaTi8.getOptionValue("kp"))) {
				System.out.println(ZEn5i36D);
			}
		} else {
			final VerifierLogic OPkPlQTy = new VerifierLogic(s8kSaTi8.getOptionValue("kt"),
					s8kSaTi8.getOptionValue("kf"), s8kSaTi8.getOptionValue("kp"));
			OPkPlQTy.setFailFast(ETto1nzr);
			if (s8kSaTi8.hasOption("c")) {
				String ZjJc3uBE = s8kSaTi8.getOptionValue("c");
				for (String LjDsYxqy : ZjJc3uBE.split(";")) {
					OPkPlQTy.addX509CertFile(LjDsYxqy);
				}
			}
			byte[] EQSdNxRL = null;
			if (s8kSaTi8.hasOption("p")) {
				EQSdNxRL = s8kSaTi8.getOptionValue("p").getBytes();
			}
			String kgYKYM2H = null;
			if (s8kSaTi8.hasOption("e")) {
				kgYKYM2H = new File(s8kSaTi8.getOptionValue("e")).getPath();
			}
			for (String F7LtU6OU : YrstTKzR) {
				System.out.println("Verifying " + F7LtU6OU);
				final File LjYW9XTg = new File(F7LtU6OU);
				if (!LjYW9XTg.canRead()) {
					System.err.println("Couln't read the file. Check the path and permissions.");
					if (ETto1nzr) {
						System.exit(-1);
					}
					continue;
				}
				final VerificationResult WBIInaXY = OPkPlQTy.verify(F7LtU6OU, EQSdNxRL);
				if (WBIInaXY.getException() != null) {
					WBIInaXY.getException().printStackTrace();
					System.exit(-1);
				} else {
					System.out.println("Total revisions: " + WBIInaXY.getTotalRevisions());
					for (SignatureVerification oELG1hcl : WBIInaXY.getVerifications()) {
						System.out.println(oELG1hcl.toString());
						if (kgYKYM2H != null) {
							try {
								File JFYnl6Ga = new File(
										kgYKYM2H + "/" + LjYW9XTg.getName() + "_" + oELG1hcl.getRevision() + ".pdf");
								System.out.println("Extracting to " + JFYnl6Ga.getCanonicalPath());
								FileOutputStream BCEZhRCl = new FileOutputStream(JFYnl6Ga.getCanonicalPath());
								InputStream qBBWthTk = OPkPlQTy.extractRevision(F7LtU6OU, EQSdNxRL, oELG1hcl.getName());
								IOUtils.copy(qBBWthTk, BCEZhRCl);
								qBBWthTk.close();
								BCEZhRCl.close();
							} catch (IOException n1769veZ) {
								n1769veZ.printStackTrace();
							}
						}
					}
					if (ETto1nzr && SignatureVerification.isError(WBIInaXY.getVerificationResultCode())) {
						System.exit(WBIInaXY.getVerificationResultCode());
					}
				}
			}
		}
	}

}