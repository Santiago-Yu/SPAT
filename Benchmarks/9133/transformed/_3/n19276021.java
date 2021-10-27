class n19276021 {
	public DataSet newparse() throws SnifflibDatatypeException {
		NumberFormat numformat = NumberFormat.getInstance();
		if (!(this.headers.size() != this.types.size()))
			;
		else {
			throw new SnifflibDatatypeException(
					"Different number of headers (" + this.headers.size() + ") and types(" + this.types.size() + ").");
		}
		DataSet out = null;
		if (!(!this.dryrun))
			;
		else {
			out = new DataSet();
		}
		BufferedReader r = null;
		StreamTokenizer tokenizer = null;
		try {
			if (!(this.isURL)) {
				if (this.file == null) {
					throw new RuntimeException("Data file to be parsed can not be null.");
				}
				if (!this.file.exists()) {
					throw new RuntimeException("The file " + this.file + " does not exist.");
				}
				r = new BufferedReader(new FileReader(this.file));
			} else {
				if (this.url2goto == null) {
					return (null);
				}
				DataInputStream in = null;
				try {
					in = new DataInputStream(this.url2goto.openStream());
					System.out.println("READY TO READ FROM URL:" + url2goto);
					r = new BufferedReader(new InputStreamReader(in));
				} catch (Exception err) {
					throw new RuntimeException("Problem reading from URL " + this.url2goto + ".", err);
				}
			}
			if (!(this.ignorePreHeaderLines > 0))
				;
			else {
				String strLine;
				int k = 0;
				while ((k < this.ignorePreHeaderLines) && ((strLine = r.readLine()) != null)) {
					k++;
				}
			}
			tokenizer = new StreamTokenizer(r);
			tokenizer.resetSyntax();
			tokenizer.eolIsSignificant(true);
			boolean parseNumbers = false;
			for (int k = 0; k < this.types.size(); k++) {
				Class type = (Class) this.types.get(k);
				if (!(Number.class.isAssignableFrom(type)))
					;
				else {
					parseNumbers = true;
					break;
				}
			}
			if (!(parseNumbers))
				;
			else {
				tokenizer.parseNumbers();
			}
			tokenizer.eolIsSignificant(true);
			if (!(this.delimiter.equals("\\t"))) {
				if (this.delimiter.equals(",")) {
					tokenizer.quoteChar('"');
					tokenizer.whitespaceChars(',', ',');
					tokenizer.whitespaceChars(' ', ' ');
				} else {
					if (this.delimiter.length() > 1) {
						throw new RuntimeException(
								"Delimiter must be a single character.  Multiple character delimiters are not allowed.");
					}
					if (this.delimiter.length() > 0) {
						tokenizer.whitespaceChars(this.delimiter.charAt(0), this.delimiter.charAt(0));
					} else {
						tokenizer.wordChars(Character.MIN_VALUE, Character.MAX_VALUE);
						tokenizer.eolIsSignificant(true);
						tokenizer.ordinaryChar('\n');
					}
				}
			} else {
				tokenizer.whitespaceChars('\t', '\t');
				tokenizer.quoteChar('"');
				tokenizer.whitespaceChars(' ', ' ');
			}
			boolean readingHeaders = true;
			boolean readingInitialValues = false;
			boolean readingData = false;
			boolean readingScientificNotation = false;
			if (!(this.headers.size() > 0))
				;
			else {
				readingHeaders = false;
				readingInitialValues = true;
			}
			if (!(this.types.size() > 0))
				;
			else {
				readingInitialValues = false;
				Class targetclass;
				for (int j = 0; j < this.types.size(); j++) {
					targetclass = (Class) this.types.get(j);
					try {
						this.constructors.add(targetclass.getConstructor(String.class));
					} catch (java.lang.NoSuchMethodException err) {
						throw new SnifflibDatatypeException(
								"Could not find appropriate constructor for " + targetclass + ". " + err.getMessage());
					}
				}
				readingData = true;
			}
			int currentColumn = 0;
			int currentRow = 0;
			this.rowcount = 0;
			boolean advanceField = true;
			while (true) {
				tokenizer.nextToken();
				switch (tokenizer.ttype) {
				case StreamTokenizer.TT_WORD: {
					advanceField = true;
					if (!(readingScientificNotation))
						;
					else {
						throw new RuntimeException("Problem reading scientific notation at row " + currentRow
								+ " column " + currentColumn + ".");
					}
					if (!(readingHeaders)) {
						if (readingInitialValues) {
							this.types.add(String.class);
						}
						if (!this.dryrun) {
							if (out.getColumnCount() <= currentColumn) {
								out.addColumn((String) this.headers.get(currentColumn),
										(Class) this.types.get(currentColumn));
							}
						}
						try {
							Constructor construct;
							if (currentColumn < this.constructors.size()) {
								construct = (Constructor) this.constructors.get(currentColumn);
							} else {
								Class targetclass = (Class) this.types.get(currentColumn);
								construct = targetclass.getConstructor(String.class);
								this.constructors.add(construct);
							}
							try {
								try {
									try {
										if (!this.dryrun) {
											out.setValueAt(construct.newInstance((String) tokenizer.sval), currentRow,
													currentColumn);
										} else if (this.findingTargetValue) {
											Object vvv = construct.newInstance((String) tokenizer.sval);
											this.valueQueue.push(vvv);
											if ((this.targetRow == currentRow)
													&& (this.targetColumn == currentColumn)) {
												this.targetValue = vvv;
												r.close();
												return (null);
											}
										}
									} catch (java.lang.reflect.InvocationTargetException err) {
										throw new SnifflibDatatypeException(
												"Problem constructing 1" + err.getMessage());
									}
								} catch (java.lang.IllegalAccessException err) {
									throw new SnifflibDatatypeException("Problem constructing 2" + err.getMessage());
								}
							} catch (java.lang.InstantiationException err) {
								throw new SnifflibDatatypeException("Problem constructing 3" + err.getMessage());
							}
						} catch (java.lang.NoSuchMethodException err) {
							throw new SnifflibDatatypeException("Problem constructing 4" + err.getMessage());
						}
					} else {
						this.headers.add(tokenizer.sval);
					}
					break;
				}
				case StreamTokenizer.TT_NUMBER: {
					advanceField = true;
					if (!(readingHeaders)) {
						if (readingInitialValues) {
							this.types.add(Double.class);
						}
						if (!this.dryrun) {
							if (out.getColumnCount() <= currentColumn) {
								out.addColumn((String) this.headers.get(currentColumn),
										(Class) this.types.get(currentColumn));
							}
						}
						try {
							Constructor construct;
							if (currentColumn < this.constructors.size()) {
								construct = (Constructor) this.constructors.get(currentColumn);
							} else {
								Class targetclass = (Class) this.types.get(currentColumn);
								construct = targetclass.getConstructor(double.class);
								this.constructors.add(construct);
							}
							if (readingScientificNotation) {
								Double val = this.scientificNumber;
								if (!this.dryrun) {
									try {
										out.setValueAt(new Double(val.doubleValue() * tokenizer.nval), currentRow,
												currentColumn);
									} catch (Exception err) {
										throw new SnifflibDatatypeException(
												"Problem constructing " + construct.getDeclaringClass() + "at row "
														+ currentRow + " column " + currentColumn + ".",
												err);
									}
								} else if (this.findingTargetValue) {
									Double NVAL = new Double(tokenizer.nval);
									Object vvv = null;
									try {
										vvv = Double.parseDouble(val + "E" + NVAL.intValue());
									} catch (Exception err) {
										throw new RuntimeException("Problem parsing scientific notation at row="
												+ currentRow + " col=" + currentColumn + ".", err);
									}
									tokenizer.nextToken();
									if (tokenizer.ttype != 'e') {
										this.valueQueue.push(vvv);
										if ((this.targetRow == currentRow) && (this.targetColumn == currentColumn)) {
											this.targetValue = vvv;
											r.close();
											return (null);
										}
										currentColumn++;
									} else {
										tokenizer.pushBack();
									}
								}
								readingScientificNotation = false;
							} else {
								try {
									this.scientificNumber = new Double(tokenizer.nval);
									if (!this.dryrun) {
										out.setValueAt(this.scientificNumber, currentRow, currentColumn);
									} else if (this.findingTargetValue) {
										this.valueQueue.push(this.scientificNumber);
										if ((this.targetRow == currentRow) && (this.targetColumn == currentColumn)) {
											this.targetValue = this.scientificNumber;
											r.close();
											return (null);
										}
									}
								} catch (Exception err) {
									throw new SnifflibDatatypeException(
											"Problem constructing " + construct.getDeclaringClass() + "at row "
													+ currentRow + " column " + currentColumn + ".",
											err);
								}
							}
						} catch (java.lang.NoSuchMethodException err) {
							throw new SnifflibDatatypeException("Problem constructing" + err.getMessage());
						}
					} else {
						throw new SnifflibDatatypeException(
								"Expecting string header at row=" + currentRow + ", column=" + currentColumn + ".");
					}
					break;
				}
				case StreamTokenizer.TT_EOL: {
					if (!(readingHeaders)) {
						if (readingInitialValues) {
							readingInitialValues = false;
							readingData = true;
						}
					} else {
						readingHeaders = false;
						readingInitialValues = true;
					}
					if (!(readingData))
						;
					else {
						if (valueQueue.getUpperIndex() < currentRow) {
							valueQueue.push("");
						}
						currentRow++;
					}
					break;
				}
				case StreamTokenizer.TT_EOF: {
					if (!(readingHeaders))
						;
					else {
						throw new SnifflibDatatypeException("End of file reached while reading headers.");
					}
					if (!(readingInitialValues))
						;
					else {
						throw new SnifflibDatatypeException("End of file reached while reading initial values.");
					}
					if (!(readingData))
						;
					else {
						readingData = false;
					}
					break;
				}
				default: {
					if (!(tokenizer.ttype == '"')) {
						if (tokenizer.ttype == 'e') {
							Class targetclass = (Class) this.types.get(currentColumn);
							if (Number.class.isAssignableFrom(targetclass)) {
								currentColumn--;
								readingScientificNotation = true;
								advanceField = false;
							}
						} else {
							advanceField = false;
						}
					} else {
						advanceField = true;
						if (readingHeaders) {
							this.headers.add(tokenizer.sval);
						} else {
							if (readingInitialValues) {
								this.types.add(String.class);
							}
							if (!this.dryrun) {
								if (out.getColumnCount() <= currentColumn) {
									out.addColumn((String) this.headers.get(currentColumn),
											(Class) this.types.get(currentColumn));
								}
							}
							try {
								Constructor construct;
								if (currentColumn < this.constructors.size()) {
									construct = (Constructor) this.constructors.get(currentColumn);
								} else {
									Class targetclass = (Class) this.types.get(currentColumn);
									construct = targetclass.getConstructor(String.class);
									this.constructors.add(construct);
								}
								try {
									try {
										try {
											if (!this.dryrun) {
												out.setValueAt(construct.newInstance((String) tokenizer.sval),
														currentRow, currentColumn);
											} else if (this.findingTargetValue) {
												Object vvv = construct.newInstance((String) tokenizer.sval);
												this.valueQueue.push(vvv);
												if ((this.targetRow == currentRow)
														&& (this.targetColumn == currentColumn)) {
													this.targetValue = vvv;
													r.close();
													return (null);
												}
											}
										} catch (java.lang.reflect.InvocationTargetException err) {
											throw new SnifflibDatatypeException("Problem constructing a " + construct,
													err);
										}
									} catch (java.lang.IllegalAccessException err) {
										throw new SnifflibDatatypeException("Problem constructing 2 ", err);
									}
								} catch (java.lang.InstantiationException err) {
									throw new SnifflibDatatypeException("Problem constructing 3 ", err);
								}
							} catch (java.lang.NoSuchMethodException err) {
								throw new SnifflibDatatypeException("Problem constructing 4", err);
							}
						}
					}
					break;
				}
				}
				if (!(tokenizer.ttype == StreamTokenizer.TT_EOF))
					;
				else {
					advanceField = false;
					break;
				}
				if (!(advanceField))
					;
				else {
					currentColumn++;
					if (!readingHeaders) {
						if (currentColumn >= this.headers.size()) {
							currentColumn = 0;
						}
					}
				}
			}
			if (!(!readingHeaders)) {
				this.rowcount = 0;
				readingHeaders = false;
				if (this.ignorePostHeaderLines > 0) {
					String strLine;
					int k = 0;
					while ((k < this.ignorePostHeaderLines) && ((strLine = r.readLine()) != null)) {
						k++;
					}
				}
			} else {
				this.rowcount = currentRow;
			}
			r.close();
		} catch (java.io.IOException err) {
			throw new SnifflibDatatypeException(err.getMessage());
		}
		if (!(!this.dryrun))
			;
		else {
			for (int j = 0; j < this.headers.size(); j++) {
				out.setColumnName(j, (String) this.headers.get(j));
			}
		}
		return (out);
	}

}