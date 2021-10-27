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
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;
//This Rule is designed ONLY for ++ and --.
public class PrePostFixExpressionDividing extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<PostfixExpression> thePostfixExps = new ArrayList<PostfixExpression>();
	ArrayList<PrefixExpression> thePrefixExps = new ArrayList<PrefixExpression>();
	Set<ExpressionStatement> ReplicationAvioding = new HashSet<ExpressionStatement>();
	AST ast = null;
	ASTRewrite rewriter = null;
	
	public PrePostFixExpressionDividing(CompilationUnit cu_, Document document_, String outputDirPath_){
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
	}
	
	
	public boolean visit(PostfixExpression node) {
		try {
			Statement father = notsuitable(node);
			if(father == null) {
				return true;
			}
			if(node.getOperator().toString() == "++" || node.getOperator().toString() == "--") {
				if(!ReplicationAvioding.contains(father)) { // In case We write one Expression Twice.
					ReplicationAvioding.add((ExpressionStatement) father);
					thePostfixExps.add(node);
				}
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}
	
	
	private Statement notsuitable(Expression node) {
		Statement father = Utils.father2AListRewriterForStatementInserting(node, rewriter);
		if(father == null || father.getNodeType() != ASTNode.EXPRESSION_STATEMENT) {
			return null;
		}
		if(node.getParent() == father) {
			return null;
		}
		return father;
	}
	
	public boolean visit(PrefixExpression node) {
		try {
			Statement father = notsuitable(node);
			if(father == null) {
				return true;
			}
			if(node.getOperator().toString() == "++" || node.getOperator().toString() == "--") {
				if(!ReplicationAvioding.contains(father)) { // In case We write one Expression Twice.
					ReplicationAvioding.add((ExpressionStatement) father);
					thePrefixExps.add(node);
				}
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}

	
	
	public void endVisit(CompilationUnit node) {
		
		if (thePrefixExps.size() == 0 && thePostfixExps.size() == 0) {
			return;
		}
		
		
		for(PrefixExpression thePrefixExp: thePrefixExps){
			
			Statement fathertoInsert = Utils.father2AListRewriterForStatementInserting(thePrefixExp, rewriter);
			
			PostfixExpression postExpCopy = ast.newPostfixExpression();
			postExpCopy.setOperand((Expression) ASTNode.copySubtree(ast, thePrefixExp.getOperand()));
			postExpCopy.setOperator(PostfixExpression.Operator.toOperator(thePrefixExp.getOperator().toString()));
			ExpressionStatement addedbeforeExpSta = ast.newExpressionStatement(postExpCopy);
			Expression innerFix = (Expression) ASTNode.copySubtree(ast, thePrefixExp.getOperand());

			ListRewrite lrt = rewriter.getListRewrite(fathertoInsert.getParent(), (ChildListPropertyDescriptor) fathertoInsert.getLocationInParent());
			lrt.insertBefore(addedbeforeExpSta, fathertoInsert, null);
			rewriter.replace(thePrefixExp, innerFix, null);
		}
		for(PostfixExpression thePostfixExp: thePostfixExps) {
			Statement fathertoInsert = Utils.father2AListRewriterForStatementInserting(thePostfixExp, rewriter);
			
			PostfixExpression postExpCopy = (PostfixExpression) ASTNode.copySubtree(ast, thePostfixExp);
			ExpressionStatement addedafterExpSta = ast.newExpressionStatement(postExpCopy);
			Expression innerFix = (Expression) ASTNode.copySubtree(ast, thePostfixExp.getOperand());

			ListRewrite lrt = rewriter.getListRewrite(fathertoInsert.getParent(), (ChildListPropertyDescriptor) fathertoInsert.getLocationInParent());
			lrt.insertAfter(addedafterExpSta, fathertoInsert, null);
			rewriter.replace(thePostfixExp, innerFix, null);
		}
		
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}
}