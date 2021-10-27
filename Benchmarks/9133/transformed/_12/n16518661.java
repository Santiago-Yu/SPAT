class n16518661 {
	public String quebraLink(String link) throws StringIndexOutOfBoundsException {
		link = link.replace(".url", "");
		int cod = 0;
		final String linkInit = link.replace("#", "");
		boolean estado = false;
		char letra;
		String linkOrig, newlink = "";
		linkOrig = link.replace("#", "");
		linkOrig = linkOrig.replace(".url", "");
		linkOrig = linkOrig.replace(".html", "");
		linkOrig = linkOrig.replace("http://", "");
		if (linkOrig.contains("clubedodownload")) {
			for (int i = 7; i < linkInit.length(); i++) {
				if (linkOrig.charAt(i) == '/') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					if (newlink.contains("//:ptth")) {
						newlink = inverteFrase(newlink);
						if (isValid(newlink)) {
							return newlink;
						}
					} else if (newlink.contains("http://")) {
						if (isValid(newlink)) {
							return newlink;
						}
					}
				}
			}
		}
		if (linkOrig.contains("protetordelink.tv")) {
			for (int i = linkOrig.length() - 1; i >= 0; i--) {
				letra = linkOrig.charAt(i);
				if (letra == '/') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					newlink = HexToChar(newlink);
					if (newlink.contains("ptth")) {
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							newlink = inverteFrase(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							newlink = inverteFrase(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						}
					} else {
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
		}
		if (linkOrig.contains("baixeaquifilmes")) {
			for (int i = 0; i < linkOrig.length(); i++) {
				letra = linkOrig.charAt(i);
				if (letra == '?') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					if (newlink.contains(":ptth")) {
						newlink = inverteFrase(newlink);
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					} else {
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
		}
		if (linkOrig.contains("downloadsgratis")) {
			for (int i = 0; i < linkOrig.length(); i++) {
				letra = linkOrig.charAt(i);
				if (letra == '!') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					if (precisaRepassar(QuebraLink.decode64(newlink))) {
						newlink = quebraLink(QuebraLink.decode64(newlink));
						if (isValid(newlink)) {
							return newlink;
						}
					} else {
						if (isValid(newlink)) {
							return newlink;
						}
					}
				}
			}
		}
		newlink = "";
		if (linkOrig.contains("vinxp")) {
			System.out.println("¨¦");
			for (int i = 1; i < linkOrig.length(); i++) {
				if (linkOrig.charAt(i) == '=') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					break;
				}
			}
			if (newlink.contains(".vinxp")) {
				newlink = newlink.replace(".vinxp", "");
			}
			newlink = decodeCifraDeCesar(newlink);
			System.out.println(newlink);
			return newlink;
		}
		if (linkOrig.contains("?")) {
			String linkTemporary = "";
			newlink = "";
			if (linkOrig.contains("go!")) {
				linkOrig = linkOrig.replace("?go!", "?");
			}
			if (linkOrig.contains("=")) {
				for (int i = 0; i < linkOrig.length(); i++) {
					letra = linkOrig.charAt(i);
					if (letra == '=') {
						for (int j = i + 1; j < linkOrig.length(); j++) {
							newlink += linkOrig.charAt(j);
						}
						linkTemporary = QuebraLink.decode64(newlink);
						break;
					}
				}
				if (linkTemporary.contains("http")) {
					newlink = "";
					for (int i = 0; i < linkTemporary.length(); i++) {
						letra = linkTemporary.charAt(i);
						if (letra == 'h') {
							for (int j = i; j < linkTemporary.length(); j++) {
								newlink += linkTemporary.charAt(j);
							}
							newlink = newlink.replace("!og", "");
							if (precisaRepassar(newlink)) {
								newlink = quebraLink(newlink);
								if (isValid(newlink)) {
									return newlink;
								}
							} else {
								if (isValid(newlink)) {
									return newlink;
								}
							}
						}
					}
				}
				if (linkTemporary.contains("ptth")) {
					newlink = "";
					linkTemporary = inverteFrase(linkTemporary);
					for (int i = 0; i < linkTemporary.length(); i++) {
						letra = linkTemporary.charAt(i);
						if (letra == 'h') {
							for (int j = i; j < linkTemporary.length(); j++) {
								newlink += linkTemporary.charAt(j);
							}
							newlink = newlink.replace("!og", "");
							if (precisaRepassar(newlink)) {
								newlink = quebraLink(newlink);
								if (isValid(newlink)) {
									return newlink;
								}
							} else {
								if (isValid(newlink)) {
									return newlink;
								}
							}
						}
					}
				}
			}
			linkTemporary = "";
			for (int i = 0; i < linkOrig.length(); i++) {
				letra = linkOrig.charAt(i);
				if (letra == '?') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						linkTemporary += linkOrig.charAt(j);
					}
					link = QuebraLink.decode64(linkTemporary);
					break;
				}
			}
			if (link.contains("http")) {
				newlink = "";
				for (int i = 0; i < link.length(); i++) {
					letra = link.charAt(i);
					if (letra == 'h') {
						for (int j = i; j < link.length(); j++) {
							newlink += link.charAt(j);
						}
						newlink = newlink.replace("!og", "");
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
			if (link.contains("ptth")) {
				newlink = "";
				linkTemporary = inverteFrase(link);
				for (int i = 0; i < linkTemporary.length(); i++) {
					letra = linkTemporary.charAt(i);
					if (letra == 'h') {
						for (int j = i; j < linkTemporary.length(); j++) {
							newlink += linkTemporary.charAt(j);
						}
						newlink = newlink.replace("!og", "");
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
			linkOrig = linkInit;
			link = linkOrig;
			newlink = "";
		}
		if (linkOrig.contains("?")) {
			String linkTemporary = "";
			newlink = "";
			if (linkOrig.contains("go!")) {
				linkOrig = linkOrig.replace("?go!", "?");
			}
			if (linkOrig.contains("=")) {
				for (int i = 0; i < linkOrig.length(); i++) {
					letra = linkOrig.charAt(i);
					if (letra == '=') {
						for (int j = i + 1; j < linkOrig.length(); j++) {
							newlink += linkOrig.charAt(j);
						}
						linkTemporary = linkTemporary.replace(".", "");
						try {
							linkTemporary = HexToChar(newlink);
						} catch (Exception e) {
							System.err.println("erro hex 1?");
							estado = true;
						}
						break;
					}
				}
				if (linkTemporary.contains("http") && !estado) {
					newlink = "";
					for (int i = 0; i < linkTemporary.length(); i++) {
						letra = linkTemporary.charAt(i);
						if (letra == 'h') {
							for (int j = i; j < linkTemporary.length(); j++) {
								newlink += linkTemporary.charAt(j);
							}
							newlink = newlink.replace("!og", "");
							if (precisaRepassar(newlink)) {
								newlink = quebraLink(newlink);
								if (isValid(newlink)) {
									return newlink;
								}
							} else {
								if (isValid(newlink)) {
									return newlink;
								}
							}
						}
					}
				}
				if (linkTemporary.contains("ptth") && !estado) {
					newlink = "";
					linkTemporary = inverteFrase(linkTemporary);
					for (int i = 0; i < linkTemporary.length(); i++) {
						letra = linkTemporary.charAt(i);
						if (letra == 'h') {
							for (int j = i; j < linkTemporary.length(); j++) {
								newlink += linkTemporary.charAt(j);
							}
							newlink = newlink.replace("!og", "");
							if (precisaRepassar(newlink)) {
								newlink = quebraLink(newlink);
								if (isValid(newlink)) {
									return newlink;
								}
							} else {
								if (isValid(newlink)) {
									return newlink;
								}
							}
						}
					}
				}
			}
			estado = false;
			linkTemporary = "";
			for (int i = 0; i < linkOrig.length(); i++) {
				letra = linkOrig.charAt(i);
				if (letra == '?') {
					for (int j = i + 1; j < linkOrig.length(); j++) {
						linkTemporary += linkOrig.charAt(j);
					}
					linkTemporary = linkTemporary.replace(".", "");
					try {
						link = HexToChar(linkTemporary);
					} catch (Exception e) {
						System.err.println("erro hex 2?");
						estado = true;
					}
					break;
				}
			}
			if (link.contains("http") && !estado) {
				newlink = "";
				for (int i = 0; i < link.length(); i++) {
					letra = link.charAt(i);
					if (letra == 'h') {
						for (int j = i; j < link.length(); j++) {
							newlink += link.charAt(j);
						}
						newlink = newlink.replace("!og", "");
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
			if (link.contains("ptth") && !estado) {
				newlink = "";
				linkTemporary = inverteFrase(link);
				for (int i = 0; i < linkTemporary.length(); i++) {
					letra = linkTemporary.charAt(i);
					if (letra == 'h') {
						for (int j = i; j < linkTemporary.length(); j++) {
							newlink += linkTemporary.charAt(j);
						}
						newlink = newlink.replace("!og", "");
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
			linkOrig = linkInit;
			link = linkOrig;
			newlink = "";
		}
		if (linkOrig.contains("?") && !linkOrig.contains("id=") && !linkOrig.contains("url=")
				&& !linkOrig.contains("link=") && !linkOrig.contains("r=http") && !linkOrig.contains("r=ftp")) {
			for (int i = 0; i < linkOrig.length(); i++) {
				letra = linkOrig.charAt(i);
				if (letra == '?') {
					newlink = "";
					for (int j = i + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					if (newlink.contains("ptth")) {
						newlink = inverteFrase(newlink);
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					} else {
						if (precisaRepassar(newlink)) {
							newlink = quebraLink(newlink);
							if (isValid(newlink)) {
								return newlink;
							}
						} else {
							if (isValid(newlink)) {
								return newlink;
							}
						}
					}
				}
			}
		}
		if ((link.contains("url=")) || (link.contains("link=")) || (link.contains("?r=http"))
				|| (link.contains("?r=ftp"))) {
			if (!link.contains("//:ptth")) {
				for (int i = 0; i < link.length(); i++) {
					letra = link.charAt(i);
					if (letra == '=') {
						for (int j = i + 1; j < link.length(); j++) {
							letra = link.charAt(j);
							newlink += letra;
						}
						break;
					}
				}
				if (precisaRepassar(newlink)) {
					newlink = quebraLink(newlink);
					if (isValid(newlink)) {
						return newlink;
					}
				} else {
					if (isValid(newlink)) {
						return newlink;
					}
				}
			}
		}
		if (linkOrig.contains("//:ptth") || linkOrig.contains("//:sptth")) {
			if (linkOrig.contains("=")) {
				for (int i = 0; i < linkOrig.length(); i++) {
					letra = linkOrig.charAt(i);
					if (letra == '=') {
						for (int j = linkOrig.length() - 1; j > i; j--) {
							letra = linkOrig.charAt(j);
							newlink += letra;
						}
						break;
					}
				}
				if (precisaRepassar(newlink)) {
					newlink = quebraLink(newlink);
					if (isValid(newlink)) {
						return newlink;
					}
				} else {
					if (isValid(newlink)) {
						return newlink;
					}
				}
			}
			newlink = inverteFrase(linkOrig);
			if (precisaRepassar(newlink)) {
				newlink = quebraLink(newlink);
				if (isValid(newlink)) {
					return newlink;
				}
			} else {
				if (isValid(newlink)) {
					return newlink;
				}
			}
		}
		if (linkOrig.contains("?go!")) {
			linkOrig = linkOrig.replace("?go!", "?down!");
			newlink = linkOrig;
			if (precisaRepassar(newlink)) {
				newlink = quebraLink(newlink);
				if (isValid(newlink)) {
					return newlink;
				}
			} else {
				if (isValid(newlink)) {
					return newlink;
				}
			}
		}
		if (linkOrig.contains("down!")) {
			linkOrig = linkOrig.replace("down!", "");
			return quebraLink(linkOrig);
		}
		newlink = "";
		for (int i = linkOrig.length() - 4; i >= 0; i--) {
			letra = linkOrig.charAt(i);
			if (letra == '=') {
				for (int j = i + 1; j < linkOrig.length(); j++) {
					newlink += linkOrig.charAt(j);
				}
				break;
			}
		}
		String ltmp = "";
		try {
			ltmp = HexToChar(newlink);
		} catch (Exception e) {
			System.err.println("erro hex 3?");
		}
		if (ltmp.contains("http://")) {
			if (precisaRepassar(ltmp)) {
				ltmp = quebraLink(ltmp);
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			} else {
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			}
		} else if (ltmp.contains("//:ptth")) {
			ltmp = inverteFrase(ltmp);
			if (precisaRepassar(ltmp)) {
				ltmp = quebraLink(ltmp);
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			} else {
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			}
		} else {
			ltmp = newlink;
		}
		ltmp = decode64(newlink);
		if (ltmp.contains("http://")) {
			if (precisaRepassar(ltmp)) {
				ltmp = quebraLink(newlink);
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			} else {
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			}
		} else if (ltmp.contains("//:ptth")) {
			ltmp = inverteFrase(ltmp);
			if (precisaRepassar(ltmp)) {
				newlink = quebraLink(newlink);
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			} else {
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			}
		} else {
			ltmp = newlink;
		}
		try {
			ltmp = decodeAscii(newlink);
		} catch (NumberFormatException e) {
			System.err.println("erro ascii");
		}
		if (ltmp.contains("http://")) {
			if (precisaRepassar(ltmp)) {
				ltmp = quebraLink(newlink);
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			} else {
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			}
		} else if (ltmp.contains("//:ptth")) {
			ltmp = inverteFrase(ltmp);
			if (precisaRepassar(ltmp)) {
				ltmp = quebraLink(ltmp);
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			} else {
				if (isValid(ltmp)) {
					newlink = ltmp;
					return newlink;
				}
			}
		} else {
			ltmp = null;
		}
		newlink = "";
		int cont = 0;
		letra = '\0';
		ltmp = "";
		newlink = "";
		for (int i = linkOrig.length() - 4; i >= 0; i--) {
			letra = linkOrig.charAt(i);
			if (letra == '=' || letra == '?') {
				for (int j = i + 1; j < linkOrig.length(); j++) {
					if (linkOrig.charAt(j) == '.') {
						break;
					}
					newlink += linkOrig.charAt(j);
				}
				break;
			}
		}
		ltmp = newlink;
		String tmp = "", tmp2 = "";
		do {
			try {
				tmp = HexToChar(ltmp);
				tmp2 = HexToChar(inverteFrase(ltmp));
				if (!tmp.isEmpty() && tmp.length() > 5 && !tmp.contains("") && !tmp.contains("¡ì") && !tmp.contains("?")
						&& !tmp.contains("")) {
					ltmp = HexToChar(ltmp);
				} else if (!inverteFrase(tmp2).isEmpty() && inverteFrase(tmp2).length() > 5
						&& !inverteFrase(tmp2).contains("?") && !inverteFrase(tmp2).contains("¡ì")
						&& !inverteFrase(tmp2).contains("?")) {
					ltmp = HexToChar(inverteFrase(ltmp));
				}
			} catch (NumberFormatException e) {
			}
			tmp = decode64(ltmp);
			tmp2 = decode64(inverteFrase(ltmp));
			if (!tmp.contains("?") && !tmp.contains("?")) {
				ltmp = decode64(ltmp);
			} else if (!tmp2.contains("?") && !tmp2.contains("?")) {
				ltmp = decode64(inverteFrase(ltmp));
			}
			try {
				tmp = decodeAscii(ltmp);
				tmp2 = decodeAscii(inverteFrase(ltmp));
				if (!tmp.contains("?") && !tmp.contains("?") && !tmp.contains("¡ì") && !tmp.contains("?")
						&& !tmp.contains("*") && !tmp.contains("\"") && !tmp.contains("^")) {
					ltmp = decodeAscii(ltmp);
				} else if (!tmp2.contains("?") && !tmp2.contains("?") && !tmp2.contains("¡ì") && !tmp2.contains("?")
						&& !tmp2.contains("*") && !tmp2.contains("\"") && !tmp2.contains("^")) {
					ltmp = decodeAscii(inverteFrase(ltmp));
				}
			} catch (NumberFormatException e) {
			}
			cont++;
			if (ltmp.contains("http")) {
				newlink = ltmp;
				if (precisaRepassar(newlink)) {
					newlink = quebraLink(newlink);
					if (isValid(newlink)) {
						return newlink;
					}
				} else {
					if (isValid(newlink)) {
						return newlink;
					}
				}
			} else if (ltmp.contains("ptth")) {
				newlink = inverteFrase(ltmp);
				if (precisaRepassar(newlink)) {
					newlink = quebraLink(newlink);
					if (isValid(newlink)) {
						return newlink;
					}
				} else {
					if (isValid(newlink)) {
						return newlink;
					}
				}
			}
		} while (!isValid(newlink) && cont <= 20);
		tmp = null;
		tmp2 = null;
		ltmp = null;
		String leitura = "";
		try {
			leitura = readHTML(linkInit);
		} catch (IOException e) {
		}
		leitura = leitura.toLowerCase();
		if (leitura.contains("trocabotao")) {
			newlink = "";
			for (int i = leitura.indexOf("trocabotao"); i < leitura.length(); i++) {
				if (Character.isDigit(leitura.charAt(i))) {
					int tmpInt = i;
					while (Character.isDigit(leitura.charAt(tmpInt))) {
						newlink += leitura.charAt(tmpInt);
						tmpInt++;
					}
					cod = Integer.parseInt(newlink);
					break;
				}
			}
			if (cod != 0) {
				for (int i = 7; i < linkInit.length(); i++) {
					letra = linkInit.charAt(i);
					if (letra == '/') {
						newlink = linkInit.substring(0, i + 1) + "linkdiscover.php?cod=" + cod;
						break;
					}
				}
				DataInputStream dat = null;
				try {
					URL url = new URL(newlink);
					InputStream in = url.openStream();
					dat = new DataInputStream(new BufferedInputStream(in));
					leitura = "";
					int dado;
					while ((dado = dat.read()) != -1) {
						letra = (char) dado;
						leitura += letra;
					}
					newlink = leitura.replaceAll(" ", "");
					if (precisaRepassar(newlink)) {
						newlink = quebraLink(newlink);
						if (isValid(newlink)) {
							return newlink;
						}
					} else {
						if (isValid(newlink)) {
							return newlink;
						}
					}
				} catch (MalformedURLException ex) {
					System.out.println("URL mal formada.");
				} catch (IOException e) {
				} finally {
					try {
						if (dat != null) {
							dat.close();
						}
					} catch (IOException e) {
						System.err.println("Falha ao fechar fluxo.");
					}
				}
			}
		}
		if (precisaRepassar(linkInit)) {
			if (linkInit.substring(8).contains("http")) {
				newlink = linkInit.substring(linkInit.indexOf("http", 8), linkInit.length());
				if (isValid(newlink)) {
					return newlink;
				}
			}
		}
		newlink = "";
		StringBuffer strBuf = null;
		try {
			strBuf = new StringBuffer(readHTML(linkInit));
			for (String tmp3 : getLibrary()) {
				if (strBuf.toString().toLowerCase().contains(tmp3)) {
					for (int i = strBuf.toString().indexOf(tmp3); i >= 0; i--) {
						if (strBuf.toString().charAt(i) == '"') {
							for (int j = i + 1; j < strBuf.length(); j++) {
								if (strBuf.toString().charAt(j) == '"') {
									if (precisaRepassar(newlink)) {
										newlink = quebraLink(newlink);
										if (isValid(newlink)) {
											return newlink;
										}
									} else {
										if (isValid(newlink)) {
											return newlink;
										}
									}
								} else {
									newlink += strBuf.toString().charAt(j);
								}
							}
						}
					}
				}
			}
		} catch (IOException ex) {
		}
		GUIQuebraLink.isBroken = false;
		return "Desculpe o link n?o pode ser quebrado.";
	}

}