class n2396191 {
	public static Vector[] getLinksFromURLFast(String zDtHYAHJ) throws Exception {
		timeCheck("getLinksFromURLFast ");
		URL kwSX2enE = new URL(zDtHYAHJ);
		URLConnection CZ6EVX8e = kwSX2enE.openConnection();
		InputStreamReader YbWCYXo3 = new InputStreamReader(CZ6EVX8e.getInputStream());
		BufferedReader ph4mFCSQ = new BufferedReader(YbWCYXo3);
		String x0vJqDKn = null;
		RE C1O9if32 = new RE("(.*/)", RE.REG_ICASE);
		System.out.println("RE: " + C1O9if32.toString());
		REMatch ksuk1mRp = C1O9if32.getMatch(zDtHYAHJ);
		String yMovZQ7k = zDtHYAHJ.substring(ksuk1mRp.getSubStartIndex(1), ksuk1mRp.getSubEndIndex(1));
		C1O9if32 = new RE("(http://.*?)/?", RE.REG_ICASE);
		ksuk1mRp = C1O9if32.getMatch(zDtHYAHJ);
		String lErXfEYG = zDtHYAHJ.substring(ksuk1mRp.getSubStartIndex(1), ksuk1mRp.getSubEndIndex(1));
		C1O9if32 = new RE("<a href=\"?(.*?)\"?>(.*?)</a>", RE.REG_ICASE);
		System.out.println("RE: " + C1O9if32.toString());
		Vector feQgHANp = new Vector(100);
		Vector SxQVGQ4Z = new Vector(100);
		StringBuffer KiNtCUk3 = new StringBuffer(10000);
		REMatch[] otBm72c1 = null;
		timeCheck("starting parsing ");
		while ((x0vJqDKn = ph4mFCSQ.readLine()) != null) {
			KiNtCUk3.append(x0vJqDKn);
		}
		String YOOkGJCA = KiNtCUk3.toString();
		String seTIQATj = null;
		otBm72c1 = C1O9if32.getAllMatches(YOOkGJCA);
		for (int VALZfIlY = 0; VALZfIlY < otBm72c1.length; VALZfIlY++) {
			seTIQATj = YOOkGJCA.substring(otBm72c1[VALZfIlY].getSubStartIndex(1), otBm72c1[VALZfIlY].getSubEndIndex(1));
			if (seTIQATj.indexOf("mailto:") != -1)
				continue;
			seTIQATj = toAbsolute(lErXfEYG, yMovZQ7k, seTIQATj);
			feQgHANp.addElement(seTIQATj);
			SxQVGQ4Z.addElement(
					YOOkGJCA.substring(otBm72c1[VALZfIlY].getSubStartIndex(2), otBm72c1[VALZfIlY].getSubEndIndex(2)));
		}
		Vector[] PuNhxq6M = new Vector[2];
		PuNhxq6M[0] = feQgHANp;
		PuNhxq6M[1] = SxQVGQ4Z;
		timeCheck("end parsing ");
		return PuNhxq6M;
	}

}