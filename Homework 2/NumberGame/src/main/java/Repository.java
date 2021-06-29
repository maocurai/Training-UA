public class Repository {
    private static Model _model;
    private static Statistics _statistics;

    public static void createModel(int min, int max) { _model = new Model(min, max); }

    public static Model getModel() {
        return _model;
    }

    public static void setModel(Model model) { _model = model; }

    public static void createStatistics() { _statistics = new Statistics(); }

    public static Statistics get_statistics() { return _statistics; }
}
