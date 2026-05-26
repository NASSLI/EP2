public class ApplicationUE3d2 {

    public static void main(String[] args) {

        /*
         * Tree structure by x-coordinate:
         *
         *              k1(6)
         *             /     \
         *         k2(3)     k3(8)
         *         /   \        \
         *      k4(1) k5(4)    k6(9)
         *               \
         *              k7(5)
         *
         * Reverse in-order:
         * k6, k3, k1, k7, k5, k2, k4
         *
         * Nodes at level 2:
         * k4, k5, k6
         *
         * Reverse in-order restricted to level 2:
         * k6, k5, k4
         */


        Physical k1 = new Nest(new Vector2D(6, 0), 1);
        Physical k2 = new Nest(new Vector2D(3, 0), 2);
        Physical k3 = new Nest(new Vector2D(8, 0), 3);
        Physical k4 = new Nest(new Vector2D(1, 0), 4);
        Physical k5 = new Nest(new Vector2D(4, 0), 5);
        Physical k6 = new Nest(new Vector2D(9, 0), 6);
        Physical k7 = new Nest(new Vector2D(5, 0), 6);

        Physical v1 = new FoodSource(new Vector2D(10, 10), 10);
        Physical v2 = new FoodSource(new Vector2D(20, 20), 20);
        Physical v3 = new FoodSource(new Vector2D(30, 30), 30);
        Physical v4 = new FoodSource(new Vector2D(40, 40), 40);
        Physical v5 = new FoodSource(new Vector2D(50, 50), 50);
        Physical v6 = new FoodSource(new Vector2D(60, 60), 60);
        Physical v7 = new FoodSource(new Vector2D(70, 70), 70);

        PhysicalPhysicalTreeMap map = new PhysicalPhysicalTreeMap();

        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        map.put(k6, v6);
        map.put(k7, v7);

        System.out.println("======================================");
        System.out.println("levelTwoIterator() TESTS");
        System.out.println("======================================");

        PhysicalIterator iterator = map.levelTwoIterator();

        checkPhysical("levelTwoIterator 0", k6, iterator.next());
        checkPhysical("levelTwoIterator 1", k5, iterator.next());
        checkPhysical("levelTwoIterator 2", k4, iterator.next());

        check("levelTwoIterator exhausted", false, iterator.hasNext());
        checkPhysical("levelTwoIterator next after exhausted", null, iterator.next());

        System.out.println("======================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("======================================");

        // TODO: end of block to activate.*/
    }

    private static void check(String testName, Object expected, Object actual) {
        if (java.util.Objects.equals(expected, actual)) {
            ok();
        } else {
            fail(testName, expected, actual);
        }
    }

    private static void checkPhysical(String testName, Physical expected, Physical actual) {
        if (expected == actual) {
            ok();
        } else {
            fail(testName, physicalToString(expected), physicalToString(actual));
        }
    }

    private static void fail(String testName, Object expected, Object actual) {
        System.out.println(testName + " FAILED -> Expected: "
                + expected + ", Actual: " + actual);
    }

    private static void ok() {
        System.out.println("OK");
    }

    private static String physicalToString(Physical p) {
        if (p == null) {
            return "null";
        }

        return p.getClass().getSimpleName()
                + "@("
                + p.getPosition().getX()
                + ", "
                + p.getPosition().getY()
                + "), r="
                + p.getRadius();
    }
}