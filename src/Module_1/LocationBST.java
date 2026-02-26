package Module_1;

/*
 * LocationBST
 * Implements Binary Search Tree for locations
 */
public class LocationBST {

    private LocationNode root;

    // Insert location into BST
    public void insert(String locationName) {
        root = insertRec(root, locationName);
    }

    private LocationNode insertRec(LocationNode root, String locationName) {

        if (root == null)
            return new LocationNode(locationName);

        if (locationName.compareTo(root.locationName) < 0)
            root.left = insertRec(root.left, locationName);
        else if (locationName.compareTo(root.locationName) > 0)
            root.right = insertRec(root.right, locationName);

        return root;
    }
    // Display locations in sorted order
    public void displayInOrder() {
        System.out.println("Locations (Sorted):");
        inorder(root);
        System.out.println();
    }

    private void inorder(LocationNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.locationName + " ");
            inorder(root.right);
        }
    }
}

