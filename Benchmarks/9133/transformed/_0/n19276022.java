class n19276022 {
	public DataSet parse() throws SnifflibDatatypeException {
		NumberFormat XUZZxjhd = NumberFormat.getInstance();
		if (this.headers.size() != this.types.size()) {
			throw new SnifflibDatatypeException(
					"Different number of headers (" + this.headers.size() + ") and types(" + this.types.size() + ").");
		}
		DataSet hRaYyKcL = null;
		if (!this.dryrun) {
			hRaYyKcL = new DataSet();
		}
		BufferedReader NhHcFH3y = null;
		StreamTokenizer mph3RMdA = null;
		try {
			if (this.isURL) {
				if (this.url2goto == null) {
					return (null);
				}
				DataInputStream uwZF13dn = null;
				try {
					uwZF13dn = new DataInputStream(this.url2goto.openStream());
					System.out.println("READY TO READ FROM URL:" + url2goto);
					NhHcFH3y = new BufferedReader(new InputStreamReader(uwZF13dn));
				} catch (Exception XTLyv7s2) {
					throw new RuntimeException("Problem reading from URL " + this.url2goto + ".", XTLyv7s2);
				}
			} else {
				if (this.file == null) {
					throw new RuntimeException("Data file to be parsed can not be null.");
				}
				if (!this.file.exists()) {
					throw new RuntimeException("The file " + this.file + " does not exist.");
				}
				NhHcFH3y = new BufferedReader(new FileReader(this.file));
			}
			if (this.ignorePreHeaderLines > 0) {
				String wHgfY7Td;
				int gpISZDfM = 0;
				while ((gpISZDfM < this.ignorePreHeaderLines) && ((wHgfY7Td = NhHcFH3y.readLine()) != null)) {
					gpISZDfM++;
				}
			}
			mph3RMdA = new StreamTokenizer(NhHcFH3y);
			mph3RMdA.resetSyntax();
			mph3RMdA.eolIsSignificant(true);
			mph3RMdA.parseNumbers();
			if (this.delimiter.equals("\\t")) {
				mph3RMdA.whitespaceChars('\t', '\t');
			}
			if (this.delimiter.equals(",")) {
				mph3RMdA.whitespaceChars(',', ',');
			}
			mph3RMdA.quoteChar('"');
			mph3RMdA.whitespaceChars(' ', ' ');
			boolean emtdFX5H = true;
			boolean sR1h2zor = false;
			boolean HhRQE2LV = false;
			boolean CKmVRKnK = false;
			if (this.headers.size() > 0) {
				emtdFX5H = false;
				sR1h2zor = true;
			}
			if (this.types.size() > 0) {
				sR1h2zor = false;
				Class MaQk3dmm;
				for (int eBd4IjdM = 0; eBd4IjdM < this.types.size(); eBd4IjdM++) {
					MaQk3dmm = (Class) this.types.get(eBd4IjdM);
					try {
						this.constructors.add(MaQk3dmm.getConstructor(String.class));
					} catch (java.lang.NoSuchMethodException GVWoIFkB) {
						throw new SnifflibDatatypeException("Could not find appropriate constructor for " + MaQk3dmm
								+ ". " + GVWoIFkB.getMessage());
					}
				}
				HhRQE2LV = true;
			}
			int KtJpDe9N = 0;
			int Nn9wKGY0 = 0;
			this.rowcount = 0;
			boolean GOJfaOlO = true;
			while (true) {
				mph3RMdA.nextToken();
				switch (mph3RMdA.ttype) {
				case StreamTokenizer.TT_WORD: {
					if (CKmVRKnK) {
						throw new RuntimeException(
								"Problem reading scientific notation at row " + Nn9wKGY0 + " column " + KtJpDe9N + ".");
					}
					GOJfaOlO = true;
					if (emtdFX5H) {
						this.headers.add(mph3RMdA.sval);
					} else {
						if (sR1h2zor) {
							this.types.add(String.class);
						}
						if (!this.dryrun) {
							if (hRaYyKcL.getColumnCount() <= KtJpDe9N) {
								hRaYyKcL.addColumn((String) this.headers.get(KtJpDe9N),
										(Class) this.types.get(KtJpDe9N));
							}
						}
						try {
							Constructor RG9m8cdw;
							if (KtJpDe9N < this.constructors.size()) {
								RG9m8cdw = (Constructor) this.constructors.get(KtJpDe9N);
							} else {
								Class q51RVhaK = (Class) this.types.get(KtJpDe9N);
								RG9m8cdw = q51RVhaK.getConstructor(String.class);
								this.constructors.add(RG9m8cdw);
							}
							try {
								try {
									try {
										if (!this.dryrun) {
											hRaYyKcL.setValueAt(RG9m8cdw.newInstance((String) mph3RMdA.sval), Nn9wKGY0,
													KtJpDe9N);
										} else if (this.findingTargetValue) {
											if ((this.targetRow == Nn9wKGY0) && (this.targetColumn == KtJpDe9N)) {
												this.targetValue = RG9m8cdw.newInstance((String) mph3RMdA.sval);
												NhHcFH3y.close();
												return (null);
											}
										}
									} catch (java.lang.reflect.InvocationTargetException GW3NwSMV) {
										throw new SnifflibDatatypeException(
												"Problem constructing 1" + GW3NwSMV.getMessage());
									}
								} catch (java.lang.IllegalAccessException TpBEuFfr) {
									throw new SnifflibDatatypeException(
											"Problem constructing 2" + TpBEuFfr.getMessage());
								}
							} catch (java.lang.InstantiationException ePDEPuS4) {
								throw new SnifflibDatatypeException("Problem constructing 3" + ePDEPuS4.getMessage());
							}
						} catch (java.lang.NoSuchMethodException rROAcqS5) {
							throw new SnifflibDatatypeException("Problem constructing 4" + rROAcqS5.getMessage());
						}
					}
					break;
				}
				case StreamTokenizer.TT_NUMBER: {
					GOJfaOlO = true;
					if (emtdFX5H) {
						throw new SnifflibDatatypeException(
								"Expecting string header at row=" + Nn9wKGY0 + ", column=" + KtJpDe9N + ".");
					} else {
						if (sR1h2zor) {
							this.types.add(Double.class);
						}
						if (!this.dryrun) {
							if (hRaYyKcL.getColumnCount() <= KtJpDe9N) {
								hRaYyKcL.addColumn((String) this.headers.get(KtJpDe9N),
										(Class) this.types.get(KtJpDe9N));
							}
						}
						try {
							Constructor q5aRrvZL;
							if (KtJpDe9N < this.constructors.size()) {
								q5aRrvZL = (Constructor) this.constructors.get(KtJpDe9N);
							} else {
								Class XV4UCHPq = (Class) this.types.get(KtJpDe9N);
								q5aRrvZL = XV4UCHPq.getConstructor(double.class);
								this.constructors.add(q5aRrvZL);
							}
							if (CKmVRKnK) {
								Double HjvJpNGy = this.scientificNumber;
								if (!this.dryrun) {
									try {
										hRaYyKcL.setValueAt(new Double(HjvJpNGy.doubleValue() * mph3RMdA.nval),
												Nn9wKGY0, KtJpDe9N);
									} catch (Exception YwbBdECG) {
										throw new SnifflibDatatypeException(
												"Problem constructing " + q5aRrvZL.getDeclaringClass() + "at row "
														+ Nn9wKGY0 + " column " + KtJpDe9N + ".",
												YwbBdECG);
									}
								} else if (this.findingTargetValue) {
									if ((this.targetRow == Nn9wKGY0) && (this.targetColumn == KtJpDe9N)) {
										Double jZ2cnpds = new Double(mph3RMdA.nval);
										try {
											this.targetValue = XUZZxjhd.parse(HjvJpNGy + "E" + jZ2cnpds);
										} catch (Exception goUexPFb) {
											throw new RuntimeException("Problem parsing scientific notation at row="
													+ Nn9wKGY0 + " col=" + KtJpDe9N + ".");
										}
										mph3RMdA.nextToken();
										if (mph3RMdA.ttype != 'e') {
											NhHcFH3y.close();
											return (null);
										} else {
											mph3RMdA.pushBack();
										}
									}
								}
								CKmVRKnK = false;
							} else {
								try {
									this.scientificNumber = new Double(mph3RMdA.nval);
									if (!this.dryrun) {
										hRaYyKcL.setValueAt(this.scientificNumber, Nn9wKGY0, KtJpDe9N);
									} else if (this.findingTargetValue) {
										if ((this.targetRow == Nn9wKGY0) && (this.targetColumn == KtJpDe9N)) {
											this.targetValue = this.scientificNumber;
											NhHcFH3y.close();
											return (null);
										}
									}
								} catch (Exception qafi0MtY) {
									throw new SnifflibDatatypeException(
											"Problem constructing " + q5aRrvZL.getDeclaringClass() + "at row "
													+ Nn9wKGY0 + " column " + KtJpDe9N + ".",
											qafi0MtY);
								}
							}
						} catch (java.lang.NoSuchMethodException iJ8Uswt2) {
							throw new SnifflibDatatypeException("Problem constructing" + iJ8Uswt2.getMessage());
						}
					}
					break;
				}
				case StreamTokenizer.TT_EOL: {
					if (emtdFX5H) {
						emtdFX5H = false;
						sR1h2zor = true;
					} else {
						if (sR1h2zor) {
							sR1h2zor = false;
							HhRQE2LV = true;
						}
					}
					if (HhRQE2LV) {
						Nn9wKGY0++;
					}
					break;
				}
				case StreamTokenizer.TT_EOF: {
					if (emtdFX5H) {
						throw new SnifflibDatatypeException("End of file reached while reading headers.");
					}
					if (sR1h2zor) {
						throw new SnifflibDatatypeException("End of file reached while reading initial values.");
					}
					if (HhRQE2LV) {
						HhRQE2LV = false;
					}
					break;
				}
				default: {
					if (mph3RMdA.ttype == '"') {
						GOJfaOlO = true;
						if (emtdFX5H) {
							this.headers.add(mph3RMdA.sval);
						} else {
							if (sR1h2zor) {
								this.types.add(String.class);
							}
							if (!this.dryrun) {
								if (hRaYyKcL.getColumnCount() <= KtJpDe9N) {
									hRaYyKcL.addColumn((String) this.headers.get(KtJpDe9N),
											(Class) this.types.get(KtJpDe9N));
								}
							}
							try {
								Constructor k87YRdVK;
								if (KtJpDe9N < this.constructors.size()) {
									k87YRdVK = (Constructor) this.constructors.get(KtJpDe9N);
								} else {
									Class ileKPP5l = (Class) this.types.get(KtJpDe9N);
									k87YRdVK = ileKPP5l.getConstructor(String.class);
									this.constructors.add(k87YRdVK);
								}
								try {
									try {
										try {
											if (!this.dryrun) {
												hRaYyKcL.setValueAt(k87YRdVK.newInstance((String) mph3RMdA.sval),
														Nn9wKGY0, KtJpDe9N);
											} else if (this.findingTargetValue) {
												if ((this.targetRow == Nn9wKGY0) && (this.targetColumn == KtJpDe9N)) {
													this.targetValue = k87YRdVK.newInstance((String) mph3RMdA.sval);
													NhHcFH3y.close();
													return (null);
												}
											}
										} catch (java.lang.reflect.InvocationTargetException p2Iqbs7V) {
											throw new SnifflibDatatypeException(
													"Problem constructing 1 " + p2Iqbs7V.getMessage());
										}
									} catch (java.lang.IllegalAccessException POz9wotq) {
										throw new SnifflibDatatypeException(
												"Problem constructing 2 " + POz9wotq.getMessage());
									}
								} catch (java.lang.InstantiationException kQRZc7te) {
									throw new SnifflibDatatypeException(
											"Problem constructing 3 " + kQRZc7te.getMessage());
								}
							} catch (java.lang.NoSuchMethodException vjr6YcRe) {
								throw new SnifflibDatatypeException("Problem constructing 4" + vjr6YcRe.getMessage());
							}
						}
					} else if (mph3RMdA.ttype == 'e') {
						Class JczKDPD0 = (Class) this.types.get(KtJpDe9N);
						if (Number.class.isAssignableFrom(JczKDPD0)) {
							KtJpDe9N--;
							CKmVRKnK = true;
							GOJfaOlO = false;
						}
					} else {
						GOJfaOlO = false;
					}
					break;
				}
				}
				if (mph3RMdA.ttype == StreamTokenizer.TT_EOF) {
					break;
				}
				if (GOJfaOlO) {
					KtJpDe9N++;
					if (!emtdFX5H) {
						if (KtJpDe9N >= this.headers.size()) {
							KtJpDe9N = 0;
						}
					}
				}
			}
			if (!emtdFX5H) {
				this.rowcount = Nn9wKGY0;
			} else {
				this.rowcount = 0;
				emtdFX5H = false;
				if (this.ignorePostHeaderLines > 0) {
					String Kaa7HVKP;
					int Kao1lohK = 0;
					while ((Kao1lohK < this.ignorePostHeaderLines) && ((Kaa7HVKP = NhHcFH3y.readLine()) != null)) {
						Kao1lohK++;
					}
				}
			}
			NhHcFH3y.close();
		} catch (java.io.IOException hMlwEEwf) {
			throw new SnifflibDatatypeException(hMlwEEwf.getMessage());
		}
		if (!this.dryrun) {
			for (int Xt2mSTiv = 0; Xt2mSTiv < this.headers.size(); Xt2mSTiv++) {
				hRaYyKcL.setColumnName(Xt2mSTiv, (String) this.headers.get(Xt2mSTiv));
			}
		}
		return (hRaYyKcL);
	}

}