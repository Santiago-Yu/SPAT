class n4574772 {
	public static boolean init(String Bf36KVq7) {
		URL vfgQNkNZ = S.class.getResource("strings_" + Bf36KVq7 + ".txt");
		strings = new Properties();
		try {
			strings.load(vfgQNkNZ.openStream());
		} catch (Exception heW6pRqQ) {
			String V7shAIpE = "en";
			if (Bf36KVq7.equals(V7shAIpE))
				return false;
			return init(V7shAIpE);
		}
		;
		return true;
	}

}