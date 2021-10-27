class n20926398 {
	public static Cursor load(URL aM2tw5Cs, String D8XC6rr4) {
		if (aM2tw5Cs == null) {
			log.log(Level.WARNING, "Trying to load a cursor with a null url.");
			return null;
		}
		String BQVCX0N9 = aM2tw5Cs.getFile();
		BufferedReader AHXnevm4 = null;
		int UUIf5bAY = 0;
		try {
			DirectoryTextureLoader LxV0W0pL;
			URL gSenhnea;
			if (BQVCX0N9.endsWith(cursorDescriptorFile)) {
				gSenhnea = aM2tw5Cs;
				Cursor Z5ikojg1 = cursorCache.get(aM2tw5Cs);
				if (Z5ikojg1 != null)
					return Z5ikojg1;
				AHXnevm4 = new BufferedReader(new InputStreamReader(aM2tw5Cs.openStream()));
				LxV0W0pL = new DirectoryTextureLoader(aM2tw5Cs, false);
			} else if (BQVCX0N9.endsWith(cursorArchiveFile)) {
				LxV0W0pL = new DirectoryTextureLoader(aM2tw5Cs, true);
				if (D8XC6rr4 == null)
					D8XC6rr4 = defaultDescriptorFile;
				gSenhnea = LxV0W0pL.makeUrl(D8XC6rr4);
				Cursor kzEn7xvV = cursorCache.get(aM2tw5Cs);
				if (kzEn7xvV != null)
					return kzEn7xvV;
				ZipInputStream AsLaX9Oy = new ZipInputStream(aM2tw5Cs.openStream());
				ZipEntry HPYhPcxc;
				boolean WMRkgpzN = false;
				while ((HPYhPcxc = AsLaX9Oy.getNextEntry()) != null) {
					if (D8XC6rr4.equals(HPYhPcxc.getName())) {
						WMRkgpzN = true;
						break;
					}
				}
				if (!WMRkgpzN) {
					throw new IOException("Descriptor file \"" + D8XC6rr4 + "\" was not found.");
				}
				AHXnevm4 = new BufferedReader(new InputStreamReader(AsLaX9Oy));
			} else {
				log.log(Level.WARNING, "Invalid cursor fileName \"{0}\".", BQVCX0N9);
				return null;
			}
			Cursor zV8Uu9eB = new Cursor();
			zV8Uu9eB.url = gSenhnea;
			List<Integer> O1IRTYZK = new ArrayList<Integer>();
			List<String> OO77ZNib = new ArrayList<String>();
			Map<String, Texture> qlk5XwcE = new HashMap<String, Texture>();
			String K67KOwdi;
			while ((K67KOwdi = AHXnevm4.readLine()) != null) {
				UUIf5bAY++;
				int L7NxzbQC = K67KOwdi.indexOf(commentString);
				if (L7NxzbQC != -1) {
					K67KOwdi = K67KOwdi.substring(0, L7NxzbQC);
				}
				StringTokenizer FOPd1q8V = new StringTokenizer(K67KOwdi, delims);
				if (!FOPd1q8V.hasMoreTokens())
					continue;
				String VWs2zM1j = FOPd1q8V.nextToken();
				if (VWs2zM1j.equals(hotSpotXPrefix)) {
					zV8Uu9eB.hotSpotOffset.x = Integer.valueOf(FOPd1q8V.nextToken());
				} else if (VWs2zM1j.equals(hotSpotYPrefix)) {
					zV8Uu9eB.hotSpotOffset.y = Integer.valueOf(FOPd1q8V.nextToken());
				} else if (VWs2zM1j.equals(timePrefix)) {
					O1IRTYZK.add(Integer.valueOf(FOPd1q8V.nextToken()));
					if (FOPd1q8V.nextToken().equals(imagePrefix)) {
						String PHmx0inG = FOPd1q8V.nextToken("");
						PHmx0inG = PHmx0inG.substring(PHmx0inG.indexOf('=') + 1);
						PHmx0inG.trim();
						OO77ZNib.add(PHmx0inG);
						if (qlk5XwcE.get(PHmx0inG) == null) {
							qlk5XwcE.put(PHmx0inG, LxV0W0pL.loadTexture(PHmx0inG));
						}
					} else {
						throw new NoSuchElementException();
					}
				}
			}
			zV8Uu9eB.frameFileNames = OO77ZNib.toArray(new String[0]);
			zV8Uu9eB.textureCache = qlk5XwcE;
			zV8Uu9eB.delays = new int[O1IRTYZK.size()];
			zV8Uu9eB.images = new Image[OO77ZNib.size()];
			zV8Uu9eB.textures = new Texture[OO77ZNib.size()];
			for (int Nsily5bd = 0; Nsily5bd < zV8Uu9eB.frameFileNames.length; Nsily5bd++) {
				zV8Uu9eB.textures[Nsily5bd] = qlk5XwcE.get(zV8Uu9eB.frameFileNames[Nsily5bd]);
				zV8Uu9eB.images[Nsily5bd] = zV8Uu9eB.textures[Nsily5bd].getImage();
				zV8Uu9eB.delays[Nsily5bd] = O1IRTYZK.get(Nsily5bd);
			}
			if (O1IRTYZK.size() == 1)
				zV8Uu9eB.delays = null;
			if (zV8Uu9eB.images.length == 0) {
				log.log(Level.WARNING, "The cursor has no animation frames.");
				return null;
			}
			zV8Uu9eB.width = zV8Uu9eB.images[0].getWidth();
			zV8Uu9eB.height = zV8Uu9eB.images[0].getHeight();
			cursorCache.put(zV8Uu9eB.url, zV8Uu9eB);
			return zV8Uu9eB;
		} catch (MalformedURLException hKzme0es) {
			log.log(Level.WARNING, "Unable to load cursor.", hKzme0es);
		} catch (IOException Xea7oKy4) {
			log.log(Level.WARNING, "Unable to load cursor.", Xea7oKy4);
		} catch (NumberFormatException OIKNUSj6) {
			log.log(Level.WARNING, "Numerical error while parsing the " + "file \"{0}\" at line {1}",
					new Object[] { aM2tw5Cs, UUIf5bAY });
		} catch (IndexOutOfBoundsException yJQrIp4m) {
			log.log(Level.WARNING, "Error, \"=\" expected in the file \"{0}\" at line {1}",
					new Object[] { aM2tw5Cs, UUIf5bAY });
		} catch (NoSuchElementException fIUidexU) {
			log.log(Level.WARNING, "Error while parsing the file \"{0}\" at line {1}",
					new Object[] { aM2tw5Cs, UUIf5bAY });
		} finally {
			if (AHXnevm4 != null) {
				try {
					AHXnevm4.close();
				} catch (IOException NeiicrqQ) {
					log.log(Level.SEVERE, "Unable to close the steam.", NeiicrqQ);
				}
			}
		}
		return null;
	}

}