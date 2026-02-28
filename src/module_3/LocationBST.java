package module_3;

/**
 * Represents a node in the Location Binary Search Tree.
 * Stores the city ID and city name.
 */
class LocationNode {
    int id;
    String cityName;
    LocationNode left, right;

    public LocationNode(int id, String cityName) {
        this.id = id;
        this.cityName = cityName;
        this.left = null;
        this.right = null;
    }
}

/**
 * Binary Search Tree implementation to store and manage city locations.
 * Facilitates the tree-based data organization of locations before mapping into the graph.
 */
public class LocationBST {
    private LocationNode root;

    public LocationBST() {
        this.root = null;
    }

    /**
     * Inserts a new location into the BST.
     * * @param id       The unique identifier for the city.
     * @param cityName The name of the city.
     */
    public void insert(int id, String cityName) {
        root = insertRecursive(root, id, cityName);
    }

    /**
     * Recursive helper method to find the correct insertion point in the BST.
     * * @param current  The current node being evaluated.
     * @param id       The city ID to insert.
     * @param cityName The city name to insert.
     * @return The updated node.
     */
    private LocationNode insertRecursive(LocationNode current, int id, String cityName) {
        // Base case: empty spot found in the tree
        if (current == null) {
            return new LocationNode(id, cityName);
        }

        // Traverse left or right based on ID comparison to maintain BST property
        if (id < current.id) {
            current.left = insertRecursive(current.left, id, cityName);
        } else if (id > current.id) {
            current.right = insertRecursive(current.right, id, cityName);
        } else {
            System.out.println("Error: Location with ID " + id + " already exists.");
        }

        return current;
    }

    /**
     * Displays all registered locations using in-order traversal.
     * Outputs the locations sorted in ascending order by their ID.
     */
    public void displayLocations() {
        System.out.println("--- Registered Locations ---");
        displayRecursive(root);
        System.out.println("----------------------------");
    }

    private void displayRecursive(LocationNode current) {
        if (current != null) {
            displayRecursive(current.left);
            System.out.println("ID: " + current.id + " | City: " + current.cityName);
            displayRecursive(current.right);
        }
    }
}