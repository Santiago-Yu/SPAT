class n20884203 {
	public static void main(String[] argv) throws Exception {
		Map args = parseOpts(argv);
		if (args.get("help") != null) {
			printUsage();
			System.exit(0);
		} else if (args.get("version") != null) {
			System.out.println("SISC - The Second Interpreter of Scheme Code - " + Util.VERSION);
			System.exit(0);
		}
		Properties props = new Properties();
		String configFile = (String) args.get("properties");
		if (configFile != null) {
			try {
				URL url = Util.url(configFile);
				URLConnection conn = url.openConnection();
				conn.setDoInput(true);
				conn.setDoOutput(false);
				props.load(conn.getInputStream());
			} catch (MalformedURLException e) {
				System.err.println("WARNING: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("WARNING: " + e.getMessage());
			}
		}
		AppContext ctx = new AppContext(props);
		Context.setDefaultAppContext(ctx);
		URL heap = AppContext.findHeap(Util.makeURL((String) args.get("heap")));
		if (heap == null) {
			System.err.println(Util.liMessage(Util.SISCB, "heapnotfound"));
			return;
		}
		if (!ctx.addHeap(AppContext.openHeap(heap)))
			return;
		Interpreter r = Context.enter(ctx);
		boolean filesLoadedSuccessfully = r
				.loadSourceFiles((String[]) ((Vector) args.get("files")).toArray(new String[0])),
				noRepl = args.get("no-repl") != null;
		boolean call = args.get("call-with-args") != null;
		int returnCode = 0;
		String expr = (String) args.get("eval");
		if (expr != null) {
			Value v = Util.VOID;
			try {
				v = r.eval(expr);
				if (!call)
					System.out.println(v);
			} catch (SchemeException se) {
				se.printStackTrace();
				returnCode = 1;
			}
		}
		String func = (String) args.get("call-with-args");
		if (func != null) {
			Procedure fun = null;
			try {
				fun = Util.proc(r.eval(func));
			} catch (SchemeException se) {
				se.printStackTrace();
				returnCode = 1;
			}
			if (fun != null) {
				Vector av = (Vector) args.get("argv");
				Value[] sargs = new Value[(av == null ? 0 : av.size())];
				for (int i = 0; i < sargs.length; i++)
					sargs[i] = new SchemeString((String) av.elementAt(i));
				Value v = Util.VOID;
				try {
					v = r.eval(fun, sargs);
					if (noRepl) {
						if (v instanceof Quantity)
							returnCode = ((Quantity) v).indexValue();
						else if (!(v instanceof SchemeVoid)) {
							System.out.println(v);
						}
					}
				} catch (SchemeException se) {
					se.printStackTrace();
					returnCode = 1;
				}
			}
		}
		DynamicEnvironment dynenv = r.dynenv;
		Context.exit();
		if (!noRepl) {
			String listen = (String) args.get("listen");
			if (listen != null) {
				int cidx = listen.indexOf(':');
				ServerSocket ssocket = cidx == -1 ? new ServerSocket(Integer.parseInt(listen), 50)
						: new ServerSocket(Integer.parseInt(listen.substring(cidx + 1)), 50,
								InetAddress.getByName(listen.substring(0, cidx)));
				System.out
						.println("Listening on " + ssocket.getInetAddress().toString() + ":" + ssocket.getLocalPort());
				System.out.flush();
				listen(ctx, ssocket);
			} else {
				REPL repl = new REPL(dynenv, getCliProc(ctx));
				repl.go();
				repl.primordialThread.thread.join();
				switch (repl.primordialThread.state) {
				case SchemeThread.FINISHED:
					if (repl.primordialThread.rv instanceof Quantity) {
						returnCode = ((Quantity) repl.primordialThread.rv).intValue();
					}
					break;
				case SchemeThread.FINISHED_ABNORMALLY:
					returnCode = 1;
					break;
				}
			}
		} else if (returnCode == 0 && !filesLoadedSuccessfully) {
			returnCode = 1;
		}
		System.exit(returnCode);
	}

}