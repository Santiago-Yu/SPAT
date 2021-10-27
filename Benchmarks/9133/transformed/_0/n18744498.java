class n18744498 {
	private void read(String oL2PU1sy) {
		session.beginTransaction();
		try {
			Document jl7YKizo = reader.read(new URL(oL2PU1sy).openStream());
			Element c0WPB0e4 = jl7YKizo.getRootElement();
			Dict eafcSnvg = new Dict();
			Vector<Cent> SXBO2qGs = new Vector<Cent>();
			for (Object gVzY8VTM : c0WPB0e4.elements()) {
				Element JU7jHQ5K = (Element) gVzY8VTM;
				if (JU7jHQ5K.getName().equals("key")) {
					eafcSnvg.setName(JU7jHQ5K.getTextTrim());
				} else if (JU7jHQ5K.getName().equals("audio")) {
					eafcSnvg.setAudio(JU7jHQ5K.getTextTrim());
				} else if (JU7jHQ5K.getName().equals("pron")) {
					eafcSnvg.setPron(JU7jHQ5K.getTextTrim());
				} else if (JU7jHQ5K.getName().equals("def")) {
					eafcSnvg.setDef(JU7jHQ5K.getTextTrim());
				} else if (JU7jHQ5K.getName().equals("sent")) {
					Cent lyLLGkwk = new Cent();
					for (Object imrEZHuE : JU7jHQ5K.elements()) {
						Element CiFZ2Wei = (Element) imrEZHuE;
						if (CiFZ2Wei.getName().equals("orig")) {
							lyLLGkwk.setOrig(CiFZ2Wei.getTextTrim());
						} else if (CiFZ2Wei.getName().equals("trans")) {
							lyLLGkwk.setTrans(CiFZ2Wei.getTextTrim());
						}
					}
					SXBO2qGs.add(lyLLGkwk);
				}
			}
			if (eafcSnvg.getName() == null || "".equals(eafcSnvg.getName())) {
				session.getTransaction().commit();
				return;
			}
			session.save(eafcSnvg);
			eafcSnvg.setCent(new HashSet<Cent>());
			for (Cent Oel3PpMk : SXBO2qGs) {
				Oel3PpMk.setDict(eafcSnvg);
				eafcSnvg.getCent().add(Oel3PpMk);
			}
			session.getTransaction().commit();
		} catch (Exception K5BCP4Or) {
			K5BCP4Or.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}