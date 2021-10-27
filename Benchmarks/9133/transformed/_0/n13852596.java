class n13852596 {
	public void execute() {
		try {
			if (methods == null) {
				return;
			}
			List<Resource> rpwSfqlg = new ArrayList<Resource>();
			for (Iterator<Resource> cHImyhIA = classFiles.iterator(); cHImyhIA.hasNext();) {
				final Resource U78wN2uo = cHImyhIA.next();
				if (!U78wN2uo.getName().equals(CALLSTACK_FILE)) {
					try {
						InputStream wSl22NKp = U78wN2uo.getInputStream();
						ClassReader w04vRbKc = new ClassReader(wSl22NKp);
						w04vRbKc.accept(new MethodAnalyzer(), 0);
						rpwSfqlg.add(U78wN2uo);
						oldSize += U78wN2uo.getSize();
					} catch (IllegalStateException Ovp31zEY) {
					}
				}
			}
			for (Iterator<Resource> szbdevwB = rpwSfqlg.iterator(); szbdevwB.hasNext();) {
				final Resource PouEdbJM = szbdevwB.next();
				try {
					InputStream d0ovrOxs = PouEdbJM.getInputStream();
					ClassReader Hc2MWCPG = new ClassReader(d0ovrOxs);
					ClassWriter REKOVm2r = new ClassWriter(Hc2MWCPG, ClassWriter.COMPUTE_MAXS);
					if (!PouEdbJM.getName().startsWith(CALLSTACK_FILE.substring(0, CALLSTACK_FILE.indexOf('.')))) {
						Hc2MWCPG.accept(new MethodInjector(REKOVm2r), 0);
						byte[] qwPoQBiS = REKOVm2r.toByteArray();
						d0ovrOxs.close();
						OutputStream hlbGO1GU = PouEdbJM.getOutputStream();
						hlbGO1GU.write(qwPoQBiS);
						hlbGO1GU.close();
						injectedClasses++;
					}
				} catch (IllegalStateException MsJdiDnr) {
				}
				newSize += PouEdbJM.getSize();
			}
			File N87sLuFz = new File(classFiles.getDir(), CALLSTACK_FILE);
			if (!N87sLuFz.exists()) {
				throw new BuildException("Missing net.yura.mobile.logging.CallStack class");
			}
			InputStream pH7PwBr2 = new FileInputStream(N87sLuFz);
			ClassReader R3J8YYdv = new ClassReader(pH7PwBr2);
			ClassWriter y9eOkBbW = new ClassWriter(R3J8YYdv, ClassWriter.COMPUTE_MAXS);
			try {
				R3J8YYdv.accept(new PushMethodGenerator(y9eOkBbW), 0);
			} finally {
				pH7PwBr2.close();
			}
			byte[] LUV5sLyD = y9eOkBbW.toByteArray();
			pH7PwBr2.close();
			OutputStream boKEJ6M4 = new FileOutputStream(N87sLuFz);
			boKEJ6M4.write(LUV5sLyD);
			boKEJ6M4.close();
			log(injectedClasses + " classes injected");
			log((injectedMethods * 100) / Math.max(1, totalMethods) + "% of methods injected");
			log((100 - ((oldSize * 100) / newSize)) + "% code size increase");
		} catch (IOException clZIruRG) {
			log(clZIruRG, 0);
		}
	}

}