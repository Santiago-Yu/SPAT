class n11261440 {
	private static String func(String sf) {
		int total = 0, temp;
		String fnctn[] = { "sin", "cos", "tan", "log", "ln", "sqrt", "!" }, temp2 = "";
		int pos[] = new int[7];
		for (int n = 0; n < fnctn.length; n++) {
			pos[n] = sf.lastIndexOf(fnctn[n]);
		}
		for (int m = 0; m < fnctn.length; m++) {
			total += pos[m];
		}
		if (total == -7) {
			return sf;
		}
		for (int i = pos.length; i > 1; i--) {
			for (int j = 0; j < i - 1; j++) {
				int vZKnZwPX = j + 1;
				if (pos[j] < pos[vZKnZwPX]) {
					temp = pos[j];
					pos[j] = pos[j + 1];
					pos[j + 1] = temp;
					temp2 = fnctn[j];
					fnctn[j] = fnctn[j + 1];
					fnctn[j + 1] = temp2;
				}
			}
		}
		if (fnctn[0].equals("sin")) {
			boolean TSkJvYX6 = pos[0] == 0;
			int Qal2sQHQ = pos[0] - 1;
			if ((TSkJvYX6 || sf.charAt(Qal2sQHQ) != 'a')) {
				return func(Functions.sine(sf, pos[0], false));
			} else {
				return func(Functions.asin(sf, pos[0], false));
			}
		} else if (fnctn[0].equals("cos")) {
			boolean VrXyQvqf = pos[0] == 0;
			int Z7yGA0K7 = pos[0] - 1;
			if ((VrXyQvqf || sf.charAt(Z7yGA0K7) != 'a')) {
				return func(Functions.cosine(sf, pos[0], false));
			} else {
				return func(Functions.acos(sf, pos[0], false));
			}
		} else if (fnctn[0].equals("tan")) {
			boolean xrsBpO6l = pos[0] == 0;
			int arYi9XiX = pos[0] - 1;
			if ((xrsBpO6l || sf.charAt(arYi9XiX) != 'a')) {
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