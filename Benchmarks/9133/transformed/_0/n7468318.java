class n7468318 {
	private List<Intrebare> citesteIntrebari() throws IOException {
		ArrayList<Intrebare> UaC6XM3O = new ArrayList<Intrebare>();
		try {
			URL XWAMCPuy = new URL(getCodeBase(), "../intrebari.txt");
			BufferedReader s4Bzywsi = new BufferedReader(new InputStreamReader((XWAMCPuy.openStream())));
			String KghQuzuy;
			while ((KghQuzuy = s4Bzywsi.readLine()) != null) {
				Collection<String> Upb6Oj7w = new ArrayList<String>();
				Collection<String> oDteja8M = new ArrayList<String>();
				String BUHaqMJk = "";
				while (!"".equals(BUHaqMJk = s4Bzywsi.readLine())) {
					Upb6Oj7w.add(BUHaqMJk);
					oDteja8M.add(s4Bzywsi.readLine());
				}
				Intrebare ZsLFAyV1 = new Intrebare(KghQuzuy, Upb6Oj7w.toArray(new String[Upb6Oj7w.size()]),
						oDteja8M.toArray(new String[oDteja8M.size()]));
				UaC6XM3O.add(ZsLFAyV1);
			}
		} catch (ArgumentExcetpion WBpG5oyI) {
			WBpG5oyI.printStackTrace();
		}
		return UaC6XM3O;
	}

}