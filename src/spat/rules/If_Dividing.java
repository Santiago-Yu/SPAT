package spat.rules;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression.Operator;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class If_Dividing extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<IfStatement> ifs = new ArrayList<IfStatement>();
	
	public If_Dividing(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(IfStatement node) {
		Expression theexp = node.getExpression();
		
		//node.getElseStatement() == null 
		//&&
		if(theexp.getNodeType() == ASTNode.INFIX_EXPRESSION
				&& ((InfixExpression)theexp).getOperator() == InfixExpression.Operator.AND) {
			ifs.add(node);
			
		}
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		
		if (ifs.size() == 0) {
			return;
		}
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(IfStatement ifer: ifs){
			IfStatement newifer_outer = ast.newIfStatement();
			IfStatement newifer_inner = ast.newIfStatement();
			InfixExpression theexp = (InfixExpression) ASTNode.copySubtree(ast, ifer.getExpression());
			Expression exp_A = (Expression) ASTNode.copySubtree(ast, theexp.getLeftOperand());
			Expression exp_B = (Expression) ASTNode.copySubtree(ast, theexp.getRightOperand());
			
			newifer_outer.setExpression(exp_A);
			newifer_inner.setExpression(exp_B);
			
			newifer_inner.setThenStatement((Statement) ASTNode.copySubtree(ast,ifer.getThenStatement()));
			newifer_inner.setElseStatement((Statement) ASTNode.copySubtree(ast,ifer.getElseStatement()));
			
			Block blocker = ast.newBlock();
			blocker.statements().add(newifer_inner);
			newifer_outer.setThenStatement(blocker);
			newifer_outer.setElseStatement((Statement) ASTNode.copySubtree(ast,ifer.getElseStatement()));
			
			rewriter.replace(ifer, newifer_outer, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}
