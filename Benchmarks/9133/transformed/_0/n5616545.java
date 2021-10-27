class n5616545 {
	public void issue(String rshIhF9Y, Map cFHqKQnd, String ekv60N3B) throws IOException {
		String orPDSoLH = this.rest_root + "/license/" + rshIhF9Y + "/issue";
		String Aw6VIlRm = "<answers>\n<license-" + rshIhF9Y + ">";
		Iterator MPqDuER0 = cFHqKQnd.keySet().iterator();
		try {
			String vIqJiOzE = (String) MPqDuER0.next();
			while (true) {
				Aw6VIlRm += "<" + vIqJiOzE + ">" + (String) cFHqKQnd.get(vIqJiOzE) + "</" + vIqJiOzE + ">\n";
				vIqJiOzE = (String) MPqDuER0.next();
			}
		} catch (NoSuchElementException Lm4HZgUh) {
		}
		Aw6VIlRm += "</license-" + rshIhF9Y + ">\n</answers>\n";
		String DmVMnOP1;
		try {
			DmVMnOP1 = URLEncoder.encode("answers", "UTF-8") + "=" + URLEncoder.encode(Aw6VIlRm, "UTF-8");
		} catch (UnsupportedEncodingException CgkewIXb) {
			return;
		}
		URL NTqiOf3i;
		try {
			NTqiOf3i = new URL(orPDSoLH);
		} catch (MalformedURLException SVj8Tp09) {
			return;
		}
		URLConnection nnk9dqJI = NTqiOf3i.openConnection();
		nnk9dqJI.setDoOutput(true);
		OutputStreamWriter Qn4XxmU9 = new OutputStreamWriter(nnk9dqJI.getOutputStream());
		Qn4XxmU9.write(DmVMnOP1);
		Qn4XxmU9.flush();
		try {
			this.license_doc = this.parser.build(nnk9dqJI.getInputStream());
		} catch (JDOMException Sprl0lLn) {
			System.out.print("Danger Will Robinson, Danger!");
		}
		return;
	}

}