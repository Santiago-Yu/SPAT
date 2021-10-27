class n19276021 {
	public DataSet newparse() throws SnifflibDatatypeException {
		NumberFormat hbbXYkZL = NumberFormat.getInstance();
		if (this.headers.size() != this.types.size()) {
			throw new SnifflibDatatypeException(
					"Different number of headers (" + this.headers.size() + ") and types(" + this.types.size() + ").");
		}
		DataSet mUo3H1AW = null;
		if (!this.dryrun) {
			mUo3H1AW = new DataSet();
		}
		BufferedReader g5AtRzxN = null;
		StreamTokenizer CS0PJtcN = null;
		try {
			if (this.isURL) {
				if (this.url2goto == null) {
					return (null);
				}
				DataInputStream bau3L7RD = null;
				try {
					bau3L7RD = new DataInputStream(this.url2goto.openStream());
					System.out.println("READY TO READ FROM URL:" + url2goto);
					g5AtRzxN = new BufferedReader(new InputStreamReader(bau3L7RD));
				} catch (Exception Yy05HD5U) {
					throw new RuntimeException("Problem reading from URL " + this.url2goto + ".", Yy05HD5U);
				}
			} else {
				if (this.file == null) {
					throw new RuntimeException("Data file to be parsed can not be null.");
				}
				if (!this.file.exists()) {
					throw new RuntimeException("The file " + this.file + " does not exist.");
				}
				g5AtRzxN = new BufferedReader(new FileReader(this.file));
			}
			if (this.ignorePreHeaderLines > 0) {
				String hh2DHkea;
				int y4nLwgED = 0;
				while ((y4nLwgED < this.ignorePreHeaderLines) && ((hh2DHkea = g5AtRzxN.readLine()) != null)) {
					y4nLwgED++;
				}
			}
			CS0PJtcN = new StreamTokenizer(g5AtRzxN);
			CS0PJtcN.resetSyntax();
			CS0PJtcN.eolIsSignificant(true);
			boolean TSYok3Mp = false;
			for (int alY0mYbp = 0; alY0mYbp < this.types.size(); alY0mYbp++) {
				Class C5HBtgNI = (Class) this.types.get(alY0mYbp);
				if (Number.class.isAssignableFrom(C5HBtgNI)) {
					TSYok3Mp = true;
					break;
				}
			}
			if (TSYok3Mp) {
				CS0PJtcN.parseNumbers();
			}
			CS0PJtcN.eolIsSignificant(true);
			if (this.delimiter.equals("\\t")) {
				CS0PJtcN.whitespaceChars('\t', '\t');
				CS0PJtcN.quoteChar('"');
				CS0PJtcN.whitespaceChars(' ', ' ');
			} else if (this.delimiter.equals(",")) {
				CS0PJtcN.quoteChar('"');
				CS0PJtcN.whitespaceChars(',', ',');
				CS0PJtcN.whitespaceChars(' ', ' ');
			} else {
				if (this.delimiter.length() > 1) {
					throw new RuntimeException(
							"Delimiter must be a single character.  Multiple character delimiters are not allowed.");
				}
				if (this.delimiter.length() > 0) {
					CS0PJtcN.whitespaceChars(this.delimiter.charAt(0), this.delimiter.charAt(0));
				} else {
					CS0PJtcN.wordChars(Character.MIN_VALUE, Character.MAX_VALUE);
					CS0PJtcN.eolIsSignificant(true);
					CS0PJtcN.ordinaryChar('\n');
				}
			}
			boolean nyQ4D6Ib = true;
			boolean UVhOdiSM = false;
			boolean nadfVVSZ = false;
			boolean DuWAHEq8 = false;
			if (this.headers.size() > 0) {
				nyQ4D6Ib = false;
				UVhOdiSM = true;
			}
			if (this.types.size() > 0) {
				UVhOdiSM = false;
				Class Eh8dxOs3;
				for (int uO1UCuo6 = 0; uO1UCuo6 < this.types.size(); uO1UCuo6++) {
					Eh8dxOs3 = (Class) this.types.get(uO1UCuo6);
					try {
						this.constructors.add(Eh8dxOs3.getConstructor(String.class));
					} catch (java.lang.NoSuchMethodException pizajpw0) {
						throw new SnifflibDatatypeException("Could not find appropriate constructor for " + Eh8dxOs3
								+ ". " + pizajpw0.getMessage());
					}
				}
				nadfVVSZ = true;
			}
			int TtxBE84B = 0;
			int kDEilSzj = 0;
			this.rowcount = 0;
			boolean Kn1p04uD = true;
			while (true) {
				CS0PJtcN.nextToken();
				switch (CS0PJtcN.ttype) {
				case StreamTokenizer.TT_WORD: {
					Kn1p04uD = true;
					if (DuWAHEq8) {
						throw new RuntimeException(
								"Problem reading scientific notation at row " + kDEilSzj + " column " + TtxBE84B + ".");
					}
					if (nyQ4D6Ib) {
						this.headers.add(CS0PJtcN.sval);
					} else {
						if (UVhOdiSM) {
							this.types.add(String.class);
						}
						if (!this.dryrun) {
							if (mUo3H1AW.getColumnCount() <= TtxBE84B) {
								mUo3H1AW.addColumn((String) this.headers.get(TtxBE84B),
										(Class) this.types.get(TtxBE84B));
							}
						}
						try {
							Constructor TBUUZB9f;
							if (TtxBE84B < this.constructors.size()) {
								TBUUZB9f = (Constructor) this.constructors.get(TtxBE84B);
							} else {
								Class wM3V2pLs = (Class) this.types.get(TtxBE84B);
								TBUUZB9f = wM3V2pLs.getConstructor(String.class);
								this.constructors.add(TBUUZB9f);
							}
							try {
								try {
									try {
										if (!this.dryrun) {
											mUo3H1AW.setValueAt(TBUUZB9f.newInstance((String) CS0PJtcN.sval), kDEilSzj,
													TtxBE84B);
										} else if (this.findingTargetValue) {
											Object X2gggARB = TBUUZB9f.newInstance((String) CS0PJtcN.sval);
											this.valueQueue.push(X2gggARB);
											if ((this.targetRow == kDEilSzj) && (this.targetColumn == TtxBE84B)) {
												this.targetValue = X2gggARB;
												g5AtRzxN.close();
												return (null);
											}
										}
									} catch (java.lang.reflect.InvocationTargetException A78h7K42) {
										throw new SnifflibDatatypeException(
												"Problem constructing 1" + A78h7K42.getMessage());
									}
								} catch (java.lang.IllegalAccessException LQJEZYcv) {
									throw new SnifflibDatatypeException(
											"Problem constructing 2" + LQJEZYcv.getMessage());
								}
							} catch (java.lang.InstantiationException xCg5Nj7J) {
								throw new SnifflibDatatypeException("Problem constructing 3" + xCg5Nj7J.getMessage());
							}
						} catch (java.lang.NoSuchMethodException uCXvflva) {
							throw new SnifflibDatatypeException("Problem constructing 4" + uCXvflva.getMessage());
						}
					}
					break;
				}
				case StreamTokenizer.TT_NUMBER: {
					Kn1p04uD = true;
					if (nyQ4D6Ib) {
						throw new SnifflibDatatypeException(
								"Expecting string header at row=" + kDEilSzj + ", column=" + TtxBE84B + ".");
					} else {
						if (UVhOdiSM) {
							this.types.add(Double.class);
						}
						if (!this.dryrun) {
							if (mUo3H1AW.getColumnCount() <= TtxBE84B) {
								mUo3H1AW.addColumn((String) this.headers.get(TtxBE84B),
										(Class) this.types.get(TtxBE84B));
							}
						}
						try {
							Constructor jOOfBvxw;
							if (TtxBE84B < this.constructors.size()) {
								jOOfBvxw = (Constructor) this.constructors.get(TtxBE84B);
							} else {
								Class wsU79Zz2 = (Class) this.types.get(TtxBE84B);
								jOOfBvxw = wsU79Zz2.getConstructor(double.class);
								this.constructors.add(jOOfBvxw);
							}
							if (DuWAHEq8) {
								Double fzAFSofk = this.scientificNumber;
								if (!this.dryrun) {
									try {
										mUo3H1AW.setValueAt(new Double(fzAFSofk.doubleValue() * CS0PJtcN.nval),
												kDEilSzj, TtxBE84B);
									} catch (Exception gmWGj62r) {
										throw new SnifflibDatatypeException(
												"Problem constructing " + jOOfBvxw.getDeclaringClass() + "at row "
														+ kDEilSzj + " column " + TtxBE84B + ".",
												gmWGj62r);
									}
								} else if (this.findingTargetValue) {
									Double HZ8H9lVH = new Double(CS0PJtcN.nval);
									Object WPWQrTE0 = null;
									try {
										WPWQrTE0 = Double.parseDouble(fzAFSofk + "E" + HZ8H9lVH.intValue());
									} catch (Exception VPr1dZta) {
										throw new RuntimeException("Problem parsing scientific notation at row="
												+ kDEilSzj + " col=" + TtxBE84B + ".", VPr1dZta);
									}
									CS0PJtcN.nextToken();
									if (CS0PJtcN.ttype != 'e') {
										this.valueQueue.push(WPWQrTE0);
										if ((this.targetRow == kDEilSzj) && (this.targetColumn == TtxBE84B)) {
											this.targetValue = WPWQrTE0;
											g5AtRzxN.close();
											return (null);
										}
										TtxBE84B++;
									} else {
										CS0PJtcN.pushBack();
									}
								}
								DuWAHEq8 = false;
							} else {
								try {
									this.scientificNumber = new Double(CS0PJtcN.nval);
									if (!this.dryrun) {
										mUo3H1AW.setValueAt(this.scientificNumber, kDEilSzj, TtxBE84B);
									} else if (this.findingTargetValue) {
										this.valueQueue.push(this.scientificNumber);
										if ((this.targetRow == kDEilSzj) && (this.targetColumn == TtxBE84B)) {
											this.targetValue = this.scientificNumber;
											g5AtRzxN.close();
											return (null);
										}
									}
								} catch (Exception PJly3jCw) {
									throw new SnifflibDatatypeException(
											"Problem constructing " + jOOfBvxw.getDeclaringClass() + "at row "
													+ kDEilSzj + " column " + TtxBE84B + ".",
											PJly3jCw);
								}
							}
						} catch (java.lang.NoSuchMethodException JkPxcMy6) {
							throw new SnifflibDatatypeException("Problem constructing" + JkPxcMy6.getMessage());
						}
					}
					break;
				}
				case StreamTokenizer.TT_EOL: {
					if (nyQ4D6Ib) {
						nyQ4D6Ib = false;
						UVhOdiSM = true;
					} else {
						if (UVhOdiSM) {
							UVhOdiSM = false;
							nadfVVSZ = true;
						}
					}
					if (nadfVVSZ) {
						if (valueQueue.getUpperIndex() < kDEilSzj) {
							valueQueue.push("");
						}
						kDEilSzj++;
					}
					break;
				}
				case StreamTokenizer.TT_EOF: {
					if (nyQ4D6Ib) {
						throw new SnifflibDatatypeException("End of file reached while reading headers.");
					}
					if (UVhOdiSM) {
						throw new SnifflibDatatypeException("End of file reached while reading initial values.");
					}
					if (nadfVVSZ) {
						nadfVVSZ = false;
					}
					break;
				}
				default: {
					if (CS0PJtcN.ttype == '"') {
						Kn1p04uD = true;
						if (nyQ4D6Ib) {
							this.headers.add(CS0PJtcN.sval);
						} else {
							if (UVhOdiSM) {
								this.types.add(String.class);
							}
							if (!this.dryrun) {
								if (mUo3H1AW.getColumnCount() <= TtxBE84B) {
									mUo3H1AW.addColumn((String) this.headers.get(TtxBE84B),
											(Class) this.types.get(TtxBE84B));
								}
							}
							try {
								Constructor eDkz8Z0t;
								if (TtxBE84B < this.constructors.size()) {
									eDkz8Z0t = (Constructor) this.constructors.get(TtxBE84B);
								} else {
									Class izsxg8QG = (Class) this.types.get(TtxBE84B);
									eDkz8Z0t = izsxg8QG.getConstructor(String.class);
									this.constructors.add(eDkz8Z0t);
								}
								try {
									try {
										try {
											if (!this.dryrun) {
												mUo3H1AW.setValueAt(eDkz8Z0t.newInstance((String) CS0PJtcN.sval),
														kDEilSzj, TtxBE84B);
											} else if (this.findingTargetValue) {
												Object wl7UUJgk = eDkz8Z0t.newInstance((String) CS0PJtcN.sval);
												this.valueQueue.push(wl7UUJgk);
												if ((this.targetRow == kDEilSzj) && (this.targetColumn == TtxBE84B)) {
													this.targetValue = wl7UUJgk;
													g5AtRzxN.close();
													return (null);
												}
											}
										} catch (java.lang.reflect.InvocationTargetException e3SYe4aJ) {
											throw new SnifflibDatatypeException("Problem constructing a " + eDkz8Z0t,
													e3SYe4aJ);
										}
									} catch (java.lang.IllegalAccessException Rz0uEACo) {
										throw new SnifflibDatatypeException("Problem constructing 2 ", Rz0uEACo);
									}
								} catch (java.lang.InstantiationException Y4OyobBb) {
									throw new SnifflibDatatypeException("Problem constructing 3 ", Y4OyobBb);
								}
							} catch (java.lang.NoSuchMethodException eJ6MtCQE) {
								throw new SnifflibDatatypeException("Problem constructing 4", eJ6MtCQE);
							}
						}
					} else if (CS0PJtcN.ttype == 'e') {
						Class eHdtZNAf = (Class) this.types.get(TtxBE84B);
						if (Number.class.isAssignableFrom(eHdtZNAf)) {
							TtxBE84B--;
							DuWAHEq8 = true;
							Kn1p04uD = false;
						}
					} else {
						Kn1p04uD = false;
					}
					break;
				}
				}
				if (CS0PJtcN.ttype == StreamTokenizer.TT_EOF) {
					Kn1p04uD = false;
					break;
				}
				if (Kn1p04uD) {
					TtxBE84B++;
					if (!nyQ4D6Ib) {
						if (TtxBE84B >= this.headers.size()) {
							TtxBE84B = 0;
						}
					}
				}
			}
			if (!nyQ4D6Ib) {
				this.rowcount = kDEilSzj;
			} else {
				this.rowcount = 0;
				nyQ4D6Ib = false;
				if (this.ignorePostHeaderLines > 0) {
					String EgNPoXD9;
					int mPBmzTkN = 0;
					while ((mPBmzTkN < this.ignorePostHeaderLines) && ((EgNPoXD9 = g5AtRzxN.readLine()) != null)) {
						mPBmzTkN++;
					}
				}
			}
			g5AtRzxN.close();
		} catch (java.io.IOException ZN0GrcQy) {
			throw new SnifflibDatatypeException(ZN0GrcQy.getMessage());
		}
		if (!this.dryrun) {
			for (int fEaVoXFM = 0; fEaVoXFM < this.headers.size(); fEaVoXFM++) {
				mUo3H1AW.setColumnName(fEaVoXFM, (String) this.headers.get(fEaVoXFM));
			}
		}
		return (mUo3H1AW);
	}

}