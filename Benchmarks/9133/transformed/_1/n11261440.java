class n11261440 {
	private static String func(String sf) {
		int total = 0, temp;
		String fnctn[] = { "sin", "cos", "tan", "log", "ln", "sqrt", "!" }, temp2 = "";
		int pos[] = new int[7];
		int tFMGh = 0;
		while (tFMGh < fnctn.length) {
			pos[tFMGh] = sf.lastIndexOf(fnctn[tFMGh]);
			tFMGh++;
		}
		int RrHVX = 0;
		while (RrHVX < fnctn.length) {
			total += pos[RrHVX];
			RrHVX++;
		}
		if (total == -7) {
			return sf;
		}
		int Sq2cW = pos.length;
		while (Sq2cW > 1) {
			for (int j = 0; j < Sq2cW - 1; j++) {
				if (pos[j] < pos[j + 1]) {
					temp = pos[j];
					pos[j] = pos[j + 1];
					pos[j + 1] = temp;
					temp2 = fnctn[j];
					fnctn[j] = fnctn[j + 1];
					fnctn[j + 1] = temp2;
				}
			}
			Sq2cW--;
		}
		if (fnctn[0].equals("sin")) {
			if ((pos[0] == 0 || sf.charAt(pos[0] - 1) != 'a')) {
				return func(Functions.sine(sf, pos[0], false));
			} else {
				return func(Functions.asin(sf, pos[0], false));
			}
		} else if (fnctn[0].equals("cos")) {
			if ((pos[0] == 0 || sf.charAt(pos[0] - 1) != 'a')) {
				return func(Functions.cosine(sf, pos[0], false));
			} else {
				return func(Functions.acos(sf, pos[0], false));
			}
		} else if (fnctn[0].equals("tan")) {
			if ((pos[0] == 0 || sf.charAt(pos[0] - 1) != 'a')) {
				return func(Functions.tangent(sf, pos[0], false));
			} else {
				return func(Functions.atan(sf, pos[0], false));
			}
		} else if (fnctn[0].equals("log")) {
			return func(Functions.logarithm(sf, pos[0]));
		} else if (fnctn[0].equals("ln")) {
			return func(Functions.lnat(sf, pos[0]));
		} else if (fnctn[0].equals("sqrt")) {
			return func(Functions.sqroot(sf, pos[0]));
		} else {
			return func(Functions.factorial(sf, pos[0]));
		}
	}

}