package Module_1;

class LocationNode {
    String name;
    LocationNode left, right;

    public LocationNode(String name) {
        this.name = name;
    }
}

public class LocationTree {
    private LocationNode root;

    public void insert(String name) {
        root = insertRec(root, name);
    }

    private LocationNode insertRec(LocationNode root, String name) {
        if (root == null) {
            return new LocationNode(name);
        }

        if (name.compareTo(root.name) < 0)
            root.left = insertRec(root.left, name);
        else if (name.compareTo(root.name) > 0)
            root.right = insertRec(root.right, name);

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(LocationNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.name);
            inorderRec(root.right);
        }
    }
}