class n4937926 {
	@Override
	public RServiceResponse execute(final NexusServiceRequest OasKqEZB) throws NexusServiceException {
		final RServiceRequest j12TQoB4 = (RServiceRequest) OasKqEZB;
		final RServiceResponse EXEjr7JI = new RServiceResponse();
		final StringBuilder lbY3MUzY = new StringBuilder("R service call results:\n");
		RSession LjcS6Bl3;
		RConnection hk5yAnwq = null;
		try {
			lbY3MUzY.append("Session Attachment: \n");
			final byte[] pM3dHRrb = j12TQoB4.getSession();
			if (pM3dHRrb != null && pM3dHRrb.length > 0) {
				LjcS6Bl3 = RUtils.getInstance().bytesToSession(pM3dHRrb);
				lbY3MUzY.append("  attaching to " + LjcS6Bl3 + "\n");
				hk5yAnwq = LjcS6Bl3.attach();
			} else {
				lbY3MUzY.append("  creating new session\n");
				hk5yAnwq = new RConnection(j12TQoB4.getServerAddress());
			}
			lbY3MUzY.append("Input Parameters: \n");
			for (String qu8Ni2mp : j12TQoB4.getInputVariables().keySet()) {
				final Object FLUcUZ1t = j12TQoB4.getInputVariables().get(qu8Ni2mp);
				if (FLUcUZ1t instanceof URI) {
					final FileObject C1ch3dEv = VFS.getManager().resolveFile(((URI) FLUcUZ1t).toString());
					final RFileOutputStream Oi8OWdrT = hk5yAnwq.createFile(C1ch3dEv.getName().getBaseName());
					IOUtils.copy(C1ch3dEv.getContent().getInputStream(), Oi8OWdrT);
					hk5yAnwq.assign(qu8Ni2mp, C1ch3dEv.getName().getBaseName());
				} else {
					hk5yAnwq.assign(qu8Ni2mp, RUtils.getInstance().convertToREXP(FLUcUZ1t));
				}
				lbY3MUzY.append("  " + FLUcUZ1t.getClass().getSimpleName() + " " + qu8Ni2mp + "=" + FLUcUZ1t + "\n");
			}
			final REXP c9RpJD51 = hk5yAnwq.eval(RUtils.getInstance().wrapCode(j12TQoB4.getCode().replace('\r', '\n')));
			lbY3MUzY.append("Execution results:\n" + c9RpJD51.asString() + "\n");
			if (c9RpJD51.isNull() || c9RpJD51.asString().startsWith("Error")) {
				EXEjr7JI.setErr(c9RpJD51.asString());
				throw new NexusServiceException("R error: " + c9RpJD51.asString());
			}
			lbY3MUzY.append("Output Parameters:\n");
			final String[] fMzPPJ2t = hk5yAnwq.eval("ls();").asStrings();
			for (String dDXzBRZ2 : fMzPPJ2t) {
				final String[] uRzVNlZh = hk5yAnwq.eval("class(" + dDXzBRZ2 + ")").asStrings();
				if (uRzVNlZh.length == 2 && "file".equals(uRzVNlZh[0]) && "connection".equals(uRzVNlZh[1])) {
					final String zRpdMbAE = hk5yAnwq.eval("showConnections(TRUE)[" + dDXzBRZ2 + "]").asString();
					lbY3MUzY.append("  R File ").append(dDXzBRZ2).append('=').append(zRpdMbAE).append('\n');
					final RFileInputStream jkPVfOKx = hk5yAnwq.openFile(zRpdMbAE);
					final File DSdVFuQ4 = File.createTempFile("nexus-" + j12TQoB4.getRequestId(), ".dat");
					IOUtils.copy(jkPVfOKx, new FileOutputStream(DSdVFuQ4));
					EXEjr7JI.getOutputVariables().put(dDXzBRZ2, DSdVFuQ4.getCanonicalFile().toURI());
				} else {
					final Object jGKA77Pl = RUtils.getInstance().convertREXP(hk5yAnwq.eval(dDXzBRZ2));
					EXEjr7JI.getOutputVariables().put(dDXzBRZ2, jGKA77Pl);
					final String iDNeWc5m = jGKA77Pl == null ? "null"
							: jGKA77Pl.getClass().isArray() ? Arrays.asList(jGKA77Pl).toString() : jGKA77Pl.toString();
					lbY3MUzY.append("  ").append(jGKA77Pl == null ? "" : jGKA77Pl.getClass().getSimpleName())
							.append(' ').append(dDXzBRZ2).append('=').append(iDNeWc5m).append('\n');
				}
			}
		} catch (ClassNotFoundException YBQ87Mr0) {
			EXEjr7JI.setErr(YBQ87Mr0.getMessage());
			LOGGER.error("Rserve Exception", YBQ87Mr0);
		} catch (RserveException YwjAsXBm) {
			EXEjr7JI.setErr(YwjAsXBm.getMessage());
			LOGGER.error("Rserve Exception", YwjAsXBm);
		} catch (REXPMismatchException R6BfBfV2) {
			EXEjr7JI.setErr(R6BfBfV2.getMessage());
			LOGGER.error("REXP Mismatch Exception", R6BfBfV2);
		} catch (IOException hBKEaQpO) {
			EXEjr7JI.setErr(hBKEaQpO.getMessage());
			LOGGER.error("IO Exception copying file ", hBKEaQpO);
		} finally {
			lbY3MUzY.append("Session Detachment:\n");
			if (hk5yAnwq != null) {
				RSession yoTstfvO;
				if (EXEjr7JI.isKeepSession()) {
					try {
						yoTstfvO = hk5yAnwq.detach();
					} catch (RserveException Xd7eCzje) {
						LOGGER.debug("Error detaching R session", Xd7eCzje);
						yoTstfvO = null;
					}
				} else {
					yoTstfvO = null;
				}
				final boolean h77GWL5e = yoTstfvO == null;
				if (!h77GWL5e) {
					EXEjr7JI.setSession(RUtils.getInstance().sessionToBytes(yoTstfvO));
					lbY3MUzY.append("  suspended session for later use\n");
				}
				hk5yAnwq.close();
				EXEjr7JI.setSession(null);
				lbY3MUzY.append("  session closed.\n");
			}
		}
		EXEjr7JI.setOut(lbY3MUzY.toString());
		return EXEjr7JI;
	}

}