class n11261440 {
	private static String func(String vsnwnDFN) {
		int WscuTUmv = 0, QQK8Af5c;
		String Q04agsJu[] = { "sin", "cos", "tan", "log", "ln", "sqrt", "!" }, YVPCKAwo = "";
		int MSMrwCMe[] = new int[7];
		for (int IAWz1ZGo = 0; IAWz1ZGo < Q04agsJu.length; IAWz1ZGo++) {
			MSMrwCMe[IAWz1ZGo] = vsnwnDFN.lastIndexOf(Q04agsJu[IAWz1ZGo]);
		}
		for (int EkUZ8I2V = 0; EkUZ8I2V < Q04agsJu.length; EkUZ8I2V++) {
			WscuTUmv += MSMrwCMe[EkUZ8I2V];
		}
		if (WscuTUmv == -7) {
			return vsnwnDFN;
		}
		for (int wLfhU1EL = MSMrwCMe.length; wLfhU1EL > 1; wLfhU1EL--) {
			for (int zGlVrZy7 = 0; zGlVrZy7 < wLfhU1EL - 1; zGlVrZy7++) {
				if (MSMrwCMe[zGlVrZy7] < MSMrwCMe[zGlVrZy7 + 1]) {
					QQK8Af5c = MSMrwCMe[zGlVrZy7];
					MSMrwCMe[zGlVrZy7] = MSMrwCMe[zGlVrZy7 + 1];
					MSMrwCMe[zGlVrZy7 + 1] = QQK8Af5c;
					YVPCKAwo = Q04agsJu[zGlVrZy7];
					Q04agsJu[zGlVrZy7] = Q04agsJu[zGlVrZy7 + 1];
					Q04agsJu[zGlVrZy7 + 1] = YVPCKAwo;
				}
			}
		}
		if (Q04agsJu[0].equals("sin")) {
			if ((MSMrwCMe[0] == 0 || vsnwnDFN.charAt(MSMrwCMe[0] - 1) != 'a')) {
				return func(Functions.sine(vsnwnDFN, MSMrwCMe[0], false));
			} else {
				return func(Functions.asin(vsnwnDFN, MSMrwCMe[0], false));
			}
		} else if (Q04agsJu[0].equals("cos")) {
			if ((MSMrwCMe[0] == 0 || vsnwnDFN.charAt(MSMrwCMe[0] - 1) != 'a')) {
				return func(Functions.cosine(vsnwnDFN, MSMrwCMe[0], false));
			} else {
				return func(Functions.acos(vsnwnDFN, MSMrwCMe[0], false));
			}
		} else if (Q04agsJu[0].equals("tan")) {
			if ((MSMrwCMe[0] == 0 || vsnwnDFN.charAt(MSMrwCMe[0] - 1) != 'a')) {
				return func(Functions.tangent(vsnwnDFN, MSMrwCMe[0], false));
			} else {
				return func(Functions.atan(vsnwnDFN, MSMrwCMe[0], false));
			}
		} else if (Q04agsJu[0].equals("log")) {
			return func(Functions.logarithm(vsnwnDFN, MSMrwCMe[0]));
		} else if (Q04agsJu[0].equals("ln")) {
			return func(Functions.lnat(vsnwnDFN, MSMrwCMe[0]));
		} else if (Q04agsJu[0].equals("sqrt")) {
			return func(Functions.sqroot(vsnwnDFN, MSMrwCMe[0]));
		} else {
			return func(Functions.factorial(vsnwnDFN, MSMrwCMe[0]));
		}
	}

}