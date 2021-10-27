class n16518661 {
	public String quebraLink(String link) throws StringIndexOutOfBoundsException {
		link = link.replace(".url", "");
		int cod = 0;
		final String linkInit = link.replace("#", "");
		boolean estado = false;
		char letra;
		String linkOrig;
		String newlink = "";
		linkOrig = link.replace("#", "");
		linkOrig = linkOrig.replace(".url", "");
		linkOrig = linkOrig.replace(".html", "");
		linkOrig = linkOrig.replace("http://", "");
		if (linkOrig.contains("clubedodownload")) {
			int ZC7G2 = 7;
			while (ZC7G2 < linkInit.length()) {
				if (linkOrig.charAt(ZC7G2) == '/') {
					for (int j = ZC7G2 + 1; j < linkOrig.length(); j++) {
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
				ZC7G2++;
			}
		}
		if (linkOrig.contains("protetordelink.tv")) {
			int LdP0e = linkOrig.length() - 1;
			while (LdP0e >= 0) {
				letra = linkOrig.charAt(LdP0e);
				if (letra == '/') {
					for (int j = LdP0e + 1; j < linkOrig.length(); j++) {
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
				LdP0e--;
			}
		}
		if (linkOrig.contains("baixeaquifilmes")) {
			int MxYIx = 0;
			while (MxYIx < linkOrig.length()) {
				letra = linkOrig.charAt(MxYIx);
				if (letra == '?') {
					for (int j = MxYIx + 1; j < linkOrig.length(); j++) {
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
				MxYIx++;
			}
		}
		if (linkOrig.contains("downloadsgratis")) {
			int n3NeB = 0;
			while (n3NeB < linkOrig.length()) {
				letra = linkOrig.charAt(n3NeB);
				if (letra == '!') {
					for (int j = n3NeB + 1; j < linkOrig.length(); j++) {
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
				n3NeB++;
			}
		}
		newlink = "";
		if (linkOrig.contains("vinxp")) {
			System.out.println("¨¦");
			int ZXUaZ = 1;
			while (ZXUaZ < linkOrig.length()) {
				if (linkOrig.charAt(ZXUaZ) == '=') {
					for (int j = ZXUaZ + 1; j < linkOrig.length(); j++) {
						newlink += linkOrig.charAt(j);
					}
					break;
				}
				ZXUaZ++;
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
				int NlOln = 0;
				while (NlOln < linkOrig.length()) {
					letra = linkOrig.charAt(NlOln);
					if (letra == '=') {
						for (int j = NlOln + 1; j < linkOrig.length(); j++) {
							newlink += linkOrig.charAt(j);
						}
						linkTemporary = QuebraLink.decode64(newlink);
						break;
					}
					NlOln++;
				}
				if (linkTemporary.contains("http")) {
					newlink = "";
					int FJFyE = 0;
					while (FJFyE < linkTemporary.length()) {
						letra = linkTemporary.charAt(FJFyE);
						if (letra == 'h') {
							for (int j = FJFyE; j < linkTemporary.length(); j++) {
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
						FJFyE++;
					}
				}
				if (linkTemporary.contains("ptth")) {
					newlink = "";
					linkTemporary = inverteFrase(linkTemporary);
					int qHHMX = 0;
					while (qHHMX < linkTemporary.length()) {
						letra = linkTemporary.charAt(qHHMX);
						if (letra == 'h') {
							for (int j = qHHMX; j < linkTemporary.length(); j++) {
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
						qHHMX++;
					}
				}
			}
			linkTemporary = "";
			int TicRs = 0;
			while (TicRs < linkOrig.length()) {
				letra = linkOrig.charAt(TicRs);
				if (letra == '?') {
					for (int j = TicRs + 1; j < linkOrig.length(); j++) {
						linkTemporary += linkOrig.charAt(j);
					}
					link = QuebraLink.decode64(linkTemporary);
					break;
				}
				TicRs++;
			}
			if (link.contains("http")) {
				newlink = "";
				int meuUR = 0;
				while (meuUR < link.length()) {
					letra = link.charAt(meuUR);
					if (letra == 'h') {
						for (int j = meuUR; j < link.length(); j++) {
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
					meuUR++;
				}
			}
			if (link.contains("ptth")) {
				newlink = "";
				linkTemporary = inverteFrase(link);
				int fuPtf = 0;
				while (fuPtf < linkTemporary.length()) {
					letra = linkTemporary.charAt(fuPtf);
					if (letra == 'h') {
						for (int j = fuPtf; j < linkTemporary.length(); j++) {
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
					fuPtf++;
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
				int ltvrG = 0;
				while (ltvrG < linkOrig.length()) {
					letra = linkOrig.charAt(ltvrG);
					if (letra == '=') {
						for (int j = ltvrG + 1; j < linkOrig.length(); j++) {
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
					ltvrG++;
				}
				if (linkTemporary.contains("http") && !estado) {
					newlink = "";
					int n2Ur1 = 0;
					while (n2Ur1 < linkTemporary.length()) {
						letra = linkTemporary.charAt(n2Ur1);
						if (letra == 'h') {
							for (int j = n2Ur1; j < linkTemporary.length(); j++) {
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
						n2Ur1++;
					}
				}
				if (linkTemporary.contains("ptth") && !estado) {
					newlink = "";
					linkTemporary = inverteFrase(linkTemporary);
					int E4Pdr = 0;
					while (E4Pdr < linkTemporary.length()) {
						letra = linkTemporary.charAt(E4Pdr);
						if (letra == 'h') {
							for (int j = E4Pdr; j < linkTemporary.length(); j++) {
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
						E4Pdr++;
					}
				}
			}
			estado = false;
			linkTemporary = "";
			int wlz5j = 0;
			while (wlz5j < linkOrig.length()) {
				letra = linkOrig.charAt(wlz5j);
				if (letra == '?') {
					for (int j = wlz5j + 1; j < linkOrig.length(); j++) {
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
				wlz5j++;
			}
			if (link.contains("http") && !estado) {
				newlink = "";
				int tG3rI = 0;
				while (tG3rI < link.length()) {
					letra = link.charAt(tG3rI);
					if (letra == 'h') {
						for (int j = tG3rI; j < link.length(); j++) {
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
					tG3rI++;
				}
			}
			if (link.contains("ptth") && !estado) {
				newlink = "";
				linkTemporary = inverteFrase(link);
				int tdH57 = 0;
				while (tdH57 < linkTemporary.length()) {
					letra = linkTemporary.charAt(tdH57);
					if (letra == 'h') {
						for (int j = tdH57; j < linkTemporary.length(); j++) {
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
					tdH57++;
				}
			}
			linkOrig = linkInit;
			link = linkOrig;
			newlink = "";
		}
		if (linkOrig.contains("?") && !linkOrig.contains("id=") && !linkOrig.contains("url=")
				&& !linkOrig.contains("link=") && !linkOrig.contains("r=http") && !linkOrig.contains("r=ftp")) {
			int DJvUC = 0;
			while (DJvUC < linkOrig.length()) {
				letra = linkOrig.charAt(DJvUC);
				if (letra == '?') {
					newlink = "";
					for (int j = DJvUC + 1; j < linkOrig.length(); j++) {
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
				DJvUC++;
			}
		}
		if ((link.contains("url=")) || (link.contains("link=")) || (link.contains("?r=http"))
				|| (link.contains("?r=ftp"))) {
			if (!link.contains("//:ptth")) {
				int AlSOG = 0;
				while (AlSOG < link.length()) {
					letra = link.charAt(AlSOG);
					if (letra == '=') {
						for (int j = AlSOG + 1; j < link.length(); j++) {
							letra = link.charAt(j);
							newlink += letra;
						}
						break;
					}
					AlSOG++;
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
				int PTTV5 = 0;
				while (PTTV5 < linkOrig.length()) {
					letra = linkOrig.charAt(PTTV5);
					if (letra == '=') {
						for (int j = linkOrig.length() - 1; j > PTTV5; j--) {
							letra = linkOrig.charAt(j);
							newlink += letra;
						}
						break;
					}
					PTTV5++;
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
		int cctId = linkOrig.length() - 4;
		while (cctId >= 0) {
			letra = linkOrig.charAt(cctId);
			if (letra == '=') {
				for (int j = cctId + 1; j < linkOrig.length(); j++) {
					newlink += linkOrig.charAt(j);
				}
				break;
			}
			cctId--;
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
		int MsBax = linkOrig.length() - 4;
		while (MsBax >= 0) {
			letra = linkOrig.charAt(MsBax);
			if (letra == '=' || letra == '?') {
				for (int j = MsBax + 1; j < linkOrig.length(); j++) {
					if (linkOrig.charAt(j) == '.') {
						break;
					}
					newlink += linkOrig.charAt(j);
				}
				break;
			}
			MsBax--;
		}
		ltmp = newlink;
		String tmp = "";
		String tmp2 = "";
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
			int ZQBQY = leitura.indexOf("trocabotao");
			while (ZQBQY < leitura.length()) {
				if (Character.isDigit(leitura.charAt(ZQBQY))) {
					int tmpInt = ZQBQY;
					while (Character.isDigit(leitura.charAt(tmpInt))) {
						newlink += leitura.charAt(tmpInt);
						tmpInt++;
					}
					cod = Integer.parseInt(newlink);
					break;
				}
				ZQBQY++;
			}
			if (cod != 0) {
				int DJYjK = 7;
				while (DJYjK < linkInit.length()) {
					letra = linkInit.charAt(DJYjK);
					if (letra == '/') {
						newlink = linkInit.substring(0, DJYjK + 1) + "linkdiscover.php?cod=" + cod;
						break;
					}
					DJYjK++;
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
					int Qp5tz = strBuf.toString().indexOf(tmp3);
					while (Qp5tz >= 0) {
						if (strBuf.toString().charAt(Qp5tz) == '"') {
							for (int j = Qp5tz + 1; j < strBuf.length(); j++) {
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
						Qp5tz--;
					}
				}
			}
		} catch (IOException ex) {
		}
		GUIQuebraLink.isBroken = false;
		return "Desculpe o link n?o pode ser quebrado.";
	}

}