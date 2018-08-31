
/**
 *  Created on 31 Aug 2018
 *  在trie中，每个节点（除了root node）存一个character。
 *  当从根节点遍历trie到指定node的时候，一个prefix就生成了。
 */
import java.util.HashMap;

public class Trie {
	private TrieNode root;

	// O(n), where n represents the key size.
	public void insert(String word) {
		TrieNode cur = root;

		for (int i = 0; i < word.length(); i++) {
			cur = cur.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}

		cur.setEndOfWord(true);
	}

	// O(n), where n represents the length of the key.
	public boolean find(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = cur.getChildren().get(ch);
			if (node == null) {
				return false;
			}

			cur = node;
		}

		return cur.isEndOfWord();
	}

	public void delete(String word) {
		delete(root, word, 0);
	}

	// O(n), where n represents the length of the key.
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord()) {
				return false;
			}
			current.setEndOfWord(false);
			return current.getChildren().isEmpty();
		}
		char ch = word.charAt(index);
		TrieNode node = current.getChildren().get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

		if (shouldDeleteCurrentNode) {
			current.getChildren().remove(ch);
			return current.getChildren().isEmpty();
		}
		return false;
	}
}

class TrieNode {
	private HashMap<Character, TrieNode> children;
	private String content;
	private boolean isWord;

	public void setEndOfWord(boolean v) {
		isWord = v;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public boolean isEndOfWord() {
		return isWord;
	}
}
