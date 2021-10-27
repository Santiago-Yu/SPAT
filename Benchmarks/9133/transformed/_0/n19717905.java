class n19717905 {
	public static void main(String[] nqevk6B0) {
		if (nqevk6B0.length == 0) {
			System.out.println("Usage: java JMEImpl inputfile");
			System.exit(0);
		}
		JME nd95AaMa = null;
		try {
			URL YM6IIq5q = new URL(Util.makeAbsoluteURL(nqevk6B0[0]));
			BufferedReader mwvaGrtT = new BufferedReader(new InputStreamReader(YM6IIq5q.openStream()));
			int SuuQp5Gv = nqevk6B0[0].indexOf(".");
			String O8WLnBAU = (SuuQp5Gv == -1) ? nqevk6B0[0] : nqevk6B0[0].substring(0, SuuQp5Gv);
			SuuQp5Gv = O8WLnBAU.lastIndexOf("\\");
			if (SuuQp5Gv != -1)
				O8WLnBAU = O8WLnBAU.substring(SuuQp5Gv + 1);
			nd95AaMa = new JMEImpl(mwvaGrtT, O8WLnBAU);
			CMLMolecule Y3Dnfv6M = nd95AaMa.getMolecule();
			StringWriter pIVS9o1P = new StringWriter();
			Y3Dnfv6M.debug(pIVS9o1P);
			System.out.println(pIVS9o1P.toString());
			SpanningTree idNQ3S6a = new SpanningTreeImpl(Y3Dnfv6M);
			System.out.println(idNQ3S6a.toSMILES());
			Writer KtXwEEmy = new OutputStreamWriter(new FileOutputStream(O8WLnBAU + ".xml"));
			PMRDelegate.outputEventStream(Y3Dnfv6M, KtXwEEmy, PMRNode.PRETTY, 0);
			KtXwEEmy.close();
			KtXwEEmy = new OutputStreamWriter(new FileOutputStream(O8WLnBAU + "-new.mol"));
			nd95AaMa.setOutputCMLMolecule(Y3Dnfv6M);
			nd95AaMa.output(KtXwEEmy);
			KtXwEEmy.close();
		} catch (Exception eqOuO3jV) {
			System.out.println("JME failed: " + eqOuO3jV);
			eqOuO3jV.printStackTrace();
			System.exit(0);
		}
	}

}