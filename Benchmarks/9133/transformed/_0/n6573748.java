class n6573748 {
	public static void main(String[] qlPImibS) {
		Stopwatch.start("");
		HtmlParser DPOznwC2 = new HtmlParser();
		try {
			Stopwatch.printTimeReset("", "> ParserDelegator");
			ParserDelegator pvi1Qm1A = new ParserDelegator();
			Stopwatch.printTimeReset("", "> url");
			URL vTIEwkMN = new URL(qlPImibS[0]);
			Stopwatch.printTimeReset("", "> openStrem");
			InputStream NzeCt1bV = vTIEwkMN.openStream();
			Stopwatch.printTimeReset("", "< parse");
			pvi1Qm1A.parse(new InputStreamReader(NzeCt1bV), DPOznwC2, true);
			Stopwatch.printTimeReset("", "< parse");
		} catch (Throwable MaWLta51) {
			MaWLta51.printStackTrace();
		}
		Stopwatch.printTimeReset("", "> traversal");
		TreeTraversal.traverse(DPOznwC2.startTag, "eachChild", new Function() {

			String Byj27umP = null;

			public void apply(Object lKNpLHYm) {
				if (lKNpLHYm instanceof String) {
					System.out.print(Byj27umP + ":");
					System.out.println(lKNpLHYm);
					return;
				}
				Tag zS8OVQqV = (Tag) lKNpLHYm;
				Byj27umP = Utils.tagPath(zS8OVQqV);
				System.out.println(Byj27umP);
			}
		});
		Stopwatch.printTimeReset("", "< traversal");
	}

}