class n1156851 {
	public void runWeb(String wicbxAXL, String LttxcGSe, String H9F8uamZ) {
		if (bDebug)
			System.out.println("WEB Path");
		List<String> Z1wboBPT = new ArrayList<String>();
		List<String> QoLMRXgL = getRobots(wicbxAXL, LttxcGSe);
		Z1wboBPT.add("/" + LttxcGSe + "/" + H9F8uamZ);
		Indexer wl3rxi4S = null;
		IndexDocument QeghAUHz = null;
		try {
			wl3rxi4S = new Indexer("/tmp/tmp/index");
			for (String uYg6yd0J : Z1wboBPT) {
				if (bDebug)
					System.out.println("\n\n*** INDEXING " + uYg6yd0J);
				if (bDebug)
					System.out.println("Have - " + uYg6yd0J);
				boolean pLrvzUiS = true;
				if (QoLMRXgL != null) {
					for (String zdKEBjIk : QoLMRXgL) {
						if (bDebug)
							System.out.println("Comparing to - " + zdKEBjIk);
						if (uYg6yd0J.startsWith(zdKEBjIk)) {
							if (bDebug)
								System.out.println("Found URL - " + zdKEBjIk + " - " + uYg6yd0J);
							pLrvzUiS = false;
							break;
						}
					}
				} else {
					pLrvzUiS = true;
				}
				uYg6yd0J = wicbxAXL + uYg6yd0J;
				ParserDelegator jWFYBc4C = new ParserDelegator();
				CallbackHandler NPYCyrR0 = new CallbackHandler(Z1wboBPT, pLrvzUiS, LttxcGSe);
				try {
					URLConnection xSgAUz5F = new URL(uYg6yd0J).openConnection();
					xSgAUz5F.setUseCaches(false);
					Date b9la2esx = new Date(xSgAUz5F.getLastModified());
					if (bDebug)
						System.out.println("\nMatch - " + uYg6yd0J + " - Modified Date - " + b9la2esx);
					BufferedReader LqS2GkuX = new BufferedReader(new InputStreamReader(xSgAUz5F.getInputStream()));
					jWFYBc4C.parse(LqS2GkuX, NPYCyrR0, true);
					if (pLrvzUiS) {
						if (bDebug)
							System.out.println("Adding Index - " + uYg6yd0J + "\nContent:" + NPYCyrR0.getText()
									+ "\nSummary:" + NPYCyrR0.getSummary() + "\nTitle:" + NPYCyrR0.getTitle());
						QeghAUHz = new IndexDocument();
						QeghAUHz.setUID(uYg6yd0J + b9la2esx.toString());
						QeghAUHz.setPageURL(uYg6yd0J);
						QeghAUHz.setModifiedDate(b9la2esx.toString());
						QeghAUHz.setContents(NPYCyrR0.getText());
						QeghAUHz.setTitle(NPYCyrR0.getTitle());
						QeghAUHz.setSummary(NPYCyrR0.getSummary());
						wl3rxi4S.addDocument(QeghAUHz);
					}
				} catch (Exception k9uO7EGd) {
					PetstoreUtil.getLogger().log(Level.SEVERE, "Inner Exception" + k9uO7EGd);
				}
			}
		} catch (Exception o9ZePRt8) {
			PetstoreUtil.getLogger().log(Level.SEVERE, "Outer Exception" + o9ZePRt8);
		} finally {
			try {
				if (wl3rxi4S != null) {
					wl3rxi4S.close();
				}
			} catch (Exception HfxaxoIY) {
				HfxaxoIY.printStackTrace();
			}
		}
	}

}