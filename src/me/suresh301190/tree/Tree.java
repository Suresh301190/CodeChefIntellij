package me.suresh301190.tree;

/**
 * Created by Suresh on 01-Apr-16.
 */
public class Tree {

    // Global Variables for Tree Construction
    int treeDepth;        // Depth of Tree
    int nodeLevel;        // Nodes at Final Level
    int nodeTotal;        // Total Nodes in Tree of depth = "treeDepth"
    int totalLen;        // Total no. of Elements in tree
    long[] array;

    public Tree(int[] A, int len) {
        treeDepth = (int) Math.ceil((Math.log(len) / Math.log(2)));
        nodeLevel = (int) Math.pow(2, (treeDepth));
        nodeTotal = 2 * nodeLevel - 1;
        totalLen = nodeLevel - 1 + len;

        int i, j;
        array = new long[nodeTotal];

        for (i = nodeLevel - 1, j = 0; i < totalLen; i++, j++) {
            array[i] = A[j];
        }

        int nl = nodeLevel, tmp, currLevel, nodeAtLevel;

        for (i = treeDepth; i > 0; i--) {
            currLevel = nl - 1 - (nl = nl / 2);
            nodeAtLevel = nl + currLevel;
            for (j = currLevel; j < nodeAtLevel; j++) {
                tmp = 2 * j;
                array[j] += array[tmp + 1] + array[tmp + 2];
            }
        }
    }

    /**
     * For Printing the above constructed tree in bottom Up Fashion
     */
    private void print() {
        int nl = nodeLevel;
        for (int i = nodeLevel - 1; i < nodeTotal; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        for (int i = treeDepth; i > 0; i--) {
            int currLevel = nl - 1 - (nl = nl / 2);
            int nodeAtLevel = nl + currLevel;
            for (int j = currLevel; j < nodeAtLevel; j++) {
                System.out.print(array[j] + "  ");
            }
            System.out.println();
        }
    }
}
