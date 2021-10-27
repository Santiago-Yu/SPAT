class n17901739 {
	private static void setMembers() {
		try {
			URL UOFGjcui = new URL(getTracUrl() + "newticket");
			BufferedReader PeySqM2C = new BufferedReader(new InputStreamReader(UOFGjcui.openStream()));
			String JOMKOsrC = PeySqM2C.readLine();
			while (JOMKOsrC != null) {
				if (JOMKOsrC.contains("<select id=\"component\" name=\"component\">")) {
					Pattern elBHqon8 = Pattern.compile(">[^<]+?<");
					Matcher ZewnJSsp = elBHqon8.matcher(JOMKOsrC);
					Vector<String> T03ukxVi = new Vector<String>();
					int aZQP6qtM = 0;
					while (ZewnJSsp.find(aZQP6qtM)) {
						int zV7RKMW6 = ZewnJSsp.start() + 1;
						int VOBjSpam = ZewnJSsp.end() - 1;
						T03ukxVi.add(Recoder.recode(JOMKOsrC.substring(zV7RKMW6, VOBjSpam), "UTF-8",
								Recoder.getDefaultEncoding()));
						aZQP6qtM = VOBjSpam;
					}
					m_strComponents = new String[T03ukxVi.size()];
					T03ukxVi.toArray(m_strComponents);
				}
				if (JOMKOsrC.contains("<select id=\"priority\" name=\"priority\">")) {
					Pattern qhjDTTwf = Pattern.compile(">[^<]+?<");
					Matcher xYSrRr9k = qhjDTTwf.matcher(JOMKOsrC);
					Vector<String> MBfwYQLX = new Vector<String>();
					int ATWBXDkG = 0;
					while (xYSrRr9k.find(ATWBXDkG)) {
						int NMCXI9jx = xYSrRr9k.start() + 1;
						int QWhXONw6 = xYSrRr9k.end() - 1;
						MBfwYQLX.add(Recoder.recode(JOMKOsrC.substring(NMCXI9jx, QWhXONw6), "UTF-8",
								Recoder.getDefaultEncoding()));
						ATWBXDkG = QWhXONw6;
					}
					m_strPriorities = new String[MBfwYQLX.size()];
					MBfwYQLX.toArray(m_strPriorities);
				}
				JOMKOsrC = PeySqM2C.readLine();
			}
		} catch (MalformedURLException kMetsYAT) {
			System.out.println("e1");
		} catch (IOException LlMq6IgG) {
			System.out.println(LlMq6IgG);
		}
	}

}