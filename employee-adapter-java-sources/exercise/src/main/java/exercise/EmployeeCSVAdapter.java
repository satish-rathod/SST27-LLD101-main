package exercise;

public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV csv;

    public EmployeeCSVAdapter(EmployeeCSV csv) {
        this.csv = csv;
    }

    private String[] split() {
        return csv.getCsvRow().split(",");
    }

    @Override
    public String getId() {
        return split()[0];
    }

    @Override
    public String getFirstName() {
        return split()[1];
    }

    @Override
    public String getLastName() {
        return split()[2];
    }

    @Override
    public String getEmail() {
        return split()[3];
    }
}
