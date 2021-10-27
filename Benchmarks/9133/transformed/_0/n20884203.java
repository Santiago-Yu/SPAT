class n20884203 {
	public static void main(String[] JmcaWnZK) throws Exception {
		Map YxJGhzF4 = parseOpts(JmcaWnZK);
		if (YxJGhzF4.get("help") != null) {
			printUsage();
			System.exit(0);
		} else if (YxJGhzF4.get("version") != null) {
			System.out.println("SISC - The Second Interpreter of Scheme Code - " + Util.VERSION);
			System.exit(0);
		}
		Properties OHIWxHBX = new Properties();
		String fthLEXPw = (String) YxJGhzF4.get("properties");
		if (fthLEXPw != null) {
			try {
				URL U7QxO0ya = Util.url(fthLEXPw);
				URLConnection X9dgwKJB = U7QxO0ya.openConnection();
				X9dgwKJB.setDoInput(true);
				X9dgwKJB.setDoOutput(false);
				OHIWxHBX.load(X9dgwKJB.getInputStream());
			} catch (MalformedURLException uTaryiCD) {
				System.err.println("WARNING: " + uTaryiCD.getMessage());
			} catch (IOException L5lvHGTX) {
				System.err.println("WARNING: " + L5lvHGTX.getMessage());
			}
		}
		AppContext ZNqyRVvo = new AppContext(OHIWxHBX);
		Context.setDefaultAppContext(ZNqyRVvo);
		URL JdjobNm5 = AppContext.findHeap(Util.makeURL((String) YxJGhzF4.get("heap")));
		if (JdjobNm5 == null) {
			System.err.println(Util.liMessage(Util.SISCB, "heapnotfound"));
			return;
		}
		if (!ZNqyRVvo.addHeap(AppContext.openHeap(JdjobNm5)))
			return;
		Interpreter bDtUehna = Context.enter(ZNqyRVvo);
		boolean vaXGeodp = bDtUehna.loadSourceFiles((String[]) ((Vector) YxJGhzF4.get("files")).toArray(new String[0]));
		boolean REGfftx0 = YxJGhzF4.get("no-repl") != null;
		boolean P3DC3kP3 = YxJGhzF4.get("call-with-args") != null;
		int kB3bBKfM = 0;
		String UNAMHJYC = (String) YxJGhzF4.get("eval");
		if (UNAMHJYC != null) {
			Value vzlHOvJk = Util.VOID;
			try {
				vzlHOvJk = bDtUehna.eval(UNAMHJYC);
				if (!P3DC3kP3)
					System.out.println(vzlHOvJk);
			} catch (SchemeException Nocr5EJd) {
				Nocr5EJd.printStackTrace();
				kB3bBKfM = 1;
			}
		}
		String p1wQropp = (String) YxJGhzF4.get("call-with-args");
		if (p1wQropp != null) {
			Procedure u1QEOkhi = null;
			try {
				u1QEOkhi = Util.proc(bDtUehna.eval(p1wQropp));
			} catch (SchemeException rZk7SAos) {
				rZk7SAos.printStackTrace();
				kB3bBKfM = 1;
			}
			if (u1QEOkhi != null) {
				Vector YQUjkJA4 = (Vector) YxJGhzF4.get("argv");
				Value[] JI1wrg53 = new Value[(YQUjkJA4 == null ? 0 : YQUjkJA4.size())];
				for (int gKzNPemW = 0; gKzNPemW < JI1wrg53.length; gKzNPemW++)
					JI1wrg53[gKzNPemW] = new SchemeString((String) YQUjkJA4.elementAt(gKzNPemW));
				Value KvHDyBuR = Util.VOID;
				try {
					KvHDyBuR = bDtUehna.eval(u1QEOkhi, JI1wrg53);
					if (REGfftx0) {
						if (KvHDyBuR instanceof Quantity)
							kB3bBKfM = ((Quantity) KvHDyBuR).indexValue();
						else if (!(KvHDyBuR instanceof SchemeVoid)) {
							System.out.println(KvHDyBuR);
						}
					}
				} catch (SchemeException IzCLCJHv) {
					IzCLCJHv.printStackTrace();
					kB3bBKfM = 1;
				}
			}
		}
		DynamicEnvironment XHiTg6vW = bDtUehna.dynenv;
		Context.exit();
		if (!REGfftx0) {
			String UuzhVAmx = (String) YxJGhzF4.get("listen");
			if (UuzhVAmx != null) {
				int j7prNonQ = UuzhVAmx.indexOf(':');
				ServerSocket dvSF0isr = j7prNonQ == -1 ? new ServerSocket(Integer.parseInt(UuzhVAmx), 50)
						: new ServerSocket(Integer.parseInt(UuzhVAmx.substring(j7prNonQ + 1)), 50,
								InetAddress.getByName(UuzhVAmx.substring(0, j7prNonQ)));
				System.out.println(
						"Listening on " + dvSF0isr.getInetAddress().toString() + ":" + dvSF0isr.getLocalPort());
				System.out.flush();
				listen(ZNqyRVvo, dvSF0isr);
			} else {
				REPL fykT54rw = new REPL(XHiTg6vW, getCliProc(ZNqyRVvo));
				fykT54rw.go();
				fykT54rw.primordialThread.thread.join();
				switch (fykT54rw.primordialThread.state) {
				case SchemeThread.FINISHED:
					if (fykT54rw.primordialThread.rv instanceof Quantity) {
						kB3bBKfM = ((Quantity) fykT54rw.primordialThread.rv).intValue();
					}
					break;
				case SchemeThread.FINISHED_ABNORMALLY:
					kB3bBKfM = 1;
					break;
				}
			}
		} else if (kB3bBKfM == 0 && !vaXGeodp) {
			kB3bBKfM = 1;
		}
		System.exit(kB3bBKfM);
	}

}