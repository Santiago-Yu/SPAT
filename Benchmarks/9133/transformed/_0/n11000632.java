class n11000632 {
	public final void provisionGSLAM() {
		try {
			UUID[] FBNZAJUS = new UUID[] { new UUID("AG-1") };
			SLA[] Ul7cpnZX = sslamContext.getSLARegistry().getIQuery().getSLA(FBNZAJUS);
			for (SLA W41yrvX8 : Ul7cpnZX) {
				Party[] HzUacWAI = W41yrvX8.getParties();
				System.out.println("SLA Info :::" + W41yrvX8.getUuid().toString());
				for (Party A1y7iT6Q : HzUacWAI) {
					System.out.println("Printing gslam_epr value for Party" + A1y7iT6Q.getId() + "--"
							+ A1y7iT6Q.getAgreementRole());
					System.out.println(HzUacWAI[0].getPropertyValue(new STND("gslam_epr")));
				}
			}
			sslamContext.getSLARegistry().getIRegister().register(Ul7cpnZX[0], FBNZAJUS, SLAState.OBSERVED);
			String m5VN2GKA = System.getenv("SLASOI_HOME") + System.getProperty("file.separator") + "Integration"
					+ System.getProperty("file.separator") + "soap" + System.getProperty("file.separator")
					+ "provision.xml";
			String onUTOq3D = "";
			URL eOPQ6F0l;
			eOPQ6F0l = new URL(syntaxConverterNegotiationWSURL);
			URLConnection Yv4equ7e = eOPQ6F0l.openConnection();
			HttpURLConnection AVnLnGTS = (HttpURLConnection) Yv4equ7e;
			FileInputStream LRr0kTQZ = new FileInputStream(m5VN2GKA);
			ByteArrayOutputStream Bpp3gfk0 = new ByteArrayOutputStream();
			SOAPClient4XG.copy(LRr0kTQZ, Bpp3gfk0);
			LRr0kTQZ.close();
			byte[] jCe3EzYf = Bpp3gfk0.toByteArray();
			AVnLnGTS.setRequestProperty("Content-Length", String.valueOf(jCe3EzYf.length));
			AVnLnGTS.setRequestProperty("Content-Type", "application/soap+xml; charset=UTF-8");
			AVnLnGTS.setRequestProperty("SOAPAction", onUTOq3D);
			AVnLnGTS.setRequestMethod("POST");
			AVnLnGTS.setDoOutput(true);
			AVnLnGTS.setDoInput(true);
			OutputStream HByJ1e63 = AVnLnGTS.getOutputStream();
			HByJ1e63.write(jCe3EzYf);
			HByJ1e63.close();
			InputStreamReader ACT8dn0m = new InputStreamReader(AVnLnGTS.getInputStream());
			BufferedReader ZjYT0HaU = new BufferedReader(ACT8dn0m);
			String ilUncxOU;
			StringBuffer In9hiYm8 = new StringBuffer();
			while ((ilUncxOU = ZjYT0HaU.readLine()) != null) {
				In9hiYm8.append(ilUncxOU);
			}
			ZjYT0HaU.close();
			javax.xml.parsers.DocumentBuilderFactory YLZckKLX = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			javax.xml.parsers.DocumentBuilder lIM4Icaq;
			lIM4Icaq = YLZckKLX.newDocumentBuilder();
			org.xml.sax.InputSource x3d3wxsK = new org.xml.sax.InputSource();
			x3d3wxsK.setCharacterStream(new java.io.StringReader(In9hiYm8.toString()));
			System.out.println(
					"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "####################################################"
							+ "#################################################\n"
							+ "####################################################"
							+ "#################################################\n" + "Component Name: GSLAM\n"
							+ "Interface Name: negotiate/coordinage\n" + "Operation Name: Provision\n" + "Input:Type "
							+ "void" + "\n" + "####################################################"
							+ "#################################################\n"
							+ "####################################################"
							+ "#################################################\n"
							+ "######################################## RESPONSE"
							+ "############################################\n\n");
			System.out.println(In9hiYm8.toString());
		} catch (MalformedURLException QQC0QhBr) {
			QQC0QhBr.printStackTrace();
		} catch (IOException OKpKI209) {
			OKpKI209.printStackTrace();
		} catch (ParserConfigurationException N5WmhdTB) {
			N5WmhdTB.printStackTrace();
		} catch (RegistrationFailureException UEei0k0m) {
			UEei0k0m.printStackTrace();
		} catch (SLAManagerContextException Pz39csg8) {
			Pz39csg8.printStackTrace();
		} catch (InvalidUUIDException FLvyeA7K) {
			FLvyeA7K.printStackTrace();
		}
	}

}