class n23094550 {
	public StringBuffer render(RenderEngine hnBX4Lt7) {
		String znrx9zUt = null;
		if (hnBX4Lt7.getWorkerContext() != null) {
			znrx9zUt = hnBX4Lt7.getWorkerContext().getWorkerStart();
		}
		if (hnBX4Lt7.isBreakState() || !hnBX4Lt7.canRender("u")) {
			return new StringBuffer();
		}
		StringBuffer t3X4VQV1 = new StringBuffer();
		varname = TagInspector.processElement(varname, hnBX4Lt7);
		action = TagInspector.processElement(action, hnBX4Lt7);
		filemode = TagInspector.processElement(filemode, hnBX4Lt7);
		xmlparse = TagInspector.processElement(xmlparse, hnBX4Lt7);
		encoding = TagInspector.processElement(encoding, hnBX4Lt7);
		decoding = TagInspector.processElement(decoding, hnBX4Lt7);
		filter = TagInspector.processElement(filter, hnBX4Lt7);
		sort = TagInspector.processElement(sort, hnBX4Lt7);
		useDocroot = TagInspector.processElement(useDocroot, hnBX4Lt7);
		useFilename = TagInspector.processElement(useFilename, hnBX4Lt7);
		useDest = TagInspector.processElement(useDest, hnBX4Lt7);
		xmlOutput = TagInspector.processElement(xmlOutput, hnBX4Lt7);
		renderOutput = TagInspector.processElement(renderOutput, hnBX4Lt7);
		callProc = TagInspector.processElement(callProc, hnBX4Lt7);
		vartype = TagInspector.processElement(vartype, hnBX4Lt7);
		if (sort == null || sort.equals("")) {
			sort = "asc";
		}
		if (useFilename.equals("") && !action.equalsIgnoreCase("listing")) {
			return new StringBuffer();
		}
		boolean Lkt7rEbI = true;
		if (useDocroot.equalsIgnoreCase("true")) {
			if (hnBX4Lt7.getVendContext().getVend().getIgnorableDocroot(hnBX4Lt7.getClientContext().getMatchedHost())) {
				Lkt7rEbI = false;
			}
		}
		if (Lkt7rEbI && (useFilename.indexOf("/") == -1 || useFilename.startsWith("./"))) {
			if (hnBX4Lt7.getWorkerContext() != null && useFilename.startsWith("./")) {
				useFilename = hnBX4Lt7.getWorkerContext().getClientContext().getPostVariable("current_path")
						+ useFilename.substring(2);
				Debug.inform("CWD path specified in filename, rewritten to '" + useFilename + "'");
			} else if (hnBX4Lt7.getWorkerContext() != null && useFilename.indexOf("/") == -1) {
				useFilename = hnBX4Lt7.getWorkerContext().getClientContext().getPostVariable("current_path")
						+ useFilename;
				Debug.inform("No path specified in filename, rewritten to '" + useFilename + "'");
			} else {
				Debug.inform("No path specified in filename, no worker context, not rewriting filename.");
			}
		}
		StringBuffer kSMcUs0n = null;
		StringBuffer W2IIWxfN = null;
		StringBuffer o4XI6cdP = null;
		W2IIWxfN = TagInspector.processBody(this, hnBX4Lt7);
		kSMcUs0n = new StringBuffer(useFilename);
		o4XI6cdP = new StringBuffer(useDest);
		String PozNJCWd = null;
		if (hnBX4Lt7.getWorkerContext() == null) {
			if (hnBX4Lt7.getRenderContext().getCurrentDocroot() == null) {
				PozNJCWd = ".";
			} else {
				PozNJCWd = hnBX4Lt7.getRenderContext().getCurrentDocroot();
			}
		} else {
			PozNJCWd = hnBX4Lt7.getWorkerContext().getDocRoot();
		}
		if (!Lkt7rEbI) {
			PozNJCWd = "";
		}
		if (useDocroot.equalsIgnoreCase("true")) {
			if (hnBX4Lt7.getVendContext().getVend().getIgnorableDocroot(hnBX4Lt7.getClientContext().getMatchedHost())) {
				Lkt7rEbI = false;
				PozNJCWd = "";
			}
		}
		if (!PozNJCWd.endsWith("/")) {
			if (!PozNJCWd.equals("") && PozNJCWd.length() > 0) {
				PozNJCWd += "/";
			}
		}
		if (kSMcUs0n != null) {
			kSMcUs0n = new StringBuffer(kSMcUs0n.toString().replaceAll("\\.\\.", ""));
		}
		if (o4XI6cdP != null) {
			o4XI6cdP = new StringBuffer(o4XI6cdP.toString().replaceAll("\\.\\.", ""));
		}
		if (action.equalsIgnoreCase("read")) {
			java.io.File GLYac9f2 = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			FileInputStream MggnqwQ0 = null;
			ByteArrayOutputStream KXGdzDjj = new ByteArrayOutputStream();
			byte UcCEf3FO[] = null;
			boolean Us7TG310 = false;
			try {
				UcCEf3FO = hnBX4Lt7.getVendContext().getFileAccess().getFile(hnBX4Lt7.getWorkerContext(),
						kSMcUs0n.toString().replaceAll("\\.\\.", ""), hnBX4Lt7.getClientContext().getMatchedHost(),
						hnBX4Lt7.getVendContext().getVend()
								.getRenderExtension(hnBX4Lt7.getClientContext().getMatchedHost()),
						null);
				KXGdzDjj.write(UcCEf3FO, 0, UcCEf3FO.length);
				Us7TG310 = true;
			} catch (Exception T2COsxva) {
				Debug.user(znrx9zUt, "Included file attempt with VFS of file '" + kSMcUs0n + "' failed: " + T2COsxva);
			}
			if (UcCEf3FO == null) {
				try {
					MggnqwQ0 = new FileInputStream(GLYac9f2);
				} catch (Exception RvlRT7Hr) {
					Debug.user(znrx9zUt, "Unable to render: Filename '" + PozNJCWd + kSMcUs0n + "' does not exist.");
					return new StringBuffer();
				}
			}
			if (xmlparse == null || xmlparse.equals("")) {
				if (UcCEf3FO == null) {
					Debug.user(znrx9zUt,
							"Opening filename '" + PozNJCWd + kSMcUs0n + "' for reading into buffer '" + varname + "'");
					UcCEf3FO = new byte[32768];
					int WBLA31WC = 0;
					while (true) {
						int XH9UA6Bm;
						try {
							XH9UA6Bm = MggnqwQ0.read(UcCEf3FO);
							KXGdzDjj.write(UcCEf3FO, 0, XH9UA6Bm);
						} catch (Exception zNk1WESM) {
							break;
						}
						if (XH9UA6Bm <= 0) {
							break;
						}
						WBLA31WC += XH9UA6Bm;
					}
				}
				byte BGcbzh9s[] = KXGdzDjj.toByteArray();
				if (renderOutput != null && renderOutput.equalsIgnoreCase("ssp")) {
					String YkGNz5fL = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n" + new String(
							FileAccess.getDefault().processServerPageData(hnBX4Lt7.getWorkerContext(), BGcbzh9s));
					BGcbzh9s = YkGNz5fL.getBytes();
				}
				Debug.user(znrx9zUt, "File read complete: " + BGcbzh9s.length + " byte(s)");
				if (MggnqwQ0 != null) {
					try {
						MggnqwQ0.close();
					} catch (Exception bYoJrcXH) {
					}
				}
				MggnqwQ0 = null;
				if (encoding != null && encoding.equalsIgnoreCase("url")) {
					if (!varname.equals("")) {
						if (hnBX4Lt7.isProtectedVariable(varname)) {
							hnBX4Lt7.setExceptionState(true,
									"Attempted to modify a read-only variable '" + varname + "'");
							return new StringBuffer();
						}
						hnBX4Lt7.getVariableContainer().setVariable(varname, Encoder.URLEncode(new String(BGcbzh9s)));
					} else {
						if (callProc != null && !callProc.equals("")) {
							Call MMDlRwSd = new Call();
							MMDlRwSd.callProcedure(hnBX4Lt7, null, null, callProc, null);
						}
						return new StringBuffer(Encoder.URLEncode(new String(BGcbzh9s)));
					}
				} else if (encoding != null && encoding.equalsIgnoreCase("xml")) {
					if (!varname.equals("")) {
						if (hnBX4Lt7.isProtectedVariable(varname)) {
							hnBX4Lt7.setExceptionState(true,
									"Attempted to modify a read-only variable '" + varname + "'");
							return new StringBuffer();
						}
						hnBX4Lt7.getVariableContainer().setVariable(varname, Encoder.XMLEncode(new String(BGcbzh9s)));
					} else {
						if (callProc != null && !callProc.equals("")) {
							Call zPM05qrF = new Call();
							zPM05qrF.callProcedure(hnBX4Lt7, null, null, callProc, null);
						}
						return new StringBuffer(Encoder.XMLEncode(new String(BGcbzh9s)));
					}
				} else if (encoding != null && encoding.equalsIgnoreCase("base64")) {
					if (!varname.equals("")) {
						if (hnBX4Lt7.isProtectedVariable(varname)) {
							hnBX4Lt7.setExceptionState(true,
									"Attempted to modify a read-only variable '" + varname + "'");
							return new StringBuffer();
						}
						hnBX4Lt7.getVariableContainer().setVariable(varname, Base64.encode(BGcbzh9s));
					} else {
						if (callProc != null && !callProc.equals("")) {
							Call mgLn7EDM = new Call();
							mgLn7EDM.callProcedure(hnBX4Lt7, null, null, callProc, null);
						}
						return new StringBuffer(Base64.encode(BGcbzh9s));
					}
				} else if (encoding != null
						&& (encoding.equalsIgnoreCase("javascript") || encoding.equalsIgnoreCase("js"))) {
					if (!varname.equals("")) {
						if (hnBX4Lt7.isProtectedVariable(varname)) {
							hnBX4Lt7.setExceptionState(true,
									"Attempted to modify a read-only variable '" + varname + "'");
							return new StringBuffer();
						}
						hnBX4Lt7.getVariableContainer().setVariable(varname,
								Encoder.JavascriptEncode(new String(BGcbzh9s)));
					} else {
						if (callProc != null && !callProc.equals("")) {
							Call jI0cewxB = new Call();
							jI0cewxB.callProcedure(hnBX4Lt7, null, null, callProc, null);
						}
						return new StringBuffer(Encoder.JavascriptEncode(new String(BGcbzh9s)));
					}
				} else {
					if (!varname.equals("")) {
						if (hnBX4Lt7.isProtectedVariable(varname)) {
							hnBX4Lt7.setExceptionState(true,
									"Attempted to modify a read-only variable '" + varname + "'");
							return new StringBuffer();
						}
						hnBX4Lt7.getVariableContainer().setVariable(varname, new String(BGcbzh9s));
					} else {
						if (callProc != null && !callProc.equals("")) {
							Call z8Q2QEop = new Call();
							z8Q2QEop.callProcedure(hnBX4Lt7, null, null, callProc, null);
						}
						return new StringBuffer(new String(BGcbzh9s));
					}
				}
			} else {
				RenderEngine L7oWYTYz = new RenderEngine(null);
				DocumentEngine ZgnhC5Tg = null;
				try {
					if (Us7TG310) {
						ByteArrayInputStream BK2jPnsy = new ByteArrayInputStream(UcCEf3FO);
						ZgnhC5Tg = new DocumentEngine(BK2jPnsy);
					} else {
						ZgnhC5Tg = new DocumentEngine(MggnqwQ0);
					}
				} catch (Exception rfI9bYHT) {
					hnBX4Lt7.setExceptionState(true,
							"XML parse of data read from file failed: " + rfI9bYHT.getMessage());
				}
				L7oWYTYz.setDocumentEngine(ZgnhC5Tg);
				hnBX4Lt7.addNodeSet(varname, ZgnhC5Tg.rootTag.thisNode);
			}
			if (MggnqwQ0 != null) {
				try {
					MggnqwQ0.close();
				} catch (Exception N3hqsIbo) {
				}
			}
			MggnqwQ0 = null;
			if (callProc != null && !callProc.equals("")) {
				Call zIk4TK2V = new Call();
				zIk4TK2V.callProcedure(hnBX4Lt7, null, null, callProc, null);
			}
			return new StringBuffer();
		} else if (action.equalsIgnoreCase("write")) {
			try {
				String pknZIzAL = kSMcUs0n.toString();
				if (pknZIzAL.lastIndexOf("/") != -1 && pknZIzAL.lastIndexOf("/") != 0) {
					pknZIzAL = pknZIzAL.substring(0, pknZIzAL.lastIndexOf("/"));
					java.io.File rxJckCRa = new java.io.File(PozNJCWd + pknZIzAL);
					if (!rxJckCRa.mkdirs()) {
						Debug.inform("Unable to create directory '" + PozNJCWd + pknZIzAL + "'");
					} else {
						Debug.inform("Created directory '" + PozNJCWd + pknZIzAL + "'");
					}
				}
				java.io.File ztdF6aaz = new java.io.File(PozNJCWd + kSMcUs0n.toString());
				FileOutputStream jhNPfHgD = null;
				if (ztdF6aaz == null) {
					hnBX4Lt7.setExceptionState(true,
							"Unable to write to file '" + kSMcUs0n + "': Cannot write to location specified");
					return new StringBuffer();
				} else if (ztdF6aaz.isDirectory()) {
					hnBX4Lt7.setExceptionState(true, "Unable to write to file '" + kSMcUs0n + "': Is a directory.");
					return new StringBuffer();
				}
				if (filemode.equalsIgnoreCase("append")) {
					jhNPfHgD = new FileOutputStream(ztdF6aaz, true);
				} else {
					jhNPfHgD = new FileOutputStream(ztdF6aaz, false);
				}
				if (decoding != null && !decoding.equals("")) {
					if (decoding.equalsIgnoreCase("base64")) {
						try {
							byte UG01NC9K[] = Base64.decode(W2IIWxfN.toString().getBytes());
							jhNPfHgD.write(UG01NC9K);
						} catch (Exception zZ3SrcVh) {
							hnBX4Lt7.setExceptionState(true,
									"Encoded data in &lt;content&gt; element does not contain valid Base64-"
											+ "encoded data.");
						}
					} else {
						jhNPfHgD.write(W2IIWxfN.toString().getBytes());
					}
				} else {
					jhNPfHgD.write(W2IIWxfN.toString().getBytes());
				}
				try {
					jhNPfHgD.flush();
				} catch (IOException XSEjlYUV) {
					Debug.inform("Unable to flush output data: " + XSEjlYUV.getMessage());
				}
				jhNPfHgD.close();
				Debug.user(znrx9zUt,
						"Wrote contents to filename '" + PozNJCWd + kSMcUs0n + "' (length=" + W2IIWxfN.length() + ")");
			} catch (IOException Obofb3BB) {
				hnBX4Lt7.setExceptionState(true,
						"Unable to write to filename '" + kSMcUs0n + "': " + Obofb3BB.getMessage());
			} catch (Exception q9HKRqoU) {
				hnBX4Lt7.setExceptionState(true,
						"Unable to write to filename '" + kSMcUs0n + "': " + q9HKRqoU.getMessage());
			}
		} else if (action.equalsIgnoreCase("listing")) {
			String j0MsaRBS = kSMcUs0n.toString();
			if (j0MsaRBS.equals("")) {
				j0MsaRBS = hnBX4Lt7.getClientContext().getPostVariable("current_path");
			}
			if (j0MsaRBS == null) {
				hnBX4Lt7.setExceptionState(true, "Filename cannot be blank when listing.");
				return new StringBuffer();
			}
			while (j0MsaRBS.endsWith("/")) {
				j0MsaRBS = j0MsaRBS.substring(0, j0MsaRBS.length() - 1);
			}
			Vector MF4L703B = new Vector();
			java.io.File KV64QLMz = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			String miaOeBGw = kSMcUs0n.toString();
			String ERkdhe9u = null;
			String[] YgaoZoV8 = miaOeBGw.split("/");
			int O4MKakdV = 0;
			for (int z2D7wTZ5 = 0; z2D7wTZ5 < miaOeBGw.length(); z2D7wTZ5++) {
				if (miaOeBGw.toString().charAt(z2D7wTZ5) == '/') {
					O4MKakdV++;
				}
			}
			ERkdhe9u = "/";
			if (O4MKakdV > 1) {
				for (int bH7w7LS1 = 0; bH7w7LS1 < (YgaoZoV8.length - 1); bH7w7LS1++) {
					if (YgaoZoV8[bH7w7LS1] != null && !YgaoZoV8[bH7w7LS1].equals("")) {
						ERkdhe9u += YgaoZoV8[bH7w7LS1] + "/";
					}
				}
			}
			if (ERkdhe9u.length() > 1 && ERkdhe9u.endsWith("/")) {
				ERkdhe9u = ERkdhe9u.substring(0, ERkdhe9u.length() - 1);
			}
			if (hnBX4Lt7.getVendContext() != null && hnBX4Lt7.getVendContext().getFileAccess() != null
					&& hnBX4Lt7.getVendContext().getFileAccess().getVFSType(kSMcUs0n.toString(),
							hnBX4Lt7.getClientContext().getMatchedHost()) == FileAccess.TYPE_JAR) {
				Vector R8tU9eFR = hnBX4Lt7.getVendContext().getFileAccess().listFiles(kSMcUs0n.toString(),
						hnBX4Lt7.getClientContext().getMatchedHost());
				Object[] J2Sl6pxw = R8tU9eFR.toArray();
				int uDCDevIc = 0;
				for (int Ru62hVO5 = 0; Ru62hVO5 < kSMcUs0n.toString().length(); Ru62hVO5++) {
					if (kSMcUs0n.toString().charAt(Ru62hVO5) == '/') {
						uDCDevIc++;
					}
				}
				t3X4VQV1 = new StringBuffer();
				t3X4VQV1.append("<listing filter=\"");
				t3X4VQV1.append(filter);
				t3X4VQV1.append("\" path=\"");
				t3X4VQV1.append(kSMcUs0n);
				if (ERkdhe9u != null) {
					t3X4VQV1.append("\" parent=\"");
					t3X4VQV1.append(ERkdhe9u);
				}
				t3X4VQV1.append("\">\n");
				hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(filter)", false, filter);
				hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(path)", false, kSMcUs0n);
				if (ERkdhe9u != null) {
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false,
							ERkdhe9u);
				} else {
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false, "/");
				}
				if (sort.equalsIgnoreCase("asc")) {
					Arrays.sort(J2Sl6pxw, new ZipSorterAscending());
				} else {
					Arrays.sort(J2Sl6pxw, new ZipSorterDescending());
				}
				for (int eXjpSx55 = 0; eXjpSx55 < J2Sl6pxw.length; eXjpSx55++) {
					ZipEntry dCJKY5Kw = (ZipEntry) J2Sl6pxw[eXjpSx55];
					String qx2ZCZov = kSMcUs0n.toString() + "/" + dCJKY5Kw.getName();
					String nQKHjcjq = qx2ZCZov.replaceFirst(kSMcUs0n.toString(), "");
					int IrE8nVzB = 0;
					if (qx2ZCZov.equalsIgnoreCase(".acl") || qx2ZCZov.equalsIgnoreCase("access.list")
							|| qx2ZCZov.equalsIgnoreCase("application.inc") || qx2ZCZov.equalsIgnoreCase("global.inc")
							|| qx2ZCZov.indexOf("/.proc") != -1 || qx2ZCZov.indexOf("/procedures") != -1) {
						continue;
					}
					for (int KG0a13s6 = 0; KG0a13s6 < nQKHjcjq.length(); KG0a13s6++) {
						if (nQKHjcjq.charAt(KG0a13s6) == '/') {
							IrE8nVzB++;
						}
					}
					if (qx2ZCZov.startsWith(kSMcUs0n.toString())) {
						String EjcxkYSD = "" + dCJKY5Kw.getSize();
						String gvuYlypK = "file";
						if (IrE8nVzB == uDCDevIc) {
							if (dCJKY5Kw.isDirectory()) {
								gvuYlypK = "directory";
							} else {
								gvuYlypK = "file";
							}
							String fld4MO3c = "read-only";
							String XKQI9qNR = Long.toString(dCJKY5Kw.getTime());
							t3X4VQV1.append("    <file name=\"");
							t3X4VQV1.append(nQKHjcjq);
							t3X4VQV1.append("\" length=\"");
							t3X4VQV1.append(EjcxkYSD);
							t3X4VQV1.append("\" type=\"");
							t3X4VQV1.append(gvuYlypK);
							t3X4VQV1.append("\" mode=\"");
							t3X4VQV1.append(fld4MO3c);
							t3X4VQV1.append("\" modtime=\"");
							t3X4VQV1.append(XKQI9qNR);
							t3X4VQV1.append("\"/>\n");
							hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7,
									varname + "(" + nQKHjcjq + ")(length)", false, "" + EjcxkYSD);
							hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + nQKHjcjq + ")(type)",
									false, gvuYlypK);
							hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + nQKHjcjq + ")(mode)",
									false, fld4MO3c);
							hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + nQKHjcjq + ")(time)",
									false, XKQI9qNR);
						}
					} else {
						if (IrE8nVzB == uDCDevIc) {
							MF4L703B.add(qx2ZCZov);
						}
					}
				}
				t3X4VQV1.append("</listing>");
				if (xmlOutput.equalsIgnoreCase("true")) {
					if (hnBX4Lt7.isProtectedVariable(varname)) {
						hnBX4Lt7.setExceptionState(true, "Attempted to modify a read-only variable '" + varname + "'");
						return new StringBuffer();
					}
					hnBX4Lt7.getVariableContainer().setVariable(varname, t3X4VQV1.toString());
					return new StringBuffer();
				}
				hnBX4Lt7.getVariableContainer().setVector(varname, MF4L703B);
			} else if (hnBX4Lt7.getVendContext() != null && hnBX4Lt7.getVendContext().getFileAccess() != null
					&& hnBX4Lt7.getVendContext().getFileAccess().getVFSType(kSMcUs0n.toString(),
							hnBX4Lt7.getClientContext().getMatchedHost()) == FileAccess.TYPE_FS) {
				Vector SHiv17Oe = hnBX4Lt7.getVendContext().getFileAccess().listFiles(kSMcUs0n.toString(),
						hnBX4Lt7.getClientContext().getMatchedHost());
				Object[] fS9BMkpX = SHiv17Oe.toArray();
				java.io.File[] fkIitBCj = new java.io.File[fS9BMkpX.length];
				for (int UpRB6DH6 = 0; UpRB6DH6 < fS9BMkpX.length; UpRB6DH6++) {
					fkIitBCj[UpRB6DH6] = (java.io.File) fS9BMkpX[UpRB6DH6];
				}
				if (sort.equalsIgnoreCase("asc")) {
					Arrays.sort(fkIitBCj, new FileSorterAscending());
				} else {
					Arrays.sort(fkIitBCj, new FileSorterDescending());
				}
				t3X4VQV1 = new StringBuffer();
				t3X4VQV1.append("<listing filter=\"");
				t3X4VQV1.append(filter);
				t3X4VQV1.append("\" path=\"");
				t3X4VQV1.append(kSMcUs0n);
				if (ERkdhe9u != null) {
					t3X4VQV1.append("\" parent=\"");
					t3X4VQV1.append(ERkdhe9u);
				}
				t3X4VQV1.append("\">\n");
				hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(filter)", false, filter);
				hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(path)", false, kSMcUs0n);
				if (ERkdhe9u != null) {
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false,
							ERkdhe9u);
				} else {
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false, "/");
				}
				for (int R25fuLmS = 0; R25fuLmS < fkIitBCj.length; R25fuLmS++) {
					java.io.File WMffD740 = fkIitBCj[R25fuLmS];
					String lj3xm5YD = kSMcUs0n.toString() + "/" + WMffD740.getName();
					if (lj3xm5YD.equalsIgnoreCase(".acl") || lj3xm5YD.equalsIgnoreCase("access.list")
							|| lj3xm5YD.equalsIgnoreCase("application.inc") || lj3xm5YD.equalsIgnoreCase("global.inc")
							|| lj3xm5YD.indexOf("/.proc") != -1 || lj3xm5YD.indexOf("/procedures") != -1) {
						continue;
					}
					String oJseiVza = lj3xm5YD.replaceFirst(kSMcUs0n.toString(), "");
					String UsgCq1Se = "" + WMffD740.length();
					String yMfMFSgP = "file";
					if (WMffD740.isDirectory()) {
						yMfMFSgP = "directory";
					} else if (WMffD740.isFile()) {
						yMfMFSgP = "file";
					} else if (WMffD740.isHidden()) {
						yMfMFSgP = "hidden";
					} else if (WMffD740.isAbsolute()) {
						yMfMFSgP = "absolute";
					}
					String EwIKUQff = "read-only";
					if (WMffD740.canRead() && !WMffD740.canWrite()) {
						EwIKUQff = "read-only";
					} else if (!WMffD740.canRead() && WMffD740.canWrite()) {
						EwIKUQff = "write-only";
					} else if (WMffD740.canRead() && WMffD740.canWrite()) {
						EwIKUQff = "read/write";
					}
					String CcO5jvZ8 = Long.toString(WMffD740.lastModified());
					if (xmlOutput.equalsIgnoreCase("true")) {
						t3X4VQV1.append("    <file name=\"");
						t3X4VQV1.append(lj3xm5YD);
						t3X4VQV1.append("\" length=\"");
						t3X4VQV1.append(UsgCq1Se);
						t3X4VQV1.append("\" type=\"");
						t3X4VQV1.append(yMfMFSgP);
						t3X4VQV1.append("\" mode=\"");
						t3X4VQV1.append(EwIKUQff);
						t3X4VQV1.append("\" modtime=\"");
						t3X4VQV1.append(CcO5jvZ8);
						t3X4VQV1.append("\"/>\n");
					} else {
						MF4L703B.add(WMffD740);
					}
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + lj3xm5YD + ")(length)", false,
							"" + UsgCq1Se);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + lj3xm5YD + ")(type)", false,
							yMfMFSgP);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + lj3xm5YD + ")(mode)", false,
							EwIKUQff);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(" + lj3xm5YD + ")(time)", false,
							CcO5jvZ8);
				}
				t3X4VQV1.append("</listing>");
				if (xmlOutput.equalsIgnoreCase("true")) {
					if (hnBX4Lt7.isProtectedVariable(varname)) {
						hnBX4Lt7.setExceptionState(true, "Attempted to modify a read-only variable '" + varname + "'");
						return new StringBuffer();
					}
					hnBX4Lt7.getVariableContainer().setVariable(varname, t3X4VQV1.toString());
					return new StringBuffer();
				}
				hnBX4Lt7.getVariableContainer().setVector(varname, MF4L703B);
			} else {
				String[] foUPylBw = null;
				if (!filter.equals("")) {
					foUPylBw = KV64QLMz.list(new ListFilter(filter));
				} else {
					foUPylBw = KV64QLMz.list();
				}
				if (sort.equalsIgnoreCase("asc")) {
					Arrays.sort(foUPylBw, new StringSorterAscending());
				} else {
					Arrays.sort(foUPylBw, new StringSorterDescending());
				}
				if (foUPylBw == null) {
					t3X4VQV1.append("<listing filter=\"");
					t3X4VQV1.append(filter);
					t3X4VQV1.append("\" path=\"");
					t3X4VQV1.append(kSMcUs0n);
					if (ERkdhe9u != null) {
						t3X4VQV1.append("\" parent=\"");
						t3X4VQV1.append(ERkdhe9u);
					}
					t3X4VQV1.append("\"/>\n");
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(filter)", false,
							filter);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(path)", false,
							kSMcUs0n);
					if (ERkdhe9u != null) {
						hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false,
								ERkdhe9u);
					} else {
						hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false,
								"/");
					}
					if (xmlOutput.equalsIgnoreCase("true")) {
						if (hnBX4Lt7.isProtectedVariable(varname)) {
							hnBX4Lt7.setExceptionState(true,
									"Attempted to modify a read-only variable '" + varname + "'");
							return new StringBuffer();
						}
						hnBX4Lt7.getVariableContainer().setVariable(varname, t3X4VQV1.toString());
					} else {
						hnBX4Lt7.getVariableContainer().setVector(varname, MF4L703B);
					}
					return new StringBuffer();
				} else {
					Debug.user(znrx9zUt,
							"Directory '" + PozNJCWd + kSMcUs0n + "' returns " + foUPylBw.length + " entry(ies)");
				}
				t3X4VQV1 = new StringBuffer();
				t3X4VQV1.append("<listing filter=\"");
				t3X4VQV1.append(filter);
				t3X4VQV1.append("\" path=\"");
				t3X4VQV1.append(kSMcUs0n);
				if (ERkdhe9u != null) {
					t3X4VQV1.append("\" parent=\"");
					t3X4VQV1.append(ERkdhe9u);
				}
				t3X4VQV1.append("\">\n");
				hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(filter)", false, filter);
				hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(path)", false, kSMcUs0n);
				if (ERkdhe9u != null) {
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false,
							ERkdhe9u);
				} else {
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7, varname + "(fileinfo)(parent)", false, "/");
				}
				for (int SU1XOnVV = 0; SU1XOnVV < foUPylBw.length; SU1XOnVV++) {
					KV64QLMz = new java.io.File(PozNJCWd + kSMcUs0n.toString() + "/" + foUPylBw[SU1XOnVV]);
					String L8L51MfR = Long.toString(KV64QLMz.length());
					String khgWLFpx = "file";
					if (KV64QLMz.isDirectory()) {
						khgWLFpx = "directory";
					} else if (KV64QLMz.isFile()) {
						khgWLFpx = "file";
					} else if (KV64QLMz.isHidden()) {
						khgWLFpx = "hidden";
					} else if (KV64QLMz.isAbsolute()) {
						khgWLFpx = "absolute";
					}
					String Aqykdzyq = "read-only";
					if (KV64QLMz.canRead() && !KV64QLMz.canWrite()) {
						Aqykdzyq = "read-only";
					} else if (!KV64QLMz.canRead() && KV64QLMz.canWrite()) {
						Aqykdzyq = "write-only";
					} else if (KV64QLMz.canRead() && KV64QLMz.canWrite()) {
						Aqykdzyq = "read/write";
					}
					String oz1pKquV = Long.toString(KV64QLMz.lastModified());
					if (xmlOutput.equalsIgnoreCase("true")) {
						t3X4VQV1.append("    <file name=\"");
						t3X4VQV1.append(foUPylBw[SU1XOnVV]);
						t3X4VQV1.append("\" length=\"");
						t3X4VQV1.append(L8L51MfR);
						t3X4VQV1.append("\" type=\"");
						t3X4VQV1.append(khgWLFpx);
						t3X4VQV1.append("\" mode=\"");
						t3X4VQV1.append(Aqykdzyq);
						t3X4VQV1.append("\" modtime=\"");
						t3X4VQV1.append(oz1pKquV);
						t3X4VQV1.append("\"/>\n");
					} else {
						MF4L703B.add(foUPylBw[SU1XOnVV]);
					}
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7,
							varname + "(" + foUPylBw[SU1XOnVV] + ")(length)", false, "" + L8L51MfR);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7,
							varname + "(" + foUPylBw[SU1XOnVV] + ")(type)", false, khgWLFpx);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7,
							varname + "(" + foUPylBw[SU1XOnVV] + ")(mode)", false, Aqykdzyq);
					hnBX4Lt7.getVariableContainer().setVariable(hnBX4Lt7,
							varname + "(" + foUPylBw[SU1XOnVV] + ")(time)", false, oz1pKquV);
				}
				t3X4VQV1.append("</listing>");
				if (xmlOutput.equalsIgnoreCase("true")) {
					if (hnBX4Lt7.isProtectedVariable(varname)) {
						hnBX4Lt7.setExceptionState(true, "Attempted to modify a read-only variable '" + varname + "'");
						return new StringBuffer();
					}
					hnBX4Lt7.getVariableContainer().setVariable(varname, t3X4VQV1.toString());
					return new StringBuffer();
				}
				hnBX4Lt7.getVariableContainer().setVector(varname, MF4L703B);
			}
		} else if (action.equalsIgnoreCase("delete")) {
			java.io.File eFtGVzdV = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			if (eFtGVzdV.isDirectory()) {
				boolean Gz66thKQ = deleteDir(new java.io.File(PozNJCWd + kSMcUs0n.toString()));
				if (!Gz66thKQ) {
					hnBX4Lt7.setExceptionState(true, "Unable to delete '" + PozNJCWd + kSMcUs0n + "'");
				}
			} else {
				String Ztv63tKT = null;
				if (kSMcUs0n.toString().indexOf("/") != -1) {
					Ztv63tKT = kSMcUs0n.toString().substring(kSMcUs0n.toString().lastIndexOf("/") + 1);
				}
				String hHcAyaOF = PozNJCWd;
				if (kSMcUs0n.toString().indexOf("/") != -1) {
					hHcAyaOF += kSMcUs0n.substring(0, kSMcUs0n.toString().lastIndexOf("/"));
				}
				String[] Kqd0OckD = null;
				eFtGVzdV = new java.io.File(hHcAyaOF);
				Kqd0OckD = eFtGVzdV.list(new ListFilter(Ztv63tKT));
				for (int fHlCj7RK = 0; fHlCj7RK < Kqd0OckD.length; fHlCj7RK++) {
					(new java.io.File(hHcAyaOF + "/" + Kqd0OckD[fHlCj7RK])).delete();
				}
			}
		} else if (action.equalsIgnoreCase("rename") || action.equalsIgnoreCase("move")) {
			if (o4XI6cdP.equals("")) {
				hnBX4Lt7.getVariableContainer().setVariable(varname + "-result",
						kSMcUs0n + ": File operation failed: No destination filename given.");
				return new StringBuffer();
			}
			java.io.File QjFcOFxe = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			boolean fcuKYIga = QjFcOFxe.renameTo(new java.io.File(PozNJCWd + o4XI6cdP.toString(), QjFcOFxe.getName()));
			if (!fcuKYIga) {
				hnBX4Lt7.setExceptionState(true,
						"Unable to rename '" + PozNJCWd + kSMcUs0n + "' to '" + PozNJCWd + o4XI6cdP + "'");
			}
		} else if (action.equalsIgnoreCase("copy")) {
			if (o4XI6cdP.equals("")) {
				hnBX4Lt7.setExceptionState(true,
						"File copy operation failed for file '" + kSMcUs0n + "': No destination file specified.");
				return new StringBuffer();
			}
			FileChannel cvklUHsJ;
			FileChannel yOIN9nK6;
			String ggagsycb = null;
			ggagsycb = PozNJCWd + kSMcUs0n.toString();
			if (vartype != null && vartype.equalsIgnoreCase("file")) {
				if (useFilename.indexOf("/") != -1) {
					useFilename = useFilename.substring(useFilename.lastIndexOf("/") + 1);
				}
				ggagsycb = hnBX4Lt7.getVariableContainer().getFileVariable(useFilename);
			}
			try {
				Debug.debug("Copying from file '" + ggagsycb + "' to '" + o4XI6cdP.toString() + "'");
				cvklUHsJ = new FileInputStream(ggagsycb).getChannel();
			} catch (IOException UaZp9GLK) {
				hnBX4Lt7.setExceptionState(true,
						"Filecopy from '" + kSMcUs0n + "' failed to read: " + UaZp9GLK.getMessage());
				return new StringBuffer();
			}
			try {
				yOIN9nK6 = new FileOutputStream(PozNJCWd + o4XI6cdP.toString()).getChannel();
			} catch (IOException cljpd2BA) {
				hnBX4Lt7.setExceptionState(true,
						"Filecopy to '" + o4XI6cdP + "' failed to write: " + cljpd2BA.getMessage());
				return new StringBuffer();
			}
			try {
				yOIN9nK6.transferFrom(cvklUHsJ, 0, cvklUHsJ.size());
				cvklUHsJ.close();
				yOIN9nK6.close();
				if (varname != null) {
					hnBX4Lt7.getVariableContainer().setVariable(varname + "-result",
							kSMcUs0n + " copy to " + o4XI6cdP + ": File copy succeeded.");
				} else {
					return new StringBuffer("true");
				}
			} catch (IOException cvtLpyC4) {
				hnBX4Lt7.setExceptionState(true,
						"Filecopy from '" + kSMcUs0n + "' to '" + o4XI6cdP + "' failed: " + cvtLpyC4.getMessage());
			}
		} else if (action.equalsIgnoreCase("exists")) {
			java.io.File I2BwX1qs = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			if (I2BwX1qs.exists()) {
				if (varname != null) {
					if (hnBX4Lt7.isProtectedVariable(varname)) {
						hnBX4Lt7.setExceptionState(true, "Attempted to modify a read-only variable '" + varname + "'");
						return new StringBuffer();
					}
					hnBX4Lt7.getVariableContainer().setVariable(varname, "true");
				} else {
					return new StringBuffer("true");
				}
			} else {
				if (varname != null) {
					if (hnBX4Lt7.isProtectedVariable(varname)) {
						hnBX4Lt7.setExceptionState(true, "Attempted to modify a read-only variable '" + varname + "'");
						return new StringBuffer();
					}
					hnBX4Lt7.getVariableContainer().setVariable(varname, "false");
				} else {
					return new StringBuffer("false");
				}
			}
		} else if (action.equalsIgnoreCase("mkdir")) {
			java.io.File JR1qUmRy = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			if (JR1qUmRy.mkdirs()) {
				if (varname != null) {
					hnBX4Lt7.getVariableContainer().setVariable(varname + "-result", "created");
				} else {
					return new StringBuffer("true");
				}
			} else {
				hnBX4Lt7.setExceptionState(true, "Unable to create directory '" + kSMcUs0n + "'");
			}
		} else if (action.equalsIgnoreCase("info")) {
			java.io.File sGkZu10w = new java.io.File(PozNJCWd + kSMcUs0n.toString());
			String ar4hRZPQ = Long.toString(sGkZu10w.length());
			String EqMD5Wyp = "file";
			if (sGkZu10w.isAbsolute()) {
				EqMD5Wyp = "absolute";
			} else if (sGkZu10w.isDirectory()) {
				EqMD5Wyp = "directory";
			} else if (sGkZu10w.isFile()) {
				EqMD5Wyp = "file";
			} else if (sGkZu10w.isHidden()) {
				EqMD5Wyp = "hidden";
			}
			String IPjbCZIc = "read-only";
			if (sGkZu10w.canRead() && !sGkZu10w.canWrite()) {
				IPjbCZIc = "read-only";
			} else if (!sGkZu10w.canRead() && sGkZu10w.canWrite()) {
				IPjbCZIc = "write-only";
			} else if (sGkZu10w.canRead() && sGkZu10w.canWrite()) {
				IPjbCZIc = "read/write";
			}
			String SG9JECEl = Long.toString(sGkZu10w.lastModified());
			if (varname != null && !varname.equals("")) {
				hnBX4Lt7.getVariableContainer().setVariable(varname + ".length", ar4hRZPQ);
				hnBX4Lt7.getVariableContainer().setVariable(varname + ".type", EqMD5Wyp);
				hnBX4Lt7.getVariableContainer().setVariable(varname + ".mode", IPjbCZIc);
				hnBX4Lt7.getVariableContainer().setVariable(varname + ".modtime", SG9JECEl);
			} else {
				t3X4VQV1 = new StringBuffer();
				t3X4VQV1.append("<file name=\"");
				t3X4VQV1.append(kSMcUs0n);
				t3X4VQV1.append("\" length=\"");
				t3X4VQV1.append(ar4hRZPQ);
				t3X4VQV1.append("\" type=\"");
				t3X4VQV1.append(EqMD5Wyp);
				t3X4VQV1.append("\" mode=\"");
				t3X4VQV1.append(IPjbCZIc);
				t3X4VQV1.append("\" modtime=\"");
				t3X4VQV1.append(SG9JECEl);
				t3X4VQV1.append("\"/>\n");
				return t3X4VQV1;
			}
		}
		if (callProc != null && !callProc.equals("")) {
			Call ZOaEw2FX = new Call();
			ZOaEw2FX.callProcedure(hnBX4Lt7, null, null, callProc, null);
		}
		return new StringBuffer();
	}

}