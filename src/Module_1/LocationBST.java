package Module_1;

public class LocationBST {
    private LocationNode root;

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
