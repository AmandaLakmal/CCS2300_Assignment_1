class LocationNode {
    String name;
    LocationNode left, right;

    public LocationNode(String name) {
        this.name = name;
        this.left = this.right = null;
    }
}

public class LocationTree {

    private LocationNode root;

    // Insert location
    public void insert(String name) {
        root = insertRec(root, name);
        System.out.println("Location stored in BST.");
    }

    private LocationNode insertRec(LocationNode root, String name) {
        if (root == null) {
            return new LocationNode(name);
        }

        if (name.compareToIgnoreCase(root.name) < 0) {
            root.left = insertRec(root.left, name);
        } else if (name.compareToIgnoreCase(root.name) > 0) {
            root.right = insertRec(root.right, name);
        }

        return root;
    }

    // Display locations (Inorder Traversal)
    public void displayLocations() {
        if (root == null) {
            System.out.println("No locations stored.");
            return;
        }

        System.out.println("Locations in Sorted Order:");
        inorder(root);
    }

    private void inorder(LocationNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.name);
            inorder(node.right);
        }
    }
}