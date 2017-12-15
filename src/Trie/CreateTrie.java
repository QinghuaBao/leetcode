package Trie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bqh on 2017/3/31.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class CreateTrie {
    private Node root = new Node();

    public static void main(String[] args) throws IOException{
        CreateTrie trie = new CreateTrie();
        Scanner in = new Scanner(new File("test.txt"));
        int num = Integer.parseInt(in.nextLine());
        for (int i = 0; i < num; i++) {
            String temp = in.nextLine();
            trie.InsertAlp(temp);
        }

        //输出每一行的结果
        int queryNum = Integer.parseInt(in.nextLine());
        Node root = trie.getRoot();
        for (int i = 0; i < queryNum; i++) {
            String queryString = in.nextLine();
            Node node = root;
            for (int j = 0; j < queryString.length(); j++) {
                node = node.getBranch(queryString.charAt(j)- 'a');
                if(node.getCount() == 0)
                    break;
            }
            System.out.println(node.getCount());
        }
    }

    //插入一个单词
    public void InsertAlp(String alp) {
        Node node = root;
        for (int i = 0; i < alp.length(); i++) {
            int branchNum = alp.charAt(i)- 'a';
            Node temp = node.getBranch(branchNum);//深克隆，所以要set
            temp.setCount();
            node.setBranch(temp, branchNum);
            node = temp;
        }
        node.setEnd(true);
    }

    public Node getRoot() {
        return root;
    }

    //插入一组词
    public void InsertTrie(ArrayList<String> alpArrayList) {
        for (int i = 0; i < alpArrayList.size(); i++) {
            String s =  alpArrayList.get(i);
            InsertAlp(s);
        }
    }
}

class Node {
    //经过此节点的单词数量
    private int count = 0;
    //是否是单词结束位置
    private boolean end = false;
    //代表26个字母的分支
    private Node[] branch = new Node[26];

    public Node() {
    }

    public void setCount() {
        count++;
    }

    public int getCount()
    {
        return count;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public void setBranch(Node node, int i) {
        this.branch[i] = node;
    }

    public Node getBranch(int i) {
        if (branch[i] == null)
            branch[i] = new Node();
        return branch[i];
    }
}
