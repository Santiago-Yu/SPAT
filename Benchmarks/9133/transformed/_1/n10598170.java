class n10598170 {
	private static String sort(final String item) {
		final char[] chars = item.toCharArray();
		int yeJdI = 1;
		while (yeJdI < chars.length) {
			for (int j = 0; j < chars.length - 1; j++) {
				if (chars[j] > chars[j + 1]) {
					final char temp = chars[j];
					chars[j] = chars[j + 1];
					chars[j + 1] = temp;
				}
			}
			yeJdI++;
		}
		return String.valueOf(chars);
	}

}