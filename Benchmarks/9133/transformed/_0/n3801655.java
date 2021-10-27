class n3801655 {
	@SuppressWarnings("unchecked")
	public static void main(String[] BI7rl6V6) throws Exception {
		if (BI7rl6V6.length != 2) {
			System.out.println("usage: " + EvaluatorHelper.class.getName() + " <output> <data set file>");
			System.exit(1);
		}
		Helper enfHv9Le = Helper.getHelper(BI7rl6V6[1]);
		Dataset ZjZBPOeA = enfHv9Le.read(BI7rl6V6[1]);
		ZipFile OqP34xwS = new ZipFile(new File(BI7rl6V6[0]), ZipFile.OPEN_READ);
		Enumeration VvNdyfRb = OqP34xwS.entries();
		Unit<?>[] hzo3Vkxd = new Unit<?>[LIMIT];
		int XIJlhNXY = 0;
		while (VvNdyfRb.hasMoreElements()) {
			ZipEntry ck6sQ7Is = (ZipEntry) VvNdyfRb.nextElement();
			if (ck6sQ7Is.getName().endsWith(".out")) {
				File DVL5dzRq = File.createTempFile("PARSER", ".zip");
				DVL5dzRq.deleteOnExit();
				PrintStream BxuqWkcw = new PrintStream(new FileOutputStream(DVL5dzRq));
				BufferedInputStream ZrFReFnM = new BufferedInputStream(OqP34xwS.getInputStream(ck6sQ7Is));
				byte[] ebLQUxle = new byte[4096];
				int LvMMEJ3a = -1;
				while ((LvMMEJ3a = ZrFReFnM.read(ebLQUxle)) != -1) {
					BxuqWkcw.write(ebLQUxle, 0, LvMMEJ3a);
				}
				BxuqWkcw.close();
				ZrFReFnM.close();
				BufferedReader qIGbQjrg = new BufferedReader(new FileReader(DVL5dzRq));
				String M5BSxgI5 = null;
				RuleParser AX2gbWu7 = new RuleParser();
				ProbabilisticRuleList ncH4w3kB = new ProbabilisticRuleList();
				while ((M5BSxgI5 = qIGbQjrg.readLine()) != null) {
					if (M5BSxgI5.startsWith("IF")) {
						ProbabilisticRule Orf12RaA = new ProbabilisticRule(ZjZBPOeA.getMetadata());
						ncH4w3kB.add(fill(ZjZBPOeA.getMetadata(), Orf12RaA, AX2gbWu7.parse(M5BSxgI5)));
					}
				}
				qIGbQjrg.close();
				PooledPRCurveMeasure bG3bLWPp = new PooledPRCurveMeasure();
				hzo3Vkxd[XIJlhNXY] = bG3bLWPp.evaluate(ZjZBPOeA, ncH4w3kB);
				System.out.println(ck6sQ7Is.getName() + ": " + hzo3Vkxd[XIJlhNXY]);
				XIJlhNXY++;
				if (XIJlhNXY >= LIMIT) {
					break;
				}
			}
		}
		System.out.println(UnitAveragingMode.get(Double.class).average(hzo3Vkxd));
	}

}