class n21161120 {
	public static void main(String[] aw9TPT8X) {
		String nlpp3EQH;
		int QClXNCDw;
		char[] zA7JUcyB;
		System.out.println("InstallCert - Install CA certificate to Java Keystore");
		System.out.println("=====================================================");
		final BufferedReader Eu00hrzc = new BufferedReader(new InputStreamReader(System.in));
		try {
			if ((aw9TPT8X.length == 1) || (aw9TPT8X.length == 2)) {
				String[] dPdM0MX2 = aw9TPT8X[0].split(":");
				nlpp3EQH = dPdM0MX2[0];
				QClXNCDw = (dPdM0MX2.length == 1) ? 443 : Integer.parseInt(dPdM0MX2[1]);
				String acQlKvBs = (aw9TPT8X.length == 1) ? "changeit" : aw9TPT8X[1];
				zA7JUcyB = acQlKvBs.toCharArray();
			} else {
				String NLjn0Oyt;
				do {
					System.out.print("Enter hostname or IP address: ");
					NLjn0Oyt = StringUtils.defaultIfEmpty(Eu00hrzc.readLine(), null);
				} while (NLjn0Oyt == null);
				nlpp3EQH = NLjn0Oyt;
				System.out.print("Enter port number [443]: ");
				NLjn0Oyt = StringUtils.defaultIfEmpty(Eu00hrzc.readLine(), null);
				QClXNCDw = NLjn0Oyt == null ? 443 : Integer.parseInt(NLjn0Oyt);
				System.out.print("Enter keystore password [changeit]: ");
				NLjn0Oyt = Eu00hrzc.readLine();
				String iFdUXUtX = "".equals(NLjn0Oyt) ? "changeit" : NLjn0Oyt;
				zA7JUcyB = iFdUXUtX.toCharArray();
			}
			char d5oJaqt2 = File.separatorChar;
			final File POLANa5U = new File(System.getProperty("java.home") + d5oJaqt2 + "lib" + d5oJaqt2 + "security");
			final File lVlu9FRy = new File(POLANa5U, "cacerts");
			System.out.println("Loading KeyStore " + lVlu9FRy + "...");
			InputStream n5cl6udo = new FileInputStream(lVlu9FRy);
			KeyStore QZeclkEf = KeyStore.getInstance(KeyStore.getDefaultType());
			QZeclkEf.load(n5cl6udo, zA7JUcyB);
			n5cl6udo.close();
			SSLContext WMxw3RMt = SSLContext.getInstance("TLS");
			TrustManagerFactory V0Adat4l = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			V0Adat4l.init(QZeclkEf);
			X509TrustManager eYAhbxuu = (X509TrustManager) V0Adat4l.getTrustManagers()[0];
			SavingTrustManager Fdd9dbLy = new SavingTrustManager(eYAhbxuu);
			WMxw3RMt.init(null, new TrustManager[] { Fdd9dbLy }, null);
			SSLSocketFactory y2S1LOyZ = WMxw3RMt.getSocketFactory();
			System.out.println("Opening connection to " + nlpp3EQH + ":" + QClXNCDw + "...");
			SSLSocket zELUMW63 = (SSLSocket) y2S1LOyZ.createSocket(nlpp3EQH, QClXNCDw);
			zELUMW63.setSoTimeout(10000);
			try {
				System.out.println("Starting SSL handshake...");
				zELUMW63.startHandshake();
				zELUMW63.close();
				System.out.println();
				System.out.println("No errors, certificate is already trusted");
			} catch (SSLException Emspl2Rh) {
				System.out.println();
				Emspl2Rh.printStackTrace(System.out);
			}
			X509Certificate[] I0eCQpV1 = Fdd9dbLy.chain;
			if (I0eCQpV1 == null) {
				System.out.println("Could not obtain server certificate chain");
				return;
			}
			System.out.println();
			System.out.println("Server sent " + I0eCQpV1.length + " certificate(s):");
			System.out.println();
			MessageDigest tN9rSLYh = MessageDigest.getInstance("SHA1");
			MessageDigest ldWBsPyu = MessageDigest.getInstance("MD5");
			for (int t8c6o0vk = 0; t8c6o0vk < I0eCQpV1.length; t8c6o0vk++) {
				X509Certificate pgOjS3Jf = I0eCQpV1[t8c6o0vk];
				System.out.println(" " + (t8c6o0vk + 1) + " Subject " + pgOjS3Jf.getSubjectDN());
				System.out.println("   Issuer  " + pgOjS3Jf.getIssuerDN());
				tN9rSLYh.update(pgOjS3Jf.getEncoded());
				System.out.println("   sha1    " + toHexString(tN9rSLYh.digest()));
				ldWBsPyu.update(pgOjS3Jf.getEncoded());
				System.out.println("   md5     " + toHexString(ldWBsPyu.digest()));
				System.out.println();
			}
			System.out.print("Enter certificate to add to trusted keystore or 'q' to quit [1]: ");
			String KYLHmRbS = Eu00hrzc.readLine().trim();
			int wUaJYG2M = -1;
			try {
				wUaJYG2M = (KYLHmRbS.length() == 0) ? 0 : Integer.parseInt(KYLHmRbS) - 1;
			} catch (NumberFormatException RAnjcDEp) {
			}
			if (wUaJYG2M < 0 || wUaJYG2M >= I0eCQpV1.length) {
				System.out.println("KeyStore not changed");
			} else {
				try {
					System.out.println("Creating keystore backup");
					final SimpleDateFormat UKu2nWLA = new SimpleDateFormat("yyyyMMddHHmmss");
					final File MuxDPbhy = new File(POLANa5U,
							CACERTS_KEYSTORE + "." + UKu2nWLA.format(new java.util.Date()));
					final FileInputStream xp3qyScV = new FileInputStream(lVlu9FRy);
					final FileOutputStream Of5pNqix = new FileOutputStream(MuxDPbhy);
					IOUtils.copy(xp3qyScV, Of5pNqix);
					xp3qyScV.close();
					Of5pNqix.close();
				} catch (Exception kjCHqhYc) {
					kjCHqhYc.printStackTrace();
				}
				System.out.println("Installing certificate...");
				X509Certificate HSvawB47 = I0eCQpV1[wUaJYG2M];
				String wygyZjg1 = nlpp3EQH + "-" + (wUaJYG2M + 1);
				QZeclkEf.setCertificateEntry(wygyZjg1, HSvawB47);
				OutputStream wcxvDeNq = new FileOutputStream(lVlu9FRy);
				QZeclkEf.store(wcxvDeNq, zA7JUcyB);
				wcxvDeNq.close();
				System.out.println();
				System.out.println(HSvawB47);
				System.out.println();
				System.out.println("Added certificate to keystore '" + lVlu9FRy + "' using alias '" + wygyZjg1 + "'");
			}
		} catch (Exception GAPA4pYX) {
			System.out.println();
			System.out.println("----------------------------------------------");
			System.out.println("Problem occured during installing certificate:");
			GAPA4pYX.printStackTrace();
			System.out.println("----------------------------------------------");
		}
		System.out.println("Press Enter to finish...");
		try {
			Eu00hrzc.readLine();
		} catch (IOException UAWfeDWj) {
			UAWfeDWj.printStackTrace();
		}
	}

}