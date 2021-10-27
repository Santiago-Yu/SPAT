class n8235223 {
	private ShaderProgram loadShaderProgram() {
		ShaderProgram XHEcIOMe = null;
		String Lq1Fh0yB = null;
		String I0lWVGY2 = null;
		Shader[] QEc8rXOI = new Shader[2];
		try {
			ClassLoader oZ1Nmwgf = this.getClass().getClassLoader();
			URL agt6n7YI = oZ1Nmwgf.getResource("Shaders/ivory.vert");
			System.out.println("url " + agt6n7YI);
			InputStream Ej1YJJHe = oZ1Nmwgf.getResourceAsStream("Shaders/ivory.vert");
			Reader pT0rPgZ4 = null;
			if (Ej1YJJHe != null) {
				pT0rPgZ4 = new InputStreamReader(Ej1YJJHe);
			} else {
				File YEaDeymn = new File("lib");
				URL papz8xC2 = new URL(
						"jar:file:" + YEaDeymn.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/ivory.vert");
				InputStream CdD89JHr = papz8xC2.openStream();
				pT0rPgZ4 = new InputStreamReader(CdD89JHr);
			}
			char[] KZw9zSfI = new char[10000];
			int ZLY6oqaX = pT0rPgZ4.read(KZw9zSfI);
			Lq1Fh0yB = new String(KZw9zSfI);
			Lq1Fh0yB = Lq1Fh0yB.substring(0, ZLY6oqaX);
		} catch (Exception i6d0uOM1) {
			System.err.println("could'nt load ivory.vert");
			i6d0uOM1.printStackTrace();
		}
		try {
			ClassLoader m3ImHiad = this.getClass().getClassLoader();
			URL jl3O0OyX = m3ImHiad.getResource("Shaders/ivory.frag");
			System.out.println("url " + jl3O0OyX);
			InputStream xsu14AOc = m3ImHiad.getResourceAsStream("Shaders/ivory.frag");
			Reader HduusNVY = null;
			if (xsu14AOc != null) {
				HduusNVY = new InputStreamReader(xsu14AOc);
			} else {
				File gdt77f93 = new File("lib");
				URL sg64BcSr = new URL(
						"jar:file:" + gdt77f93.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/ivory.frag");
				InputStream SjczbUxR = sg64BcSr.openStream();
				HduusNVY = new InputStreamReader(SjczbUxR);
			}
			char[] Y4wdysjr = new char[10000];
			int U2wRFuel = HduusNVY.read(Y4wdysjr);
			I0lWVGY2 = new String(Y4wdysjr);
			I0lWVGY2 = I0lWVGY2.substring(0, U2wRFuel);
		} catch (Exception w8IkDmeH) {
			System.err.println("could'nt load ivory.frag");
			w8IkDmeH.printStackTrace();
		}
		if (Lq1Fh0yB != null && I0lWVGY2 != null) {
			QEc8rXOI[0] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_VERTEX, Lq1Fh0yB);
			QEc8rXOI[1] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_FRAGMENT, I0lWVGY2);
			XHEcIOMe = new GLSLShaderProgram();
			XHEcIOMe.setShaders(QEc8rXOI);
		}
		return XHEcIOMe;
	}

}