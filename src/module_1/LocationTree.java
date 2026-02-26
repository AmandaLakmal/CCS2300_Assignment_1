class LocationTree {

    class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    Node root;

    public void insert(String data) {
        root = insertRec(root, data);
        System.out.println("Location stored in tree.");
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            return new Node(data);
        }

        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }
}