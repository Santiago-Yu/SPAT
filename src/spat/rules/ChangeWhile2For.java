package spat.rules;

import java.util.ArrayList;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class ChangeWhile2For extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<WhileStatement> whiles = new ArrayList<WhileStatement>();
	
	public ChangeWhile2For(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(WhileStatement node) {
		whiles.add(node);
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (whiles.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(WhileStatement whiler: whiles){
			ForStatement forer = ast.newForStatement();
			Expression theexp = (Expression) ASTNode.copySubtree(ast, whiler.getExpression());
			forer.setExpression(theexp);
			Statement bodystatement = whiler.getBody();
			Statement forbody = (Statement) ASTNode.copySubtree(ast, bodystatement);
			forer.setBody(forbody);
			
			rewriter.replace(whiler, forer, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
