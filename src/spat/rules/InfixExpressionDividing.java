package spat.rules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class InfixExpressionDividing extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<InfixExpression> theInfixExps = new ArrayList<InfixExpression>();
	Set<Expression> ReplicationAvioding = new HashSet<Expression>();
	
	public InfixExpressionDividing(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(InfixExpression node) {
		try {
			InfixExpression father = Utils.father2AInfixExpression(node);
			if(father!=null && PrimitiveType.toCode(node.resolveTypeBinding().toString()) != null) {
				if(!ReplicationAvioding.contains(father)) { // In case We write one Expression Twice.
					ReplicationAvioding.add(father);
					theInfixExps.add(node);
				}
				
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (theInfixExps.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(InfixExpression theInfixExp: theInfixExps){
			//System.out.println("find one:");
			//System.out.println(theInfixExp.toString());
			String theStringOftheType = theInfixExp.resolveTypeBinding().toString();
			//System.out.println(theStringOftheType);
			//System.out.println(Utils.father2AInfixExpression(theInfixExp).toString());
			
			
			
			VariableDeclarationFragment tmpDecFra = ast.newVariableDeclarationFragment();
			SimpleName tmpName = ast.newSimpleName(Utils.getRandomString(8));
			tmpDecFra.setName(tmpName);
			tmpDecFra.setInitializer((InfixExpression) ASTNode.copySubtree(ast, theInfixExp));
			
			VariableDeclarationStatement tmpDec = ast.newVariableDeclarationStatement(tmpDecFra);
			PrimitiveType pt = ast.newPrimitiveType(PrimitiveType.toCode(theStringOftheType));
			tmpDec.setType(pt);
			
			Statement insertbeforethisfather = Utils.father2AListRewriterForStatementInserting(theInfixExp, rewriter);
			if(insertbeforethisfather == null) {//No where to insert. face it.
				continue;
			}
			ListRewrite lrt = rewriter.getListRewrite(insertbeforethisfather.getParent(), (ChildListPropertyDescriptor) insertbeforethisfather.getLocationInParent());
			lrt.insertBefore(tmpDec, insertbeforethisfather, null);
			rewriter.replace(theInfixExp, tmpName, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
