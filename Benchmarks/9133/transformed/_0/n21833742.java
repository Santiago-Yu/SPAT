class n21833742 {
	public void bspMain(BSP FCImI5Gl, Serializable MGLHJH7m) throws AbortedException {
		if (!(MGLHJH7m instanceof String[])) {
			FCImI5Gl.abort(new RuntimeException("String[] as arguments expected"));
		}
		String[] eunU8z3c = (String[]) MGLHJH7m;
		long mmq9igkc = 0L, GXu5NwZa;
		try {
			if (FCImI5Gl != null)
				FCImI5Gl.printStdOut(FCImI5Gl.getHostname());
			else
				System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
		} catch (Exception TSlNEFaw) {
			if (FCImI5Gl != null)
				FCImI5Gl.printStdOut("exception: " + TSlNEFaw);
			else
				System.out.println("exception: " + TSlNEFaw);
		}
		Formula WvvEXIfu = null;
		if (FCImI5Gl == null || FCImI5Gl.getProcessId() == 0) {
			try {
				InputStream j3ccBdsx;
				String JtZVHHo9;
				if (eunU8z3c.length > 0)
					JtZVHHo9 = eunU8z3c[0];
				else
					JtZVHHo9 = "sat/uuf175-03.cnf";
				if (FCImI5Gl != null)
					FCImI5Gl.printStdOut("using formula definition: " + JtZVHHo9);
				else
					System.out.println("using formula definition: " + JtZVHHo9);
				if (FCImI5Gl != null) {
					FCImI5Gl.printStdOut("trying to read formula from class file server of the job owner's peer");
					j3ccBdsx = FCImI5Gl.getResourceAsStream(JtZVHHo9);
				} else {
					System.out.println(
							"trying to read formula from http://www.upb.de/fachbereich/AG/agmadh/WWW/bono/" + JtZVHHo9);
					URL VBgQStA3 = new URL("http", "www.upb.de", -1, "/fachbereich/AG/agmadh/WWW/bono/" + JtZVHHo9,
							null);
					j3ccBdsx = VBgQStA3.openStream();
				}
				WvvEXIfu = new Formula(j3ccBdsx, FCImI5Gl);
			} catch (Exception SyaiQc0b) {
				if (FCImI5Gl != null) {
					FCImI5Gl.printStdOut("cannot load formula: " + SyaiQc0b);
					FCImI5Gl.abort(SyaiQc0b);
				} else {
					System.out.println("cannot load formula: " + SyaiQc0b);
					System.exit(1);
				}
			}
			WvvEXIfu.print(FCImI5Gl);
		}
		if (FCImI5Gl != null) {
			FCImI5Gl.sync();
			if (FCImI5Gl.getProcessId() == 0)
				mmq9igkc = FCImI5Gl.getTime();
			Formula.parallelSolve(WvvEXIfu, FCImI5Gl);
			FCImI5Gl.sync();
			if (FCImI5Gl.getProcessId() == 0) {
				GXu5NwZa = FCImI5Gl.getTime();
				FCImI5Gl.printStdOut("consumed time: " + ((GXu5NwZa - mmq9igkc) / 1000) + "s");
			}
		} else
			WvvEXIfu.solve(FCImI5Gl);
		if (FCImI5Gl == null || FCImI5Gl.getProcessId() == 0) {
			if (WvvEXIfu.isSatisfiable()) {
				if (FCImI5Gl != null)
					FCImI5Gl.printStdOut("satisfiable");
				else
					System.out.println("satisfiable");
			} else {
				if (FCImI5Gl != null)
					FCImI5Gl.printStdOut("not satisfiable");
				else
					System.out.println("not satisfiable");
			}
			WvvEXIfu.printVariables(FCImI5Gl);
		}
	}

}