package com.practice.DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Trie {
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String s) {
		TrieNode current = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode node = current.children.get(c);
			if (node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public void delete(String s) {
		delete(root, s, 0);
	}

	public boolean delete(TrieNode current, String s, int index) {
		if (index == s.length()) {
			// if you've reached to the end of the s, then delete only if current node's
			// endofword is true
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		char c = s.charAt(index);
		TrieNode node = current.children.get(c);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrent = delete(node, s, index + 1);
		if (shouldDeleteCurrent) {
			current.children.remove(c);
			return current.children.size() == 0;
		}
		return false;
	}

	public boolean search(String s) {
		TrieNode current = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode node = current.children.get(c);
			if (node == null)
				return false;
			current = node;
		}
		return current.endOfWord;
	}

	public static void main(String[] args) {
		List<String> stringsList = new ArrayList<String>();
		stringsList.add("pqrs");
		stringsList.add("pprt");
		stringsList.add("psst");
		stringsList.add("qqrs");
		stringsList.add("pqrs");
		Trie trie = new Trie();
		for (String string : stringsList) {
			trie.insert(string);
		}
		System.out.println(trie.search("pprt"));
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfWord;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}