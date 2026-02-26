package Module_1;

/*
 * LocationNode
 * Represents a node in Binary Search Tree
 */
public class LocationNode {

    String locationName;
    LocationNode left;
    LocationNode right;

    // Constructor
    public LocationNode(String locationName) {
        this.locationName = locationName;
        this.left = null;
        this.right = null;
    }
}

