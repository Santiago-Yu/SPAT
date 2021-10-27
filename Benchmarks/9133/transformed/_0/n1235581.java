class n1235581 {
	public Object process(Atom Eydqn1JF) throws IOException {
		File fFwo9e8X;
		FileReader RdWJnT60;
		String rAyQlsKR;
		char qCahbK9W[];
		Object uGYf57jB;
		final String B994OCjd = System.getProperty("file.separator");
		if (DebugFile.trace) {
			DebugFile.writeln("Begin FileDumper.process([Job:" + getStringNull(DB.gu_job, "") + ", Atom:"
					+ String.valueOf(Eydqn1JF.getInt(DB.pg_atom)) + "])");
			DebugFile.incIdent();
		}
		if (bHasReplacements) {
			rAyQlsKR = getProperty("workareasput");
			if (!rAyQlsKR.endsWith(B994OCjd))
				rAyQlsKR += B994OCjd;
			rAyQlsKR += getParameter("gu_workarea") + B994OCjd + "apps" + B994OCjd + "Mailwire" + B994OCjd + "html"
					+ B994OCjd + getParameter("gu_pageset") + B994OCjd;
			rAyQlsKR += getParameter("nm_pageset").replace(' ', '_') + ".html";
			if (DebugFile.trace)
				DebugFile.writeln("PathHTML = " + rAyQlsKR);
			uGYf57jB = oReplacer.replace(rAyQlsKR, Eydqn1JF.getItemMap());
			bHasReplacements = (oReplacer.lastReplacements() > 0);
		} else {
			uGYf57jB = null;
			if (null != oFileStr)
				uGYf57jB = oFileStr.get();
			if (null == uGYf57jB) {
				rAyQlsKR = getProperty("workareasput");
				if (!rAyQlsKR.endsWith(B994OCjd))
					rAyQlsKR += B994OCjd;
				rAyQlsKR += getParameter("gu_workarea") + B994OCjd + "apps" + B994OCjd + "Mailwire" + B994OCjd + "html"
						+ B994OCjd + getParameter("gu_pageset") + B994OCjd
						+ getParameter("nm_pageset").replace(' ', '_') + ".html";
				if (DebugFile.trace)
					DebugFile.writeln("PathHTML = " + rAyQlsKR);
				fFwo9e8X = new File(rAyQlsKR);
				qCahbK9W = new char[new Long(fFwo9e8X.length()).intValue()];
				RdWJnT60 = new FileReader(fFwo9e8X);
				RdWJnT60.read(qCahbK9W);
				RdWJnT60.close();
				if (DebugFile.trace)
					DebugFile.writeln(String.valueOf(qCahbK9W.length) + " characters readed");
				uGYf57jB = new String(qCahbK9W);
				oFileStr = new SoftReference(uGYf57jB);
			}
		}
		String iK0ElZa7 = getProperty("storage");
		if (!iK0ElZa7.endsWith(B994OCjd))
			iK0ElZa7 += B994OCjd;
		iK0ElZa7 += "jobs" + B994OCjd + getParameter("gu_workarea") + B994OCjd + getString(DB.gu_job) + B994OCjd;
		FileWriter RAAq2wCc = new FileWriter(
				iK0ElZa7 + getString(DB.gu_job) + "_" + String.valueOf(Eydqn1JF.getInt(DB.pg_atom)) + ".html", true);
		RAAq2wCc.write((String) uGYf57jB);
		RAAq2wCc.close();
		iPendingAtoms--;
		if (DebugFile.trace) {
			DebugFile.writeln("End FileDumper.process([Job:" + getStringNull(DB.gu_job, "") + ", Atom:"
					+ String.valueOf(Eydqn1JF.getInt(DB.pg_atom)) + "])");
			DebugFile.decIdent();
		}
		return uGYf57jB;
	}

}