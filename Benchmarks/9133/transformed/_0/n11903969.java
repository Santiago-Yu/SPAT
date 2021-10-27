class n11903969 {
	private ShaderProgram loadShaderProgram() {
		ShaderProgram C4ZRuhnW = null;
		String WKZ1y8tQ = null;
		String L6lMsYH3 = null;
		Shader[] krjUSDWp = new Shader[2];
		try {
			ClassLoader zI33WMYT = this.getClass().getClassLoader();
			URL HaGnArVz = zI33WMYT.getResource("Shaders/simple.vert");
			System.out.println("url " + HaGnArVz);
			InputStream ZuStHAqF = zI33WMYT.getResourceAsStream("Shaders/simple.vert");
			Reader TmM5r6kq = null;
			if (ZuStHAqF != null) {
				TmM5r6kq = new InputStreamReader(ZuStHAqF);
			} else {
				File SZ69gU8F = new File("lib");
				URL SCPLnK2L = new URL(
						"jar:file:" + SZ69gU8F.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/simple.vert");
				InputStream uO7jIN3M = SCPLnK2L.openStream();
				TmM5r6kq = new InputStreamReader(uO7jIN3M);
			}
			char[] Xy4Dfd6a = new char[10000];
			int NIJA3zut = TmM5r6kq.read(Xy4Dfd6a);
			WKZ1y8tQ = new String(Xy4Dfd6a);
			WKZ1y8tQ = WKZ1y8tQ.substring(0, NIJA3zut);
		} catch (Exception oToZFYDp) {
			System.err.println("could'nt load simple.vert");
			oToZFYDp.printStackTrace();
		}
		try {
			ClassLoader wn2xb86e = this.getClass().getClassLoader();
			URL npsM1KKN = wn2xb86e.getResource("Shaders/simple.frag");
			System.out.println("url " + npsM1KKN);
			InputStream ORx6GDz7 = wn2xb86e.getResourceAsStream("Shaders/simple.frag");
			Reader lfi9T1E0 = null;
			if (ORx6GDz7 != null) {
				lfi9T1E0 = new InputStreamReader(ORx6GDz7);
			} else {
				File lbELFFaS = new File("lib");
				URL GWEr1yhY = new URL(
						"jar:file:" + lbELFFaS.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/simple.frag");
				InputStream TejrjRXC = GWEr1yhY.openStream();
				lfi9T1E0 = new InputStreamReader(TejrjRXC);
			}
			char[] SLIdYUmE = new char[10000];
			int B6OhpWVT = lfi9T1E0.read(SLIdYUmE);
			L6lMsYH3 = new String(SLIdYUmE);
			L6lMsYH3 = L6lMsYH3.substring(0, B6OhpWVT);
		} catch (Exception D9AkIW5W) {
			System.err.println("could'nt load simple.frag");
			D9AkIW5W.printStackTrace();
		}
		if (WKZ1y8tQ != null && L6lMsYH3 != null) {
			krjUSDWp[0] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_VERTEX, WKZ1y8tQ);
			krjUSDWp[1] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_FRAGMENT, L6lMsYH3);
			C4ZRuhnW = new GLSLShaderProgram();
			C4ZRuhnW.setShaders(krjUSDWp);
		}
		return C4ZRuhnW;
	}

}