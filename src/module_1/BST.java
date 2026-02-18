package smartcity;

public class BST {
    private BSTNode root;

    public void insert(Location location) {
        root = insertRec(root, location);
    }

    private BSTNode insertRec(BSTNode root, Location location) {
        if (root == null) {
            return new BSTNode(location);
        }

        if (location.getName().compareTo(root.data.getName()) < 0)
            root.left = insertRec(root.left, location);
        else if (location.getName().compareTo(root.data.getName()) > 0)
            root.right = insertRec(root.right, location);

        return root;
    }

    public boolean search(String name) {
        return searchRec(root, name);
    }

    private boolean searchRec(BSTNode root, String name) {
        if (root == null)
            return false;

        if (name.equals(root.data.getName()))
            return true;

        if (name.compareTo(root.data.getName()) < 0)
            return searchRec(root.left, name);

        return searchRec(root.right, name);
    }
}
