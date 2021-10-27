class n13015489 {
	public void prepareOutput(HttpServletRequest gDZLM5Eu) {
		EaasyStreet.logTrace(METHOD_IN + className + OUTPUT_METHOD);
		super.prepareOutput(gDZLM5Eu);
		String AiR1FMcU = Constants.EMPTY_STRING;
		String Itjmp2mN = null;
		List F97AFLmw = null;
		try {
			URL qQpbQ0l9 = new URL(sourceUrl);
			BufferedReader SYJwRbPe = new BufferedReader(new InputStreamReader(qQpbQ0l9.openStream()));
			String d1YIjPvR = "";
			StringBuffer gJPTExO7 = new StringBuffer();
			while ((d1YIjPvR = SYJwRbPe.readLine()) != null) {
				gJPTExO7.append(d1YIjPvR);
				gJPTExO7.append(Constants.LF);
			}
			Itjmp2mN = gJPTExO7.toString();
		} catch (FileNotFoundException DLjr0ZtG) {
			gDZLM5Eu.setAttribute(Constants.RAK_SYSTEM_ACTION, Constants.SYSTEM_ACTION_BACK);
			EaasyStreet.handleSafeEvent(gDZLM5Eu,
					new Event(Constants.EAA0012I, new String[] { "URL", DLjr0ZtG.getMessage(), DLjr0ZtG.toString() }));
		} catch (Exception YYsql11M) {
			gDZLM5Eu.setAttribute(Constants.RAK_SYSTEM_ACTION, Constants.SYSTEM_ACTION_BACK);
			EaasyStreet.handleSafeEvent(gDZLM5Eu,
					new Event(Constants.EAA0012I, new String[] { "URL", YYsql11M.getMessage(), YYsql11M.toString() }));
		}
		if (Itjmp2mN != null) {
			if (startDelimiter != null) {
				F97AFLmw = StringUtils.split(Itjmp2mN, startDelimiter);
				if (F97AFLmw != null && F97AFLmw.size() > 1) {
					Itjmp2mN = (String) F97AFLmw.get(1);
					if (F97AFLmw.size() > 2) {
						for (int vOKrltZ9 = 2; vOKrltZ9 < F97AFLmw.size(); vOKrltZ9++) {
							Itjmp2mN += startDelimiter;
							Itjmp2mN += F97AFLmw.get(vOKrltZ9);
						}
					}
				} else {
					Itjmp2mN = null;
				}
			}
		}
		if (Itjmp2mN != null) {
			if (endDelimiter != null) {
				F97AFLmw = StringUtils.split(Itjmp2mN, endDelimiter);
				if (F97AFLmw != null && F97AFLmw.size() > 0) {
					Itjmp2mN = (String) F97AFLmw.get(0);
				} else {
					Itjmp2mN = null;
				}
			}
		}
		if (Itjmp2mN != null) {
			if (replacementValues != null && !replacementValues.isEmpty()) {
				for (int KV9exCZ3 = 0; KV9exCZ3 < replacementValues.size(); KV9exCZ3++) {
					LabelValueBean opjQb5wK = (LabelValueBean) replacementValues.get(KV9exCZ3);
					Itjmp2mN = StringUtils.replace(Itjmp2mN, opjQb5wK.getLabel(), opjQb5wK.getValue());
				}
			}
		}
		if (Itjmp2mN != null) {
			AiR1FMcU = Itjmp2mN;
		}
		gDZLM5Eu.setAttribute(getFormName(), AiR1FMcU);
		EaasyStreet.logTrace(METHOD_OUT + className + OUTPUT_METHOD);
	}

}